package security;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CRL;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.io.File;
import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import Verification.VerificationRequest;

public class Server {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream inputStream = null;

    public void close() {
        try {
            if (socket != null) socket.close();
            if (inputStream != null) inputStream.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    private void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for client ...");
            socket = serverSocket.accept();
            System.out.println("Client accepted");
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server(int port) {
        start(port);

        try {
            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                VerificationRequest request = objectMapper.readValue(message, VerificationRequest.class);
                validateCertificateChain(request.getCertificateChain());
                validateSignature(request);
                String jsonFilePath ="C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\PKCS12 for security project\\verifiedClientData.json";
                String derFilePath  = "C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\PKCS12 for security project\\signedData.der";
                saveJsonToFile(message, jsonFilePath);
                convertJsonToDer(jsonFilePath, derFilePath);


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error during verification: " + e.getMessage());
            }

        } catch (IOException i) {
            System.out.println(i);
        } finally {
            close();
            System.out.println("Closing connection");
        }
    }
    
    private static void saveJsonToFile(String jsonData, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonData);
            System.out.println("JSON file saved successfully " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving JSON" + e.getMessage());
        }
    }


    private static void convertJsonToDer(String jsonFilePath, String derFilePath) {
        try {
            // read json
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(jsonFilePath);
            
            if (!jsonFile.exists()) {
                System.err.println("JSON file to convert to DER not found.");
                return;
            }

            VerificationRequest request = objectMapper.readValue(jsonFile, VerificationRequest.class);

            // Data extraction
            byte[] dataBytes = Base64.getDecoder().decode(request.getData());
            byte[] signatureBytes = Base64.getDecoder().decode(request.getSignature());

            // Save in DER format
            try (FileOutputStream fos = new FileOutputStream(derFilePath)) {
                fos.write(dataBytes);      // Writing original data
                fos.write(signatureBytes); // Add a digital signature
            }

            System.out.println(" DER file saved successfully: " + derFilePath);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(" Error converting JSON to DER: " + e.getMessage());
        }
    }

    private static void validateCertificateChain(List<String> certChainBase64) throws Exception {
        System.out.println("Starting the certificate chain validation process...");

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        X509Certificate[] certChain = new X509Certificate[certChainBase64.size()];

     // Rebuild certificate chain from Base64
        for (int i = 0; i < certChainBase64.size(); i++) {
            byte[] certBytes = Base64.getDecoder().decode(certChainBase64.get(i));
            certChain[i] = (X509Certificate) certFactory.generateCertificate(
                    new java.io.ByteArrayInputStream(certBytes)
            );
        }
        
     // Address of CRL files
        String rootCRLPath         = "C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\CRL folders for security project\\rootCA\\rootCA.crl"; // Root certificate CRL file path
        String intermediateCRLPath = "C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\CRL folders for security project\\intermediateCA\\intermediateCA.crl"; // Root certificate CRL file path

        for (X509Certificate cert : certChain) {
            try {
                validateCRL(cert, rootCRLPath, intermediateCRLPath);
            } catch (CertificateException e) {
                System.out.println("Certificate has been revoked.: " + cert.getSubjectX500Principal());
                throw e;
            }
        }
     //**step1: check the CRL 
        System.out.println("1. The certificates provided are not in the CRL list.");

     // ** Step 2: Check the certificate format **
        System.out.println("2. Certificate format checked: All certificates are in X.509 format.");

     // **Step 3: Check the completeness of the certificate chain**
        if (!isCompleteChain(certChain)) {
            throw new CertificateException("2. Certificate format checked: All certificates are in X.509 format.");
        }
        System.out.println("3. The certificate chain is complete and ends with the root certificate.");

     // ** Step 4: Check and validate certificate signatures **
        validateSignatures(certChain);

     // ** Step 5: Check the validity period of the certificates **
        validateValidityPeriods(certChain);

     // ** Step 6: Check Key Usage Certificates **
        validateKeyUsages(certChain);

     // ** Step 7: Check the CN (Common Name) of the certificates **
        validateCommonNames(certChain);

     // ** Step 8: Check Authority Key Identifier and Subject Key Identifier **
        validateKeyIdentifiers(certChain);

     // ** Step 9: Check Basic Constraints Certificates **
        validateBasicConstraints(certChain);

        System.out.println("The certificate chain is valid.");
    }

    private static boolean isCompleteChain(X509Certificate[] certChain) throws Exception {
        for (int i = 0; i < certChain.length - 1; i++) {
            X509Certificate issuer = certChain[i + 1];
            X509Certificate subject = certChain[i];

            try {
                subject.verify(issuer.getPublicKey());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static void validateSignatures(X509Certificate[] certChain) throws Exception {
        for (int i = 0; i < certChain.length - 1; i++) {
            X509Certificate issuer = certChain[i + 1];
            X509Certificate subject = certChain[i];
            subject.verify(issuer.getPublicKey());
        }
        System.out.println("4. Signatures of all certificates in the chain were verified.");
    }

    private static void validateValidityPeriods(X509Certificate[] certChain) throws Exception {
        for (X509Certificate cert : certChain) {
            cert.checkValidity();
        }
        System.out.println("5. The validity dates of all certificates have been checked and are valid.");
    }

    private static void validateKeyUsages(X509Certificate[] certChain) throws Exception {
        for (int i = 0; i < certChain.length; i++) {
            boolean[] keyUsages = certChain[i].getKeyUsage();

         // End Entity Certificate
            if (i == 0) {
                if (keyUsages == null || !keyUsages[0]) { // DigitalSignature
                    throw new CertificateException("Key Usage End Entity Certificate is not valid for digital signature.");
                }
            }
         // Intermediate and root certificates
            else {
                if (keyUsages == null || !keyUsages[5] || !keyUsages[6]) { // Key_CertSign و Crl_Sign
                    throw new CertificateException("Key Usage The CA certificate is not valid for issuing or signing certificates.");
                }
            }
        }
        System.out.println("6. Key Usage All certificates are valid.");
    }

    private static void validateCommonNames(X509Certificate[] certChain) throws Exception {

        // Check if the chain length is greater than 1 for validation
        if (certChain.length > 1) {
            // Validate client certificate against intermediate certificate
            String clientIssuer = certChain[0].getIssuerX500Principal().getName();
            String intermediateSubject = certChain[1].getSubjectX500Principal().getName();

            if (!clientIssuer.equals(intermediateSubject)) {
                throw new CertificateException("Name chaining validation failed: Issuer of certificate 1 does not match Subject of certificate 2");
            }

            // Validate intermediate certificate against root certificate
            String intermediateIssuer = certChain[1].getIssuerX500Principal().getName();
            String rootSubject = certChain[2].getSubjectX500Principal().getName();

            if (!intermediateIssuer.equals(rootSubject)) {
                throw new CertificateException("Name chaining validation failed: Issuer of certificate 2 does not match Subject of certificate 3");
            }
        }

        // Validate root certificate (subject and issuer should be the same)
        X509Certificate rootCert = certChain[certChain.length - 1];
        if (!rootCert.getSubjectX500Principal().equals(rootCert.getIssuerX500Principal())) {
            throw new CertificateException("Root certificate validation failed: Subject and Issuer must be identical.");
        }

        System.out.println("7.Common Name (CN) validation passed: Name chaining is correct.");
    }

    private static void validateKeyIdentifiers(X509Certificate[] certChain) throws Exception {
        if (certChain.length < 3) {
            throw new Exception("The certificate chain is incomplete for AKI/SKI validation.");
        }

        // Validate between client certificate and intermediate CA certificate
        validateSingleKeyIdentifierPair(certChain[0], certChain[1], "client", "intermediate");

        // Validate between intermediate CA certificate and root CA certificate
        validateSingleKeyIdentifierPair(certChain[1], certChain[2], "intermediate", "root");
        
     // Validate between root CA certificate and root CA certificate
        validateSingleKeyIdentifierPair(certChain[2], certChain[2], "root", "root");
    }

    private static void validateSingleKeyIdentifierPair(
            X509Certificate certWithAKI,
            X509Certificate certWithSKI,
            String certWithAKIName,
            String certWithSKIName) throws Exception {

        // Extract AKI
        byte[] akiExtensionValue = certWithAKI.getExtensionValue("2.5.29.35");
        if (akiExtensionValue == null) {
            throw new Exception("Authority Key Identifier not found in the " + certWithAKIName + " certificate.");
        }
        String authorityKeyIdentifier = extractAuthorityKeyIdentifier(akiExtensionValue);
   //**     System.out.println("Extracted AKI from " + certWithAKIName + " certificate (hex): " + authorityKeyIdentifier);

        // Extract SKI
        byte[] skiExtensionValue = certWithSKI.getExtensionValue("2.5.29.14");
        if (skiExtensionValue == null) {
            throw new Exception("Subject Key Identifier not found in the " + certWithSKIName + " certificate.");
        }
        String subjectKeyIdentifier = extractSubjectKeyIdentifier(skiExtensionValue);
   //**     System.out.println("Extracted SKI from " + certWithSKIName + " certificate (hex): " + subjectKeyIdentifier);

        // Compare AKI and SKI
        if (!authorityKeyIdentifier.equals(subjectKeyIdentifier)) {
            throw new Exception("Authority Key Identifier from the " + certWithAKIName +
                    " certificate does not match the Subject Key Identifier from the " + certWithSKIName + " certificate.");
        }

        System.out.println("8.AKI and SKI validation passed between " + certWithAKIName + " and " + certWithSKIName + " certificates.");
    }

    private static String extractAuthorityKeyIdentifier(byte[] akiExtensionValue) throws IOException {
        // Decode the Authority Key Identifier value
        byte[] decoded = java.util.Arrays.copyOfRange(akiExtensionValue, 4, akiExtensionValue.length); // Strip the ASN.1 OCTET STRING header

        // Skip the first 2 bytes and extract the next 20 bytes
        if (decoded.length < 22) {
            throw new IOException("Unexpected AKI structure: insufficient length for key identifier.");
        }
        byte[] akiKeyId = java.util.Arrays.copyOfRange(decoded, 2, 22); // Extract the 20-byte Key Identifier
        return DatatypeConverter.printHexBinary(akiKeyId).toLowerCase();
    }

    private static String extractSubjectKeyIdentifier(byte[] skiExtensionValue) throws IOException {
        // Decode the Subject Key Identifier value
        byte[] decoded = java.util.Arrays.copyOfRange(skiExtensionValue, 4, skiExtensionValue.length); // Strip the ASN.1 OCTET STRING header
        return DatatypeConverter.printHexBinary(decoded).toLowerCase();
    }


    private static void validateBasicConstraints(X509Certificate[] certChain) throws Exception {
        for (int i = 0; i < certChain.length; i++) {
            X509Certificate cert = certChain[i];
            int basicConstraints = cert.getBasicConstraints();

            if (i == certChain.length - 1) { // rootCA
                if (basicConstraints < 0) {
                    throw new CertificateException("The root certificate must have valid Basic Constraints.");
                }
            } else { // Intermediate or End Entity Certificate
                if (basicConstraints > 0) {
                    throw new CertificateException("The End Entity certificate cannot be a CA.");
                }
            }
        }
        System.out.println("9. Basic Constraints Certificates Checked and are valid.");
    }
    
    private static void validateCRL(X509Certificate cert, String rootCRLPath, String intermediateCRLPath) throws Exception {
        System.out.println("Validating certificate against CRL...");

     // Select the appropriate CRL file (root or intermediate)
        String crlFilePath;
        if (isRootCertificate(cert)) {
            crlFilePath = rootCRLPath;
            System.out.println("Using root CRL file: " + crlFilePath);
        } else {
            crlFilePath = intermediateCRLPath;
            System.out.println("Using intermediate CRL file: " + crlFilePath);
        }

        //Load CRL from file
        FileInputStream crlInputStream = new FileInputStream(new File(crlFilePath));
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        CRL crl = certFactory.generateCRL(crlInputStream);

      // Check certificate status
        if (crl.isRevoked(cert)) {
            throw new CertificateException("The certificate has been revoked according to CRL.");
        } else {
            System.out.println("Certificate is not revoked according to the CRL.");
        }
    }

    // Auxiliary method for root certificate detection
    private static boolean isRootCertificate(X509Certificate cert) {
        //If the Subject and Issuer are the same, it is a root certificate.
        return cert.getSubjectX500Principal().equals(cert.getIssuerX500Principal());
    }
    
    

    /**
     * Signature verification method
     */
    private static void validateSignature(VerificationRequest request) throws Exception {
        System.out.println("Starting the signature verification process...");

        // Data reconstruction
        byte[] originalData = Base64.getDecoder().decode(request.getData());
        byte[] signedData = Base64.getDecoder().decode(request.getSignature());

        // Public key regeneration
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        byte[] certBytes = Base64.getDecoder().decode(request.getCertificateChain().get(0));
        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(
                new java.io.ByteArrayInputStream(certBytes)
        );
        PublicKey publicKey = cert.getPublicKey();

        // Signature verification
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(originalData);

        if (signature.verify(signedData)) {
            System.out.println("The signature is valid.");
        } else {
            System.out.println("the signature is not valid");
        }
        
    }

    public static void main(String[] args) {
        new Server(5000);
    }
}

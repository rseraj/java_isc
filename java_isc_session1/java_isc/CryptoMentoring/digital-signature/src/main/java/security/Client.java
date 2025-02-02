package security;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.*;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Scanner;


public class Client {
	  
    // Initialize socket and input/output streams
    private Socket socket = null;
    private DataOutputStream output_stream = null;
    
    
    private String keyStorePath = "C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\PKCS12 for security project\\client.p12";
    private String jsonSavePath = "C:\\Users\\seraj\\Documents\\workspace-spring-tool-suite-4-4.26.0.RELEASE\\PKCS12 for security project\\signedData.json";
    
    
    private void dump(String payload, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(payload);
        } catch (Exception e) {
            System.err.println("Error saving JSON:" + e.getMessage());
        }
    }
    
    private String get_password() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the Keystore password: ");
        String password = scanner.nextLine();
        return password;
    }
    
    
    private void connect(String address, int port) {

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            output_stream = new DataOutputStream(socket.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }
    }
    
    
    private void close() {
        try {
            output_stream.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public Client(String address, int port) {
    	String jsonPayload = null;
    	KeyStore keystore = null;
    	String password = get_password();
    	
		try {
			keystore = KeyStore.getInstance("PKCS12");
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
        try (FileInputStream fis = new FileInputStream(keyStorePath)) {
			keystore.load(fis, password.toCharArray());
			PrivateKey privateKey = (PrivateKey) keystore.getKey("clientcertificate", password.toCharArray());
			Certificate[] certChain = keystore.getCertificateChain("clientcertificate");
			if (privateKey == null || certChain == null) {
				throw new Exception("Private key or certificate chain not found.");
			}
			String data = "This is some data to sign"; // Data to be signed
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(privateKey);
			signature.update(data.getBytes());
			byte[] signedData = signature.sign();
			String base64Data = Base64.getEncoder().encodeToString(data.getBytes());
			String base64SignedData = Base64.getEncoder().encodeToString(signedData);
			
			//Convert certificate chain to Base64 and JSON-friendly 
			StringBuilder certChainBase64 = new StringBuilder();
			certChainBase64.append("[");
			for (Certificate cert : certChain) {
			    certChainBase64.append("\"")
			                   .append(Base64.getEncoder().encodeToString(cert.getEncoded()))
			                   .append("\",");
			}
			if (certChainBase64.length() > 1) {
				certChainBase64.setLength(certChainBase64.length() - 1); // Remove the extra trailing comma
			}
			certChainBase64.append("]");
			jsonPayload = String.format(
					"{\"data\": \"%s\", \"signature\": \"%s\", \"certificateChain\": %s}",
					base64Data, base64SignedData, certChainBase64.toString()
					);
			dump(jsonPayload, jsonSavePath);
			
			
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException | CertificateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

        connect(address, port);

        try {
            output_stream.writeUTF(jsonPayload);
        }
        catch (IOException i) {
            System.out.println(i);
        }

        close();
    }

    public static void main(String[] args) {
        Client c = new Client("127.0.0.1", 5000);
    }
}
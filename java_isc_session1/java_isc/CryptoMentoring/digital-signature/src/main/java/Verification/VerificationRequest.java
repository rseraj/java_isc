package Verification;

import java.util.List;

public class VerificationRequest {
    private String data;
    private String signature;
    private List<String> certificateChain; // لیستی از رشته‌ها

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getCertificateChain() {
        return certificateChain;
    }

    public void setCertificateChain(List<String> certificateChain) {
        this.certificateChain = certificateChain;
    }
}

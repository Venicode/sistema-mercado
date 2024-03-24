package models.Payment;

public class Pix extends Payment {
    private String keyPix;
    public Pix(String methodPayment, double amount, String keyPix){
        super(methodPayment, amount);
        this.keyPix = keyPix;
    }

    public String getKeyPix() {
        return keyPix;
    }

    public void setKeyPix(String keyPix) {
        this.keyPix = keyPix;
    }
}

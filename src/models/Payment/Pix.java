package models.Payment;

public class Pix extends Payment {
    private String keyPix;

    public Pix(String keyPix, String description){
        super(description);
        this.keyPix = keyPix;
    }
    public String getKeyPix() {
        return keyPix;
    }

    public void setKeyPix(String keyPix) {
        this.keyPix = keyPix;
    }

    @Override
    public void methodPayment() {
        System.out.println("Chave PIX:" + keyPix);
    }
}

package models.Payment;

public abstract class Payment {
    private String descriptionMethodPayment;

    public Payment(String descriptionMethodPayment){
        this.descriptionMethodPayment = descriptionMethodPayment;
    }
    public abstract void methodPayment();

    public String getDescriptionMethodPayment() {
        return descriptionMethodPayment;
    }

    public void setDescriptionMethodPayment(String descriptionMethodPayment) {
        this.descriptionMethodPayment = descriptionMethodPayment;
    }
}

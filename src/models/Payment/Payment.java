package models.Payment;

public abstract class Payment {
    private String methodPayment;
    private double amount;

    public Payment(String methodPayment, double amount) {
        this.methodPayment = methodPayment;
        this.amount = amount;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

package models.Payment;

public class CreditCard extends Payment {
    private int parcelCount;
    private double amount;
    public void methodPayment(){
        if (parcelCount > 6) {
            amount = amount + (amount * 0.05);
        }
    }
    public int getParcelCount() {
        return parcelCount;
    }

    public void setParcelCount(int parcelCount) {
        this.parcelCount = parcelCount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

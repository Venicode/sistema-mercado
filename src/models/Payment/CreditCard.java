package models.Payment;

public class CreditCard extends Payment {
    private int parcelCount;
    CreditCard(int parcelCount, String methodPayment, double amount){
        super(methodPayment, amount);
        this.parcelCount = parcelCount;
    }
    public double calculateInterest(double amount){
        if (parcelCount > 6) {
            amount = amount + (amount * 0.05);
        }
        return amount;
    }
    public int getParcelCount() {
        return parcelCount;
    }

    public void setParcelCount(int parcelCount) {
        this.parcelCount = parcelCount;
    }
}

package models.Payment;

public class Cash extends Payment {
    private double amount;
    private double amountPaid;

    public Cash(String description){
        super(description);
    }
    public void methodPayment(){
        double changeAmount = amountPaid - amount;
        if(changeAmount<0){
            System.out.println("Dinheiro insuficiente para o pagamento.");
            System.out.println("Falta: "+changeAmount);
        }
        if(changeAmount ==0){
           this.amount = amountPaid;
        } System.out.println("Valor para troco: "+changeAmount);
        this.amount = changeAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}

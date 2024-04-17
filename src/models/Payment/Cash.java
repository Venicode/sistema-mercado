package models.Payment;

public class Cash extends Payment {
    private double amount;
    private double amountPaid;

    public Cash(String description){
        super(description);
    }
    public void methodPayment(){
        if(amountPaid<amount){
            System.out.println("Dinheiro insuficiente para o pagamento.");
            System.out.println("Falta: "+ (amount - amountPaid));
        }
        else {
            System.out.println("Valor para troco: " + (amountPaid - amount));
        }
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

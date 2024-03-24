package models.Payment;

public class Cash extends Payment {
    public Cash(String methodPayment, double amount) {
        super(methodPayment, amount);
    }
    public double calculateChange(double amountPaid){
        double changeAmount = amountPaid - super.getAmount();
        if(changeAmount<0){
            System.out.println("Dinheiro insuficiente para o pagamento.");
            System.out.println("Falta: "+changeAmount);
        }
        if(changeAmount ==0){
            return changeAmount;
        } System.out.println("Valor para troco: "+changeAmount);
        return changeAmount;
    }
}

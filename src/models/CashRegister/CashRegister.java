package models.CashRegister;

public class CashRegister {
    private double balance;

    public CashRegister(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

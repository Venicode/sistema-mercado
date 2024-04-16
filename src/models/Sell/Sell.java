package models.Sell;

import models.People.Customer;
import models.Product.Product;
import models.Payment.Payment;
public class Sell {
    Customer customer;
    Product product;
    Payment payment;
    private double amount;
    private int quantity;
    public Sell(Customer customer, Product product,
                models.Payment.Payment payment, double amount, int quantity) {
        this.customer = customer;
        this.product = product;
        this.payment = payment;
        this.amount = amount;
        this.quantity = quantity;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public models.Payment.Payment getPayment() {
        return payment;
    }

    public void setPayment(models.Payment.Payment payment) {
        this.payment = payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

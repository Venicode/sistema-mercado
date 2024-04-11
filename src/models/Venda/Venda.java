package models.Venda;

import models.Payment.Payment;
import models.People.Client;
import models.Product.Product;

public class Venda {
    Client client;
    Product product;
    Payment payment;
    private double amount;
    private int quantity;
    public Venda(Client client, Product product,
                           Payment payment, double amount, int quantity) {
        this.client = client;
        this.product = product;
        this.payment = payment;
        this.amount = amount;
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
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

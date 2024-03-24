package models.Product;

import models.People.Supplier;

public class Grocery extends Product {
    private String expirationDate;

    public Grocery(String description, double costPrice,
                   double sellingPrice, Supplier supplier,
                   int quantity, String expirationDate) {
        super(description, costPrice, sellingPrice,
                supplier, quantity);
        this.expirationDate = expirationDate;

    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

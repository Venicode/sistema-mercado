package models.Stock;

import models.Product.Product;

import java.util.ArrayList;

public class Stock {
    private final ArrayList<Product> list = new ArrayList<>();
    private int amount;

    public ArrayList<Product> getList() {
        return list;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }
}

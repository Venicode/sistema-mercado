package models.Stock;

import models.Product.Product;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private final Map<Product, Integer> mapProductsInStock = new HashMap<>();
    private int amountTotal;

    public Map<Product, Integer> getMapProductsInStock() {
        return mapProductsInStock;
    }
    public int getAmountTotal() {
        for (int amount: mapProductsInStock.values()) {
            this.amountTotal += amount;
        } return this.amountTotal;
    }
}

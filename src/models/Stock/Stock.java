package models.Stock;

import models.Product.Product;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private Map<Product, Integer> estoqueProdutos = new HashMap<>();
    private int amountTotal;

    public Map<Product, Integer> getProductsInStock() {
        return estoqueProdutos;
    }
    public int getAmountTotal() {
        for (int amount: estoqueProdutos.values()) {
            this.amountTotal += amount;
        } return this.amountTotal;
    }
}

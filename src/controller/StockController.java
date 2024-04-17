package controller;

import models.Product.Product;
import models.Stock.Stock;

public class StockController {
    Stock newStock;

    public StockController(Stock newStock){
        this.newStock = newStock;
    }
    public void addProductToStock(Product newProduct){
        newStock.getMapProductsInStock().put(newProduct, newProduct.getQuantity());
        System.out.println("Produto cadastrado com sucesso!");
    }
    public void updateProductInStock(Product newProduct, int newQuantity){
        newProduct.setQuantity(newProduct.getQuantity()-newQuantity);
        newStock.getMapProductsInStock().replace(newProduct, newProduct.getQuantity());
    }
    public Product getProductInStock(Long barcode){
        for (Product product: newStock.getMapProductsInStock().keySet()){
            if(product.getBarCode() == barcode){
                return product;
            }
        }return null;
    }
    public int currentStockBalance(){
        return newStock.getAmountTotal();
    }
}

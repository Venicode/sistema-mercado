package controller;

import models.Product.Product;
import models.Stock.Stock;

import java.util.function.BiConsumer;

public class StockController {
    Stock newStock;

    public StockController(Stock newStock){
        this.newStock = newStock;
    }
    public void addProductToStock(Product newProduct){
        newStock.getProductsInStock().put(newProduct, newProduct.getQuantity());
        System.out.println("Produto cadastrado com sucesso!");
    }
    public void updateProductInStock(Product newProduct, int newQuantity){
        newProduct.setQuantity(newProduct.getQuantity()-newQuantity);
        newStock.getProductsInStock().replace(newProduct, newProduct.getQuantity());
    }
    public void listProductInStock(){
        System.out.println("Lista de produtos no estoque:");
        for (Product i : newStock.getProductsInStock().keySet()) {
            System.out.print("Nome do produto: "+i.getDescription());
            System.out.println(" Quantidade:" + i.getQuantity());
        }
    }
    public Product getProductInStock(Long barcode){
        for (Product product: newStock.getProductsInStock().keySet()){
            if(product.getBarCode() == barcode){
                return product;
            }
        }return null;
    }
    public int currentStockBalance(){
        return newStock.getAmountTotal();
    }
}

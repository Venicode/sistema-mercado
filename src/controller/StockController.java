package controller;

import models.Product.Product;
import models.Stock.Stock;

public class StockController {
    Stock newStock = new Stock();
    public void cadastrarProdutoNoEstoque(Product newProduct){
        newStock.getList().add(newProduct);
        newStock.setAmount(newProduct.getQuantity());
        System.out.println("Produto cadastrado com sucesso!");
    }
    public void listarProdutosNoEstoque(){
        System.out.println("Lista de produtos no estoque:");
        for (Product i : newStock.getList()) {
            System.out.print("Nome do produto: "+i.getDescription());
            System.out.println(" Quantidade:" + i.getQuantity());
        }
        System.out.println("Total de produtos no estoque:"+ newStock.getAmount());
    }
}

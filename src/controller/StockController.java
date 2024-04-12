package controller;

import models.Product.Product;
import models.Stock.Stock;

public class StockController {
    Stock newStock;

    public StockController(Stock newStock){
        this.newStock = newStock;
    }
    public void cadastrarProdutoNoEstoque(Product newProduct){
        newStock.getEstoqueProdutos().put(newProduct, newProduct.getQuantity());
        System.out.println("Produto cadastrado com sucesso!");
    }
    public void atualizarProdutoNoEstoque(Product newProduct, int newQuantity){
        newProduct.setQuantity(newProduct.getQuantity()-newQuantity);
        newStock.getEstoqueProdutos().replace(newProduct, newProduct.getQuantity());
        System.out.println("Estoque do produto atualizado!");
    }
    public void listarProdutosNoEstoque(){
        System.out.println("Lista de produtos no estoque:");
        for (Product i : newStock.getEstoqueProdutos().keySet()) {
            System.out.print("Nome do produto: "+i.getDescription());
            System.out.println(" Quantidade:" + i.getQuantity());
        }
    }
    public int saldoAtualEstoque(){
        return newStock.getAmountTotal();
    }
}

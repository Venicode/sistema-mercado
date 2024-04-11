package controller;

import models.Stock.Stock;
import models.Venda.Venda;

import java.util.ArrayList;

public class VendaController {

private ArrayList<Venda> listaVendas = new ArrayList<>();
    public void realizarVenda(Venda venda) {
        if (venda.getQuantity()> venda.getProduct().getQuantity()) {
            System.out.println("Quantidade não disponível no estoque.");
        }
        if (venda.getAmount()<venda.getProduct().getSellingPrice()){
            System.out.println("Valor insuficiente para a compra.");
        }
        else{
            listaVendas.add(venda);
            Stock newStock = new Stock();
            int novaQuantidade = (venda.getQuantity() - newStock.getAmount());
            newStock.setAmount(novaQuantidade);
            System.out.println("Venda realizada com sucesso");
            System.out.println("O cliente: " + venda.getClient().getName()+
                    " realizou a compra do produto: " +
                    venda.getProduct().getDescription() +
                    " no valor de " + venda.getProduct().getSellingPrice());
            System.out.println("Novo estoque total: "+ newStock.getAmount());
        }
    }
}

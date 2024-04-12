package controller;

import models.CashRegister.CashRegister;
import models.Venda.Venda;

import java.util.ArrayList;

public class VendaController {
    CashRegister newCashRegister = new CashRegister();
    private ArrayList<Venda> listaVendas = new ArrayList<>();

    public void realizarVenda(Venda venda, StockController stock) {
        if (venda.getQuantity() > venda.getProduct().getQuantity()) {
            System.out.println("Quantidade não disponível no estoque.");
        }
        if (venda.getAmount() < venda.getProduct().getSellingPrice()) {
            System.out.println("Valor insuficiente para a compra.");
        } else {
            listaVendas.add(venda);
            stock.atualizarProdutoNoEstoque(venda.getProduct(), venda.getQuantity());
            newCashRegister.setBalance(venda.getAmount());
            System.out.println(newCashRegister.getBalance());
            System.out.println("Venda realizada com sucesso");
            System.out.println("O cliente: " + venda.getClient().getName() +
                    " realizou a compra do produto: " +
                    venda.getProduct().getDescription() +
                    " no valor de " + venda.getProduct().getSellingPrice());
            System.out.println("Novo estoque do produto: " + stock.newStock.getEstoqueProdutos().get(venda.getProduct()));
            System.out.println("Saldo do caixa: " + newCashRegister.getBalance());
        }
    }
}

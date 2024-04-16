package controller;

import models.CashRegister.CashRegister;
import models.Sell.Sell;

import java.util.ArrayList;

public class SellController {

    private ArrayList<Sell> listSales = new ArrayList<>();

    public void registerSell(Sell sell, StockController stock, CashRegister newCashRegister) {
        if (sell.getQuantity() > sell.getProduct().getQuantity()) {
            System.out.println("Quantidade não disponível no estoque.");
        }
        if (sell.getAmount() < sell.getProduct().getSellingPrice()) {
            System.out.println("Valor insuficiente para a compra.");
        } else {
            listSales.add(sell);
            stock.updateProductInStock(sell.getProduct(), sell.getQuantity());
            newCashRegister.setBalance(sell.getAmount());
            System.out.println("Venda realizada com sucesso");
            System.out.println("O cliente: " + sell.getClient().getName() +
                    " realizou a compra do produto: " +
                    sell.getProduct().getDescription() +
                    " no valor de " + sell.getAmount());
            System.out.println("Novo estoque do produto: " + stock.newStock.getProductsInStock().get(sell.getProduct()));
            System.out.println("Saldo do caixa: " + newCashRegister.getBalance());
        }
    }
}

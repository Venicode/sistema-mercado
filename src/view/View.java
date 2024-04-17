package view;

import models.Sell.Sell;

import java.util.ArrayList;

public class View {
    public void welcome(){
        System.out.println("Olá, o que deseja fazer hoje?");
    }
    public void mainMenu(){
        System.out.println("1 - Realizar venda");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar cliente");
        System.out.println("4 - Cadastrar fornecedor");
        System.out.println("5 - Consultas");
        System.out.println("6 - Saldo do caixa");
        System.out.println("7 - Sair do programa");
    }
    public void reportsMenu(){
        System.out.println("1 - Listar vendas realizadas");
        System.out.println("2 - Listar produtos cadastrados");
        System.out.println("3 - Listar clientes cadastrados");
        System.out.println("4 - Listar fornecedores cadastrados");
        System.out.println("5 - Voltar");
    }
    public void listMethodsPayments(){
        System.out.println("Dinheiro");
        System.out.println("Cartão de Crédito");
        System.out.println("PIX");
    }
    public void listSales(ArrayList<Sell> listSales) {
        System.out.println("Lista de vendas realizadas");
        for (Sell sell : listSales) {
            System.out.println("Cliente: " + sell.getClient().getName()
                    + " Valor venda: " + sell.getAmount()
                    + " Produto: " + sell.getProduct().getDescription()
                    + " Quantidade: " + sell.getQuantity()
                    + " Forma de pagamento: "
                    + sell.getPayment().getDescriptionMethodPayment());
        }
    }
    public void farewell(){
        System.out.println("Tchau! Até logo!");
    }
}
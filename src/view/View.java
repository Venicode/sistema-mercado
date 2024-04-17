package view;

import models.Payment.Payment;
import models.People.Customer;
import models.People.Supplier;
import models.Product.Product;
import models.Sell.Sell;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class View {
    public void welcome() {
        System.out.print("························································································\n" +
                ":██╗   ██╗███████╗███╗   ██╗██╗    ███╗   ███╗ █████╗ ██████╗ ██╗  ██╗███████╗████████╗:\n" +
                ":██║   ██║██╔════╝████╗  ██║██║    ████╗ ████║██╔══██╗██╔══██╗██║ ██╔╝██╔════╝╚══██╔══╝:\n" +
                ":██║   ██║█████╗  ██╔██╗ ██║██║    ██╔████╔██║███████║██████╔╝█████╔╝ █████╗     ██║   :\n" +
                ":╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║    ██║╚██╔╝██║██╔══██║██╔══██╗██╔═██╗ ██╔══╝     ██║   :\n" +
                ": ╚████╔╝ ███████╗██║ ╚████║██║    ██║ ╚═╝ ██║██║  ██║██║  ██║██║  ██╗███████╗   ██║   :\n" +
                ":  ╚═══╝  ╚══════╝╚═╝  ╚═══╝╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝   :\n" +
                "························································································");
        System.out.println("\no que deseja fazer hoje?");
    }

    public void mainMenu() {
        System.out.println("1 - Realizar venda");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar cliente");
        System.out.println("4 - Cadastrar fornecedor");
        System.out.println("5 - Consultas");
        System.out.println("6 - Saldo do caixa");
        System.out.println("7 - Sair do programa");
    }

    public void reportsMenu() {
        System.out.println("1 - Listar vendas realizadas");
        System.out.println("2 - Listar produtos cadastrados");
        System.out.println("3 - Listar clientes cadastrados");
        System.out.println("4 - Listar fornecedores cadastrados");
        System.out.println("5 - Voltar");
    }

    public void listMethodsPayments(ArrayList<Payment> listMethodsPaymentsRegistered) {
        int index = 0;
        for (Payment methodPayment : listMethodsPaymentsRegistered) {
            System.out.println((index += 1) + " - " + methodPayment.getDescriptionMethodPayment());
        }
    }

    public void listCategorysProducts(ArrayList<String> listCategorysProducts) {
        int index = 0;
        for (String category : listCategorysProducts) {
            System.out.println((index += 1) + " - " + category);
        }
    }

    public void listSales(ArrayList<Sell> listSales) {
        System.out.println("**************************");
        System.out.println("Lista de vendas realizadas");
        System.out.println("**************************");
        for (Sell sell : listSales) {
            System.out.println("\nCliente: " + sell.getClient().getName()
                    + " Valor venda: " + sell.getAmount()
                    + " Produto: " + sell.getProduct().getDescription()
                    + " Quantidade: " + sell.getQuantity()
                    + " Forma de pagamento: "
                    + sell.getPayment().getDescriptionMethodPayment());
        }
    }

    public void listCustomers(ArrayList<Customer> listCustomers) {
        System.out.println("******************************");
        System.out.println("Lista de clientes cadastrados:");
        System.out.println("******************************");
        for (Customer i : listCustomers) {
            System.out.println("\n" + i.getName());
        }
    }

    public void listProductsInStock(Map<Product, Integer> getProductsInStock) {
        System.out.println("*****************************");
        System.out.println("Lista de produtos no estoque:");
        System.out.println("*****************************");
        for (Product i : getProductsInStock.keySet()) {
            System.out.print("\nNome do produto: " + i.getDescription() + " Quantidade:" + i.getQuantity() + "\n");
        }
    }

    public void listSuppliers(ArrayList<Supplier> listSuppliers) {
        System.out.println("**********************");
        System.out.println("Lista de Fornecedores:");
        System.out.println("**********************");
        for (Supplier i : listSuppliers) {
            System.out.println("\n" + i.getName());
        }
    }

    public void farewell() {
        System.out.println("Tchau! Até logo!");
    }
}
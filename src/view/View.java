package view;

import controller.StockController;
import models.Category.Category;
import models.Payment.Payment;
import models.People.Customer;
import models.People.Supplier;
import models.Product.Product;
import models.Sell.Sell;

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
    }

    public void mainMenu() {
        System.out.println("Menu de opções:");
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
        System.out.println("Qual seria o tipo de pagamento?");
        int index = 0;
        for (Payment methodPayment : listMethodsPaymentsRegistered) {
            System.out.println((index) + " - " + methodPayment.getDescriptionMethodPayment());
            index+=1;
        }
    }

    public void listCategorys(ArrayList<Category> listCategorys) {
        System.out.println("Qual categoria de produto deseja cadastrar?");
        int index = 0;
        for (Category category : listCategorys) {
            System.out.println((index) + " - " + category.getDescriptionCategory());
            index+=1;
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

    public void listProductsInStock(Map<Product, Integer> getProductsInStock, StockController newStockController) {
        System.out.println("*****************************");
        System.out.println("Lista de produtos no estoque:");
        System.out.println("*****************************");
        System.out.println("Total no Estoque: " + newStockController.currentStockBalance());
        for (Product i : getProductsInStock.keySet()) {
            System.out.print("\nDescrição do Produto: " + i.getDescription()
                    + " Quantidade: " + i.getQuantity()
                    + " Fornecedor: " + i.getSupplier().getName()
                    + " Código de barras: " + i.getBarCode()
                    + " Categoria: " + i.getCategory().getDescriptionCategory()
                    + "\n");
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
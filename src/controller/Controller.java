package controller;

import models.CashRegister.CashRegister;
import models.People.Customer;
import models.People.Supplier;
import models.Stock.Stock;
import view.View;

import java.util.Scanner;

public class Controller {
    CustomerController newCustomerController = new CustomerController();
    SellController newSellController = new SellController();
    Stock newStock = new Stock();
    StockController newStockController = new StockController(newStock);
    PaymentController newPaymentController = new PaymentController();
    CashRegister newCashRegister = new CashRegister();
    SupplierController newSupplierController = new SupplierController();
    ProductController newProductController = new ProductController();
    Scanner option = new Scanner(System.in);

    public void controller() {
        while (true) {
            View newView = new View();
            newView.welcome();
            newView.mainMenu();

            String answer = option.nextLine();
            if (answer.equals("1")) {
                newSellController.newSell(
                        newCustomerController,
                        newStockController,
                        newPaymentController,
                        newCashRegister,
                        option
                );
            }
            if (answer.equals("2")) {
                newProductController.registerProduct(
                        option,
                        newSupplierController,
                        newStockController);
            }
            if (answer.equals("3")) {
                newCustomerController.registerNewCustomer(option);
            }
            if (answer.equals("4")) {
                newSupplierController.registerNewSupplier(option);
            }
            if (answer.equals("5")) {
                while (true) {
                    newView.reportsMenu();
                    System.out.println("Escolha uma opção");
                    String choice = option.nextLine();
                    if (choice.equals("1")) {
                        newView.listSales(newSellController.getListSales());
                    }
                    if (choice.equals("2")) {
                        newStockController.listProductInStock();
                    }
                    if (choice.equals("3")) {
                        newCustomerController.listCustomers();
                    }
                    if (choice.equals("4")) {
                        newSupplierController.listSuppliers();
                    }
                    if (choice.equals("5")) {
                        break;
                    }
                }
            }
            if (answer.equals("6")) {
                System.out.println("Saldo atual do caixa: " + newCashRegister.getBalance());
                continue;
            }
            if (answer.equals("7")) {
                newView.farewell();
                break;
            }
        }
        option.close();
    }
}

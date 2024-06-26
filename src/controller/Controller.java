package controller;

import models.CashRegister.CashRegister;
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
    View newView = new View();
    LoginController newLoginController = new LoginController();

    private boolean comeBack() {
        System.out.println("Aperte qualquer tecla para voltar");
        String choiceReturn = option.nextLine();
        return true;
    }

    public void controller() {
        newView.welcome();
        if (newLoginController.login(option)) {
            while (true) {
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
                    if (comeBack()) {
                        continue;
                    }
                }
                if (answer.equals("2")) {
                    while (true) {
                        newView.cadastro();
                        System.out.println("Escolha uma opção:");
                        String choice = option.nextLine();
                        if (choice.equals("1")) {
                            newProductController.registerProduct(
                                    option,
                                    newSupplierController,
                                    newStockController);
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("2")) {
                            newCustomerController.registerNewCustomer(option);
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("3")) {
                            newSupplierController.registerNewSupplier(option);
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("4")) {
                            break;
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                    }
                }
                if (answer.equals("3")) {
                    while (true) {
                        newView.reportsMenu();
                        System.out.println("Escolha uma opção:");
                        String choice = option.nextLine();
                        if (choice.equals("1")) {
                            newView.listSales(newSellController.getListSales());
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("2")) {
                            newView.listProductsInStock(newStockController.newStock.getMapProductsInStock(), newStockController);
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("3")) {
                            newView.listCustomers(newCustomerController.getListCustomersRegistered());
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("4")) {
                            newView.listSuppliers(newSupplierController.getListSuppliersRegistered());
                            if (comeBack()) {
                                continue;
                            }
                        }
                        if (choice.equals("5")) {
                            break;
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                    }
                }
                if (answer.equals("4")) {
                    System.out.println("Saldo atual do caixa: " + newCashRegister.getBalance());
                    if (comeBack()) {
                        continue;
                    }
                }
                if (answer.equals("5")) {
                    newView.farewell();
                    break;
                }
            }
            option.close();
        }
    }
}

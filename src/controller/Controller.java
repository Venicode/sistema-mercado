package controller;

import models.CashRegister.CashRegister;
import models.Payment.Payment;
import models.People.Customer;
import models.People.Supplier;
import models.Product.Grocery;
import models.Product.Product;
import models.Sell.Sell;
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
    Customer newCliente = new Customer(
            "1234561232",
            "Vitoria",
            "123123123");
    Supplier newSupplier = new Supplier(
            "Atacadao",
            "(11)4151-2340",
            "atacacao@gmail.com",
            "97.104.730/0001-74"
    );
    Grocery newProduct2 = new Grocery(
            "macarrao",
            10,
            20,
            newSupplier,
            200,
            "10/08/2024",
            12312
    );

    public void controller() {
        newCustomerController.registerCustomer(newCliente);
        newStockController.addProductToStock(newProduct2);
        while (true) {
            View newView = new View();
            newView.welcome();
            newView.mainMenu();
            Scanner option = new Scanner(System.in);
            String answer = option.nextLine();
            if (answer.equals("1")) {
                System.out.println("Informe o CPF do cliente");
                String cpf = option.nextLine();
                if (newCustomerController.checkIfCustomerRegistered(cpf)) {
                    System.out.println("Informe o código de barras do produto");
                    String barcode = option.nextLine();
                    Long longBarCode = Long.valueOf(barcode);
                    if (newStockController.getProductInStock(longBarCode) == null) {
                        System.out.println("Produto não cadatrado");
                        continue;
                    } else {
                        Product sellProduct = newStockController.getProductInStock(longBarCode);
                        System.out.println("Informe a quantidade que deseja comprar");
                        int quantity = Integer.parseInt(option.nextLine());
                        double amount = quantity * sellProduct.getSellingPrice();
                        System.out.println("Qual seria o tipo de pagamento?");
                        while (true) {
                            newPaymentController.putMethodsPayments();
                            newPaymentController.listMethodPayments();
                            String optionMethodPayment = option.nextLine();

                            if (newPaymentController.checkIfMethodPaymentRegistered(optionMethodPayment.toLowerCase())) {
                                Payment methodPayment = newPaymentController.getMethodPayment(optionMethodPayment.toLowerCase());
                                double amountCreditCard = newPaymentController.realizeMethodPayment(methodPayment, amount);
                                if (methodPayment.getDescriptionMethodPayment().equals("crédito")) {
                                    amount = amountCreditCard;
                                }
                                Sell newSell = new Sell(
                                        newCustomerController.getCustomer(cpf),
                                        sellProduct,
                                        methodPayment,
                                        amount,
                                        quantity
                                );
                                newSellController.registerSell(newSell, newStockController, newCashRegister);
                                break;
                            } else {
                                System.out.println("Método de pagamento não inválido");
                                continue;
                            }
                        }
                        System.out.println("Deseja realizar mais alguma operação? Digite Sim ou Não");
                        String choice = option.nextLine().toLowerCase();
                        if (choice.equals("sim")) {
                            continue;
                        }
                        break;
                    }
                } else {
                    System.out.println("Cliente não cadastrado");
                    continue;
                }
            }
            if (answer.equals("6")) {
                double stockBalance = newStockController.currentStockBalance();
                System.out.println("Saldo atual do caixa: " + newCashRegister.getBalance());
                continue;
            }
            if (answer.equals("7")) {
                newView.farewell();
                break;
            }
            option.close();
        }
    }
}

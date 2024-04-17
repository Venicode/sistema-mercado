package controller;

import models.CashRegister.CashRegister;
import models.Payment.Payment;
import models.Product.Product;
import models.Sell.Sell;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class SellController {

    final ArrayList<Sell> listSales = new ArrayList<>();

    public ArrayList<Sell> getListSales() {
        return listSales;
    }

    public void addSellToList(Sell sell, double amountCostumer, StockController stock, CashRegister newCashRegister) {
        listSales.add(sell);
        stock.updateProductInStock(sell.getProduct(), sell.getQuantity());
        newCashRegister.setBalance(sell.getAmount());
        System.out.println("Venda realizada com sucesso");
        System.out.println("O cliente: " + sell.getClient().getName() +
                " realizou a compra do produto: " +
                sell.getProduct().getDescription() +
                " no valor de " + sell.getAmount());
        System.out.println("Novo estoque do produto: " + stock.newStock.getMapProductsInStock().get(sell.getProduct()));
        System.out.println("Saldo do caixa: " + newCashRegister.getBalance());

    }

    public void newSell(CustomerController newCustomerController,
                        StockController newStockController,
                        PaymentController newPaymentController,
                        CashRegister newCashRegister,
                        Scanner option) {

        while (true) {
            System.out.println("Informe o CPF do cliente");
            String cpf = option.nextLine();
            if (newCustomerController.checkIfCustomerRegistered(cpf)) {
                System.out.println("Informe o código de barras do produto");
                String barcode = option.nextLine();
                long longBarCode = Long.parseLong(barcode);
                if (newStockController.getProductInStock(longBarCode) == null) {
                    System.out.println("Produto não cadatrado. Realize o cadastro na opção do menu principal.");
                    break;
                } else {
                    Product sellProduct = newStockController.getProductInStock(longBarCode);
                    System.out.println("Informe a quantidade que deseja comprar");
                    int quantity = Integer.parseInt(option.nextLine());
                    if (quantity > sellProduct.getQuantity()) {
                        System.out.println("Quantidade não disponível no estoque.");
                        System.out.println("Quantidade de estoque do produto: " + sellProduct.getQuantity());
                        continue;
                    }
                    double amount = quantity * sellProduct.getSellingPrice();
                    System.out.println("Valor da venda: " + amount);
                    System.out.println("Qual seria o tipo de pagamento?");
                    while (true) {
                        View newView = new View();
                        newView.listMethodsPayments(newPaymentController.listMethodsPaymentsRegistered);
                        int optionMethodPayment = Integer.parseInt(option.nextLine());
                        if (newPaymentController.checkIfMethodPaymentRegistered(optionMethodPayment)) {

                            Payment methodPayment = newPaymentController.getMethodPayment(optionMethodPayment);
                            double amountCustomer = newPaymentController.realizeMethodPayment(methodPayment, amount);
                            Sell newSell = new Sell(
                                    newCustomerController.getCustomer(cpf),
                                    sellProduct,
                                    methodPayment,
                                    amount,
                                    quantity
                            );
                            System.out.println("Deseja aplicar algum desconto? S/N");
                            String answer = option.nextLine().toUpperCase();
                            if (answer.equals("S")) {
                                while (true) {
                                    System.out.println("Qual o valor do desconto?");
                                    double discount = Double.parseDouble(option.nextLine());
                                    if (discount <= 0) {
                                        System.out.println("Valor do desconto inválido, digite algo maior que 0.");
                                        continue;
                                    }
                                    newSell.setAmount(newSell.calculateDiscount(discount));
                                    break;
                                }
                            }
                            addSellToList(newSell, amountCustomer, newStockController, newCashRegister);
                            break;
                        } else {
                            System.out.println("Método de pagamento não inválido");
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
                System.out.println("Cliente não cadastrado. Realize o cadastro na opção do menu principal.");
                break;
            }

        }
    }


}

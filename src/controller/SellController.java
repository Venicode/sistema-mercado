package controller;

import models.CashRegister.CashRegister;
import models.Payment.Payment;
import models.Product.Product;
import models.Sell.Sell;

import java.util.ArrayList;
import java.util.Scanner;

public class SellController {

    final ArrayList<Sell> listSales = new ArrayList<>();

    public ArrayList<Sell> getListSales() {
        return listSales;
    }

    public void validateSell(Sell sell, double amountCostumer, StockController stock, CashRegister newCashRegister) {
        if (sell.getQuantity() > sell.getProduct().getQuantity()) {
            System.out.println("Quantidade não disponível no estoque.");
        }
        if (amountCostumer < sell.getAmount()) {
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

    public void newSell(CustomerController newCustomerController,
                        StockController newStockController,
                        PaymentController newPaymentController,
                        CashRegister newCashRegister,
                        Scanner option) {
        newPaymentController.putMethodsPayments();
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
                    double amount = quantity * sellProduct.getSellingPrice();
                    System.out.println("Valor da venda: "+ amount);
                    System.out.println("Qual seria o tipo de pagamento?");
                    while (true) {
                        newPaymentController.listMethodPayments();
                        String optionMethodPayment = option.nextLine();

                        if (newPaymentController.checkIfMethodPaymentRegistered(optionMethodPayment.toLowerCase())) {
                            Payment methodPayment = newPaymentController.getMethodPayment(optionMethodPayment.toLowerCase());
                                double amountCustomer = newPaymentController.realizeMethodPayment(methodPayment, amount);
                            Sell newSell = new Sell(
                                    newCustomerController.getCustomer(cpf),
                                    sellProduct,
                                    methodPayment,
                                    amount,
                                    quantity
                            );
                            validateSell(newSell,amountCustomer, newStockController, newCashRegister);
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

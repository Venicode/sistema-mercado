package controller;

import models.Payment.Cash;
import models.Payment.CreditCard;
import models.Payment.Payment;
import models.Payment.Pix;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentController {

    final ArrayList<Payment> listMethodsPaymentsRegistered = new ArrayList<>();

    Scanner option = new Scanner(System.in);
    public PaymentController(){
        registerMethodsPayments();
    }
    private void registerMethodsPayments() {
        Cash newCashMethod = new Cash("dinheiro");
        CreditCard newCreditCardMethod = new CreditCard("crédito");
        Pix newPixMethod = new Pix("11987102458", "pix");
        listMethodsPaymentsRegistered.add(newCashMethod);
        listMethodsPaymentsRegistered.add(newCreditCardMethod);
        listMethodsPaymentsRegistered.add(newPixMethod);
    }

    public boolean checkIfMethodPaymentRegistered(int index) {
        for (Payment payment : listMethodsPaymentsRegistered) {
            if (listMethodsPaymentsRegistered.get(index) !=null) {
                return true;
            }
        }
        return false;
    }

    public Payment getMethodPayment(int index) {
        return listMethodsPaymentsRegistered.get(index);
    }
    public double putMethodPayment(Payment methodPayment, double amount) {

        if (methodPayment.getDescriptionMethodPayment().equals("dinheiro")) {
            while (true) {
                System.out.println("Informe o valor do dinheiro:");
                double cash = Double.parseDouble(option.nextLine());
                if (cash < amount) {
                    System.out.println("Valor inferior a compra.");
                    continue;
                }
                Cash methodPayment1 = (Cash) methodPayment;
                methodPayment1.setAmount(amount);
                methodPayment1.setAmountPaid(cash);
                methodPayment1.methodPayment();
                return cash;
            }
        }
        if (methodPayment.getDescriptionMethodPayment().equals("pix")) {
            System.out.println("Pague na chave PIX abaixo:");
            Pix methodPaymentPIX = (Pix) methodPayment;
            methodPaymentPIX.methodPayment();
        }
        if (methodPayment.getDescriptionMethodPayment().equals("crédito")) {
            CreditCard creditCardMethod = (CreditCard) methodPayment;
            System.out.println("Em quantas parcelas deseja fazer a compra?");
            int parcelCount = Integer.parseInt(option.nextLine());
            creditCardMethod.setAmount(amount);
            creditCardMethod.setParcelCount(parcelCount);
            creditCardMethod.methodPayment();
            return creditCardMethod.getAmount();
        }
        return 0;
    }
}

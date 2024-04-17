package controller;

import models.Payment.Cash;
import models.Payment.CreditCard;
import models.Payment.Payment;
import models.Payment.Pix;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentController {

    final ArrayList<Payment> listMethodsPaymentsRegistered = new ArrayList<>();

    public ArrayList<Payment> getListMethodsPaymentsRegistered() {
        return listMethodsPaymentsRegistered;
    }

    Scanner option = new Scanner(System.in);
    public PaymentController(){
        putMethodsPayments();
    }
    public void putMethodsPayments() {
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
        return listMethodsPaymentsRegistered.get(index-1);
    }

    public double realizeMethodPayment(Payment methodPayment, double amountPaid) {

        if (methodPayment.getDescriptionMethodPayment().equals("dinheiro")) {
            while (true) {
                System.out.println("Informe o valor do dinheiro");
                double cash = Double.parseDouble(option.nextLine());
                if (cash < amountPaid) {
                    System.out.println("Valor inferior a compra.");
                    continue;
                }
                Cash methodPayment1 = (Cash) methodPayment;
                methodPayment1.setAmount(amountPaid);
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
                creditCardMethod.setAmount(amountPaid);
                creditCardMethod.setParcelCount(parcelCount);
                creditCardMethod.methodPayment();
                return creditCardMethod.getAmount();
            }
            return 0;
        }

}

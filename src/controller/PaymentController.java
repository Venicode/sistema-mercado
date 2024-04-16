package controller;

import models.Payment.Cash;
import models.Payment.CreditCard;
import models.Payment.Payment;
import models.Payment.Pix;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentController {

    private final ArrayList<Payment> list = new ArrayList<>();
    Scanner option = new Scanner(System.in);

    public void putMethodsPayments() {
        Cash newCashMethod = new Cash("dinheiro");
        CreditCard newCreditCardMethod = new CreditCard("crédito");
        Pix newPixMethod = new Pix("11987102458", "pix");
        list.add(newCashMethod);
        list.add(newCreditCardMethod);
        list.add(newPixMethod);
    }

    public boolean checkIfMethodPaymentRegistered(String description) {
        for (Payment payment : list) {
            if (payment.getDescriptionMethodPayment().equals(description)) {
                return true;
            }
        }
        return false;
    }

    public void listMethodPayments() {
        for (Payment i : list) {
            System.out.println(i.getDescriptionMethodPayment());
        }
    }

    public Payment getMethodPayment(String description) {
        for (Payment payment : list) {
            if (payment.getDescriptionMethodPayment().equals(description)) {
                return payment;
            }
        }
        return null;
    }

    public double realizeMethodPayment(Payment methodPayment, double amountPaid) {

        if (methodPayment.getDescriptionMethodPayment().equals("dinheiro")) {
            System.out.println("Informe o valor do dinheiro");
            double cash = Double.parseDouble(option.nextLine());
            Cash methodPayment1 = (Cash) methodPayment;
            methodPayment1.setAmount(amountPaid);
            methodPayment1.setAmountPaid(cash);
            methodPayment1.methodPayment();
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

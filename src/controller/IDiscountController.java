package controller;

import models.Sell.Sell;

import java.util.Scanner;

public class IDiscountController {
    public void applyDiscount(Sell newSell, Scanner option){
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
}

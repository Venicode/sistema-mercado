package controller;

import models.People.Supplier;
import models.Product.Drinks;
import models.Product.Grocery;

import java.util.Scanner;

public class ProductController {
    public void registerProduct(Scanner option,
                                SupplierController newSupplierController,
                                StockController newStockController) {


        System.out.println("Informe a descrição do produto");
        String description = option.nextLine();
        System.out.println("Informe o valor de compra");
        double costPrice = Double.parseDouble(option.nextLine());
        System.out.println("Informe o valor de venda");
        double sellingPrice = Double.parseDouble(option.nextLine());
        System.out.println("Informe o CNPJ do fornecedor");
        String CNPJ = option.nextLine();
        if (newSupplierController.checkIfSupplierRegistered(CNPJ)) {
            Supplier newSupplier = newSupplierController.getSupplier(CNPJ);
            System.out.println("Informe a quantidade do produto em estoque");
            int quantity = Integer.parseInt(option.nextLine());
            System.out.println("Informe a data de validade");
            String expirationDate = option.nextLine();
            System.out.println("Informe o código de barras do produto");
            long barcode = Long.parseLong(option.nextLine());
            while (true) {
                System.out.println("Qual categoria de produto deseja cadastrar? Alimentício ou bebida");
                String category = option.nextLine();
                if (category.equals("Alimentício")) {
                    Grocery newGrocery = new Grocery(
                            description,
                            costPrice,
                            sellingPrice,
                            newSupplier,
                            quantity,
                            expirationDate,
                            barcode
                    );
                    newStockController.addProductToStock(newGrocery);
                    break;
                }
                if (category.equals("Bebida")) {
                    System.out.println("Informe a quantidade de litros:");
                    double liters = Double.parseDouble(option.nextLine());
                    System.out.println("Bebida tem teor alcólico? S/N");
                    String answer = option.nextLine().toUpperCase();
                    boolean isAcoholic = answer.equals("S");
                    Drinks newDrink = new Drinks(
                            description,
                            costPrice,
                            sellingPrice,
                            newSupplier,
                            quantity,
                            liters,
                            isAcoholic,
                            expirationDate,
                            barcode
                    );
                    newStockController.addProductToStock(newDrink);
                    break;
                } else {
                    System.out.println("Categoria inválida");
                }
            }
        } else{
            System.out.println("Fornecedor não cadastrado. Realize o cadastro na opção do menu principal.");
        }
    }
}

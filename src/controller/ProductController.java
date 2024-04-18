package controller;

import models.People.Supplier;
import models.Product.Drinks;
import models.Product.Grocery;
import view.View;

import java.util.Scanner;

public class ProductController {
    CategoryController newCategoryController = new CategoryController();
    View newView = new View();

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
                newView.listCategorys(newCategoryController.getListCategoryRegistered());
                String category = option.nextLine();
                if (category.equals("0")) {
                    Grocery newGrocery = new Grocery(
                            description,
                            costPrice,
                            sellingPrice,
                            newSupplier,
                            quantity,
                            expirationDate,
                            barcode,
                            newCategoryController.insertCategoryToProduct(0)
                    );
                    System.out.println("Categoria do produto é: " + newGrocery.getCategory().getDescriptionCategory());
                    newStockController.addProductToStock(newGrocery);
                    break;
                }
                if (category.equals("1")) {
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
                            barcode,
                            newCategoryController.insertCategoryToProduct(1)
                    );
                    System.out.println("Categoria do produto é: " + newDrink.getCategory().getDescriptionCategory());
                    newStockController.addProductToStock(newDrink);
                    break;
                }

                else {
                    System.out.println("Categoria inválida");
                }
            }
        } else {
            System.out.println("Fornecedor não cadastrado. Realize o cadastro na opção do menu principal.");
        }
    }
}

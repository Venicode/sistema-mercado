package controller;

import models.People.Supplier;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierController {
    final ArrayList<Supplier> listSuppliersRegistered = new ArrayList<>();

    public ArrayList<Supplier> getListSuppliersRegistered() {
        return listSuppliersRegistered;
    }

    public void addSupplierToList(Supplier newSupplier) {
        listSuppliersRegistered.add(newSupplier);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }
    public void registerNewSupplier(Scanner option) {
        System.out.println("Informe o CNPJ do fornecedor:");
        String cnpj = option.nextLine();
        System.out.println("Informe o nome do fornecedor:");
        String name = option.nextLine();
        System.out.println("Informe o telefone do fornecedor:");
        String phone = option.nextLine();
        System.out.println("Informe o email do fornecedor:");
        String email = option.nextLine();
        Supplier newSupplier = new Supplier(
          cnpj,
          name,
          phone,
          email
        );
        addSupplierToList(newSupplier);
    }
    public boolean checkIfSupplierRegistered(String CNPJ) {
        for (Supplier supplier : listSuppliersRegistered) {
            if (supplier.getCNPJ().equals(CNPJ)) {
                return true;
            }
        }
        return false;
    }
    public Supplier getSupplier(String CNPJ) {
        for (Supplier supplier : listSuppliersRegistered) {
            if (supplier.getCNPJ().equals(CNPJ)) {
                return supplier;
            }
        }
        return null;
    }
}

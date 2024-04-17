package controller;

import models.People.Customer;
import models.People.Supplier;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierController {
    private final ArrayList<Supplier> list = new ArrayList<>();

    public void addSupplierToList(Supplier newSupplier) {
        list.add(newSupplier);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }
    public void registerNewSupplier(Scanner option) {
        System.out.println("Informe o CNPJ do fornecedor");
        String cnpj = option.nextLine();
        System.out.println("Informe o nome do fornecedor");
        String name = option.nextLine();
        System.out.println("Informe o telefone do fornecedor");
        String phone = option.nextLine();
        System.out.println("Informe o email do fornecedor");
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
        for (Supplier supplier : list) {
            if (supplier.getCNPJ().equals(CNPJ)) {
                return true;
            }
        }
        return false;
    }
    public void listSuppliers() {
        System.out.println("Lista de Fornecedores:");
        for (Supplier i : list) {
            System.out.println(i.getName());
        }
    }
    public Supplier getSupplier(String CNPJ) {
        for (Supplier supplier : list) {
            if (supplier.getCNPJ().equals(CNPJ)) {
                return supplier;
            }
        }
        return null;
    }
}

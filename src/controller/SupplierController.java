package controller;

import models.People.Supplier;

import java.util.ArrayList;

public class SupplierController {
    private final ArrayList<Supplier> list = new ArrayList<>();

    public void registerSupplier(Supplier newSupplier) {
        list.add(newSupplier);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    public void listSuppliers() {
        System.out.println("Lista de Fornecedores:");
        for (Supplier i : list) {
            System.out.println(i.getName());
        }
    }
}

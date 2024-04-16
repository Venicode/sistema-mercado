package controller;

import models.People.Customer;

import java.util.ArrayList;

public class CustomerController {
    private final ArrayList<Customer> list = new ArrayList<>();

    public void registerCustomer(Customer newCustomer) {
        list.add(newCustomer);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public boolean checkIfCustomerRegistered(String CPF) {
        for (Customer customer : list) {
            if (customer.getCPF().equals(CPF)) {
                return true;
            }
        }
        return false;
    }

    public void listCustomers() {
        System.out.println("Lista de clientes cadastrados:");
        for (Customer i : list) {
            System.out.println(i.getName());
        }
    }

    public Customer getCustomer(String cpf) {
        for (Customer customer : list) {
            if (customer.getCPF().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }
}

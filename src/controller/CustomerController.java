package controller;

import models.People.Customer;
import models.People.Supplier;
import models.Product.Grocery;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    private final ArrayList<Customer> list = new ArrayList<>();

    public void addCustomerToList(Customer newCustomer) {
        list.add(newCustomer);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void registerNewCustomer(Scanner option) {
        System.out.println("Informe o CPF do cliente");
        String cpf = option.nextLine();
        System.out.println("Informe o nome do cliente");
        String name = option.nextLine();
        System.out.println("Informe o telefone do cliente");
        String phone = option.nextLine();
        Customer newCustomer = new Customer(
                cpf,
                name,
                phone
        );
        addCustomerToList(newCustomer);
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

package controller;

import models.People.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    final ArrayList<Customer> listCustomersRegistered = new ArrayList<>();

    public ArrayList<Customer> getListCustomersRegistered() {
        return listCustomersRegistered;
    }

    public void addCustomerToList(Customer newCustomer) {
        listCustomersRegistered.add(newCustomer);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void registerNewCustomer(Scanner option) {
        System.out.println("Informe o CPF do cliente:");
        String cpf = option.nextLine();
        System.out.println("Informe o nome do cliente:");
        String name = option.nextLine();
        System.out.println("Informe o telefone do cliente:");
        String phone = option.nextLine();
        Customer newCustomer = new Customer(
                cpf,
                name,
                phone
        );
        addCustomerToList(newCustomer);
    }

    public boolean checkIfCustomerRegistered(String CPF) {
        for (Customer customer : listCustomersRegistered) {
            if (customer.getCPF().equals(CPF)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String cpf) {
        for (Customer customer : listCustomersRegistered) {
            if (customer.getCPF().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }
}

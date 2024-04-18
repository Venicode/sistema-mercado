package controller;

import models.Login.Login;

import java.util.Scanner;

public class LoginController {
    public LoginController() {
        createLogin();
    }

    Login newLogin = new Login();

    public boolean checkLogin(String ID, String password) {
        return ID.equals(newLogin.getUser()) && password.equals(newLogin.getPassword());
    }
    public boolean login(Scanner option){
        System.out.println("\nRealize seu login:");
        System.out.println("Informe seu usuário:");
        String user = option.nextLine();
        System.out.println("Informe sua senha");
        String password = option.nextLine();
        if(checkLogin(user,password)){
            System.out.println("Acesso liberado!\n");
            return true;
        }
        System.out.println("Acesso negado.");
        return false;
    }
    public void createLogin() {
        newLogin.setUser("user");
        newLogin.setPassword("123");
    }
}

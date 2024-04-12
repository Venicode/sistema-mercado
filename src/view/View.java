package view;

public class View {
    public void welcome(){
        System.out.println("Olá, o que deseja fazer hoje?");
    }
    public void mainMenu(){
        System.out.println("1 - Realizar venda");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar cliente");
        System.out.println("4 - Cadastrar fornecedor");
        System.out.println("5 - Consultas");
        System.out.println("6 - Saldo do caixa");
        System.out.println("7 - Sair do programa");
    }
    public void reportsMenu(){
        System.out.println("Listar vendas realizadas");
        System.out.println("Listar produtos cadastrados");
        System.out.println("Listar clientes cadastrados");
        System.out.println("Listar fornecedores cadastrados");
    }
    public void farewell(){
        System.out.println("Tchau! Até logo!");
    }
}
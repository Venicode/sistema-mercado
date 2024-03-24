package models.People;

public class Client extends People {
    private String CPF;

    public Client(String CPF, String name, String phone) {
        super(name, phone);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}

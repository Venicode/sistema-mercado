package models.People;

public class Customer extends People {
    private String CPF;

    public Customer(String CPF, String name, String phone) {
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

package models.People;

public class Supplier extends People {
    private String email;
    private String CNPJ;
    public Supplier(String CNPJ, String name, String phone, String email){
        super(name, phone);
        this.CNPJ = CNPJ;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}

package models.People;

public class Supplier extends People {
    private String email;
    private String CNPJ;
    public Supplier(String name, String phone, String email, String CNPJ){
        super(name, phone);
        this.email = email;
        this.CNPJ = CNPJ;
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

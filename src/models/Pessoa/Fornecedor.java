package models.Pessoa;

public class Fornecedor extends Pessoa{
    private String email;
    private String CNPJ;
    public Fornecedor(String nomeCompleto, String telefone, String email, String CNPJ){
        super(nomeCompleto, telefone);
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

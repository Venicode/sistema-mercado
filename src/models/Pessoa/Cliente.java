package models.Pessoa;

public class Cliente extends Pessoa{
    private String CPF;

    public Cliente(String CPF,String nomeCompleto, String telefone) {
        super(nomeCompleto, telefone);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}

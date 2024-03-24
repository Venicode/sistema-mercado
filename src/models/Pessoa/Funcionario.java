package models.Pessoa;

public class Funcionario extends Pessoa{
    private int matricula;
    private String CPF;
    public  Funcionario(String nomeCompleto, String telefone, int matricula, String CPF){
        super(nomeCompleto, telefone);
        this.matricula = matricula;
        this.CPF = CPF;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}

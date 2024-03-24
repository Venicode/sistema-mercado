package models.Pagamento;

public class CartaoCredito extends Pagamento{
    private int quantidadeParcelas;
    CartaoCredito(int quantidadeParcelas, String tipoPagamento, double valor){
        super(tipoPagamento, valor);
        this.quantidadeParcelas = quantidadeParcelas;
    }
    public double calcularJuros(double valor){
        if(quantidadeParcelas>6){
            valor = valor + (valor*0.05);
            return valor;
        } else{
            return valor;
        }
    }

}

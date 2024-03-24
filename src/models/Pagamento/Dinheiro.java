package models.Pagamento;

public class Dinheiro extends Pagamento {
    public Dinheiro(String tipoPagamento, double valor) {
        super(tipoPagamento, valor);
    }
    public double calculaTroco(double valorPago){
        double valorTroco = valorPago - super.getValorPagamento();
        if(valorTroco<0){
            System.out.println("Dinheiro insuficiente para o pagamento.");
            System.out.println("Falta: "+valorTroco);
        }
        if(valorTroco ==0){
            return valorTroco;
        } System.out.println("Valor para troco: "+valorTroco);
        return valorTroco;
    }
}

package models.Pagamento;

public abstract class Pagamento {
    private String tipoPagamento;
    private double valorPagamento;

    public Pagamento(String tipoPagamento, double valorPagamento) {
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
}

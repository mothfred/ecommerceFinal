package ecommerce.pagamento;

public class PagamentoCredito implements FormaPagamento {

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento via credito realizado.");
        return valor;
    }
}

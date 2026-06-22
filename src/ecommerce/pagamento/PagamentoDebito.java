package ecommerce.pagamento;

public class PagamentoDebito implements FormaPagamento {

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento via debito realizado.");
        return valor;
    }
}

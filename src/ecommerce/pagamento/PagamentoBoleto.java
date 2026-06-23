package ecommerce.pagamento;

public class PagamentoBoleto implements FormaPagamento {

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento via boleto realizado.");
        return valor;
    }
}

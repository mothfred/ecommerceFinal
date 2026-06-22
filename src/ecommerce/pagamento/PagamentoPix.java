package ecommerce.pagamento;

public class PagamentoPix implements FormaPagamento {

    private static final double DESCONTO = 0.15;

    @Override
    public double pagar(double valor) {
        double valorComDesconto = valor * (1 - DESCONTO);
        System.out.println("Pagamento via PIX realizado com 15% de desconto.");
        return valorComDesconto;
    }
}

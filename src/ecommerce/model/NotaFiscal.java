package ecommerce.model;

public class NotaFiscal {

    private Pedido pedido;

    public NotaFiscal(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void emitir() {
        System.out.println("Nota fiscal emitida para o pedido " + pedido.getCodigo() + ".");
    }
}
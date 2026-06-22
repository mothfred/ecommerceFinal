package ecommerce.entrega;

public class RetiradaLoja implements Entrega{
    @Override
    public void entregar() {
        System.out.println("Poderá ser retirado na loja");
    }
}

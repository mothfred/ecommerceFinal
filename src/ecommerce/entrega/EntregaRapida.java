package ecommerce.entrega;

public class EntregaRapida implements Entrega{
    @Override
    public void entregar() {
        System.out.println("Entrega rapida selecionada. Estimativa de entrega em ate 3 dias");
    }
}

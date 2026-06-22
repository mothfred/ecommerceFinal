package ecommerce.entrega;

public class EntregaPadrao implements Entrega{
    @Override
    public void entregar(){
        System.out.println("Entrega padrão selecionada. Prazo estimado entre 7 a 15 dias");
    }
}

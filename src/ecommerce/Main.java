package ecommerce;
import java.util.Scanner;

import ecommerce.entrega.Entrega;
import ecommerce.entrega.EntregaRapida;
import ecommerce.entrega.EntregaPadrao;
import ecommerce.entrega.RetiradaLoja;
import ecommerce.model.*;
import ecommerce.pagamento.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Selecione o tipo de entrega");
        System.out.println("1=Entrega Padrao");
        System.out.println("2=Entrega Rapida");
        System.out.println("3=Retirada na Loja");
        System.out.println("Digite a opção");

        int opcao = sc.nextInt();

        Entrega entrega;
        if (opcao == 1) {
            entrega = new EntregaPadrao();
        }else if (opcao == 2) {
            entrega = new EntregaRapida();
        }else if (opcao == 3) {
            entrega = new RetiradaLoja();
        }else{
            System.out.println("Opção inválida");
            sc.close();
            return;
        }
        entrega.entregar();
        sc.close();
    }
}

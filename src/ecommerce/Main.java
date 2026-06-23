package ecommerce;

import java.util.Scanner;

import ecommerce.entrega.Entrega;
import ecommerce.entrega.EntregaPadrao;
import ecommerce.entrega.EntregaRapida;
import ecommerce.entrega.RetiradaLoja;
import ecommerce.model.AtendenteVirtual;
import ecommerce.model.Cliente;
import ecommerce.model.ClienteEmpresa;
import ecommerce.model.ClientePessoaFisica;
import ecommerce.model.Endereco;
import ecommerce.model.Pedido;
import ecommerce.model.Produto;
import ecommerce.pagamento.FormaPagamento;
import ecommerce.pagamento.PagamentoBoleto;
import ecommerce.pagamento.PagamentoCredito;
import ecommerce.pagamento.PagamentoDebito;
import ecommerce.pagamento.PagamentoPix;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema de E-commerce ===");

        Cliente cliente = criarCliente(sc);
        cliente.criarConta();

        Endereco endereco = criarEndereco(sc);
        cliente.registrarEndereco(endereco);

        FormaPagamento pagamento = escolherPagamento(sc);
        cliente.registrarFormaPagamento(pagamento);

        Entrega entrega = escolherEntrega(sc);

        Pedido pedido = new Pedido(1, cliente, pagamento, entrega);
        adicionarProdutos(sc, pedido);

        cliente.adicionarPedido(pedido);

        System.out.println();
        System.out.println("=== Dados do cliente ===");
        cliente.exibirDados();

        System.out.println();
        System.out.println("=== Finalizando pedido ===");
        pedido.finalizarPedido();

        System.out.println();
        AtendenteVirtual atendente = new AtendenteVirtual("Atendente Bot");
        cliente.contatarAtendente(atendente);

        sc.close();
    }

    private static Cliente criarCliente(Scanner sc) {
        System.out.println();
        System.out.println("Escolha o tipo de cliente:");
        System.out.println("1 - Pessoa fisica");
        System.out.println("2 - Empresa");
        int tipoCliente = lerInteiro(sc, "Opcao: ");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        if (tipoCliente == 2) {
            System.out.print("CNPJ: ");
            String cnpj = sc.nextLine();
            return new ClienteEmpresa(nome, email, cnpj);
        }

        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        return new ClientePessoaFisica(nome, email, cpf);
    }

    private static Endereco criarEndereco(Scanner sc) {
        System.out.println();
        System.out.println("Digite o endereco:");

        System.out.print("Rua: ");
        String rua = sc.nextLine();

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        System.out.print("CEP: ");
        String cep = sc.nextLine();

        return new Endereco(rua, cidade, cep);
    }

    private static FormaPagamento escolherPagamento(Scanner sc) {
        System.out.println();
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Boleto");
        System.out.println("2 - Credito");
        System.out.println("3 - Debito");
        System.out.println("4 - PIX");
        int opcao = lerInteiro(sc, "Opcao: ");

        if (opcao == 2) {
            return new PagamentoCredito();
        } else if (opcao == 3) {
            return new PagamentoDebito();
        } else if (opcao == 4) {
            return new PagamentoPix();
        }

        return new PagamentoBoleto();
    }

    private static Entrega escolherEntrega(Scanner sc) {
        System.out.println();
        System.out.println("Escolha o tipo de entrega:");
        System.out.println("1 - Entrega padrao");
        System.out.println("2 - Entrega rapida");
        System.out.println("3 - Retirada na loja");
        int opcao = lerInteiro(sc, "Opcao: ");

        if (opcao == 2) {
            return new EntregaRapida();
        } else if (opcao == 3) {
            return new RetiradaLoja();
        }

        return new EntregaPadrao();
    }

    private static void adicionarProdutos(Scanner sc, Pedido pedido) {
        System.out.println();
        int quantidade = lerInteiro(sc, "Quantos produtos deseja adicionar? ");

        for (int i = 1; i <= quantidade; i++) {
            System.out.println();
            System.out.println("Produto " + i + ":");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            double preco = lerDouble(sc, "Preco: R$ ");

            Produto produto = new Produto(nome, preco);
            pedido.adicionarProduto(produto);
        }
    }

    private static int lerInteiro(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        int numero = Integer.parseInt(sc.nextLine());
        return numero;
    }

    private static double lerDouble(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        String texto = sc.nextLine().replace(",", ".");
        double numero = Double.parseDouble(texto);
        return numero;
    }
}

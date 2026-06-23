package ecommerce.model;

import java.util.ArrayList;
import ecommerce.pagamento.FormaPagamento;

public abstract class Cliente {
    private String nome;
    private String email;
    private Endereco endereco;
    private FormaPagamento formaPagamento;
    private ArrayList<Pedido> pedidos;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(FormaPagamento formaPagamento) { this.formaPagamento = formaPagamento; }

    public ArrayList<Pedido> getPedidos() { return pedidos; }

    public void criarConta() {
        System.out.println("Conta criada para " + nome + ".");
    }

    public void registrarEndereco(Endereco endereco) {
        this.endereco = endereco;
        System.out.println("Endereço registrado para " + nome + ".");
    }

    public void registrarFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        System.out.println("Forma de pagamento registrada.");
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void contatarAtendente(AtendenteVirtual atendente) {
        atendente.atenderCliente(this);
    }

    public abstract void exibirDados();
}


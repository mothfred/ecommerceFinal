package ecommerce.model;

import ecommerce.entrega.Entrega;
import ecommerce.pagamento.FormaPagamento;
import java.util.ArrayList;

public class Pedido {

    private int codigo;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private FormaPagamento formaPagamento;
    private Entrega entrega;
    private NotaFiscal notaFiscal;

    public Pedido(int codigo, Cliente cliente, FormaPagamento formaPagamento, Entrega entrega) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.entrega = entrega;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao pedido.");
    }

    public void adicionarProduto(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
        System.out.println("Produto " + nome + " adicionado ao pedido.");
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public void finalizarPedido() {
        double total = calcularTotal();
        System.out.println("Total do pedido: R$ " + total);
        double valorFinal = formaPagamento.pagar(total);
        System.out.println("Valor final: R$ " + valorFinal);
        entrega.entregar();
        gerarNotaFiscal();
    }

    public void gerarNotaFiscal() {
        notaFiscal = new NotaFiscal(this);
        notaFiscal.emitir();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }
}
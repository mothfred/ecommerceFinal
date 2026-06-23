package ecommerce.model;

import java.util.ArrayList;

public class AtendenteVirtual {
    private String nome;
    private ArrayList<Cliente> clientesAtendidos;

    public AtendenteVirtual(String nome) {
        this.nome = nome;
        this.clientesAtendidos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public ArrayList<Cliente> getClientesAtendidos() { return clientesAtendidos; }

    public void atenderCliente(Cliente cliente) {
        this.clientesAtendidos.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " está sendo atendido pelo " + this.nome + ".");
    }
}
package ecommerce.model;

public class ClientePessoaFisica extends Cliente {
    private String cpf;

    public ClientePessoaFisica(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    // Demonstração de Sobrescrita
    @Override
    public void exibirDados() {
        System.out.println("Cliente Pessoa Física: " + getNome() + " | Email: " + getEmail() + " | CPF: " + cpf);
        if (getEndereco() != null) {
            getEndereco().exibirEndereco();
        }
    }
}

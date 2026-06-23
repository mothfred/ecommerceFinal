package ecommerce.model;

public class ClienteEmpresa extends Cliente {
    private String cnpj;

    public ClienteEmpresa(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    @Override
    public void exibirDados() {
        System.out.println("Cliente Empresa: " + getNome() + " | Email: " + getEmail() + " | CNPJ: " + cnpj);
        if (getEndereco() != null) {
            getEndereco().exibirEndereco();
        }
    }
}

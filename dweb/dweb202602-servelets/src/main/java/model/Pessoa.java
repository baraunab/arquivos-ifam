package model;
// model - utilizada apenas para representar dados
public class Pessoa {
    // Java Beans - protecao de atributos por meio
    // do modo privado
    private String nome;
    private String email;
    private String telefone;
    private Cidade cidade;

    // pode acessar o atributo
    public String getNome () {
        return nome;
    }
    // pode escrever no atributo
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}

package teste;

import model.Pessoa;

public class TestePessoa {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Beatriz Barauna Bitar");
        pessoa.setTelefone("4002-8922");
        pessoa.setEmail("beatriz@gmail.com");

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Telefone: " + pessoa.getTelefone());
        System.out.println("Email: " + pessoa.getEmail());

        /*TODO - atividade
        *  Criar as classes
        * Cidade: Nome, Estado
        * Estado: Nome, Sigla */
    }
}

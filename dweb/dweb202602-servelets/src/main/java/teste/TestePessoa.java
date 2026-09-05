package teste;

import model.Cidade;
import model.Estado;
import model.Pessoa;

public class TestePessoa {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        Estado estado = new Estado();
        Cidade cidade = new Cidade();

        pessoa.setNome("Beatriz Barauna Bitar");
        pessoa.setTelefone("4002-8922");
        pessoa.setEmail("beatriz@gmail.com");

        estado.setNome("Amazonas");
        estado.setSigla("AM");

        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        pessoa.setCidade(cidade);

        System.out.println("*****************************");
        System.out.println("+ Nome: " + pessoa.getNome());
        System.out.println("+ Telefone: " + pessoa.getTelefone());
        System.out.println("+ Email: " + pessoa.getEmail());
        System.out.println("+ Cidade: " + pessoa.getCidade().getNome());
        System.out.println("+ Estado (UF): " + pessoa.getCidade().getEstado().getNome() + " (" + pessoa.getCidade().getEstado().getSigla() + ")");
        System.out.println("*****************************");

        // Associação entre as classes
        // Servlets: biblioteca padrao do java para servidores
    }
}

package teste;

import model.Cidade;
import model.Estado;
import model.Pessoa;

import java.util.ArrayList;

public class TestaListaPessoa {

    public static void main(String[] args) {

        // Generics - passar tipagem para um elemento
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Beatriz Barauna Bitar");
        pessoa1.setTelefone("4002-8922");
        pessoa1.setEmail("beatriz@gmail.com");
        pessoa1.setCidade(cidade);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Joao");
        pessoa2.setTelefone("4020-8422");
        pessoa2.setEmail("joaor@gmail.com");
        pessoa2.setCidade(cidade);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Maria");
        pessoa3.setTelefone("4200-2922");
        pessoa3.setEmail("maria@gmail.com");
        pessoa3.setCidade(cidade);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        for(int i = 0; i < 3; i++) {
            System.out.println("+ Nome: " + pessoas.get(i).getNome());
            System.out.println("+ Telefone: " + pessoas.get(i).getTelefone());
            System.out.println("+ Email: " + pessoas.get(i).getEmail());
            System.out.println("+ Cidade: " + pessoas.get(i).getCidade().getNome());
            System.out.println("+ Estado (UF): " + pessoas.get(i).getCidade().getEstado().getNome() + " (" + pessoas.get(i).getCidade().getEstado().getSigla() + ")");
            System.out.println("*****************************");
        }

        for(Pessoa p:pessoas) {
            System.out.println("+ Nome: " +p.getNome());
            System.out.println("+ Telefone: " + p.getTelefone());
            System.out.println("+ Email: " + p.getEmail());
            System.out.println("+ Cidade: " + p.getCidade().getNome());
            System.out.println("+ Estado (UF): " + p.getCidade().getEstado().getNome() + " (" + p.getCidade().getEstado().getSigla() + ")");
            System.out.println("*****************************");
        }
    }
}

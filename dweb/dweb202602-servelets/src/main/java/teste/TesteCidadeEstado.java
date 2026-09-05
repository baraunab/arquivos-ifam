package teste;

import model.Cidade;
import model.Estado;

public class TesteCidadeEstado {

    public static void main(String[] args) {

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        System.out.println("\nEstado *************");
        System.out.println("Nome: " + estado.getNome());
        System.out.println("Sigla: " + estado.getSigla());

        System.out.println("\nCidade *************");
        System.out.println("Nome: " + cidade.getNome());
        Estado estadoEmCidade = cidade.getEstado();
        System.out.println("Estado: " + estadoEmCidade.getNome());
        System.out.println("Sigla: " + estadoEmCidade.getSigla());

        System.out.println("\nCidade/Estado (Sigla): "
                            + cidade.getNome() + "/"
                            + cidade.getEstado().getNome() + " ("
                            + cidade.getEstado().getSigla() + ")");

    }
}
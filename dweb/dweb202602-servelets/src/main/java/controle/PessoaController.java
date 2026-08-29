package controle;

import model.Pessoa;

import java.util.Scanner;

public class PessoaController {
    public void adicionarPessoa () {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Nome");
        System.out.println(pessoa.getNome());


    }
}

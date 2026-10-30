package edu.ifam.tads.dweb.servlet;

import edu.ifam.tads.dweb.model.Cidade;
import edu.ifam.tads.dweb.model.Estado;
import edu.ifam.tads.dweb.model.Pais;
import edu.ifam.tads.dweb.model.Pessoa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PessoaServlet extends HttpServlet {

    private List<Pessoa> pessoas;
    private List<Cidade> cidades;

    public void init(){

        this.cidades = new ArrayList<Cidade>();

        this.pessoas = new ArrayList<Pessoa>();

        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setSigla("BR");

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");
        estado.setPais(pais);

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        Cidade cidade2 = new Cidade();
        cidade2.setNome("Manacapuru");
        cidade2.setEstado(estado);

        Cidade cidade3 = new Cidade();
        cidade3.setNome("Autazes");
        cidade3.setEstado(estado);

        cidades.add(cidade);
        cidades.add(cidade2);
        cidades.add(cidade3);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Rogerio");
        pessoa1.setTelefone("3234-5678");
        pessoa1.setEmail("rogerio@ifam.edu.br");
        pessoa1.setCidade(cidade);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("João");
        pessoa2.setTelefone("3234-0001");
        pessoa2.setEmail("joao@ifam.edu.br");
        pessoa2.setCidade(cidade);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Maria");
        pessoa3.setTelefone("3234-0002");
        pessoa3.setEmail("maria@ifam.edu.br");
        pessoa3.setCidade(cidade);

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Leonardo");
        pessoa4.setTelefone("3234-0003");
        pessoa4.setEmail("leo@ifam.edu.br");
        pessoa4.setCidade(cidade);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

            String acao = req.getParameter("acao");
            if(acao == null){
                acao = "listar";
            }

            if(acao.equals("listar")) {

                req.setAttribute("listaPessoas", pessoas);

                RequestDispatcher dispatcher = req.getRequestDispatcher("pessoas.jsp");

                dispatcher.forward(req, resp);
            }else if(acao.equals("cadastrar")){

                RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro.jsp");
                dispatcher.forward(req, resp);

            }else if(acao.equals("salvar")){

                String nome = req.getParameter("nome");
                String telefone = req.getParameter("telefone");
                String email = req.getParameter("email");

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setTelefone(telefone);
                pessoa.setEmail(email);

                pessoas.add(pessoa);

                resp.sendRedirect("pessoa?acao=listar");

            }
    }

}

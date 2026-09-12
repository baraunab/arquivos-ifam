package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cidade;
import model.Estado;
import model.Pessoa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OlaIfamServlet extends HttpServlet {
    // protocolo http - get/post sao metodos

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        PrintWriter saida = resp.getWriter();

        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("     <meta charsert=\"UTF-8\">");
        saida.println("     <title>Ola ifam</title>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("     <h1>Olá IFAM!</h1>");
      /*  saida.println("     <p><b>Nome</b>: " + pessoa.getNome() + " </p>");
        saida.println("     <p><b><i>Email</b></i>: " + pessoa.getEmail() + " </p>");
        saida.println("     <p><b>Telefone</b>: " + pessoa.getTelefone() + " </p>");
        saida.println("     <p><b>Cidade</b>: " + pessoa.getCidade().getNome() + " </p>");
        saida.println("     <p><b>Estado (UF)</b>: " + pessoa.getCidade().getEstado().getNome() + " <b>(" + pessoa.getCidade().getEstado().getSigla() + ")</b>  </p>");*/
        saida.println("     <table border=1px>");
        saida.println("         <caption>Tabela 1: Dados de Pessoa</caption>");
        saida.println("         <thead>");
        saida.println("             <tr>");
        saida.println("                 <th>Nome</th>");
        saida.println("                 <th>Email</th>");
        saida.println("                 <th>Telefone</th>");
        saida.println("                 <th>Cidade</th>");
        saida.println("                 <th>Estado</th>");
        saida.println("             </tr>");
        saida.println("         </thead>");
        saida.println("         <tbody>");

        for(Pessoa p:pessoas) {
            saida.println("             <tr>");
            saida.println("                 <td>" + p.getNome() + "</td>");
            saida.println("                 <td>" + p.getEmail() + "</td>");
            saida.println("                 <td>" + p.getTelefone() + "</td>");
            saida.println("                 <td>" + p.getCidade().getNome() + "</td>");
            saida.println("                 <td>" + p.getCidade().getEstado().getNome() + "</td>");
            saida.println("             <tr>");
        }

        saida.println("         </tbody>");
        saida.println("     </table>");
        saida.println("</body>");
        saida.println("</html>");
        // Atividade
        // Colocar os dados da pessoa em uma tabela
    }
}
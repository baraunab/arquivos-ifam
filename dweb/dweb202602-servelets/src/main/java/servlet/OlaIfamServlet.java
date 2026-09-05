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

public class OlaIfamServlet extends HttpServlet {
    // protocolo http - get/post sao metodos

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Pessoa pessoa = new Pessoa();
        Estado estado = new Estado();
        Cidade cidade = new Cidade();

        estado.setNome("Amazonas");
        estado.setSigla("AM");

        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        pessoa.setNome("Beatriz");
        pessoa.setEmail("beatriz@gmail.com");
        pessoa.setTelefone("4002-8922");
        pessoa.setCidade(cidade);

        PrintWriter saida = resp.getWriter();

        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("<meta charsert=\"UTF-8\">");
        saida.println("<title>Ola ifam</title>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("<h1>Olá IFAM!</h1>");
        saida.println("<p>Nome: " + pessoa.getNome() + " </p>");
        saida.println("<p>Email: " + pessoa.getEmail() + " </p>");
        saida.println("<p>Telefone: " + pessoa.getTelefone() + " </p>");
        saida.println("<p>Cidade: " + pessoa.getCidade().getNome() + " </p>");
        saida.println("<p>Estado (UF): " + pessoa.getCidade().getEstado().getNome() + " (" + pessoa.getCidade().getEstado().getSigla() + ")  </p>");
        saida.println("</body>");
        saida.println("</html>");
    }
}

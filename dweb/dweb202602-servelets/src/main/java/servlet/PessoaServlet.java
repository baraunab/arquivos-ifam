package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cidade;
import model.Estado;
import model.Pessoa;
import org.eclipse.jdt.internal.compiler.lookup.InferenceVariable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PessoaServlet extends HttpServlet {
    // protocolo http - get/post sao metodos

    private List<Pessoa> pessoas;
    private List<Cidade> cidades;

    public void init () {
        this.pessoas = new ArrayList<Pessoa>();
        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        Cidade cidade1 = new Cidade();
        cidade1.setNome("Presidente Figueiredo");
        cidade1.setEstado(estado);

        this.cidades = new ArrayList<Cidade>();
        cidades.add(cidade);
        cidades.add(cidade1);

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

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");
        if (acao == null) { acao = "listar"; }

        String parametroNome = req.getParameter("nome");
        if(parametroNome == null) {parametroNome = "";}

        // verificar se o botao salvar foi pressionado
        String botaoSalvar = req.getParameter("salvar");
        if (botaoSalvar != null) {

            // pegar dados dos parametros na url
            String parNome = req.getParameter("nome");
            String parEmail = req.getParameter("email");
            String parTelefone = req.getParameter("telefone");
            String parCidade = req.getParameter("cidade");
            
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(parNome);
            pessoa.setEmail(parEmail);
            pessoa.setTelefone(parTelefone);
            pessoa.setCidade(cidades.get(Integer.parseInt(parCidade)));

            // adiciona a nova pessoa na lista
            pessoas.add(pessoa);

            resp.sendRedirect("pessoa");
        }

        PrintWriter saida = resp.getWriter();

        Pessoa addPessoa = new Pessoa();

        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("     <meta charsert=\"UTF-8\">");
        saida.println("     <title>Gerenciamento de pessoas</title>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("<h1>Gerenciamento de Pessoas</h1>");
        saida.println("<br>");

        if(acao.equals("listar")) {
            saida.println("<a href='pessoa?acao=cadastrar'>+ Cadastrar Pessoa</a>");
            saida.println("<br>");
            saida.println("<br>");
            saida.println("<form method='GET' action='pessoa'>");
            saida.println("     <label for='filtroNome' style=\"padding-right: 3px\">Nome</label>");
            saida.println("     <input type='text' id='filtroNome' name='nome' value=''/>");
            saida.println("     <br>");
            saida.println("     <button type='submit' style=\"padding-left: 3px\">Pesquisar</button>");
            saida.println("</form>");
            saida.println("     <table border=1px>");
            saida.println("         <caption>Tabela 1: Dados de Pessoa</caption>");
            saida.println("         <thead>");
            saida.println("             <tr>");
            saida.println("                 <th>Nome</th>");
            saida.println("                 <th>Email</th>");
            saida.println("                 <th>Telefone</th>");
            saida.println("                 <th>Cidade/Sigla</th>");
            saida.println("             </tr>");
            saida.println("         </thead>");
            saida.println("         <tbody>");
            for(Pessoa p:pessoas) {

                if (p.getNome().contains(parametroNome)) {
                    saida.println("             <tr>");
                    saida.println("                 <td>" + p.getNome() + "</td>");
                    saida.println("                 <td>" + p.getEmail() + "</td>");
                    saida.println("                 <td>" + p.getTelefone() + "</td>");
                    saida.println("                 <td>" + p.getCidade().getNome() + "/"+ p.getCidade().getEstado().getSigla() +"</td>");
                    saida.println("             </tr>");

                }
            }

            saida.println("         </tbody>");
            saida.println("     </table>");

        } else if (acao.equals("cadastrar")) {
            saida.println("<form method='GET' action='pessoa'>");
            saida.println("     <label for='campoNome' style=\"padding-right: 3px\">Nome: </label>");
            saida.println("     <input type='text' id='campoNome' name='nome' value=''/>");
            saida.println("<br> <br>");
            saida.println("     <label for='campoEmail' style=\"padding-right: 3px\">Email: </label>");
            saida.println("     <input type='text' id='campoEmail' name='email' value=''/>");
            saida.println("<br> <br>");
            saida.println("     <label for='campoTelefone' style=\"padding-right: 3px\">Telefone: </label>");
            saida.println("     <input type='text' id='campTelefone' name='telefone' value=''/>");
            saida.println("<br> <br>");

            saida.println("<label>Cidade/Sigla</label>");
            saida.println("<select name='cidade'>");
            int i = 0;
            for(Cidade c:cidades) {
                saida.println("     <option value='"+ i +"'>" + c.getNome() + "/" + c.getEstado().getSigla() + "<option>");
                i++;
            }
            saida.println("</select for='cidade'>");
            saida.println("<br> <br>");
            saida.println("     <button type='submit' name='salvar' value='pressionado' style=\"padding-left: 3px\">Salvar</button>");
            saida.println("</form>");

        }

        saida.println("<br>");
        saida.println("<br>");
        saida.println("</body>");
        saida.println("</html>");
    }
}
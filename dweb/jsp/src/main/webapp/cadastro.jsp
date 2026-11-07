<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.ifam.tads.dweb.model.Pessoa" %>
<%@ page import="edu.ifam.tads.dweb.model.Cidade" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Pessoas - JSP</title>
    </head>
    <body>
        <h2>Cadastro de Pessoas com JSP e Servlet</h2>

        <%
            List<Pessoa> listaPessoas = (List<Pessoa>) request.getAttribute("listaPessoas");
            String idEditar = (String) request.getAttribute("idEditar");
        %>

        <form method="POST" action="pessoa">

            <input type='hidden' id='id' name='id' value='<% if (idEditar != null) out.print(idEditar); else out.print("");%>'></input>

            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" value="<% if (idEditar != null) out.print(listaPessoas.get(Integer.parseInt(idEditar)).getNome()); %>" required /><br><br>

            <label for="telefone">Telefone:</label><br>
            <input type="text" id="telefone" name="telefone" value="<% if (idEditar != null) out.print(listaPessoas.get(Integer.parseInt(idEditar)).getTelefone()); %>" required><br><br>

            <label for="email">Email:</label><br>
            <input type="text" id="email" name="email" value="<% if (idEditar != null) out.print(listaPessoas.get(Integer.parseInt(idEditar)).getEmail()); %>" required><br><br>

            <label for="cidade">Cidade:</label><br>
            <select id="cidade" name="cidade" required>
                <%
                List<Cidade> listaCidades = (List<Cidade>) request.getAttribute("listaCidades");

                for (int i = 0; i < listaCidades.size(); i++) {
                    Cidade cidade = listaCidades.get(i);
                %>

                <option value="<%out.print(i);%>" <% if (idEditar != null && Integer.parseInt(idEditar) == i) out.print("selected"); %>>
                    <% out.println(cidade.getNome()); %>
                </option>

                <%
                }
                %>
            </select><br><br>

            <button type="submit" name="acao" value="salvar">Salvar</button>
            <a href="pessoa?acao=listar">Cancelar</a>
        </form>
    </body>
</html>
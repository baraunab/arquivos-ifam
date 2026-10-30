<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.ifam.tads.dweb.model.Pessoa" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Pessoas - JSP</title>
    </head>
    <body>
        <h2>Cadastro de Pessoas com JSP e Servlet</h2>

        <form method="GET" action="pessoa">

            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome" required><br><br>

            <label for="telefone">Telefone:</label><br>
            <input type="text" id="telefone" name="telefone" required><br><br>

            <label for="email">Email:</label><br>
            <input type="text" id="email" name="email" required><br><br>

            <button type="submit" name="acao" value="salvar">Salvar</button>
            <a href="pessoa?acao=listar">Cancelar</a>
        </form>
    </body>
</html>





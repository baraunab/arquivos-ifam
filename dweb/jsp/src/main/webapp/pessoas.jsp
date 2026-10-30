<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.ifam.tads.dweb.model.Pessoa" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Pessoas - JSP</title>
</head>
<body>
    <h2>Gerenciamento de Pessoas com JSP e Servlet</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>País</th>
        </tr>

    <%
    // Scriptlet
        List<Pessoa> listaPessoas = (List<Pessoa>) request.getAttribute("listaPessoas");

        if(listaPessoas != null){
            for(Pessoa p: listaPessoas){
    %>
        <tr>
            <td><% out.println(p.getNome()); %></td>
            <td><% out.println(p.getTelefone()); %></td>
            <td><% out.println(p.getEmail()); %></td>
            <td><% out.println(p.getCidade() != null ? p.getCidade().getNome() : "-"); %></td>
            <td><% out.println(p.getCidade() != null && p.getCidade().getEstado() != null ? p.getCidade().getEstado().getSigla() : "-"); %></td>
            <td><% out.println(p.getCidade() != null && p.getCidade().getEstado() != null && p.getCidade().getEstado().getPais() != null ? p.getCidade().getEstado().getPais().getNome() : "-"); %></td>
         </tr>


    <%
            }
        }
    %>
    </table>
    <br>
    <a href="pessoa?acao=cadastrar">Cadastrar</a>
</body>
</html>


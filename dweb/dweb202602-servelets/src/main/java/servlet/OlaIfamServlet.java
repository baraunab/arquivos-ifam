package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class OlaIfamServlet extends HttpServlet {
    // protocolo http - get/post sao metodos

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter saida = resp.getWriter();

        saida.println("<!DOCTYPE html>");
        saida.println("<html lang=\"pt-br\">");
        saida.println("<head>");
        saida.println("<meta charsert=\"UTF-8\">");
        saida.println("<title>Ola ifam</title>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("<h1>Olá IFAM!</h1>");
        saida.println("</body>");
        saida.println("</html>");
    }
}

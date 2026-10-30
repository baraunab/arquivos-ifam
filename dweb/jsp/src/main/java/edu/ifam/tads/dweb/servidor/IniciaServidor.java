package edu.ifam.tads.dweb.servidor;

import edu.ifam.tads.dweb.servlet.PessoaServlet;
import jakarta.servlet.Servlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class IniciaServidor {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector(); // Iniciar o conector HTTP do tomcat.

        String webapp = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("",webapp);

        String nomeServlet="PessoaServlet";
        Tomcat.addServlet(context,nomeServlet, new PessoaServlet());

        context.addServletMappingDecoded("/pessoa",nomeServlet);

//        http://localhost:8080/pessoa

        System.out.println("Servidor Tomcat rodando...");

        tomcat.start();
        tomcat.getServer().await();

    }

}

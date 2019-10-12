package com.hotelar.controllers;

import com.hotelar.contratos.Comandos;
import com.hotelar.entidades.BancoDeDados;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controller", urlPatterns = {"/Controller/*"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            String paramAction = request.getParameter("acao");

            String nomeDaClasse = "com.hotelar.comandos." + paramAction;
            Class classeAction = Class.forName(nomeDaClasse);
            
            Comandos comandoAction = (Comandos)classeAction.newInstance();
            
            String pageDispatcher = comandoAction.executar(request, response);
            
            request.getRequestDispatcher(pageDispatcher).forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

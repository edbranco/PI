/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "ServletFilialAlterar", urlPatterns = {"/ServletFilialAlterar"})
public class ServletFilialAlterar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        boolean mensagem = false;
        
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Filial.jsp");
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idTexto = request.getParameter("idFilial");
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        Filial filial = new Filial();

        FilialDAO dao = new FilialDAO();
        
        if (botaoValor.equals("Pesquisar")) {
            dao.consultarFilial(filial, id);
        }
        else if (botaoValor.equals("Alterar")) {
           
           
            String nome = request.getParameter("nomeFilial");
            String cnpj = request.getParameter("cnpj");
            String uf = request.getParameter("uf");
        
            filial.setNomefilial(nome);
            filial.setCnpj(cnpj);
            filial.setUf(uf);

            dao.alterarFiial(filial, id);
           
            boolean mensagem = true;
        
            request.setAttribute("mensagem", mensagem);
        }

        request.setAttribute("filial", filial);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Filial.jsp");
        disp.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

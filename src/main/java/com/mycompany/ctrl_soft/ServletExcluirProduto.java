/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eder Rodrigues
 */
@WebServlet(name = "ServletExcluirProduto", urlPatterns = {"/ServletExcluirProduto"})
public class ServletExcluirProduto extends HttpServlet {

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
        boolean semRegistro = false;
        boolean produtoExiste = false;
        
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("semRegistro", semRegistro);
        request.setAttribute("produtoExiste", produtoExiste);

        RequestDispatcher disp
                = request.getRequestDispatcher("ExcluirProduto.jsp");
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
//        processRequest(request, response);
        
            String idTexto = request.getParameter("idProduto");
            int id = Integer.parseInt(idTexto);
            String botaoValor = request.getParameter("btn-consultar");

            Produto produto = new Produto();
            Produto produtoTeste = new Produto();

            ProdutoDAO dao = new ProdutoDAO();
            boolean semRegistro;
            boolean produtoExiste;

            if (botaoValor.equals("Pesquisar")) {   
                produtoTeste = dao.consultarProduto(produto, id);

                if (produtoTeste.nome.equals("")) {
                    semRegistro = true;
                    produtoExiste = false;
                    request.setAttribute("semRegistro", semRegistro);
                    request.setAttribute("produtoExiste", produtoExiste);
                } else {
                    semRegistro = false;
                    produtoExiste = true;
                    request.setAttribute("semRegistro", semRegistro);
                    request.setAttribute("produtoExiste", produtoExiste);
                    request.setAttribute("produto", produto);
                }
            }
            else {            
                boolean excluido = dao.exluirProduto(id);

                if (excluido == true) {
                    boolean mensagem = true;
                    semRegistro = false;
                    request.setAttribute("mensagem", mensagem); 
                    request.setAttribute("semRegistro", semRegistro);
                } else {
                    boolean mensagem = false;
                    semRegistro = true;
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("semRegistro", semRegistro);
                }
            }        
        
            RequestDispatcher disp
                = request.getRequestDispatcher("ExcluirProduto.jsp");
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

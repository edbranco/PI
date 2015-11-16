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
 * @author Douglas
 */
@WebServlet(name = "ServletFuncionarioExcluir", urlPatterns = {"/ServletFuncionarioExcluir"})
public class ServletFuncionarioExcluir extends HttpServlet {

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
        boolean funcionarioExiste = false;
        
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("semRegistro", semRegistro);
        request.setAttribute("funcionarioExiste", funcionarioExiste);

        RequestDispatcher disp
                = request.getRequestDispatcher("Excluir_Funcionario.jsp");
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
        //processRequest(request, response);
        String idTexto = request.getParameter("idfuncionario");
        int id = Integer.parseInt(idTexto);
        String botaoValor = request.getParameter("btn-consultar");

        Funcionario funcionario = new Funcionario();
        Funcionario funcionarioTeste = new Funcionario();        

        FuncionarioDAO dao = new FuncionarioDAO();        
        boolean semRegistro;
        boolean funcionarioExiste;
        
        if (botaoValor.equals("Pesquisar")) {   
            funcionarioTeste = dao.consultarFuncionario(funcionario, id);
            
            if (funcionarioTeste.uf.equals("")) {
                semRegistro = true;
                funcionarioExiste = false;
                request.setAttribute("semRegistro", semRegistro);
                request.setAttribute("funcionarioExiste", funcionarioExiste);
            } else {
                semRegistro = false;
                funcionarioExiste = true;
                request.setAttribute("semRegistro", semRegistro);
                request.setAttribute("funcionarioExiste", funcionarioExiste);
                request.setAttribute("funcionario", funcionario);
            }
        }
        else {            
            boolean excluido = dao.excluirFuncionario(funcionario, id);
            
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
            = request.getRequestDispatcher("Excluir_Funcionario.jsp");
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

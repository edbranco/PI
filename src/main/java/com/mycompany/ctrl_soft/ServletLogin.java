/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eder Rodrigues
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
       // processRequest(request, response);
        String usuario;
        String senha;

        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");

        // Validar nome de usuário e senha.
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        funcionario = funcionarioDAO.validarFuncionario(funcionario, usuario, senha);

        if (funcionario != null) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                // Força invalidação da sessão anterior.
                sessao.invalidate();
            }
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", funcionario);
            RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
            rd.forward(request, response);
            return;
            // FIM CASO SUCESSO
        }
        response.sendRedirect("Erro.jsp");

//        if (valorBotao.equals("OK")) {
//            usuario = request.getParameter("usuario");
//            senha = request.getParameter("senha");
//            Login login = new Login(usuario,senha);
//            
//            
//            
//            LoginDAO log = new LoginDAO();
//            log.Autenticar(usuario,senha,login);
//            
//            if (log.getK() == true) {
//                request.setAttribute("login", login);
//
//                RequestDispatcher disp
//                        = request.getRequestDispatcher("Menu.jsp");
//                disp.forward(request, response);
//            } else {
//                request.setAttribute("login", login);
//                RequestDispatcher disp
//                        = request.getRequestDispatcher("Erro.jsp");
//                disp.forward(request, response);
//            }
//
//        }
    }
    // Implementar aqui a validação do usuário com os dados
    // armazenados no banco de dados.

    

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
        HttpSession sessao = request.getSession(false);
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/Login_Usuario.jsp");
            rd.forward(request, response);
            return;
        }
        response.sendRedirect("/");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuarioLogin = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        FuncionarioDAO userDao = new FuncionarioDAO();
        
        Funcionario usuario = validar(usuarioLogin, senha);
        if (usuario != null) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                // Força invalidação da sessão anterior.
                sessao.invalidate();
            }
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect("Menu.jsp");
            return;
            // FIM CASO SUCESSO
        }
        response.sendRedirect("Erro.jsp");

    }

    private Funcionario validar(String usuarioLogin, String senha) {
        
        FuncionarioDAO userDao = new FuncionarioDAO();
        
        Funcionario usuario = userDao.buscarUsuario(usuarioLogin, senha);
        
        if (usuario != null && userDao.autenticar(usuarioLogin, senha)) {
            return usuario;
        }
        return null;
    }
}
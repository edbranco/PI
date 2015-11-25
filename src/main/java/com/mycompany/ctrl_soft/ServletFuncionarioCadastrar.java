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
 * @author Ude
 */
@WebServlet(name = "ServletFuncionarioCadastrar", urlPatterns = {"/ServletFuncionarioCadastrar"})
public class ServletFuncionarioCadastrar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCadastrarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCadastrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String nome = request.getParameter("nomefuncionario");
        String usuario = request.getParameter("nomeusuario");
        String senha = request.getParameter("senhausuario");
        long filial = Long.valueOf(request.getParameter("filialfuncionario"));
        int ra = Integer.valueOf(request.getParameter("rafuncionario"));
        String cpf = request.getParameter("cpffuncionario");
        String telefone = request.getParameter("telefonefuncionario");
        String email = request.getParameter("emailfuncionario");
        String endereco = request.getParameter("enderecofuncionario");
        String cidade = request.getParameter("cidadefuncionario");
        String uf = request.getParameter("estadofuncionario");
        String cargo = request.getParameter("cargofuncionario");

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setUsuario(usuario);      
        funcionario.setSenha(senha);
        funcionario.setIdFilial(filial);
        funcionario.setRa(ra);
        funcionario.setCpf(cpf);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        funcionario.setCidade(cidade);
        funcionario.setUf(uf);
        funcionario.setCargo(cargo);

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.cadastrarFuncionario(funcionario);

        request.setAttribute("funcionario", funcionario);
        
        boolean mensagem = true;
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher disp
            = request.getRequestDispatcher("Cadastrar_Funcionario.jsp");
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

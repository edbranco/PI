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
 * @author Ude
 */
@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})
public class ServletAlterarUsuario extends HttpServlet {

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
            out.println("<title>Servlet AlterarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarUsuario at " + request.getContextPath() + "</h1>");
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

        String idTexto = request.getParameter("idUsuario");
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        Usuario usu = new Usuario();

        ConexaoUsuarioDAO dao = new ConexaoUsuarioDAO();

        if (botaoValor.equals("Pesquisar")) {
            dao.alterarUsuario(usu, id);
        } else {
            String nomeUsuario = request.getParameter("nomeUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            String nomeFuncionario = request.getParameter("telefoneUsuario");
            int ra = Integer.parseInt(request.getParameter("raUsuario"));
            String cpf = request.getParameter("cpfUsuario");
            String telefone = request.getParameter("telefoneUsuario");
            String email = request.getParameter("emailUsuario");
            String endereco = request.getParameter("enderecoUsuario");
            String cidade = request.getParameter("cidadeUsuario");
            String uf = request.getParameter("ufUsuario");
            String cargo = request.getParameter("cargoUsuario");

            usu.setNomeUsuario(nomeUsuario);
            usu.setSenhaUsuario(senhaUsuario);
            usu.setNomeFuncionario(nomeFuncionario);
            usu.setRa(ra);
            usu.setCpf(cpf);
            usu.setTelefone(telefone);
            usu.setEmail(email);
            usu.setEndereco(endereco);
            usu.setCidade(cidade);
            usu.setUf(uf);
            usu.setCargo(cargo);

            dao.alterarUsuario(usu, id);
        }

        request.setAttribute("usu", usu);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Usuario.jsp");
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

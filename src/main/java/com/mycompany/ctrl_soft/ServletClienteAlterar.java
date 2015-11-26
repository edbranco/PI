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
@WebServlet(name = "ServletClienteAlterar", urlPatterns = {"/ServletClienteAlterar"})
public class ServletClienteAlterar extends HttpServlet {

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
        
        //Variáveis de verificação
        boolean mensagem = false;
        boolean habilitado = false;
        boolean semRegistro = false;
        
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("habilitado", habilitado);
        request.setAttribute("semRegistro", semRegistro);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Cliente.jsp");
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
        
        //Valores dos campos do formulário
        String idTexto = request.getParameter("idCliente");
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        //Cria um novo objeto cliente e outro de teste
        Cliente cliente = new Cliente();
        Cliente clienteTeste = new Cliente();

        //Cria objeto do tipo DAO
        ClienteDAO dao = new ClienteDAO();
        //variável que indica se há registros
        boolean semRegistro;
        
        //Verifica qual dos botões foi acionado
        if (botaoValor.equals("Pesquisar")) {   
            clienteTeste = dao.consultarCliente(cliente, id);
            //Se a coluna UF do banco estiver vazia, significa q o cliente não existe
            if (clienteTeste.uf.equals("")) {
                semRegistro = true;
                boolean habilitado = false; //variável que habilita campos
                request.setAttribute("habilitado", habilitado);
                request.setAttribute("semRegistro", semRegistro);
            } else {
                semRegistro = false;                
                boolean habilitado = true;
                request.setAttribute("habilitado", habilitado);
                request.setAttribute("semRegistro", semRegistro);
            }
        }
        else {
            
            String nome = request.getParameter("nomeCliente");
            String cpf = request.getParameter("cpfCliente");
            String telefone = request.getParameter("telefoneCliente");
            String email = request.getParameter("emailCliente");
            String endereco = request.getParameter("enderecoCliente");
            String cidade = request.getParameter("cidadeCliente");
            String uf = request.getParameter("estadoCliente");

            //Setando novo cliente
            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setCidade(cidade);
            cliente.setUf(uf);

            //Objeto DAO chama função alterar
            dao.alterarCliente(cliente, id);
            
            boolean mensagem = true; //variável q mostra ou não mensagem
            request.setAttribute("mensagem", mensagem);
        }

        request.setAttribute("cliente", cliente);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Cliente.jsp");
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

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
@WebServlet(name = "ServletFuncionarioAlterar", urlPatterns = {"/ServletFuncionarioAlterar"})
public class ServletFuncionarioAlterar extends HttpServlet {

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
        
        //instancia a FilialDAO
        FilialDAO filial = new FilialDAO();
   
        //lista a filial
        List<Filial> listaFilial = filial.listarFilial();

        request.setAttribute("listaFilial", listaFilial);
        //seta o atributo
        
        boolean mensagem = false;
        boolean habilitado = false;
        boolean semRegistro = false;
        
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("habilitado", habilitado);
        request.setAttribute("semRegistro", semRegistro);
        
        //seta os atributos
        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Funcionario.jsp");
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

        String idTexto = request.getParameter("idfuncionario");//recupera o parâmetro
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        // instancia a classe Funcionário  
        Funcionario funcionario = new Funcionario(); 
        Funcionario funcionarioTeste = new Funcionario();

        FuncionarioDAO dao = new FuncionarioDAO();
        boolean semRegistro;
        
        
        if (botaoValor.equals("Pesquisar")) {   
            // se o usuário selecionar o botão pesquisar a classe se de teste irá consultar o Funcionário
            funcionarioTeste = dao.consultarFuncionario(funcionario, id);
            
            if (funcionarioTeste.uf.equals("")) {
                // se for nulo não há registro
                semRegistro = true;
                boolean habilitado = false;
                 //Seta os atributos
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
            String nome = request.getParameter("nomefuncionario");
            long filial = Long.valueOf(request.getParameter("filialfuncionario"));
            int ra = Integer.valueOf(request.getParameter("rafuncionario"));
            String cpf = request.getParameter("cpffuncionario");
            String telefone = request.getParameter("telefonefuncionario");
            String email = request.getParameter("emailfuncionario");
            String endereco = request.getParameter("enderecofuncionario");
            String cidade = request.getParameter("cidadefuncionario");
            String uf = request.getParameter("estadofuncionario");
            String cargo = request.getParameter("cargofuncionario");

            funcionario.setId(id);
            funcionario.setNome(nome);
            funcionario.setIdFilial(filial);
            funcionario.setRa(ra);
            funcionario.setCpf(cpf);
            funcionario.setTelefone(telefone);
            funcionario.setEmail(email);
            funcionario.setEndereco(endereco);
            funcionario.setCidade(cidade);
            funcionario.setUf(uf);
            funcionario.setCargo(cargo);

            // altera o Funcionário
            dao.alterarFuncionario(funcionario, id);
            
            boolean mensagem = true;
            request.setAttribute("mensagem", mensagem);
        }

        request.setAttribute("funcionario", funcionario); // seta o atributo
        
        //instancia a filial
        FilialDAO filial = new FilialDAO();
   
        //Lista a filial
        List<Filial> listaFilial = filial.listarFilial();

        //Seta o Atributo listaFilial
        request.setAttribute("listaFilial", listaFilial);

        //Despacha para a jsp.Alterar_Funcionario
        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Funcionario.jsp");
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

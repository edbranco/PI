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
        //Mensagens de verificações
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
            //Pegando os parametros do usuário idproduto
            String idTexto = request.getParameter("idProduto");
            //convertendo o idproduto em int
            int id = Integer.parseInt(idTexto);
            //analisando qual funcionalidade usuario deseja realizar
            String botaoValor = request.getParameter("btn-consultar");
            //Instancia a classe produto sendo uma para teste de verificação
            Produto produto = new Produto();
            Produto produtoTeste = new Produto();
            //Instanciando classe para chamado dos métodos
            ProdutoDAO dao = new ProdutoDAO();
            //Booleans de verificações de registro
            boolean semRegistro;
            boolean produtoExiste;
            //Significa que o usuario clicou em Pesquisar
            if (botaoValor.equals("Pesquisar")) {   
                //Variavel recebe resultado do método de consulta de acordo com o produto e id
                produtoTeste = dao.consultarProduto(produto, id);
                //Verificando se houve retorno de alguem produto
                if (produtoTeste.nome.equals("")) {
                    //comprova sem registro
                    semRegistro = true;
                    produtoExiste = false;
                    request.setAttribute("semRegistro", semRegistro);
                    request.setAttribute("produtoExiste", produtoExiste);
                } else {
                    //Comprova que houve registro e produto existe
                    semRegistro = false;
                    produtoExiste = true;
                    request.setAttribute("semRegistro", semRegistro);
                    request.setAttribute("produtoExiste", produtoExiste);
                    request.setAttribute("produto", produto);
                }
            }
            //Usuario solicitou a funcionalidade de exclusão de produtos
            else {  
                //Boolean verificando se houve foi feito a exclusao
                boolean excluido = dao.exluirProduto(id);

                if (excluido == true) {
                    //excluido com sucesso
                    boolean mensagem = true;
                    semRegistro = false;
                    request.setAttribute("mensagem", mensagem); 
                    request.setAttribute("semRegistro", semRegistro);
                } else {
                    //excluido sem sucesso
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

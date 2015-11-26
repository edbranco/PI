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

/**
 *
 * @author Lucas
 */
@WebServlet(name = "ServletPreVendaProduto", urlPatterns = {"/ServletPreVendaProduto"})
public class ServletPreVendaProduto extends HttpServlet {

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
                = request.getRequestDispatcher("PreVendaProduto.jsp");
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
       
        //Valores dos campos do formulário
        String idTexto = request.getParameter("idProduto");
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        //Cria um novo objeto produto e outro de teste
        Produto produto = new Produto();
        Produto produtoTeste = new Produto();

        //Cria objeto do tipo DAO
        ProdutoDAO dao = new ProdutoDAO();
        //variável que indica se há registros
        boolean semRegistro;
        
        //Verifica qual dos botões foi acionado
        if (botaoValor.equals("Pesquisar")) {   
            produtoTeste = dao.consultarProduto(produto, id);
            //Se a coluna nome do banco estiver vazia, significa q o produto não existe
            if (produtoTeste.nome.equals("")) {
                semRegistro = true;
                boolean habilitado = false;
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
            String idFilialTexto = request.getParameter("idfilial");
            int idfilial = Integer.parseInt(idFilialTexto);
            String nome = request.getParameter("nomeProduto");
            String marca = request.getParameter("marcaProduto");
            String preco = request.getParameter("precoProduto");
            int qtde = Integer.parseInt(request.getParameter("qtdeProduto"));
            
            //Setando novo cliente
            produto.setId_filial(idfilial);
            produto.setId(id);
            produto.setNome(nome);
            produto.setMarca(marca);
            produto.setPreco(Double.parseDouble(preco));
            produto.setQtde(qtde);
            
            boolean mensagem = true;
            request.setAttribute("mensagem", mensagem);
            
            request.setAttribute("produto", produto);
            
             RequestDispatcher disp
                = request.getRequestDispatcher("Efetuar_Venda.jsp");
        disp.forward(request, response);
        }

        request.setAttribute("produto", produto);

        RequestDispatcher disp
                = request.getRequestDispatcher("PreVendaProduto.jsp");
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

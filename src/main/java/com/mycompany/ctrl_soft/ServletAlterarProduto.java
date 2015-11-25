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
@WebServlet(name = "ServletAlterarProduto", urlPatterns = {"/ServletAlterarProduto"})
public class ServletAlterarProduto extends HttpServlet {

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
        boolean habilitado = false;
        boolean semRegistro = false;
        
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("habilitado", habilitado);
        request.setAttribute("semRegistro", semRegistro);

        RequestDispatcher disp
                = request.getRequestDispatcher("AlterarProduto.jsp");
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
        //Pegando id do parametro do usuario
        String idTexto = request.getParameter("idProduto");
        //pegando valor do submit 
        
        String botaoValor = request.getParameter("btn-consultar");
        //Atribuindo id do usuario em uma variavel
        int id = Integer.parseInt(idTexto);
        
        //Criando duas instancias da classe produto, sendo uma para teste
        Produto produto = new Produto();
        Produto produtoTeste = new Produto();
        
        //Instanciando a classe para chamar os métodos
        ProdutoDAO dao = new ProdutoDAO();
        //Boolean com para confirmar se houve registro no banco
        boolean semRegistro;
        //Observando qual Função o usuário chamou No caso Pesquisar Produto
        if (botaoValor.equals("Pesquisar")) {  
            //Produto teste recebendo o resultado do método de consulta
            produtoTeste = dao.consultarProduto(produto, id);
            //Verificando se houve retorno conforme com os parametros
            if (produtoTeste.nome.equals("")) {
                //Entrando nesse if signifca que não foi encotrado o Produto procurado
                semRegistro = true;
                boolean habilitado = false;
                request.setAttribute("habilitado", habilitado);
                request.setAttribute("semRegistro", semRegistro);
            } else {
                //Entrando nesse if signifca que foi encotrado o Produto procurado
                semRegistro = false;                
                boolean habilitado = true;
                request.setAttribute("habilitado", habilitado);
                request.setAttribute("semRegistro", semRegistro);
            }
        }
        //Else responsavel por mostrar a requisição do Alterar Produto
        else {
            //Pegando atributos do input
            String nome = request.getParameter("nomeProduto");
            String marca = request.getParameter("marcaProduto");
            String preco = request.getParameter("precoProduto");
            int qtde = Integer.parseInt(request.getParameter("qtdeProduto"));
            
            //Setando os atributos do input na instancia da classe Produto
            produto.setId(id);
            produto.setNome(nome);
            produto.setMarca(marca);
            produto.setPreco(Double.parseDouble(preco));
            produto.setQtde(qtde);
            //chamando o método alterar
            dao.alterarProduto(produto, id);
            //Boolean que certifica que foi feito a alteração com sucesso
            boolean mensagem = true;
            request.setAttribute("mensagem", mensagem);
        }

        request.setAttribute("produto", produto);

        RequestDispatcher disp
                = request.getRequestDispatcher("AlterarProduto.jsp");
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

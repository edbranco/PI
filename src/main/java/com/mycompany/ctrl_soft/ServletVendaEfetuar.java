/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "ServletVendaEfetuar", urlPatterns = {"/ServletVendaEfetuar"})
public class ServletVendaEfetuar extends HttpServlet {

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
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
   
        List<Produto> listaProduto = produtoDAO.listarProdutos();
        
        boolean mensagem = false;
        boolean mensagem2 = false;
        boolean clienteExiste = true;

        request.setAttribute("listaProduto", listaProduto);
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("mensagem2", mensagem2);
        request.setAttribute("clienteExiste", clienteExiste);
        
          RequestDispatcher disp = request.getRequestDispatcher("Efetuar_Venda.jsp");
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
        
        long idProduto = Long.valueOf(request.getParameter("vendaproduto"));
        long idFilial = Long.valueOf(request.getParameter("idfilial"));
        long idFuncionario = Long.valueOf(request.getParameter("idfuncionario"));
        String cpf = request.getParameter("vendacliente");
        double preco = Double.valueOf(request.getParameter("vendapreco"));
        int qtde = Integer.valueOf(request.getParameter("qtdeproduto"));
        
        //variáveis que checam se cliente existe e se foi cadastrado
        boolean clienteExiste;
        boolean mensagem;
        boolean mensagem2;
        boolean prodEmEstoque;
        
        Venda venda = new Venda();        
        VendaDAO dao = new VendaDAO(); 
        
        //Cliente a ser verificado a existência
        Cliente cliente = new Cliente();
        
        dao.consultarCpfCliente(cliente, cpf);
        prodEmEstoque = dao.consultarProduto(idProduto, qtde);
        
        if (cliente.id != null) {
            if (prodEmEstoque == false) {
                clienteExiste = true;
                mensagem = false;
                mensagem2 = true;
            } else {           
                venda.setId_produto(idProduto);
                venda.setId_filial(idFilial);
                venda.setId_funcionario(idFuncionario);
                venda.setId_cliente(cliente.id);
                venda.setPreco(preco);
                venda.setDt_cadastro(new Date());

                clienteExiste = true;

                dao.efetuarVenda(venda, qtde);

                mensagem = true;
                mensagem2 = false;
            }
        } else {
            clienteExiste = false;
            mensagem = false;
            mensagem2 = false;
        }
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
   
        List<Produto> listaProduto = produtoDAO.listarProdutos();

        request.setAttribute("listaProduto", listaProduto);        
        request.setAttribute("venda", venda);
        request.setAttribute("clienteExiste", clienteExiste);
        request.setAttribute("mensagem", mensagem);
        request.setAttribute("mensagem2", mensagem2);

        RequestDispatcher disp
            = request.getRequestDispatcher("Efetuar_Venda.jsp");
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

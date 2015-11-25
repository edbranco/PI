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
 * @author Lucas
 */
@WebServlet(name = "ServletFilialAlterar", urlPatterns = {"/ServletFilialAlterar"})
public class ServletFilialAlterar extends HttpServlet {

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
                = request.getRequestDispatcher("Alterar_Filial.jsp");
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
        //Recebe id Filial da requisição
        String idTexto = request.getParameter("idFilial");
        //Recebe o value do botão que foi usado na requisição
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);
        
        //Cria objetos da classe filial
        Filial filial = new Filial();
        Filial filialTeste = new Filial();
        
        //Cria objeto da classe FilialDAO onde estão localizados os metodos de Filial
        FilialDAO dao = new FilialDAO();
        boolean semRegistro;
        //Caso value btn-consultar seja Pesquisar é chamada a função consultarFILIAL
        if (botaoValor.equals("Pesquisar")) {
            filialTeste = dao.consultarFilial(filial, id);
            
            //Verifica se a pesquisa retornou alguma filial
            if (filialTeste.uf.equals("")) {
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
        //Caso value btn-consultar seja "Alterar" é resgatado os campos e chamada a função alterarFilial
        else if (botaoValor.equals("Alterar")) {          
            String nome = request.getParameter("nomeFilial");
            String cnpj = request.getParameter("cnpj");
            String uf = request.getParameter("uf");
        
            filial.setIdfilial(id);
            filial.setNomefilial(nome);
            filial.setCnpj(cnpj);
            filial.setUf(uf);

            dao.alterarFiial(filial, id);
           
            boolean mensagem = true;        
            request.setAttribute("mensagem", mensagem);
        }

        request.setAttribute("filial", filial);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Filial.jsp");
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

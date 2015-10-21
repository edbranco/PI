/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eder Rodrigues
 */
public class Estoque {
       private Connection obterConexao() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        // Passo 1: Registrar driver JDBC.
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        // Passo 2: Abrir a conexão
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ctrl_bd;SecurityMechanism=3",
                "duel", // usuario
                "duel"); // senha
        return conn;
    }
    
    public void cadastrarProduto(ProdutosDAO p) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO PRODUTO (NOME_PRODUTO, MARCA_PRODUTO, " // ESPACO ANTES DO "
                + "VL_PRECO, VL_QTDE, DT_CADASTRO) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getMarca());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQtde());
            stmt.setDate(5, new java.sql.Date(p.getDtCadastro().getTime()));
            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public List<ProdutosDAO> listarProdutos() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_PRODUTO, NOME_PRODUTO, MARCA_PRODUTO, VL_PRECO, VL_QTDE FROM PRODUTO";
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            List<ProdutosDAO> listaProdutos = new ArrayList<ProdutosDAO>();
            while (resultados.next()) {
                ProdutosDAO p = new ProdutosDAO();
                p.setId(resultados.getLong("ID_PRODUTO"));
                p.setNome(resultados.getString("NOME_PRODUTO"));
                p.setMarca(resultados.getString("MARCA_PRODUTO"));
                p.setPreco(resultados.getDouble("VL_PRECO"));
                p.setQtde(resultados.getInt("VL_QTDE"));
                listaProdutos.add(p);
            }
            return listaProdutos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}

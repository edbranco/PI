/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class FilialDAO {

    private Long idfilial;
    private String nomefilial;
    private String uf;
    private String cnpj;

    public FilialDAO() {
    }

    public FilialDAO(String nomefilial, String uf, String cnpj) {

        this.nomefilial = nomefilial;
        this.uf = uf;
        this.cnpj = cnpj;

    }
    
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

       public void cadastrarFilial(FilialDAO f) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_FILIAL (NOME_FILIAL, UF, " // ESPACO ANTES DO "
                + "CNPJ) VALUES (?, ?, ?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, f.getNomefilial());
            stmt.setString(2, f.getUf());
            stmt.setString(3, f.getCnpj());
            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
       
           public void excluirFilial(int id) {
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "DELETE FROM TB_Filial WHERE ID_Filial = ?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro excluídoo com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * @return the idfilial
     */
    public Long getIdfilial() {
        return idfilial;
    }

    /**
     * @param idfilial the idfilial to set
     */
    public void setIdfilial(Long idfilial) {
        this.idfilial = idfilial;
    }

    /**
     * @return the nomefilial
     */
    public String getNomefilial() {
        return nomefilial;
    }

    /**
     * @param nomefilial the nomefilial to set
     */
    public void setNomefilial(String nomefilial) {
        this.nomefilial = nomefilial;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eder Rodrigues
 */
public class LoginDAO {

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

    public Login Autenticar(String usuario, String senha, Login login) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        long id = 0;
        

        String sql = "Select ID_Funcionario FROM TB_Funcionario WHERE Senha= 'admin'  AND Usuario = 'admin' ";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql);

            while (resultados.next()) {

                id = Long.parseLong(resultados.getString("ID_Funcionario"));
             
            }
            //seta o id_filial para a classe de produto
            login.setId(id);
            

            return login;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            return null;
    }
}

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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class FilialDAO {


    public FilialDAO() {
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

    public void cadastrarFilial(Filial f) {
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

    public void alterarFiial(Filial filial, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "UPDATE TB_Filial SET Nome_Filial=?, UF=?, CNPJ=? "
                + " WHERE ID_Filial = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
                       
            stmt.setString(1, filial.getNomefilial());
            stmt.setString(2, filial.getUf());
            stmt.setString(3, filial.getCnpj());
            
            stmt.setLong(4, id);
            stmt.executeUpdate();
            System.out.println("Registro alterado com sucesso.");

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
    
    public Filial consultarFilial(Filial filial, int id) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String nome = "";
        String cnpj = "";
        String uf = "";
        Long idfilial = null;
            
        String sql2 = "SELECT * FROM TB_Filial WHERE ID_Filial = " + id;
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            while (resultados.next()) {
                idfilial = Long.parseLong(resultados.getString("ID_Filial"));
                nome = resultados.getString("Nome_Filial");
                uf = resultados.getString("uf");
                cnpj = resultados.getString("cnpj");
                
            }
           
            filial.setIdfilial(idfilial);
            filial.setCnpj(cnpj);
            filial.setNomefilial(nome);
            filial.setUf(uf);

            return filial;

        } catch (SQLException ex) {
            Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Filial> listarFilial() {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String sql2 = "SELECT * FROM TB_Filial";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            ArrayList<Filial> listaFilial = new ArrayList<Filial>();

            while (resultados.next()) {
                //Cliente temporário
                Filial filial = new Filial();

                filial.setNomefilial(resultados.getString("nome_filial"));
      

                listaFilial.add(filial);
            }
            return listaFilial;

        } catch (SQLException ex) {
            Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Filial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

 
}

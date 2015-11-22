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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eder Rodrigues
 */
public class ProdutoDAO {

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

    public void cadastrarProduto(Produto p) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        long id_filial_user_logado = p.id_filial;

//        String sql2 = "SELECT ID_FILIAL FROM TB_Funcionario WHERE ID_Funcionario = 1";
//        try {
//            conn = obterConexao();
//            stmt2 = conn.createStatement();
//            ResultSet resultados = stmt2.executeQuery(sql2);
//
//            while (resultados.next()) {
//                id_filial_user_logado = resultados.getInt("ID_FILIAL");
//            }
//            //seta o id_filial para a classe de produto
//            p.setId_filial(id_filial_user_logado);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }

        String sql = "INSERT INTO TB_PRODUTO (ID_FILIAL, NOMEPRODUTO, MARCA, " // ESPACO ANTES DO "
                + "PRECO, QTDE) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setLong(1, p.getId_filial());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getMarca());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getQtde());
//            stmt.setDate(5, new java.sql.Date(p.getDtCadastro().getTime()));
            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void alterarProduto(Produto produto, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_Produto SET NomeProduto=?, Marca=?, Preco=?, Qtde=?  "
                + " WHERE ID_Produto= ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQtde());
            stmt.setLong(5, produto.getId());
            stmt.executeUpdate();
            System.out.println("Registro alterado com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Produto consultarProduto(Produto produto, int id) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String nome = "";
        String marca = "";
        double preco = 0;
        int qtde = 0;
        int idf = 0;
        int idp = 0;

        String sql2 = "SELECT * FROM TB_Produto WHERE ID_Produto = " + id;
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            while (resultados.next()) {

                nome = resultados.getString("NomeProduto");
                marca = resultados.getString("Marca");
                preco = Double.parseDouble(resultados.getString("preco"));
                qtde = Integer.parseInt(resultados.getString("Qtde"));
                idf = Integer.parseInt(resultados.getString("ID_Filial"));
                idp = Integer.parseInt(resultados.getString("ID_Produto"));
            }
            //seta o id_filial para a classe de produto
            produto.setNome(nome);
            produto.setMarca(marca);
            produto.setPreco(preco);
            produto.setQtde(qtde);
            produto.setId(idp);
            produto.setId_filial(idf);

            return produto;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Produto> listarProdutos() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_Produto";
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultados.next()) {
                Produto p = new Produto();
                p.setId(resultados.getLong("ID_PRODUTO"));
                p.setId_filial(resultados.getLong("ID_Filial"));
                p.setNome(resultados.getString("NOMEPRODUTO"));
                p.setMarca(resultados.getString("MARCA"));
                p.setPreco(resultados.getDouble("PRECO"));
                p.setQtde(resultados.getInt("QTDE"));
                listaProdutos.add(p);
            }
            return listaProdutos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public List<Produto> listaProdutos(String nome) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TB_PRODUTO WHERE NomeProduto LIKE LOWER('%" + nome + "%')";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            List<Produto> listaProdutos = new ArrayList<Produto>();
            while (resultados.next()) {
                Produto p = new Produto();
                p.setId(resultados.getLong("ID_PRODUTO"));
                p.setId_filial(resultados.getLong("ID_Filial"));
                p.setNome(resultados.getString("NOMEPRODUTO"));
                p.setMarca(resultados.getString("MARCA"));
                p.setPreco(resultados.getDouble("PRECO"));
                p.setQtde(resultados.getInt("QTDE"));
                listaProdutos.add(p);
  
            }
            return listaProdutos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public boolean exluirProduto(int id){
        boolean cadastrado = false;
        
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "DELETE FROM TB_Produto WHERE ID_Produto= ?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
                       
            stmt.setInt(1, id);
            int retorno = stmt.executeUpdate();
            
            if (retorno == 1){
                cadastrado = true;
            }else{
                cadastrado = false;
            }
            
            return cadastrado;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

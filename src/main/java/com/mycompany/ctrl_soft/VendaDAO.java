/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.util.Date;
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
 * @author Douglas
 */
public class VendaDAO {
    
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
    
    //Função que efetua as Vendas
    public boolean efetuarVenda(Venda venda, int qtde) {
        boolean cadastrado = false;
        
        PreparedStatement stmt = null;
        Connection conn = null;      
        double preco = venda.getPreco();
        preco *= qtde;
        
        
        String sql = "INSERT INTO TB_Venda (ID_Filial, ID_Produto, ID_Cliente, ID_Funcionario, "
                + "DataVenda, PrecoTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);            
           
            stmt.setLong(1, venda.getId_filial());
            stmt.setLong(2, venda.getId_produto());
            stmt.setLong(3, venda.getId_cliente());
            stmt.setLong(4, venda.getId_funcionario());
            stmt.setDate(5, new java.sql.Date(venda.getDt_cadastro().getTime()));
            stmt.setDouble(6, preco);
            stmt.executeUpdate();
            
            cadastrado = true;
            Long id_produto = venda.getId_produto();
            diminuirEstoque(qtde, id_produto);
            return cadastrado;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return cadastrado;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return cadastrado;
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
    
    public List<Venda> relatorio() {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String sql2 = "Select tb_produto.NOMEPRODUTO,tb_filial.Nome_Filial,tb_funcionario.NomeFuncionario, tb_venda.precototal, tb_venda.DATAVENDA\n" +
            "from TB_PRODUTO \n" +
            "inner join tb_venda on tb_produto.id_produto = tb_venda.id_produto\n" +
            "inner join tb_Filial on tb_filial.id_filial = tb_venda.id_filial\n" +
            "inner join tb_funcionario on tb_funcionario.id_funcionario = tb_venda.id_funcionario"
                + " Order by tb_filial.NOME_FILIAL";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            ArrayList<Venda> relatorio = new ArrayList<Venda>();

            
            
            while (resultados.next()) {
            Venda venda = new Venda();  
                venda.setNomeProduto(resultados.getString("NOMEPRODUTO"));
                venda.setNomeFilial(resultados.getString("NOME_FILIAL"));
                venda.setNomeFuncionario(resultados.getString("NOMEFUNCIONARIO"));
                venda.setPreco(resultados.getDouble("PRECOTOTAL"));
                venda.setDt_cadastro(resultados.getDate("DATAVENDA"));
                relatorio.add(venda);
            }
            return relatorio;

        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public List<Venda> relatorioFilial(int id) {
        
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        String sql2 = "Select tb_produto.NOMEPRODUTO,tb_filial.Nome_Filial,tb_funcionario.NomeFuncionario, tb_venda.precototal, tb_venda.DATAVENDA\n" +
"            from TB_PRODUTO\n" +
"            inner join tb_venda on tb_produto.id_produto = tb_venda.id_produto\n" +
"           inner join tb_Filial on tb_filial.id_filial = tb_venda.id_filial\n" +
"           inner join tb_funcionario on tb_funcionario.id_funcionario = tb_venda.id_funcionario\n" +
" \n" +
"                            where TB_FILIAL.ID_FILIAL = "+id+ "";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
            ArrayList<Venda> relatorioFilial = new ArrayList<Venda>();
            
            while (resultados.next()) {
            Venda venda = new Venda();  
                venda.setNomeProduto(resultados.getString("NOMEPRODUTO"));
                venda.setNomeFilial(resultados.getString("NOME_FILIAL"));
                venda.setNomeFuncionario(resultados.getString("NOMEFUNCIONARIO"));
                venda.setPreco(resultados.getDouble("PRECOTOTAL"));
                venda.setDt_cadastro(resultados.getDate("DATAVENDA"));
                relatorioFilial.add(venda);
            }
            return relatorioFilial;

        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    //Função de consulta de Clientes
    public Cliente consultarCpfCliente(Cliente cliente, String cpf) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        Long id = null;
        
        String sql2 = "SELECT * FROM TB_Cliente WHERE CPF = '" + cpf + "'";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
//            if(resultados == null){
//                return null;
//            }

            while (resultados.next()) {          
                id = resultados.getLong("ID_Cliente");
            }
            //seta o id_filial para a classe de produto
            cliente.setId(id);
            
            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Função para diminuir qtde em estoque dos produtos
    public void diminuirEstoque(int qtde, Long id_produto) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        int qtdeAtual = 0;
        int novaQtde = 0;
        
        //Pegar qtde atual
        String sql2 = "SELECT Qtde FROM TB_Produto WHERE ID_Produto = " + id_produto;
        
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            while (resultados.next()) {          
                qtdeAtual = resultados.getInt("Qtde");
            }
            
            novaQtde = qtdeAtual - qtde;
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }           
            
            

        String sql = "UPDATE TB_Produto SET Qtde=? "
                + "WHERE ID_Produto=?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, novaQtde);
            stmt.setLong(2, id_produto);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Consultar qtde em estoque, pra saber se é possível comprar
    public boolean consultarProduto(long idProduto, int qtde) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        int qtdeAtual = 0;
        int novaQtde = 0;
        
        String sql2 = "SELECT Qtde FROM TB_Produto WHERE ID_Produto = " + idProduto;
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            while (resultados.next()) {          
                qtdeAtual = resultados.getInt("Qtde");
            }
            
            novaQtde = qtdeAtual - qtde;
            
            if (novaQtde < 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}

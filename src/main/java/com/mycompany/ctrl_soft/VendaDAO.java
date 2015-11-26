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
        
        //String que responsável pela query que será feita ao banco
        String sql = "INSERT INTO TB_Venda (ID_Filial, ID_Produto, ID_Cliente, ID_Funcionario, "
                + "DataVenda, PrecoTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);            
           
            //Atribuindo ao banco os dados que estão no objeto Cliente
            stmt.setLong(1, venda.getId_filial());
            stmt.setLong(2, venda.getId_produto());
            stmt.setLong(3, venda.getId_cliente());
            stmt.setLong(4, venda.getId_funcionario());
            stmt.setDate(5, new java.sql.Date(venda.getDt_cadastro().getTime()));
            stmt.setDouble(6, preco);
            stmt.executeUpdate();
            
            cadastrado = true;
            
            //variável q recebe o id do produto
            Long id_produto = venda.getId_produto();
            //chama função que diminui quantidade da venda do estoque
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
    //Função que retorna todas as vendas, foi utilizado inner join para receber outros atributos da chave estrangeira
    public List<Venda> relatorio() {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        //String que responsável pela query que será feita ao banco
        String sql2 = "Select tb_cliente.NOMECLIENTE, tb_produto.NOMEPRODUTO,tb_filial.Nome_Filial,tb_funcionario.NomeFuncionario, tb_venda.precototal, tb_venda.DATAVENDA\n" +
"            from TB_PRODUTO \n" +
"            inner join tb_venda on tb_produto.id_produto = tb_venda.id_produto\n" +
"            inner join tb_Filial on tb_filial.id_filial = tb_venda.id_filial\n" +
"            inner join tb_funcionario on tb_funcionario.id_funcionario = tb_venda.id_funcionario\n" +
"            inner join tb_cliente on tb_cliente.ID_CLIENTE = tb_venda.ID_CLIENTE\n" +
"               Order by tb_filial.NOME_FILIAL";
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            //Objeto do tipo lista
            ArrayList<Venda> relatorio = new ArrayList<Venda>();

            
            //Enquanto houver vendas, estas serão adicionados à lista
            while (resultados.next()) {
            Venda venda = new Venda();  
                venda.setNomeCliente(resultados.getString("NOMECLIENTE"));
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
    
    //Função similiar a relatorio, no entanto é passado um id de filial como parametro, a função retorna apenas os relatorios de uma filial
    public List<Venda> relatorioFilial(int id) {
        
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        //String que responsável pela query que será feita ao banco
        String sql2 = "Select tb_cliente.NOMECLIENTE, tb_produto.NOMEPRODUTO,tb_filial.Nome_Filial,tb_funcionario.NomeFuncionario, tb_venda.precototal, tb_venda.DATAVENDA\n" +
"            from TB_PRODUTO \n" +
"            inner join tb_venda on tb_produto.id_produto = tb_venda.id_produto\n" +
"            inner join tb_Filial on tb_filial.id_filial = tb_venda.id_filial\n" +
"            inner join tb_funcionario on tb_funcionario.id_funcionario = tb_venda.id_funcionario\n" +
"            inner join tb_cliente on tb_cliente.ID_CLIENTE = tb_venda.ID_CLIENTE\n" +
"              \n" +
"          where TB_FILIAL.ID_FILIAL = "+id+"\n" +
"                 Order by tb_filial.NOME_FILIAL";
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
            //Novo objeto do tipo lista
            ArrayList<Venda> relatorioFilial = new ArrayList<Venda>();
            
            //Enquanto houver vendas, estas serão adicionados à lista
            while (resultados.next()) {
            Venda venda = new Venda();  
                venda.setNomeCliente(resultados.getString("NOMECLIENTE"));
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
        
        //String que responsável pela query que será feita ao banco
        String sql2 = "SELECT * FROM TB_Cliente WHERE CPF = '" + cpf + "'";
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
//            if(resultados == null){
//                return null;
//            }

            //Enquanto houver clientes, estes serão adicionados à lista
            while (resultados.next()) {          
                id = resultados.getLong("ID_Cliente");
                cliente.setId(id);
            }
            
            
            
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
        
        //String que responsável pela query que será feita ao banco
        String sql2 = "SELECT Qtde FROM TB_Produto WHERE ID_Produto = " + id_produto;
        
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            //Pega quantidade atual em estoque
            while (resultados.next()) {          
                qtdeAtual = resultados.getInt("Qtde");
            }
            
            //Nova quantidade em estoque
            novaQtde = qtdeAtual - qtde;
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }           
            
            
        //Faz Update no banco
        String sql = "UPDATE TB_Produto SET Qtde=? "
                + "WHERE ID_Produto=?";

        try {
            //Obtendo conexão do banco
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
        
        //String que responsável pela query que será feita ao banco
        String sql2 = "SELECT Qtde FROM TB_Produto WHERE ID_Produto = " + idProduto;
        try {
            //Obtendo conexão do banco
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            //Pega quantidade atual
            while (resultados.next()) {          
                qtdeAtual = resultados.getInt("Qtde");
            }
            
            novaQtde = qtdeAtual - qtde;
            
            //Verifica se é possível realizar compra
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

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
public class ClienteDAO {
    
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
    
    //Função de cadastro de Clientes
    public void cadastrarCliente(Cliente cliente) {
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "INSERT INTO TB_Cliente (NomeCliente, CPF, Telefone, Email, "
                + "Endereco, Cidade, UF) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);            
           
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getUf());
//            stmt.setDate(5, new java.sql.Date(p.getDtCadastro().getTime()));
            stmt.executeUpdate();
            System.out.println("Registro incluído com sucesso.");

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
    
    //Função de exclusão de Clientes
    public void excluirCliente(int id) {
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "DELETE FROM TB_Cliente WHERE ID_Cliente = ?";
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
    
    //Função de consulta de Clientes
    public Cliente consultarCliente(Cliente cliente, int id) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String nome = "";
        String cpf = "";
        String telefone = "";
        String email = "";
        String endereco = "";
        String cidade = "";
        String uf = "";
        
        String sql2 = "SELECT * FROM TB_Cliente WHERE ID_Cliente = " + id;
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            while (resultados.next()) {
                
                nome = resultados.getString("NomeCliente");
                cpf = resultados.getString("CPF");
                telefone = resultados.getString("Telefone");
                email = resultados.getString("Email");
                endereco = resultados.getString("Endereco");
                cidade = resultados.getString("Cidade");
                uf = resultados.getString("UF");
            }
            //seta o id_filial para a classe de produto
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setCidade(cidade);
            cliente.setUf(uf);
            
            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Função de alteração de Clientes
    public void alterarCliente(Cliente cliente, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;       
        
        String sql = "UPDATE TB_Cliente SET NomeCliente=?, CPF=?, Telefone=?, Email=?, Endereco=?, "
                + "Cidade=?, UF=? WHERE ID_Cliente = ?";
        
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
                       
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getUf());
            stmt.setLong(8, id);
            stmt.executeUpdate();
            System.out.println("Registro alterado com sucesso.");

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
    
    //Função de listar Clientes
    public List<Cliente> listarCliente(String nome) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        String sql2 = "SELECT * FROM TB_Cliente WHERE NomeCliente LIKE '%" + nome + "%'";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);

            List<Cliente> listaClientes = new ArrayList<Cliente>();
            
            while (resultados.next()) {
                //Cliente temporário
                Cliente clienteTemp = new Cliente();
                
                clienteTemp.setId(resultados.getLong("ID_Cliente"));
                clienteTemp.setNome(resultados.getString("NomeCliente"));
                clienteTemp.setCpf(resultados.getString("CPF"));
                clienteTemp.setTelefone(resultados.getString("Telefone"));
                clienteTemp.setEmail(resultados.getString("Email"));
                clienteTemp.setEndereco(resultados.getString("Endereco"));
                clienteTemp.setCidade(resultados.getString("Cidade"));
                clienteTemp.setUf(resultados.getString("UF"));
                
                //Adiciona na lista o cliente temporário
                listaClientes.add(clienteTemp);
            }
            return listaClientes;

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}

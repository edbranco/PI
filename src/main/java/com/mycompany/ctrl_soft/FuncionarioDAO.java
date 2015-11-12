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
 * @author Ude
 */
public class FuncionarioDAO {

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

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        boolean cadastrado = false;
        
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO TB_Funcionario (ID_Filial, Usuario, Senha, NomeFuncionario, RA, CPF, "
                    + "Telefone, Email, Endereco, Cidade, UF, Cargo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, funcionario.getIdFilial());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getNome());
            stmt.setInt(5, funcionario.getRa());
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getTelefone());
            stmt.setString(8, funcionario.getEmail());
            stmt.setString(9, funcionario.getEndereco());
            stmt.setString(10, funcionario.getCidade());
            stmt.setString(11, funcionario.getUf());
            stmt.setString(12, funcionario.getCargo());

            stmt.executeUpdate();
            
            cadastrado = true;
            return cadastrado;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void alterarFuncionario(Funcionario usu, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_FUNCIONARIO SET NomeUsuario = ?, Senha = ?, nomeFuncionario = ?, RA = ?, CPF = ?, "
                + "Telefone = ?, Email = ?, Endereco = ?, Cidade = ?, UF = ?, Cargo = ?) WHERE id ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usu.getNomeUsuario());
            stmt.setString(2, usu.getSenhaUsuario());
            stmt.setString(3, usu.getNomeFuncionario());
            stmt.setInt(4, usu.getRa());
            stmt.setString(5, usu.getCpf());
            stmt.setString(6, usu.getTelefone());
            stmt.setString(7, usu.getEmail());
            stmt.setString(8, usu.getEndereco());
            stmt.setString(9, usu.getCidade());
            stmt.setString(10, usu.getUf());
            stmt.setString(11, usu.getCargo());
            stmt.setInt(12, usu.getIdUsuario());
            stmt.execute();
            stmt.close();
//            stmt.executeUpdate();
            System.out.println("Alterado Com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirFuncionario(Funcionario usu, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM TB_Funcionario WHERE ID_Usuario = ?";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro excluído com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Funcionario> ListarFuncionarios() {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TF_Funcionario";

        List<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Funcionario usu = new Funcionario();

                usu.setIdUsuario(resultado.getInt("id"));
                usu.setNomeUsuario(resultado.getString("nomeUsuario"));
                usu.setSenhaUsuario(resultado.getString("senhaUsuario"));
                usu.setNomeFuncionario(resultado.getString("nomeFuncionario"));
                usu.setRa(resultado.getInt("ra"));
                usu.setCpf(resultado.getString("cpf"));
                usu.setTelefone(resultado.getString("telefone"));
                usu.setEndereco(resultado.getString("endereco"));
                usu.setCidade(resultado.getString("cidade"));
                usu.setUf(resultado.getString("uf"));
                usu.setCargo(resultado.getString("cargo"));
                lista.add(usu);
            }
            System.out.println("Busca Realizada!");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

}

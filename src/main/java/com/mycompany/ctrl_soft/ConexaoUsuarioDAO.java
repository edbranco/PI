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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ude
 */
public class ConexaoUsuarioDAO {

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

    public void cadastrarUsuario(Usuario usu, String nomeFilial) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT id_filial FROM TB_Filial where nome_filial = "+nomeFilial+"";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            int idFilial = 0;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                idFilial = rs.getInt("ID_Filial");
            }
            usu.setIdFilial(idFilial);

            
            
           String sql2 = "INSERT INTO TB_FUNCIONARIO (id_filial,Usuario, Senha, nomeFuncionario, RA, CPF, "
                    + "Telefone, Email, Endereco, Cidade, UF, Cargo ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            conn = obterConexao();
            stmt = conn.prepareStatement(sql2);
            stmt.setLong(1, usu.getIdFilial());
            stmt.setString(2, usu.getNomeUsuario());
            stmt.setString(3, usu.getSenhaUsuario());
            stmt.setString(4, usu.getNomeFuncionario());
            stmt.setInt(5, usu.getRa());
            stmt.setString(6, usu.getCpf());
            stmt.setString(7, usu.getTelefone());
            stmt.setString(8, usu.getEmail());
            stmt.setString(9, usu.getEndereco());
            stmt.setString(10, usu.getCidade());
            stmt.setString(11, usu.getUf());
            stmt.setString(12, usu.getCargo());

          stmt.executeUpdate();
//            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void alterarUsuario(Usuario usu, int id) {
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
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void excluirUsuario(Usuario usu, int id) {
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
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Usuario> ListarUsuarios() {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "SELECT * FROM TF_Funcionario";

        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Usuario usu = new Usuario();

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
            Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

}

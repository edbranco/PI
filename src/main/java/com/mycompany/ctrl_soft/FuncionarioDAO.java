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

    public void alterarFuncionario(Funcionario funcionario, int id) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE TB_Funcionario SET ID_Filial=?, NomeFuncionario=?, RA=?, CPF=?, Telefone=?, "
                + "Email=?, Endereco=?, Cidade=?, UF=?, Cargo=? WHERE ID_Funcionario=?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setLong(1, funcionario.getIdFilial());
            stmt.setString(2, funcionario.getNome());
            stmt.setInt(3, funcionario.getRa());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getEndereco());
            stmt.setString(8, funcionario.getCidade());
            stmt.setString(9, funcionario.getUf());
            stmt.setString(10, funcionario.getCargo());
            stmt.setLong(11, id);
            stmt.executeUpdate();

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

    public boolean excluirFuncionario(Funcionario funcionario, int id) {
        boolean cadastrado;
        
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "DELETE FROM TB_Funcionario WHERE ID_Funcionario = ?";
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

    //Função de consulta de Funcionarios
    public Funcionario consultarFuncionario(Funcionario funcionario, int id) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;
        
        long idfilial = 0;
        String nome = "";
        int ra = 0;
        String cpf = "";
        String telefone = "";
        String email = "";
        String endereco = "";
        String cidade = "";
        String uf = "";
        String cargo = "";
        
        String sql2 = "SELECT * FROM TB_Funcionario WHERE ID_Funcionario = " + id;
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
            if(resultados == null){
                return null;
            }

            while (resultados.next()) {   
                idfilial = Long.parseLong(resultados.getString("ID_Filial"));
                nome = resultados.getString("NomeFuncionario");
                ra = resultados.getInt("RA");
                cpf = resultados.getString("CPF");
                telefone = resultados.getString("Telefone");
                email = resultados.getString("Email");
                endereco = resultados.getString("Endereco");
                cidade = resultados.getString("Cidade");
                uf = resultados.getString("UF");
                cargo = resultados.getString("Cargo");
            }
            
            funcionario.setId(id);
            funcionario.setIdFilial(idfilial);
            funcionario.setNome(nome);
            funcionario.setRa(ra);
            funcionario.setCpf(cpf);
            funcionario.setTelefone(telefone);
            funcionario.setEmail(email);
            funcionario.setEndereco(endereco);
            funcionario.setCidade(cidade);
            funcionario.setUf(uf);
            funcionario.setCargo(cargo);
            
            return funcionario;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    public List<Funcionario> ListarFuncionarios(String nome) {
        PreparedStatement stmt = null;
        Statement stmt2 = null;
        Connection conn = null;

        String sql2 = "SELECT * FROM TB_Funcionario WHERE UPPER(NomeFuncionario) LIKE UPPER('%" + nome + "%')";
        try {
            conn = obterConexao();
            stmt2 = conn.createStatement();
            ResultSet resultados = stmt2.executeQuery(sql2);
            
            List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

            while (resultados.next()) {
                //Cliente temporário
                Funcionario funcionarioTemp = new Funcionario();

                funcionarioTemp.setId(resultados.getInt("ID_Funcionario"));
                funcionarioTemp.setNome(resultados.getString("NomeFuncionario"));
                funcionarioTemp.setRa(resultados.getInt("RA"));
                funcionarioTemp.setCpf(resultados.getString("CPF"));
                funcionarioTemp.setTelefone(resultados.getString("Telefone"));
                funcionarioTemp.setEmail(resultados.getString("Email"));
                funcionarioTemp.setEndereco(resultados.getString("Endereco"));
                funcionarioTemp.setCidade(resultados.getString("Cidade"));
                funcionarioTemp.setUf(resultados.getString("UF"));
                funcionarioTemp.setCargo(resultados.getString("Cargo"));
                
                //Adiciona na lista o cliente temporário
                listaFuncionarios.add(funcionarioTemp);
            }
            
            return listaFuncionarios;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    
    //Métodos para autenticação
    
    public boolean autenticar(String usuarioLogin, String senha) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT Usuario,Senha from TB_Funcionario\n"
                + "WHERE Usuario = '" + usuarioLogin
                + "' AND  Senha = '" + senha + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                String usuarioBanco = resultados.getString("Usuario");
                String senhaBanco = resultados.getString("Senha");

                if (senhaBanco.equals(senha)) {
                    return true;
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }
    
    public Funcionario buscarUsuario(String email, String senha) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from TB_Funcionario\n"
                + "WHERE Usuario = '" + email
                + "' AND  Senha = '" + senha + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("ID_Funcionario");
                String emailBanco = resultados.getString("Usuario");
                String senhaBanco = resultados.getString("Senha");
                int filialBanco = resultados.getInt("ID_Filial");
                String nomeCompleto = resultados.getString("NomeFuncionario");
                String cargoBanco = resultados.getString("cargo");

                if (senhaBanco.equals(senha)) {
                    Funcionario User = new Funcionario();
                    
                    User.setId(id);
                    User.setIdFilial(filialBanco);
                    User.setUsuario(emailBanco);
                    User.setSenha(senhaBanco);
                    User.setNome(nomeCompleto);
                    User.setCargo(cargoBanco);
            
                    return User;
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

    public Funcionario buscarUsuario(String email) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from TB_Funcionario\n"
                + "WHERE Usuario = '" + email + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("ID_Funcionario");
                String emailBanco = resultados.getString("Usuario");
                String senhaBanco = resultados.getString("Senha");
                int filialBanco = resultados.getInt("ID_Filial");
                String nomeCompleto = resultados.getString("NomeFuncionario");
                String cargoBanco = resultados.getString("cargo");
                if (emailBanco.equals(email)) {
                    Funcionario User = new Funcionario();
                    
                    User.setId(id);
                    User.setIdFilial(filialBanco);
                    User.setUsuario(emailBanco);
                    User.setSenha(senhaBanco);
                    User.setNome(nomeCompleto);
                    User.setCargo(cargoBanco);
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

}

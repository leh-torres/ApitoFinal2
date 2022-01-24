package dao;

import classes.Usuario;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;

public class UsuarioDao {

    Connection conn =  null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int intRS;
    Usuario usuario =  new Usuario();

    public UsuarioDao(){}

    /**
     * *******Método que retorna o id de um usuário*********
     * @param email
     * @param senha
     * @return id
     */
    public int getId(String email, String senha){
        int id_user;
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT id_user FROM usuario WHERE email_user = ? AND senha_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setString(1, email);
                pst.setString(2, senha);
            rs = pst.executeQuery();

            if(rs.next()){
                id_user = rs.getInt("id_user");
                conexaoBanco.closeConexao();
                return id_user;
            } else{
                System.out.println("+----------------------+");
                System.out.println("|   Id não encontrado  |");
                System.out.println("+----------------------+");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no getId: " + e);
        }

        return 0;
    }
    

    //TO DO - Ajeitar a imagem do perfil - MÉTODO DESNECESSÁRIO
    /**
     * ******Método para recuperar o avatar do usuário********
     * @return image
     */
    public Image getImagem(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "SELECT * FROM usuario WHERE id_user=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, Integer.toString(usuario.getId_usuario()));
            rs = pst.executeQuery();
            
            if(rs.next()){
                if(rs.getBinaryStream("imagem_user") != null){
                InputStream imageFile = rs.getBinaryStream("imagem_user");
                Image image = new Image(imageFile);
                return image;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Não existe imagem salva");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    /**
     * ******Método que retorna do nome do usuário******
     * @return nome
     */
    public String getNome(){
        String nome_user;
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT nome_user FROM usuario WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, usuario.getId_usuario());
            rs = pst.executeQuery();

            if(rs.next()){
                nome_user = rs.getString("nome_user");
                conexaoBanco.closeConexao();
                return nome_user;
            } else{
                System.out.println("+----------------------+");
                System.out.println("|  Nome não encontrado |");
                System.out.println("+----------------------+");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no getNome: " + e);
        }

        return null;
    }

    /**
     * Método para retornar o sobrenome do usuário
     * @return sobrenome_user
     */
    public String getSobrenome(){
        String sobrenome_user;
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT sobrenome_user FROM usuario WHERE id_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, usuario.getId_usuario());
            rs = pst.executeQuery();

            if(rs.next()){
                sobrenome_user = rs.getString("sobrenome_user");
                conexaoBanco.closeConexao();
                return sobrenome_user;
            } else{
                System.out.println("+---------------------------+");
                System.out.println("|  Sobrenome não encontrado |");
                System.out.println("+---------------------------+");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no getSobrenome: " + e);
        }

        return null;
    }

    /**
     * ***Método para verificar se as informações do login são válidas*****
     * @param email
     * @param senha
     * @return
     */
    public boolean verificaLogin(String email, String senha){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        String SQL = "SELECT * FROM usuario WHERE email_user = ? AND senha_user = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setString(1, email);
                pst.setString(2, senha);

            rs = pst.executeQuery();
            if(rs.next()){
                conn.close();
                conexaoBanco.closeConexao();
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos" );
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no verificaLogin: " + ex);
            return false;
        }
        return false;
    }
    
    /**
     * Método para cadastrar usuário
     * @param nome
     * @param sobrenome
     * @param email
     * @param senha
     * @param imageFile
     * @return
     * @throws PacketTooBigException
     */
    public boolean cadastrarUsuario(String nome, String sobrenome, String email, String senha, FileInputStream imageFile) throws PacketTooBigException{
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
        String SQL = "SELECT * FROM usuario WHERE nome_user=? and sobrenome_user=? and email_user=? and senha_user=? and imagem_user=?";

        try {
           pst = (PreparedStatement)conn.prepareStatement(SQL);
           pst.setString(1, nome);
           pst.setString(2, sobrenome);
           pst.setString(3, email);
           pst.setString(4, senha);
           pst.setBinaryStream(5, imageFile);
           rs = pst.executeQuery();

           if(rs.next()){
               JOptionPane.showMessageDialog(null, "Operação inválida!!" + "\n" + "Usuário já cadastrado.");
               conn.close();
               conexao.closeConexao();

               return false;
            } else{
                SQL = "INSERT INTO usuario VALUES(null,?,?,?,?,?)";

                try {
                    pst = (PreparedStatement)conn.prepareStatement(SQL);
                    pst.setString(1, nome);
                    pst.setString(2, sobrenome);
                    pst.setString(3, email);
                    pst.setString(4, senha);
                    pst.setBinaryStream(5, imageFile);
                    intRS = pst.executeUpdate();

                    if(intRS == 1){
                        JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!!");
                        conn.close();
                        conexao.closeConexao();

                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "ERRO: Usuário não cadastrado!");
                    }

                } catch (Exception e) {
                   System.out.println("Erro INSERT INTO: " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro SELECT FROM: " + e);
        }

        return false;

    }
 }


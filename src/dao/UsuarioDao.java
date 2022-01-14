package dao;

import classes.Usuario;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;

import javax.swing.JOptionPane;

public class UsuarioDao {

    Connection conn =  null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Usuario usuario =  new Usuario();

    public UsuarioDao(){}

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
    
 }


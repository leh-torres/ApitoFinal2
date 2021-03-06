/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Time;
import classes.Usuario;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class TimeDao {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet ps = null;
    private Conexao conexao = new Conexao();
    private int rs;
    private Time time = new Time();
    private ArrayList<Time> listaTime = new ArrayList<>();
    private Usuario usuario = new Usuario();

    public TimeDao() {

    }

    public boolean inserirTime(String nome_time, FileInputStream fis, String abreviacao_time, int fk_usuario) {
        conn = conexao.getConnection();

        String SQL = "INSERT INTO times (nome_time,imagem_time,abreviacao_time,fk_usuario) VALUES (?,?,?,?)";

        try {
            pst = (PreparedStatement) conn.prepareStatement(SQL);
            pst.setString(1, nome_time);
            pst.setBinaryStream(2, fis);
            pst.setString(3, abreviacao_time);
            pst.setInt(4, fk_usuario);
            rs = pst.executeUpdate();

            if (rs == 1) {
                conexao.closeConexao();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public ArrayList<Time> pesquisaTime(String nome){
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
        
        String SQL = "SELECT * FROM times where nome_time LIKE '"+nome+"%' ORDER BY nome_time AND fk_usuario = ?";

        try {
            pst = (PreparedStatement) conn.prepareStatement(SQL);
            pst.setInt(1, usuario.getId_usuario());
            ps = pst.executeQuery();
            
            while(ps.next()){
                Time time = new Time();
                
                time.setId_time(ps.getInt("id_time"));
                time.setNome_time(ps.getString("nome_time"));
                InputStream imageFile = ps.getBinaryStream("imagem_time");;
                Image image = new Image(imageFile);
                time.setImagem_time(image);
                time.setAbreviacao_time(ps.getString("abreviacao_time"));
                
                listaTime.add(time);    
            }
            conexao.closeConexao();
            return listaTime;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }        
        return null;
    }
    
    public int getId(){
        int id_time;
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT MAX(id_time) as id_time FROM times";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            ps = pst.executeQuery();

            if(ps.next()){
                id_time = ps.getInt("id_time");
                conexaoBanco.closeConexao();
                return id_time;
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

    public Image getImagem(int idTime){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "SELECT imagem_time FROM times WHERE id_time=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, idTime);
            ps = pst.executeQuery();
            
            if(ps.next()){
                if(ps != null){
                    InputStream imageFile = ps.getBinaryStream("imagem_time");
                    Image image = new Image(imageFile);
                    return image;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public String getAbrev(int idTime){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "SELECT abreviacao_time FROM times WHERE id_time=?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, idTime);
            ps = pst.executeQuery();
            
            if(ps.next()){
                if(ps != null){
                    return ps.getString("abreviacao_time");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public boolean atualizaAbreviacao(String abreviacao, int id){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "UPDATE times SET abreviacao_time = ? WHERE id_time = ?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, abreviacao);
            pst.setInt(2, id);
            rs = pst.executeUpdate();

            if(rs == 1){
                System.out.println("Abreviação atualizada com sucesso!");
                conexaoBanco.closeConexao();
            }

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean atualizaNome(String nome, int id){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "UPDATE times SET nome_time = ? WHERE id_time = ?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, nome);
            pst.setInt(2, id);
            rs = pst.executeUpdate();

            if(rs == 1){
                System.out.println("Nome atualizado com sucesso!");
                conexaoBanco.closeConexao();
            }

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean atualizaImagem(FileInputStream fis, int id){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "UPDATE times SET imagem_time = ? WHERE id_time = ?";
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setBinaryStream(1, fis);
            pst.setInt(2, id);
            rs = pst.executeUpdate();

            if(rs == 1){
                System.out.println("Imagem atualizado com sucesso!");
                conexaoBanco.closeConexao();
            }

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean excluirTime(int id){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "DELETE FROM times WHERE times.id_time = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setInt(1, id);
            rs = pst.executeUpdate();

            if(rs == 1){
                conexaoBanco.closeConexao();
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return false;
    }
    
}

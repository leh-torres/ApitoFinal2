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

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet ps = null;
    Conexao conexao = new Conexao();
    int rs;
    Time time = new Time();
    ArrayList<Time> listaTime = new ArrayList<>();
    Usuario usuario = new Usuario();

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
}

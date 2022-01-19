/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        private String resultado;
        int rs;
    
        public TimeDao(){
        
        }
    
        public boolean inserirTime(String nome_time,FileInputStream fis,String abreviacao_time,int fk_usuario){
        conn = conexao.getConnection();
        
        String SQL = "INSERT INTO times (nome_time,imagem_time,abreviacao_time,fk_usuario) VALUES (?,?,?,?)";
        
        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);
            pst.setString(1, nome_time);
            pst.setBinaryStream(2, fis);
            pst.setString(3, abreviacao_time);
            pst.setInt(4, fk_usuario);
            rs = pst.executeUpdate();
            
            if(rs == 1){
                conexao.closeConexao();
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }           
}



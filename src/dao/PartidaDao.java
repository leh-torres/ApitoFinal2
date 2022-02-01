/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class PartidaDao {
    
    private Connection conn = null; 
    private PreparedStatement ps = null; 
    private ResultSet rs = null; 
    private int retUpdate;
    private Usuario usuario = new Usuario();
    private int id ;
    private String resultado;
    public  static int[] id_selecionado = new int[16];
    private int idPart;
    
    public boolean cadastrarPart(String data_part,String hora_part, String local_part, int fk_comp,int fk_time1,int fk_time2){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        String SQL = "SELECT * FROM partida WHERE local_part = ? and fk_comp = ? and data_part = ? and horario_part = ? ";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setString(1, local_part);
            ps.setInt(2, fk_comp);
            ps.setString(3, data_part);
            ps.setString(4, hora_part);
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Partida já cadastrado");
                conexaoBanco.closeConexao();

                return false;
            } else{                
                SQL = "INSERT INTO partida (data_part,horario_part,local_part,fk_comp,fk_time1,fk_time2) VALUES (?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setString(1, data_part);
                    ps.setString(2, hora_part);
                    ps.setString(3, local_part);
                    ps.setInt(4, fk_comp);
                    ps.setInt(5, fk_time1);
                    ps.setInt(6, fk_time2);
                    retUpdate = ps.executeUpdate();


                    if(retUpdate == 1){
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
                        conexaoBanco.closeConexao();
    
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: INSERT INTO----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
            }

        } catch (SQLException exSQL) {
            System.out.println("-----------ERRO: SELECT FROM----------");
            JOptionPane.showMessageDialog(null, exSQL);
        }

        return false;
        
    }
    
}

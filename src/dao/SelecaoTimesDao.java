/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Competicao;
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
public class SelecaoTimesDao {
    
    private Connection conn = null; 
    private PreparedStatement ps = null; 
    private ResultSet rs = null; 
    private int retUpdate;
    private Usuario usuario = new Usuario();
    private int id ;
    private int [] ids = new int[9];
    
    public boolean cadastrarTimesSelecionados(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        id = Competicao.getId_comp_aux();

                String SQL = "INSERT INTO selecao_times (fk_competicao, fk_usuario, fk_time1, fk_time2, fk_time3, fk_time4, fk_time5, fk_time6, fk_time7, fk_time8) VALUES (?,?,?,?,?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setInt(1,id);
                    ps.setInt(2, usuario.getId_usuario());
                    ps.setInt(3, Competicao.getTimesSelecionados().get(0).getId_time());
                    ps.setInt(4, Competicao.getTimesSelecionados().get(1).getId_time());
                    ps.setInt(5, Competicao.getTimesSelecionados().get(2).getId_time());
                    ps.setInt(6, Competicao.getTimesSelecionados().get(3).getId_time());
                    ps.setInt(7, Competicao.getTimesSelecionados().get(4).getId_time());
                    ps.setInt(8, Competicao.getTimesSelecionados().get(5).getId_time());
                    ps.setInt(9, Competicao.getTimesSelecionados().get(6).getId_time());
                    ps.setInt(10, Competicao.getTimesSelecionados().get(7).getId_time());
                    
                    retUpdate = ps.executeUpdate();

                    if(retUpdate == 1){
                        conexaoBanco.closeConexao();
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: INSERT INTO----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
        return false;
        
    }
    
    public boolean alterarTimesSelecionados(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        id = Competicao.getId_comp_aux();

                String SQL = "UPDATE selecao_times SET fk_time1 = ?, fk_time2 = ?, fk_time3 = ?, fk_time4 = ?, fk_time5 = ?, fk_time6 = ?, fk_time7 = ?, fk_time8 = ? WHERE fk_competicao = ? AND fk_usuario = ?";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setInt(1, Competicao.getTimesSelecionados().get(0).getId_time());
                    ps.setInt(2, Competicao.getTimesSelecionados().get(1).getId_time());
                    ps.setInt(3, Competicao.getTimesSelecionados().get(2).getId_time());
                    ps.setInt(4, Competicao.getTimesSelecionados().get(3).getId_time());
                    ps.setInt(5, Competicao.getTimesSelecionados().get(4).getId_time());
                    ps.setInt(6, Competicao.getTimesSelecionados().get(5).getId_time());
                    ps.setInt(7, Competicao.getTimesSelecionados().get(6).getId_time());
                    ps.setInt(8, Competicao.getTimesSelecionados().get(7).getId_time());
                    ps.setInt(9,id);
                    ps.setInt(10, usuario.getId_usuario());
                    
                    retUpdate = ps.executeUpdate();

                    if(retUpdate == 1){
                        conexaoBanco.closeConexao();
                        return true;
                    } else{
                        JOptionPane.showMessageDialog(null, "----ERRO!----");
                    }
                    
                } catch (SQLException exSQL) {
                    System.out.println("------------ERRO: INSERT INTO----------");
                    JOptionPane.showMessageDialog(null, exSQL);
                }
        return false;
        
    }    
    
    public int[] getIds(int idCampeonato,int idUsuario){
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();

        String SQL = "SELECT * FROM selecao_times WHERE fk_competicao = ? AND fk_usuario = ?";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, idCampeonato);
            ps.setInt(2, idUsuario);
            rs = ps.executeQuery();

            if(rs.next()){
                ids[0] = rs.getInt("fk_time1");
                ids[1] = rs.getInt("fk_time2");
                ids[2] = rs.getInt("fk_time3");
                ids[3] = rs.getInt("fk_time4");
                ids[4] = rs.getInt("fk_time5");
                ids[5] = rs.getInt("fk_time6");
                ids[6] = rs.getInt("fk_time7");
                ids[7] = rs.getInt("fk_time8");
                
                conexao.closeConexao();
                conn.close();
                return ids;
            } else{
                conexao.closeConexao();
                conn.close();
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }


        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Competicao;
import classes.Time;
import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private Competicao competicao = new Competicao();
    private int id = competicao.getId_comp_aux();
    
    public boolean cadastrarTimesSelecionados(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        id = competicao.getId_comp_aux();

                String SQL = "INSERT INTO selecao_times (fk_competicao, fk_usuario, fk_time1, fk_time2, fk_time3, fk_time4, fk_time5, fk_time6, fk_time7, fk_time8) VALUES (?,?,?,?,?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setInt(1,id);
                    ps.setInt(2, usuario.getId_usuario());
                    ps.setInt(3, competicao.getTimesSelecionados().get(0).getId_time());
                    ps.setInt(4, competicao.getTimesSelecionados().get(1).getId_time());
                    ps.setInt(5, competicao.getTimesSelecionados().get(2).getId_time());
                    ps.setInt(6, competicao.getTimesSelecionados().get(3).getId_time());
                    ps.setInt(7, competicao.getTimesSelecionados().get(4).getId_time());
                    ps.setInt(8, competicao.getTimesSelecionados().get(5).getId_time());
                    ps.setInt(9, competicao.getTimesSelecionados().get(6).getId_time());
                    ps.setInt(10, competicao.getTimesSelecionados().get(7).getId_time());
                    
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
        id = competicao.getId_comp_aux();

                String SQL = "UPDATE selecao_times SET fk_time1 = ?, fk_time2 = ?, fk_time3 = ?, fk_time4 = ?, fk_time5 = ?, fk_time6 = ?, fk_time7 = ?, fk_time8 = ? WHERE fk_competicao = ? AND fk_usuario = ?";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setInt(1, competicao.getTimesSelecionados().get(0).getId_time());
                    ps.setInt(2, competicao.getTimesSelecionados().get(1).getId_time());
                    ps.setInt(3, competicao.getTimesSelecionados().get(2).getId_time());
                    ps.setInt(4, competicao.getTimesSelecionados().get(3).getId_time());
                    ps.setInt(5, competicao.getTimesSelecionados().get(4).getId_time());
                    ps.setInt(6, competicao.getTimesSelecionados().get(5).getId_time());
                    ps.setInt(7, competicao.getTimesSelecionados().get(6).getId_time());
                    ps.setInt(8, competicao.getTimesSelecionados().get(7).getId_time());
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
}

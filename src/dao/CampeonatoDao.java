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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rayla
 */
public class CampeonatoDao {
    
    Connection conn = null; 
    PreparedStatement ps = null; 
    ResultSet rs = null; 
    private int retUpdate;
    Usuario usuario = new Usuario();
    ArrayList<Competicao> listaComp = new ArrayList<>();
    
    public boolean cadastrarComp(Competicao competicao){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT * FROM competicao WHERE nome_comp = ? ";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setString(1, competicao.getNome_comp());
            rs = ps.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Campeonato já cadastrado");
                conexaoBanco.closeConexao();

                return true;
            } else{
                SQL = "INSERT INTO competicao (nome_comp, descricao_comp, premiacao_comp, data_ini_comp, data_termi_comp, situacao_comp, fk_usuario) VALUES (?,?,?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setString(1, competicao.getNome_comp());
                    ps.setString(2, competicao.getDescricao_comp());
                    ps.setString(3, competicao.getPremiacao_comp());
                    ps.setString(4, competicao.getData_ini_comp());
                    ps.setString(5, competicao.getData_termi_comp());
                    ps.setString(6, competicao.getSituacao_comp());
                    ps.setInt(7, competicao.getFk_usuario());
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
            }

        } catch (SQLException exSQL) {
            System.out.println("-----------ERRO: SELECT FROM----------");
            JOptionPane.showMessageDialog(null, exSQL);
        }

        return false;
        
    }
    
    public ArrayList verificaCampeonatoAberto(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        String SQL = "SELECT * FROM competicao WHERE fk_usuario=?";
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, usuario.getId_usuario());
            rs = ps.executeQuery();
            
                while(rs.next()){
                    
                Competicao competicao = new Competicao();
                competicao.setId_comp(rs.getInt("id_comp"));
                competicao.setNome_comp(rs.getString("nome_comp"));
                competicao.setDescricao_comp(rs.getString("descricao_comp"));
                competicao.setPremiacao_comp(rs.getString("premiacao_comp"));
                competicao.setData_ini_comp(rs.getString("data_ini_comp"));
                competicao.setData_termi_comp(rs.getString("data_termi_comp"));
                competicao.setSituacao_comp(rs.getString("situacao_comp"));
                competicao.setQuantidade_times_comp(rs.getInt("quantidade_times_comp"));
                competicao.setFk_usuario(rs.getInt("fk_usuario"));
                listaComp.add(competicao);
                }
                conexaoBanco.closeConexao();
                return listaComp;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public boolean verificaCapeonato(int id){
       
       Conexao conexaoBanco = new Conexao();
       conn = conexaoBanco.getConnection();
       String SQL = "SELECT * FROM competicao WHERE fk_usuario = ?";

       try {
           ps = (PreparedStatement)conn.prepareStatement(SQL);

                ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()){
                conn.close();
                conexaoBanco.closeConexao();
                return true;
            } else{
                System.out.println("+----------------------------------+");
                System.out.println("|   Nenhuma competicao cadastrada  |");
                System.out.println("+----------------------------------+");
                return false;      
            }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro no verificaCampeonto:" + e);
       }

       return false;
   }
    
}

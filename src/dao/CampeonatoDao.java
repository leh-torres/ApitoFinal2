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
    
    private Connection conn = null; 
    private PreparedStatement ps = null; 
    private ResultSet rs = null; 
    private int retUpdate;
    private Usuario usuario = new Usuario();
    private ArrayList<Competicao> listaComp = new ArrayList<>();
    
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
                SQL = "INSERT INTO competicao (nome_comp, descricao_comp, premiacao_comp,situacao_comp, fk_usuario) VALUES (?,?,?,?,?)";

                try {
                    ps = (PreparedStatement)conn.prepareStatement(SQL);
                    ps.setString(1, competicao.getNome_comp());
                    ps.setString(2, competicao.getDescricao_comp());
                    ps.setString(3, competicao.getPremiacao_comp());
                    ps.setString(4, competicao.getSituacao_comp());
                    ps.setInt(5, competicao.getFk_usuario());
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
    
    public ArrayList<Competicao> verificaCampeonatoAberto(){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        
        int cont = 0;
        
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
                competicao.setSituacao_comp(rs.getString("situacao_comp"));
                competicao.setQuantidade_times_comp(rs.getInt("quantidade_times_comp"));
                competicao.setFk_usuario(rs.getInt("fk_usuario"));
                
                listaComp.add(competicao);
                cont ++;
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
    
   public int getId(){
        int id_time;
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT MAX(id_comp) as id_comp FROM competicao";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            if(rs.next()){
                id_time = rs.getInt("id_comp");
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

    public String getNome(int idCampeonato)
    {
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();

        String SQL = "SELECT nome_comp FROM competicao WHERE id_comp = ?";
        String nome;

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, idCampeonato);
            rs = ps.executeQuery();

            if(rs.next()){
                nome = rs.getString("nome_comp");
                conexao.closeConexao();
                conn.close();
                return nome;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Partida;
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
public class PartidaDao {
    
    public Connection conn = null; 
    public PreparedStatement ps = null; 
    public ResultSet rs = null; 
    private int retUpdate;
    public Usuario usuario = new Usuario();
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

    public ArrayList getListaPartidas(int idCompeticao){
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
    
        ArrayList<Partida> arrayPartidas = new ArrayList<>();
    
        String SQL = "SELECT * FROM partida WHERE fk_comp = ?";
    
        try{
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setInt(1, idCompeticao);
            rs = ps.executeQuery();
    
            while(rs.next()){
                Partida partida = new Partida();
                partida.setId_part(rs.getInt("id_part"));
                partida.setData_part(rs.getString("data_part"));
                partida.setHorario_part(rs.getString("horario_part"));
                partida.setLocal_part(rs.getString("local_part"));
                partida.setPlacar_part(rs.getString("placar_part"));
                partida.setFk_compDinamico(rs.getInt("fk_comp"));
                partida.setFk_time1Dinamico(rs.getInt("fk_time1"));
                partida.setFk_time2Dinamico(rs.getInt("fk_time2"));
                partida.setFk_momento_da_pontuacao(rs.getInt("fk_momento_da_pontuacao"));
                arrayPartidas.add(partida);
            }
            conexao.closeConexao();
            conn.close();
            return arrayPartidas;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
        return null;
    
    }

    /**
     * Método para atualizar o local da partida
     * @param local
     * @param id
     * @return
     */
    public boolean editarLocal(String local, int id){

        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
        String SQL = "UPDATE partida SET local_part = ? WHERE id_part = ?";
        
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setString(1, local);
            ps.setInt(2, id);
            retUpdate = ps.executeUpdate();

            if(retUpdate == 1){
                conn.close();
                conexao.closeConexao();
                return true;
            } else{
                System.out.println("Local não atualizado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Método para atualizar o local da partida
     * @param local
     * @param id
     * @return
     */
    public boolean editarHora(String horario, int id){

        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
        String SQL = "UPDATE partida SET horario_part = ? WHERE id_part = ?";
        
        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setString(1, horario);
            ps.setInt(2, id);
            retUpdate = ps.executeUpdate();

            if(retUpdate == 1){
                conn.close();
                conexao.closeConexao();
                return true;
            } else{
                System.out.println("Horario não atualizado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
}

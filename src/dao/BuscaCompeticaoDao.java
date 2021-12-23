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
public class BuscaCompeticaoDao {
    
    Connection conn = null; 
    PreparedStatement ps = null; 
    ResultSet rs = null; 
    Usuario usuario = new Usuario();
    ArrayList<Competicao> listaComp = new ArrayList<>();
    
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
    
}

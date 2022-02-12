/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Jogadores;
import classes.Time;
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
public class JogadoresDao {
    
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet ps = null;
    private int rs;
    private TimeDao timeDao = new TimeDao();
    private ArrayList<Jogadores> listaDeJogadores = new ArrayList<>();
    
    public boolean cadastrarJogador(String nome) {
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();

        String SQL = "INSERT INTO competidores (nome_competidor,fk_time) VALUES (?,?)";

        try {
            pst = (PreparedStatement) conn.prepareStatement(SQL);
            pst.setString(1, nome);
            pst.setInt(2, timeDao.getId());
            rs = pst.executeUpdate();

            if (rs == 1) {
                conexao.closeConexao();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public ArrayList<Jogadores> getJogadores(String nome, int idTime){
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();
        
        String SQL = "SELECT * FROM competidores where nome_competidor LIKE '"+nome+"%' ORDER BY nome_competidor AND fk_time = ?";

        try {
            pst = (PreparedStatement) conn.prepareStatement(SQL);
            pst.setInt(1, idTime);
            ps = pst.executeQuery();
            
            while(ps.next()){
                Jogadores jogador = new Jogadores();
                
                jogador.setId_competidor(ps.getInt("id_competidor"));
                jogador.setNome_competidor(ps.getString("nome_competidor"));
                jogador.setFk_time(ps.getInt("fk_time"));
                
                listaDeJogadores.add(jogador);    
            }
            conexao.closeConexao();
            return listaDeJogadores;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }        
        return null;
    }
    
    
}

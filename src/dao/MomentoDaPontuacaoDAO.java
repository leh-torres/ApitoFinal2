package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MomentoDaPontuacaoDAO {

    private Connection conn = null; 
    private PreparedStatement ps = null; 
    private ResultSet rs = null; 
    private int retUpdate;


    /**
     * Método para cadastraro  o momento da partida
     * @param idJogador
     * @param tempo
     * @param idPartida
     * @return
     */
    public boolean cadastrarMomentoPart(int idJogador, String tempo, int idPartida){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();               
        
        String SQL = "INSERT INTO momento_da_pontuacao (tempo_partida, fk_competidor, fk_partida) VALUES (?,?,?)";

        try {
            ps = (PreparedStatement)conn.prepareStatement(SQL);
            ps.setString(1, tempo);
            ps.setInt(2, idJogador);
            ps.setInt(3, idPartida);
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
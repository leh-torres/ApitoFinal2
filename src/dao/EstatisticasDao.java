package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class EstatisticasDao {
    public Connection conn = null; 
    public PreparedStatement ps = null; 
    public ResultSet rs = null; 
    private int retUpdate;

    public boolean cadastrarEstatistica(String nome, int valor, int idPartida){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();               
        String SQL = "INSERT INTO estatistica(nome_estatistica, valor_estatistica, fk_partida) VALUES (?,?,?)";

            try {
                ps = (PreparedStatement)conn.prepareStatement(SQL);
                ps.setString(1, nome);
                ps.setInt(2, valor);
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Time time = new Time();
    private TimeDao timeDao = new TimeDao();
    
    public boolean cadastrarJogador() {
        Conexao conexao = new Conexao();
        conn = conexao.getConnection();

        String SQL = "INSERT INTO competidores (nome_competidor,fk_time) VALUES (?,?)";

        try {
            pst = (PreparedStatement) conn.prepareStatement(SQL);
            pst.setString(1, time.getNome_time());
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
    
}

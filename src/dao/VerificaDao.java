package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VerificaDao {
    
    Connection conn  = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public VerificaDao(){}

    public boolean verificaLogin(String email, String senha){
        Conexao conexaoBanco = new Conexao();
        conn = conexaoBanco.getConnection();
        String SQL = "SELECT * FROM usuario WHERE email_user = ? AND senha_user = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setString(1, email);
                pst.setString(2, senha);

            rs = pst.executeQuery();
            if(rs.next()){
                conn.close();
                conexaoBanco.closeConexao();
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos" );
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro no verificaLogin: " + ex);
            return false;
        }
        return false;
    }
    

   public boolean verificaCapeonato(int id){
       
       Conexao conexaoBanco = new Conexao();
       conn = conexaoBanco.getConnection();
       String SQL = "SELECT * FROM competicao WHERE fk_usuario = ?";

       try {
           pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setInt(1, id);

            rs = pst.executeQuery();

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

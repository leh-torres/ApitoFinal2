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

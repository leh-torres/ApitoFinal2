package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class UsuarioDao {

    Connection conn =  null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Conexao conexaoBanco = new Conexao();

    public UsuarioDao(){}

    public int getId(String email, String senha){
        int id_user;
        conn = conexaoBanco.getConnection();

        String SQL = "SELECT id_user FROM usuario WHERE email_user = ? AND senha_user = ?";

        try {
            pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setString(1, email);
                pst.setString(2, senha);
            rs = pst.executeQuery();

            if(rs.next()){
                id_user = rs.getInt("id_user");
                conexaoBanco.closeConexao();
                return id_user;
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
}

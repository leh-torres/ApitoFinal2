/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela2_Cadastro;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import apitofinal.ApitoFinal;
import classes.Usuario;
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tela3_Cadastro.Tela3_Cadastro;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 * @author Leticia Torres
 */
public class FXMLCadastroController implements Initializable {


    @FXML
    private TextField txtNome, txtEmail, txtSobrenome;
    @FXML
    private PasswordField password;

    private Usuario user = new Usuario();
    private UsuarioDao userDao = new UsuarioDao();

    @FXML
    private void btnAvanca(ActionEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        boolean retorno;

        if(txtNome.getText().isEmpty()){
            txtNome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setNome(txtNome.getText());
        }

        if(txtSobrenome.getText().isEmpty()){
            txtSobrenome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setSobrenome(txtSobrenome.getText());
        }

        if(txtEmail.getText().isEmpty()){
            txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setEmail(txtEmail.getText());
        }

        if(password.getText().isEmpty()){
            password.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            Usuario.criptografaSenha(password.getText());
        }
        
        retorno = userDao.cadastrarUsuario(user.getNome(), user.getSobrenome(), user.getEmail(), user.getSenha());
        
        if(retorno == true){
            trocaDeTela();
            user.setId_usuario(userDao.getId(user.getEmail(), user.getSenha()));
        } else{
            System.out.println("Erro ao trocar de tela");
        } 

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        password.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            try {
                if(event.getCode() == KeyCode.ENTER){

               
                    boolean retorno;

                    if(txtNome.getText().isEmpty()){
                        txtNome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setNome(txtNome.getText());
                    }

                    if(txtSobrenome.getText().isEmpty()){
                        txtSobrenome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setSobrenome(txtSobrenome.getText());
                    }

                    if(txtEmail.getText().isEmpty()){
                       txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setEmail(txtEmail.getText());
                    }

                    if(password.getText().isEmpty()){
                        password.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.criptografaSenha(password.getText());
                    }
        
                    retorno = userDao.cadastrarUsuario(user.getNome(), user.getSobrenome(), user.getEmail(), user.getSenha());
        
                    if(retorno == true){
                        trocaDeTela();
                    } else{
                       System.out.println("Erro ao trocar de tela");
                    } 


                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao mudar para a tela 3" + e);
            }
        });
    } 
    
    @FXML
    private void btnVoltar(ActionEvent event){
        ApitoFinal telaInicial = new ApitoFinal();
        fechaTela();

        try {
            telaInicial.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fechaTela(){
        Tela2_Cadastro.getStage().close();
    }

    private void trocaDeTela(){
        Tela3_Cadastro tela3 = new Tela3_Cadastro();
        fechaTela();

        try {
            tela3.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir tela 3");
        }
    }
    
}

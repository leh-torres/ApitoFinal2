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
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import apitofinal.ApitoFinal;
import classes.Usuario;
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
    TextField txtNome, txtEmail, txtSobrenome;
    @FXML
    PasswordField password;

    Usuario user = new Usuario();

    @FXML
    private void btnAvanca(ActionEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        if(txtNome.getText().isBlank()){
            txtNome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setNome(txtNome.getText());
        }

        if(txtSobrenome.getText().isBlank()){
            txtSobrenome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setSobrenome(txtSobrenome.getText());
        }

        if(txtEmail.getText().isBlank()){
            txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.setEmail(txtEmail.getText());
        }

        if(password.getText().isBlank()){
            password.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            user.criptografaSenha(password.getText());
        }
        
        Tela3_Cadastro tela3 = new Tela3_Cadastro();
        fechaTela();

        try {
            tela3.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir tela 3");
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

                    if(txtNome.getText().isBlank()){
                        txtNome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setNome(txtNome.getText());
                    }
            
                    if(txtSobrenome.getText().isBlank()){
                        txtSobrenome.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setSobrenome(txtSobrenome.getText());
                    }
            
                    if(txtEmail.getText().isBlank()){
                        txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.setEmail(txtEmail.getText());
                    }
            
                    if(password.getText().isBlank()){
                        password.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        user.criptografaSenha(password.getText());
                    }
                    
                    Tela3_Cadastro tela3 = new Tela3_Cadastro();
                    fechaTela();
            
                    try {
                        tela3.start(new Stage());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Erro ao abrir tela 3");
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
    
}

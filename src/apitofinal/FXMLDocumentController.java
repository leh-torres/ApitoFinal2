/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Usuario;
import dao.CompeticaoDao;
import dao.UsuarioDao;
import dao.VerificaDao;
import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela4_CriarCampeonato.Tela04CriarCampeonato;

/**
 *
 * @author RonaldoMatos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField senhaPass;

    VerificaDao verifica = new VerificaDao();
    Usuario usuario = new Usuario();
    UsuarioDao userDao = new UsuarioDao();
    CompeticaoDao compDao = new CompeticaoDao();
    boolean retorno, retorno2;

    @FXML
    private void botaoEntrar(ActionEvent event) {

        if(emailTxt.getText().length() == 0 ){
            emailTxt.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");    
        }else{
            emailTxt.setStyle(null);
        }

        if(senhaPass.getText().length() == 0){
            senhaPass.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        } else{
            senhaPass.setStyle(null);
        }
       
        retorno = userDao.verificaLogin(emailTxt.getText(), senhaPass.getText());

        if(retorno == true){
            usuario.setId_usuario(userDao.getId(emailTxt.getText(), senhaPass.getText()));
            usuario.setEmail(emailTxt.getText());
            usuario.setSenha(senhaPass.getText());
            usuario.setImagem(userDao.getImagem());
            usuario.setNome(userDao.getNome());
                
            retorno2 = compDao.verificaCapeonato(usuario.getId_usuario());

                if(retorno2 == true){
                    Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
                    fecha();
                    try {
                        tela10.start(new Stage());
                    } catch (Exception e) {
                       System.out.println("Tela 10 não iniciada" + e);;
                    }
                   

                } else{
                    Tela04CriarCampeonato tela04 = new Tela04CriarCampeonato();
                    fecha();

                    try {
                        tela04.start(new Stage());
                    } catch (Exception e) {
                        System.out.println( "Tela 04 não iniciada " + e);
                    }


                }
        } else{
            emailTxt.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
            senhaPass.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        senhaPass.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            try {
                if(event.getCode() == KeyCode.ENTER){
                    
                    if(emailTxt.getText().length() == 0 ){
                        emailTxt.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");    
                    }else{
                        emailTxt.setStyle(null);
                    }
            
                    if(senhaPass.getText().length() == 0){
                        senhaPass.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                    } else{
                        senhaPass.setStyle(null);
                    }

                    retorno = userDao.verificaLogin(emailTxt.getText(), senhaPass.getText());
                    if(retorno == true){
                        usuario.setId_usuario(userDao.getId(emailTxt.getText(), senhaPass.getText()));
                        usuario.setEmail(emailTxt.getText());
                        usuario.setSenha(senhaPass.getText());
                        usuario.setImagem(userDao.getImagem());
                        usuario.setNome(userDao.getNome());
                            
                        retorno2 = compDao.verificaCapeonato(usuario.getId_usuario());
            
                            if(retorno2 == true){
                                Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
                                fecha();
                                try {
                                    tela10.start(new Stage());
                                } catch (Exception e) {
                                   JOptionPane.showMessageDialog(null, "Tela 10 não iniciada " + e);
                                }
                               
            
                            } else{
                                Tela04CriarCampeonato tela04 = new Tela04CriarCampeonato();
                                fecha();
            
                                try {
                                    tela04.start(new Stage());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Tela 04 não iniciada " + e);
                                }
            
            
                            }
                    } else{
                        emailTxt.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                        senhaPass.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
        
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no ENTRE:" + e);
            }
        });
    }  
    
    /**
     * Método para fechar a tela atual
     */
    private void fecha(){
        ApitoFinal.getStage().close();
    }
    
}

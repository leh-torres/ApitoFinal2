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
import dao.UsuarioDao;
import dao.VerificaDao;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    boolean retorno, retorno2;

    @FXML
    private void botaoEntrar(ActionEvent event) {
        retorno = verifica.verificaLogin(emailTxt.getText(), senhaPass.getText());

        if(retorno == true){
            usuario.setId_usuario(userDao.getId(emailTxt.getText(), senhaPass.getText()));
            usuario.setEmail(emailTxt.getText());
            usuario.setSenha(senhaPass.getText());
                
            retorno2 = verifica.verificaCapeonato(usuario.getId_usuario());

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
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        senhaPass.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            try {
                if(event.getCode() == KeyCode.ENTER){
                    retorno = verifica.verificaLogin(emailTxt.getText(), senhaPass.getText());
                    if(retorno == true){
                        usuario.setId_usuario(userDao.getId(emailTxt.getText(), senhaPass.getText()));
                        usuario.setEmail(emailTxt.getText());
                        usuario.setSenha(senhaPass.getText());
                            
                        retorno2 = verifica.verificaCapeonato(usuario.getId_usuario());
            
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

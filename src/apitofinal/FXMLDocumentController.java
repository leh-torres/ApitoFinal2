/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitofinal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Usuario;
<<<<<<< HEAD
import dao.CampeonatoDao;
=======
import dao.CompeticaoDao;
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela2_Cadastro.Tela2_Cadastro;
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

<<<<<<< HEAD
    CampeonatoDao verificaCampeonato = new CampeonatoDao();
=======
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631
    Usuario usuario = new Usuario();
    UsuarioDao userDao = new UsuarioDao();
    CompeticaoDao compDao = new CompeticaoDao();
    boolean retorno, retorno2;

    @FXML
<<<<<<< HEAD
    private void botaoEntrar(ActionEvent event) {
        retorno = userDao.verificaLogin(emailTxt.getText(), senhaPass.getText());
=======
    private void botaoEntrar(ActionEvent event) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        usuario.criptografaSenha(senhaPass.getText());
        retorno = userDao.verificaLogin(emailTxt.getText(), usuario.getSenha());
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631

        if(retorno == true){
            usuario.setId_usuario(userDao.getId(emailTxt.getText(), usuario.getSenha()));
            usuario.setEmail(emailTxt.getText());
            usuario.setImagem(userDao.getImagem());
            usuario.setNome(userDao.getNome());
            usuario.setSobrenome(userDao.getSobrenome());
            usuario.setImagem(userDao.getImagem());
                
<<<<<<< HEAD
            retorno2 = verificaCampeonato.verificaCapeonato(usuario.getId_usuario());
=======
            retorno2 = compDao.verificaCapeonato(usuario.getId_usuario());
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631

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
            usuario.limpaUsuario();
            emailTxt.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
            senhaPass.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        senhaPass.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            try {
                if(event.getCode() == KeyCode.ENTER){
<<<<<<< HEAD
                    retorno = userDao.verificaLogin(emailTxt.getText(), senhaPass.getText());
=======
                    usuario.criptografaSenha(senhaPass.getText());
                    retorno = userDao.verificaLogin(emailTxt.getText(), usuario.getSenha());
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631
                    if(retorno == true){
                        usuario.setId_usuario(userDao.getId(emailTxt.getText(), usuario.getSenha()));
                        usuario.setEmail(emailTxt.getText());
                        usuario.setImagem(userDao.getImagem());
                        usuario.setNome(userDao.getNome());
                        usuario.setSobrenome(userDao.getSobrenome());
                        usuario.setImagem(userDao.getImagem());
                            
<<<<<<< HEAD
                        retorno2 = verificaCampeonato.verificaCapeonato(usuario.getId_usuario());
=======
                        retorno2 = compDao.verificaCapeonato(usuario.getId_usuario());
>>>>>>> 1e0281d9a2883c105514fbf066e6f65377f86631
            
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
                        usuario.limpaUsuario();
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

    /**
     * Função para mudar a tela ao clicar no botão cadastrar
     * @param event
     */
    @FXML
    private void iniciarCadastro(ActionEvent event){
        Tela2_Cadastro tela2 = new Tela2_Cadastro();
        fecha();

        try {
            tela2.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Tela 2 não iniciada");
        }
    }
    
}

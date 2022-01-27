/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela4_CriarCampeonato;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tela14_Perfil.Tela14Perfil;

/**
 *
 * @author eroti
 */
public class principalController implements Initializable {
    
    @FXML
    private Label nome_usuario;

    @FXML
    private ImageView logo_usuario;

    Usuario usuario = new Usuario();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }  
    
    @FXML
    private void perfilUsuario(MouseEvent event){
        Tela14Perfil telaPerfil = new Tela14Perfil();
        
        try {
            telaPerfil.start(new Stage());
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Telas.tela5_CadastrarCampeonato;

import classes.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author eroti
 */
public class CadastrarCampeonatoController implements Initializable {
    
    Usuario usuario = new Usuario();
    
    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }    
    
}

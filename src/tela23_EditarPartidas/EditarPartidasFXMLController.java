/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela23_EditarPartidas;

import classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela22_MaisInfo.Tela22MaisInfo;
import tela25_EditarTimes.Tela25EditarTimes;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarPartidasFXMLController implements Initializable {

    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    private Usuario usuario = new Usuario();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }    
    
    @FXML
    private void acaoBtnMaisInfo() throws IOException{
        Tela22MaisInfo tela22 = new Tela22MaisInfo();
        fecha();
        tela22.start(new Stage());
    }
    
    @FXML
    private void acaoBtnEditarTimes() throws IOException{
        Tela25EditarTimes tela25 = new Tela25EditarTimes();
        fecha();
        tela25.start(new Stage());
    }
    
    @FXML
    private void acaoBtnVoltar() throws IOException{
        Tela22MaisInfo tela22 = new Tela22MaisInfo();
        fecha();
        tela22.start(new Stage());
    }
    
    private void fecha(){
        Tela23EditarPartidas.getStage().close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela14_Perfil;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Usuario;
import dao.UsuarioDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela18_EditarPerfil.Tela18EditarPerfil;
import tela19_ExcluirPerfil.Tela19ExcluirPerfil;
import tela4_CriarCampeonato.Tela04CriarCampeonato;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class PerfilFXMLController implements Initializable {

    @FXML
    private Label labelNomeCompleto;
    @FXML
    private Label labelEmail;
    @FXML
    private ImageView imageFoto;
    Usuario usuario = new Usuario();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String nomeCompleto = "  " + usuario.getNome() + " " + usuario.getSobrenome();

        imageFoto.setImage(usuario.getImagem());
        labelNomeCompleto.setText(nomeCompleto);
        labelEmail.setText(usuario.getEmail());
    }
    
    @FXML
    private void telaEditarPerfil(ActionEvent event){
        Tela18EditarPerfil tela18 = new Tela18EditarPerfil();
        fechaTelas();
        try {
            tela18.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnExcluirPerfil(ActionEvent event) throws Exception{
        Tela19ExcluirPerfil excluirPerfil = new Tela19ExcluirPerfil();
        excluirPerfil.start(new Stage());
    }

    @FXML
    private void sairDoSistema(ActionEvent event){
        fechaTelas();
        Platform.exit();
        System.exit(0);
    }
    
    private void fechaTelas(){
        Tela14Perfil.getStage().close();
        Tela04CriarCampeonato.getStage().close();
    }
    
}

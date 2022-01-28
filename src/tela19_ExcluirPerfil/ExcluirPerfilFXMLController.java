/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela19_ExcluirPerfil;

import java.net.URL;
import java.util.ResourceBundle;

import apitofinal.ApitoFinal;
import classes.Usuario;
import dao.UsuarioDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import tela14_Perfil.Tela14Perfil;
import tela4_CriarCampeonato.Tela04CriarCampeonato;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class ExcluirPerfilFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void btnConfirma(ActionEvent event) throws Exception{
        boolean retorno;

        Usuario usuario = new Usuario();
        UsuarioDao userDao = new UsuarioDao();

        retorno = userDao.excluirUsuario(usuario.getId_usuario());
        if(retorno == true){
            voltaParaLogin();
        } else{
            fechaTelaAtual();
        }
    }

    @FXML
    private void btnNaoConfirma(ActionEvent event){
        fechaTelaAtual();
    }

    private void fechaTelas(){
        Tela19ExcluirPerfil.getStage().close();
        Tela14Perfil.getStage().close();
        Tela04CriarCampeonato.getStage().close();
        ApitoFinal.getStage().close();
    }

    private void fechaTelaAtual(){
        Tela19ExcluirPerfil.getStage().close();
    }

    private void voltaParaLogin() throws Exception{
        ApitoFinal telaInicial = new ApitoFinal();
        fechaTelas();
        telaInicial.start(new Stage());
    }
    
    
}

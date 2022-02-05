/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela17_ExcluirCampeonato;

import classes.Competicao;
import dao.CampeonatoDao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela15_Campeonato.Tela15Campeonato;
import tela16_EditarCampeonato.Tela16EditarCampeonato;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class ExcluirCampeonatoFXMLController implements Initializable {

    @FXML
    private Button btn_confirmar,btn_cancelar;
    
    private CampeonatoDao campeonatoDao = new CampeonatoDao();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    private void acaoBtnConfirmar(ActionEvent event){
        if(campeonatoDao.excluirCompeticao(Competicao.getId_comp_aux())){
            Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
            
            try {
                fecha();
                tela10.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ExcluirCampeonatoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void acaoBtnCancelar(ActionEvent event){
        Tela15Campeonato tela15 = new Tela15Campeonato();
        fecha();
        try {
            tela15.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ExcluirCampeonatoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecha(){
        Tela17ExcluirCampeonato.getStage().close();
    }
    
}

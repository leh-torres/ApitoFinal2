/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela13_DadosPartidas;

import classes.Partida;
import dao.PartidaDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class DadosPartidasFXMLController implements Initializable {
    
    @FXML
    private TextField local;
    
    @FXML
    private DatePicker data_partida;
    
    @FXML
    private TextField horario_partida;
    
    private Partida partida = new Partida();
    private PartidaDao part = new PartidaDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    public void acaoBotaoSalvar(ActionEvent event){
        
        if(part.cadastrarPart(data_partida.getEditor().getText(), horario_partida.getText(), local.getText(),
                Partida.getFk_comp(), Partida.getFk_time1(), Partida.getFk_time2()) == true){
            
            fecha();
        }
    }
    
    private void fecha(){
        Tela13DadosPartidas.getStage().close();
    }
}

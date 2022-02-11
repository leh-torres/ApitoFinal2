/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela26_ExcluirTime;

import classes.Time;
import dao.TimeDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class ExcluirTimeFXMLController implements Initializable {
    
    private TimeDao timeDao = new TimeDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void acaoBtnConfirmar(ActionEvent event){
        if(timeDao.excluirTime(Time.getId_time_aux())){
            JOptionPane.showMessageDialog(null, "Time excluído com sucesso!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro ao excluir time!");
        }
    }
    
    @FXML
    private void acaoBtnCancelar(ActionEvent event){
        Tela26ExcluirTime.getStage().close();
    }
    
}

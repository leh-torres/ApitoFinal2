/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela24_EditarDadosPartida;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Partida;
import classes.Usuario;
import dao.PartidaDao;
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarDadosPartidaFXMLController implements Initializable {

    @FXML
    private CheckBox checkEditarLocal, checkEditarData, checkEditarHora;
    @FXML
    private TextField txtEditarLocal, txtHorario;
    @FXML
    private DatePicker datePickerEditarData;

    private static Partida partida = new Partida();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public static void setPartida(Partida partidaPassada) {
       partida = partidaPassada;
    }    
    
    /**
     * **Método para ao marcar os checkBoxs escrever no TextFild e botões sejam liberados**
     * @param event
     */
    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkEditarLocal.isSelected()){
            txtEditarLocal.setEditable(true);
        } else{
            txtEditarLocal.setEditable(false);
        }

        if(checkEditarData.isSelected()){
            datePickerEditarData.setDisable(false);
        } else{
            datePickerEditarData.setDisable(true);
        }

        if(checkEditarHora.isSelected()){
            txtHorario.setEditable(true);
        } else{
            txtHorario.setEditable(false);
        }

    }

    
    /**
     * **Método para atulizar os campos escolhidos***
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnAtualiza(ActionEvent event) throws Exception{
        PartidaDao partidaDao = new PartidaDao();

        if(checkEditarLocal.isSelected()){
            partidaDao.editarLocal(txtEditarLocal.getText(), partida.getId_part());
        } 
        if(checkEditarData.isSelected()){
            partidaDao.editarData(datePickerEditarData.getEditor().getText(), partida.getId_part());
        }
        if(checkEditarHora.isSelected()){
            partidaDao.editarHora(txtHorario.getText(), partida.getId_part());
        }
        
        Tela24EditarDadosPartida.getStage().close();
    }
}

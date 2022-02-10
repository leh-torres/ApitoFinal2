/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela20_DefinirResultado;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class DefinirResultadoFXMLController implements Initializable {

    private static int idPartida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JOptionPane.showMessageDialog(null, "IdPartida: " + idPartida);
    }

    public static int getIdPartida() {
        return idPartida;
    }

    public static void setIdPartida(int idPartida) {
        DefinirResultadoFXMLController.idPartida = idPartida;
    }    
    
}

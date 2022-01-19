/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela7_CadastrarTime;

import classes.Usuario;
import dao.TimeDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tela6_SelecaoTimes.Tela06SelecaoTimes;

/**
 *
 * @author eroti
 */
public class CadastrarTimeController implements Initializable{
    
    @FXML
    private TextField nome_time;
    
    @FXML
    private TextField abreviacao_time;
    
    @FXML
    private ImageView escudo_time;
    
    @FXML
    private Button btn_escudo;
    
    @FXML
    private Button btn_voltar;
    
    @FXML
    private Button btn_avancar;
    
    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;
    private boolean verifica;
    private FileChooser fc; 
    Usuario usuario = new Usuario();
    TimeDao time = new TimeDao();
    
    private Boolean cadastrar() throws FileNotFoundException{
        image = new File(path);
        fis = new FileInputStream(image);
        verifica = time.inserirTime(nome_time.getText(), fis, abreviacao_time.getText(),usuario.getId_usuario());
        if(verifica){
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERRO: Cadastro não realizado!");
            return false;
        }
    }
    
    @FXML
    private void importarImagem(ActionEvent event){
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            System.out.println("Arquivo enviado.");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        System.out.println(image);
        
        path = seletedFile.getAbsolutePath();
    }
    
    @FXML
    private void acaoBotaoAvancar(ActionEvent event) throws FileNotFoundException{
        if(cadastrar() == true){
            trocarTela();
        }
    }
    
    @FXML
    private void acaoBotaoVoltar(ActionEvent event){
        trocarTela();
    }
    
    private void fecha(){
        Tela07CadastrarTime.getStage().close();
    }
    
    private void trocarTela(){
        Tela06SelecaoTimes tela = new Tela06SelecaoTimes();
        fecha();
        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarTimeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }
}

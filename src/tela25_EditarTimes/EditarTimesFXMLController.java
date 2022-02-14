/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela25_EditarTimes;

import classes.Competicao;
import classes.Time;
import classes.Usuario;
import dao.TimeDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;

import javax.swing.JOptionPane;
import tela16_EditarCampeonato.Tela16EditarCampeonato;
import tela22_MaisInfo.Tela22MaisInfo;
import tela23_EditarPartidas.Tela23EditarPartidas;
import tela26_ExcluirTime.Tela26ExcluirTime;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarTimesFXMLController implements Initializable {

    @FXML
    private Label nome_usuario;

    @FXML
    private ImageView logo_usuario, imagem_time;

    @FXML
    private ListView lista;

    @FXML
    private TextField barra_pesquisa, nome_time, abreviacao_time;
    
    @FXML
    private CheckBox seletor_nome,seletor_escudo, seletor_abreviacao;
    
    @FXML
    private Button btn_adicionar_imagem;

    private ArrayList<Time> listaTime = new ArrayList<>();

    private Usuario usuario = new Usuario();
    private TimeDao timeDao = new TimeDao();
    private ObservableList<String> time;
    private int id ;
    private static FileInputStream fis = null;
    private String path =  null;;
    private File image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }

    @FXML
    private void listaDePesquisa(KeyEvent e) {
        TimeDao timeDao = new TimeDao();

        int i = 0;

        listaTime = timeDao.pesquisaTime(barra_pesquisa.getText());

        if (listaTime.size() > 8) {
            listaTime = null;
        }

        if (listaTime == null) {
            lista.setVisible(false);
            lista.refresh();
        }

        switch (listaTime.size()) {

            case 1:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time());
                break;

            case 2:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time());
                break;

            case 3:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time());
                break;

            case 4:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time(), listaTime.get(3).getNome_time());
                break;

            case 5:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time(), listaTime.get(3).getNome_time(), listaTime.get(4).getNome_time());
                break;

            case 6:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time(), listaTime.get(3).getNome_time(), listaTime.get(4).getNome_time(),
                        listaTime.get(5).getNome_time());
                break;

            case 7:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time(), listaTime.get(3).getNome_time(), listaTime.get(4).getNome_time(),
                        listaTime.get(5).getNome_time(), listaTime.get(6).getNome_time());
                break;

            case 8:
                time = FXCollections.observableArrayList(listaTime.get(0).getNome_time(), listaTime.get(1).getNome_time(),
                        listaTime.get(2).getNome_time(), listaTime.get(3).getNome_time(), listaTime.get(4).getNome_time(),
                        listaTime.get(5).getNome_time(), listaTime.get(6).getNome_time(), listaTime.get(7).getNome_time());
                break;

        }

        while (i < listaTime.size()) {
            lista.setItems(time);
            i++;
        }
        if (i >= 1) {
            lista.setVisible(true);
        } else {
            lista.setVisible(false);
        }
    }

    @FXML
    private void capturarElemento(MouseEvent e) {

        int linha = lista.getSelectionModel().getSelectedIndex();
        if (linha >= 0) {
            id = listaTime.get(linha).getId_time();
            nome_time.setText(listaTime.get(linha).getNome_time());
            abreviacao_time.setText(listaTime.get(linha).getAbreviacao_time());
            imagem_time.setImage(listaTime.get(linha).getImagem_time());
        }
    }
    
    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(seletor_nome.isSelected()){
            nome_time.setEditable(true);
        } else{
            nome_time.setEditable(false);
        }

        if(seletor_abreviacao.isSelected()){
            abreviacao_time.setEditable(true);
        } else{
            abreviacao_time.setEditable(false);
        }

        if(seletor_escudo.isSelected()){
            btn_adicionar_imagem.setDisable(false);
        } else{
            btn_adicionar_imagem.setDisable(true);
        }
    }
    
    @FXML
    private void acaoSalvar(ActionEvent event){

        if(seletor_nome.isSelected()){
            timeDao.atualizaNome(nome_time.getText(),id);
        } 
        if(seletor_abreviacao.isSelected()){
            timeDao.atualizaAbreviacao(abreviacao_time.getText(),id);
        }
        if(seletor_escudo.isSelected()){
            timeDao.atualizaImagem(fis,id);
        }        
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        refreshScreen();
    }
    
    @FXML
    private void importarImagem(ActionEvent event) throws FileNotFoundException{
        FileChooser fc = new FileChooser();
        File seletedFile = fc.showOpenDialog(null);
        
        if(seletedFile != null){
            System.out.println("Arquivo enviado.");
        }else{
            System.out.println("Arquivo não é válido!");
        }
        System.out.println(image);
        
        path = seletedFile.getAbsolutePath();
        image = new File(path);
        fis = new FileInputStream(image);
        Image imagem = new Image(fis);
        
        imagem_time.setImage(imagem);
    }
    
    @FXML
    private void acaoBtnExcluirTime(ActionEvent event){
        barra_pesquisa.setText(null);
        nome_time.setText(null);
        abreviacao_time.setText(null);
        imagem_time.setImage(null);
        lista.setVisible(false);
        Time.setId_time_aux(id);
        
        JOptionPane.showMessageDialog(null, "Observação: o time exluido pode está participando de alguma partida de algum"
                + " campeonato assim podendo excluir partidas de algum campeonato!");
        
        Tela26ExcluirTime tela26 = new Tela26ExcluirTime();
        
        try {
            tela26.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(EditarTimesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshScreen(){
        Tela25EditarTimes tela25 = new Tela25EditarTimes();
        fecha();

        try {
            tela25.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }
    }
    
    @FXML
    private void acaoBtnMaisInfo() throws IOException{
        Tela22MaisInfo tela22 = new Tela22MaisInfo();
        fecha();
        tela22.start(new Stage());
    }
    
    @FXML
    private void acaoBtnEditarPartida() throws Exception{
        Tela23EditarPartidas tela23 = new Tela23EditarPartidas();
        fecha();
        tela23.start(new Stage());
    }
    
    @FXML
    private void acaoBtnVoltar() throws Exception{
        Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
        fecha();
        tela10.start(new Stage());
    }
    
    private void fecha(){
        Tela25EditarTimes.getStage().close();
    }
}

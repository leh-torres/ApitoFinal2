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

import classes.Competicao;
import dao.TimeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela22_MaisInfo.Tela22MaisInfo;
import tela24_EditarDadosPartida.EditarDadosPartidaFXMLController;
import tela24_EditarDadosPartida.Tela24EditarDadosPartida;
import tela25_EditarTimes.Tela25EditarTimes;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarPartidasFXMLController implements Initializable {

    @FXML
    private ImageView logo_usuario, image1, image2, image3, image4, image5, image6, image7, image8;
    @FXML
    private Label nomeUsuario;
    
    private Usuario usuario = new Usuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logo_usuario.setImage(usuario.getImagem());
        nomeUsuario.setText(usuario.getNome());

        limpaImageViews();
        carregaTimes();
    }    

     /**
     * Método que limpa todos os ImageView
     */
    private void limpaImageViews()
    {
        image1.setImage(null);
        image2.setImage(null);
        image3.setImage(null);
        image4.setImage(null);
        image5.setImage(null);
        image6.setImage(null);
        image7.setImage(null);
        image8.setImage(null);
        
    }

    /**
     * Método que carrega as imagens dos times na árvore
     */
    private void carregaTimes()
    {
       TimeDao timeDao = new TimeDao();
       
       image1.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time1Dinamico()));
       image2.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time2Dinamico()));
       
       image3.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time1Dinamico()));
       image4.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time2Dinamico()));
       
       image5.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time1Dinamico()));
       image6.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time2Dinamico()));
       
       image7.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time1Dinamico()));
       image8.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time2Dinamico()));

    }

    //Botões centrais
    @FXML
    private void btnEditarDados1(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(0).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados2(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(1).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados3(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(2).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados4(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(3).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados5(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(4).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados6(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
    }

    @FXML
    private void btnEditarDados7(ActionEvent event) throws Exception{
        EditarDadosPartidaFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
        Tela24EditarDadosPartida tela24 = new Tela24EditarDadosPartida();
        tela24.start(new Stage());
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

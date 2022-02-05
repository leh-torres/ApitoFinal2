/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela15_Campeonato;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.TimeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela12_SelecionarPartida.Tela12SelecionarPartida;
import tela16_EditarCampeonato.Tela16EditarCampeonato;
import tela17_ExcluirCampeonato.Tela17ExcluirCampeonato;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class CampeonatoFXMLController implements Initializable {

    @FXML
    private ImageView logo_usuario, imgTime1, imgTime2, imgTime3, imgTime4, imgTime5, imgTime6, imgTime7, imgTime8, imgTime9, imgTime10, imgTime11, imgTime12, imgTime14;
    @FXML
    private ImageView imgTime13;
    @FXML
    private Label txtNomeUsuario, labelNomeComp;

    private Usuario usuario = new Usuario();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        labelNomeComp.setText(getNomeComp());
        txtNomeUsuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        limpaImageViews();
        carregaTimes();

        
    } 

    /**
     * Método que limpa todos os ImageView
     */
    private void limpaImageViews()
    {
        imgTime1.setImage(null);
        imgTime2.setImage(null);
        imgTime3.setImage(null);
        imgTime4.setImage(null);
        imgTime5.setImage(null);
        imgTime6.setImage(null);
        imgTime7.setImage(null);
        imgTime8.setImage(null);
        imgTime9.setImage(null);
        imgTime10.setImage(null);
        imgTime11.setImage(null);
        imgTime12.setImage(null);
        imgTime13.setImage(null);
        imgTime14.setImage(null);
    }

    /**
     * Método que carrega as imagens dos times na árvore
     */
    private void carregaTimes()
    {
       TimeDao timeDao = new TimeDao();
       
       imgTime1.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time1Dinamico()));
       imgTime2.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time2Dinamico()));
       
       imgTime3.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time1Dinamico()));
       imgTime4.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time2Dinamico()));
       
       imgTime11.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time1Dinamico()));
       imgTime12.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time2Dinamico()));
       
       imgTime13.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time1Dinamico()));
       imgTime14.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time2Dinamico()));


        //TO DO carregar imagens dos times ganhadores
    }

    /**
     * Método para mudar para a tela SelecionarPartidas
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnSelecionarPartida(ActionEvent event) throws Exception
    {
        Tela12SelecionarPartida tela12 = new Tela12SelecionarPartida();
        fechaTela();
        tela12.start(new Stage());
    }

    /**
     * Método para mudar para a tela Editar Campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnEditarCampeonato(ActionEvent event) throws Exception
    {
        Tela16EditarCampeonato tela16 = new Tela16EditarCampeonato();
        fechaTela();
        tela16.start(new Stage());
    }

    /**
     * Método para mudar para a tela Excluir Campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnExcluirCampeonato(ActionEvent event) throws Exception
    {
        Tela17ExcluirCampeonato tela17 = new Tela17ExcluirCampeonato();
        fechaTela();
        tela17.start(new Stage());
    }

    /**
     * Método para mudar para a tela Selecionar Campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnVoltar(ActionEvent event) throws Exception
    {
        Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
        tela10.start(new Stage());
    }

    /**
     * Método para fecha a tela atual
     */
    private void fechaTela()
    {
        Tela15Campeonato.getStage().close();
    }
   
    /**
     * Retorna o nome da Competição
     * @return
     */
    private String getNomeComp(){
        CampeonatoDao campDao = new CampeonatoDao();
        return "    " + campDao.getNome(Competicao.getId_comp_aux());
    } 
    
}

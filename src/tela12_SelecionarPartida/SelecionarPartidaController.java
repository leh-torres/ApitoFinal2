/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela12_SelecionarPartida;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.TimeDao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela15_Campeonato.Tela15Campeonato;
import tela20_DefinirResultado.DefinirResultadoFXMLController;
import tela20_DefinirResultado.Tela20DefinirResultados;

/**
 *
 * @author eroti
 */
public class SelecionarPartidaController implements Initializable {
    
    @FXML
    private Label nome_usuario, labelNomeCampeonato;

    @FXML
    private ImageView logo_usuario, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, 
        time11, time12, time13, time14;
    
    @FXML
    private Label label;
    
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7;

    private Usuario usuario = new Usuario();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelNomeCampeonato.setText(getNomeComp());
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        carregaImagensTimes();
    }    

    /**
     * Retorna o nome da Competição
     * @return
     */
    private String getNomeComp(){
        CampeonatoDao campDao = new CampeonatoDao();
        return "    " + campDao.getNome(Competicao.getId_comp_aux());
    } 

    private void carregaImagensTimes()
    {
        TimeDao timeDao = new TimeDao();

        time1.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time1Dinamico()));
        time2.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time2Dinamico()));

        time3.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time1Dinamico()));
        time4.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time2Dinamico()));

        time5.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time1Dinamico()));
        time6.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time2Dinamico()));

        time7.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time1Dinamico()));
        time8.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time2Dinamico()));

        time9.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time1Dinamico()));
        time10.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time2Dinamico()));
    }

    @FXML
    private void btnInicio(ActionEvent event) throws Exception
    {
        Tela15Campeonato tela15 = new Tela15Campeonato();
        fechaTela();
        tela15.start(new Stage());
    }

    @FXML
    private void btnVs(ActionEvent event) throws Exception
    {
        if(button1.isCache())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(0).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(0).getId_part());
        } else if(button2.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(1).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(1).getId_part());
        } else if(button3.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(2).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(2).getId_part());
        } else if(button4.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(3).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(3).getId_part());
        } else if(button5.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(4).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(4).getId_part());
        } else if(button6.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
        } else if(button7.isPressed())
        {
            DefinirResultadoFXMLController.setIdPartida(Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
            System.out.println("IdPassado: " + Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
        }

        Tela20DefinirResultados tela20 = new Tela20DefinirResultados();
        fechaTela();
        tela20.start(new Stage());

    }


    private void fechaTela()
    {
        Tela12SelecionarPartida.getStage().close();
    }
    
}

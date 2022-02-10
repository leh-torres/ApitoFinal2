/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela11_DefinirPartidas;

import classes.Competicao;
import classes.Partida;
import classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela13_DadosPartidas.Tela13DadosPartidas;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class DefinirPartidasFXMLController implements Initializable {

    @FXML
    private Label nome_usuario;

    @FXML
    private ImageView logo_usuario;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;

    @FXML
    private ImageView img8;

    private Usuario usuario = new Usuario();
    private Partida partida = new Partida();
    private int cont = 0;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        img1.setImage(Competicao.getTimesSelecionados().get(0).getImagem_time());
        img2.setImage(Competicao.getTimesSelecionados().get(1).getImagem_time());
        img3.setImage(Competicao.getTimesSelecionados().get(2).getImagem_time());
        img4.setImage(Competicao.getTimesSelecionados().get(3).getImagem_time());
        img5.setImage(Competicao.getTimesSelecionados().get(4).getImagem_time());
        img6.setImage(Competicao.getTimesSelecionados().get(5).getImagem_time());
        img7.setImage(Competicao.getTimesSelecionados().get(6).getImagem_time());
        img8.setImage(Competicao.getTimesSelecionados().get(7).getImagem_time());

        Partida.setFk_comp(Competicao.getId_comp_aux());

    }

    @FXML
    public void acaoPart1(ActionEvent event) throws IOException {
        btn1.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(Competicao.getTimesSelecionados().get(0).getId_time());
        Partida.setFk_time2(Competicao.getTimesSelecionados().get(1).getId_time());
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart2(ActionEvent event) throws IOException {
        btn2.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(Competicao.getTimesSelecionados().get(2).getId_time());
        Partida.setFk_time2(Competicao.getTimesSelecionados().get(3).getId_time());
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart3(ActionEvent event) throws IOException {
        btn3.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(Competicao.getTimesSelecionados().get(4).getId_time());
        Partida.setFk_time2(Competicao.getTimesSelecionados().get(5).getId_time());
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart4(ActionEvent event) throws IOException {
        btn4.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(Competicao.getTimesSelecionados().get(6).getId_time());
        Partida.setFk_time2(Competicao.getTimesSelecionados().get(7).getId_time());
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart5(ActionEvent event) throws IOException {
        btn5.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(0);
        Partida.setFk_time2(0);
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart6(ActionEvent event) throws IOException {
        btn6.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(0);
        Partida.setFk_time2(0);
        tela.start(new Stage());
    }

    @FXML
    public void acaoPart7(ActionEvent event) throws IOException {
        btn7.setDisable(true);
        cont++;
        Tela13DadosPartidas tela = new Tela13DadosPartidas();
        Partida.setFk_time1(0);
        Partida.setFk_time2(0);
        tela.start(new Stage());
    }

    @FXML
    public void acaoConcluir(ActionEvent event) throws Exception {
        if (cont == 7) {
            Tela10SelecionarCampeonato tela1 = new Tela10SelecionarCampeonato();
            fecha();
            tela1.start(new Stage());
            fecha();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione todas as partidas");
        }
    }

    public void fecha() {
        Tela11DefinirPartidas.getStage().close();
    }

}

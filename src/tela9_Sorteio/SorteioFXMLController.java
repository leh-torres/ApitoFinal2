/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela9_Sorteio;

import classes.Competicao;
import classes.Time;
import classes.Usuario;
import dao.SelecaoTimesDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela11_DefinirPartidas.Tela11DefinirPartidas;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class SorteioFXMLController implements Initializable {

    @FXML
    private Label nome_usuario;

    @FXML
    private ImageView logo_usuario;

    @FXML
    private ImageView time1;

    @FXML
    private ImageView time2;

    @FXML
    private ImageView time3;

    @FXML
    private ImageView time4;

    @FXML
    private ImageView time5;

    @FXML
    private ImageView time6;

    @FXML
    private ImageView time7;

    @FXML
    private ImageView time8;

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

    @FXML
    private Button btn_sortear;

    private int i = 0;
    private int j = 0;
    private int id;
    private int count = 0;
    private int[] id_sorteado = new int[9];
    private Usuario usuario = new Usuario();
    private Competicao competicao = new Competicao();
    private ArrayList<Time> timesSorteados = new ArrayList<>();
    private SelecaoTimesDao selecaoTimesDao = new SelecaoTimesDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        sortear();

        img1.setImage(competicao.getTimesSelecionados().get(0).getImagem_time());
        img2.setImage(competicao.getTimesSelecionados().get(1).getImagem_time());
        img3.setImage(competicao.getTimesSelecionados().get(2).getImagem_time());
        img4.setImage(competicao.getTimesSelecionados().get(3).getImagem_time());
        img5.setImage(competicao.getTimesSelecionados().get(4).getImagem_time());
        img6.setImage(competicao.getTimesSelecionados().get(5).getImagem_time());
        img7.setImage(competicao.getTimesSelecionados().get(6).getImagem_time());
        img8.setImage(competicao.getTimesSelecionados().get(7).getImagem_time());

    }

    @FXML
    private void acaoBotaoSortear(ActionEvent event) throws SQLException {

        if (count == 0) {
            time1.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 1) {
            time2.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 2) {
            time3.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 3) {
            time4.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 4) {
            time5.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 5) {
            time6.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 6) {
            time7.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
        } else if (count == 7) {
            time8.setImage(competicao.getTimesSelecionados().get(id_sorteado[count]).getImagem_time());
            btn_sortear.setText("Avançar");
        } else if (count == 8) {
            for (i = 0; i < 8; i++) {
                for (j = 0; j < i; j++) {
                    if (id_sorteado[j] == competicao.getTimesSelecionados().get(j).getId_time()) {
                        timesSorteados.add(competicao.getTimesSelecionados().get(j));
                    }
                }
            }
            if(selecaoTimesDao.alterarTimesSelecionados() == true){
                trocarTela();
            }
        }
        count++;
    }

    private void sortear() {
        Random random = new Random();

        for (i = 0; i < 8; i++) {
            id = random.nextInt(8);
            for (j = 0; j < i; j++) {
                if (id == id_sorteado[j]) {
                    sortear();
                } else {
                    id_sorteado[i] = id;
                }
            }
        }
    }

    private void trocarTela() {
        Tela11DefinirPartidas tela1 = new Tela11DefinirPartidas();
        fecha();

        try {
            tela1.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(SorteioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fecha() {
        Tela09Sorteio.getStage().close();
    }

}

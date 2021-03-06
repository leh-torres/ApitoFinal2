/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela21_MomentoPartida;

import java.net.URL;
import java.util.ResourceBundle;

import classes.Partida;
import classes.Usuario;
import dao.EstatisticasDao;
import dao.PartidaDao;
import dao.TimeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela12_SelecionarPartida.Tela12SelecionarPartida;
import tela20_DefinirResultado.Tela20DefinirResultados;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class MomentoPartidaFXMLController implements Initializable {

    @FXML
    private Label nome_usuario, qtdGols1, qtdGols2, abrev1, abrev2;
    @FXML
    private TextField txtCartoesVermelhos, txtCartoesAmarelos, txtChutesAoGol, txtEscanteios;
    @FXML
    private ImageView logo_usuario;

    private static Partida partida = new Partida();
    private Usuario usuario = new Usuario();
    private TimeDao timeDao = new TimeDao();
    private PartidaDao partidaDao = new PartidaDao();
    private int gols1, gols2;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        abrev1.setText("  " + timeDao.getAbrev(partida.getFk_time1Dinamico()));
        abrev2.setText("  " + timeDao.getAbrev(partida.getFk_time2Dinamico()));
        qtdGols1.setText(gols1+"");
        qtdGols2.setText(gols2+"");
    } 

    public static void setGols2(int gols2) {
        int gols22 = gols2;
        gols2 = gols22;
    }

    public static void setGols1(int gols1) {
        int gols12 = gols1;
        gols1 = gols12;
    }
    
    private void setEstatisticas(){
        EstatisticasDao estatisticasDao = new EstatisticasDao();
        
        if(txtCartoesAmarelos != null){
            estatisticasDao.cadastrarEstatistica("Cart??o Amarelo", Integer.parseInt(txtCartoesAmarelos.getText()), partida.getId_part());
        } else{
            txtCartoesAmarelos.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        }

        if(txtCartoesVermelhos!= null){
            estatisticasDao.cadastrarEstatistica("Cart??o Vermelho", Integer.parseInt(txtCartoesVermelhos.getText()), partida.getId_part());
        } else{
            txtCartoesVermelhos.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        }

        if(txtChutesAoGol != null){
            estatisticasDao.cadastrarEstatistica("Chutes ao gol", Integer.parseInt(txtChutesAoGol.getText()), partida.getId_part());
        } else{
            txtChutesAoGol.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        }

        if(txtEscanteios != null){
            estatisticasDao.cadastrarEstatistica("Escanteios", Integer.parseInt(txtEscanteios.getText()), partida.getId_part());
        } else{
            txtEscanteios.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-background-color:  #EBF2F5; -fx-border-radius: 4px;");
        }

    }

    @FXML
    private void btnAvancar(ActionEvent event) throws Exception{
        setEstatisticas();
        Tela12SelecionarPartida tela12 = new Tela12SelecionarPartida();
        fecharTela();
        tela12.start(new Stage());
    }

    @FXML
    private void btnVoltar(ActionEvent event) throws Exception{
        Tela20DefinirResultados tela20 = new Tela20DefinirResultados();
        fecharTela();
        tela20.start(new Stage());
    }

    private void fecharTela(){
        Tela21MomentoPartida.getStage().close();
    }

    public static void setPartida(Partida partidaPassada) {
        partida = partidaPassada;
    }    
    
}

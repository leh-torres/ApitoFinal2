/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela20_DefinirResultado;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JOptionPane;

import classes.Jogadores;
import classes.Partida;
import classes.Usuario;
import dao.JogadoresDao;
import dao.TimeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tela12_SelecionarPartida.Tela12SelecionarPartida;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class DefinirResultadoFXMLController implements Initializable {

    @FXML
    private Label nome_usuario, labelAbrev1, labelAbrev2, qtdGolsTime1, qtdGolsTime2;
    @FXML
    private TextField txtNomeJogador1, txtNomeJogador2, txtTempo1, txtTempo2;
    @FXML
    private ImageView logo_usuario, image1, image2;
    @FXML
    private ListView listViewJogador1, listViewJogador2;
    
    private ArrayList<Jogadores> listaJogadores = new ArrayList<>();
    private ObservableList<String> jogador;
    private JogadoresDao jogadoresDao = new JogadoresDao();
    private TimeDao timeDao = new TimeDao();
    private Usuario usuario = new Usuario();
    private static Partida partida = new Partida();
    private String tempoGol1, tempoGol2;
    private int qtdGols1 = 0, qtdGols2 = 0;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        setAbrev();
        setImagensTimes();
        qtdGolsTime1.setText("0");
        qtdGolsTime2.setText("0");

        listViewJogador1.setVisible(false);
        listViewJogador2.setVisible(false);

       
    }

    private void setAbrev(){
        labelAbrev1.setText("  " + timeDao.getAbrev(partida.getFk_time1Dinamico()));
        labelAbrev2.setText("  " + timeDao.getAbrev(partida.getFk_time2Dinamico()));
    }

    private void setImagensTimes(){
        image1.setImage(timeDao.getImagem(partida.getFk_time1Dinamico()));
        image2.setImage(timeDao.getImagem(partida.getFk_time2Dinamico()));
    }

    public static void setPartida(Partida partidaPassada) {
        partida = partidaPassada;
    }    


    @FXML
    private void listaDePesquisa1(KeyEvent e) {

        int i = 0;

        if(txtNomeJogador1.getText() == ""){
            listaJogadores = null;
        } else{
            listaJogadores = jogadoresDao.getJogadores(txtNomeJogador1.getText(), partida.getFk_time1Dinamico());
        }
        JOptionPane.showMessageDialog(null, "Arraylist classe tamanho: " + listaJogadores.size());

        if (listaJogadores.size() > 24) {
            listaJogadores= null;
        }

        if (listaJogadores == null) {
            listViewJogador1.setVisible(false);
            listViewJogador1.refresh();
        }

        switch (listaJogadores.size()) {

            case 1:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor());
                break;

            case 2:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor());
                break;

            case 3:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor());
                break;

            case 4:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor());
                break;

            case 5:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor());
                break;

            case 6:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                        listaJogadores.get(5).getNome_competidor());
                break;

            case 7:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                        listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor());
                break;

            case 8:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                        listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                        listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor());
                break;

            case 9:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor());
                break;

            case 10:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor());
                break;

            case 11:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor());
                break;

            case 12:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor());
                break;

            case 13:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor());
                break;

            case 14:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor());
                break;

            case 15:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor());
                break;

            case 16:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor());
                break;

            case 17:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor());
                break;

            case 18:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor());
                break;

            case 19:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor(), listaJogadores.get(18).getNome_competidor());
                break;

            case 20:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor(), listaJogadores.get(18).getNome_competidor(), listaJogadores.get(19).getNome_competidor());
                break;

            case 21:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor(), listaJogadores.get(18).getNome_competidor(), listaJogadores.get(19).getNome_competidor(),
                    listaJogadores.get(20).getNome_competidor());
                break;

            case 22:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor(), listaJogadores.get(18).getNome_competidor(), listaJogadores.get(19).getNome_competidor(),
                    listaJogadores.get(20).getNome_competidor(), listaJogadores.get(21).getNome_competidor());
                break;

            case 23:
                jogador = FXCollections.observableArrayList(listaJogadores.get(0).getNome_competidor(), listaJogadores.get(1).getNome_competidor(),
                    listaJogadores.get(2).getNome_competidor(), listaJogadores.get(3).getNome_competidor(), listaJogadores.get(4).getNome_competidor(),
                    listaJogadores.get(5).getNome_competidor(), listaJogadores.get(6).getNome_competidor(), listaJogadores.get(7).getNome_competidor(),
                    listaJogadores.get(8).getNome_competidor(), listaJogadores.get(9).getNome_competidor(), listaJogadores.get(10).getNome_competidor(),
                    listaJogadores.get(11).getNome_competidor(), listaJogadores.get(12).getNome_competidor(), listaJogadores.get(13).getNome_competidor(),
                    listaJogadores.get(14).getNome_competidor(), listaJogadores.get(15).getNome_competidor(), listaJogadores.get(16).getNome_competidor(),
                    listaJogadores.get(17).getNome_competidor(), listaJogadores.get(18).getNome_competidor(), listaJogadores.get(19).getNome_competidor(),
                    listaJogadores.get(20).getNome_competidor(), listaJogadores.get(21).getNome_competidor(), listaJogadores.get(22).getNome_competidor());
                break;
        }

        while (i < listaJogadores.size()) {
            listViewJogador1.setItems(jogador);
            i++;
        }
        if (i >= 1) {
            listViewJogador1.setVisible(true);
        } else {
            listViewJogador1.setVisible(false);
        }
    }


    @FXML
    private void capturarElemento1(MouseEvent e) {

            int cont = 0;
            int linha = listViewJogador1.getSelectionModel().getSelectedIndex();
            if (linha >= 0) {

                switch (cont) {

                    case 1:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 2:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 3:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 4:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 5:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 6:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 7:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 8:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;

                    case 9:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                        break;
                        
                    case 10:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 11:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 12:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 13:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 14:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 15:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 16:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 17:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 18:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 19:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 20:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 21:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 22:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 23:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                        
                    case 24:
                        txtNomeJogador1.clear();
                        txtNomeJogador1.setText(listaJogadores.get(linha).getNome_competidor());
                    break;
                }
                cont++;
            }

    }

    @FXML
    private void btnAdicionarGol1(ActionEvent event){
        qtdGols1 += 1;
        qtdGolsTime1.setText(Integer.toString(qtdGols1));
        tempoGol1 = txtTempo1.getText();
        txtTempo1.clear();
    }

    @FXML
    private void btnAdicionarGol2(ActionEvent event){
        qtdGols2 += 1;
        qtdGolsTime2.setText(Integer.toString(qtdGols2));
        tempoGol2 = txtTempo2.getText();
        txtTempo2.clear();
    }

    @FXML
    private void btnVoltar(ActionEvent event) throws Exception{
        Tela12SelecionarPartida tela12 = new Tela12SelecionarPartida();
        fechaTela();
        tela12.start(new Stage());

    }

    private void fechaTela(){
        Tela20DefinirResultados.getStage().close();
    }
  
    
}

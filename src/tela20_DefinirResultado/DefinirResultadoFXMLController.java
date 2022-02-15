/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela20_DefinirResultado;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Jogadores;
import classes.Partida;
import classes.Usuario;
import dao.JogadoresDao;
import dao.MomentoDaPontuacaoDAO;
import dao.PartidaDao;
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
import tela21_MomentoPartida.MomentoPartidaFXMLController;
import tela21_MomentoPartida.Tela21MomentoPartida;

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
    private TimeDao timeDao = new TimeDao();
    private Usuario usuario = new Usuario();
    private static Partida partida = new Partida();
    private int qtdGols1 = 0, qtdGols2 = 0, idJogador1, idJogador2;
   

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
        JogadoresDao jogadoresDao = new JogadoresDao();

        int i = 0;
    
        listaJogadores = jogadoresDao.getJogadores(txtNomeJogador1.getText(), partida.getFk_time1Dinamico());

        if (listaJogadores.size() >= 24) {
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

                    case 0:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 1:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 2:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 3:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 4:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 5:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 6:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 7:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 8:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                        break;
                        
                    case 9:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 10:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 11:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 12:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 13:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 14:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 15:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 16:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 17:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 18:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 19:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 20:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 21:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 22:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 23:
                        idJogador1 = listaJogadores.get(linha).getId_competidor();
                    break;
                }
                cont++;
            }

    }

    @FXML
    private void listaDePesquisa2(KeyEvent e) {
        JogadoresDao jogadoresDao = new JogadoresDao();

        int i = 0;

        listaJogadores = jogadoresDao.getJogadores(txtNomeJogador2.getText(), partida.getFk_time2Dinamico());

        if (listaJogadores.size() >= 24) {
            listaJogadores= null;
        }

        if (listaJogadores == null) {
            listViewJogador2.setVisible(false);
            listViewJogador2.refresh();
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
            listViewJogador2.setItems(jogador);
            i++;
        }
        if (i >= 1) {
            listViewJogador2.setVisible(true);
        } else {
            listViewJogador2.setVisible(false);
        }
    }


    @FXML
    private void capturarElemento2(MouseEvent e) {

            int cont = 0;
            int linha = listViewJogador2.getSelectionModel().getSelectedIndex();
            if (linha >= 0) {

                switch (cont) {

                    case 0:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 1:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 2:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 3:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 4:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 5:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 6:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 7:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;

                    case 8:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                        break;
                        
                    case 9:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 10:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 11:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 12:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 13:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 14:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 15:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 16:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 17:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 18:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 19:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 20:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 21:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 22:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                        
                    case 23:
                        idJogador2 = listaJogadores.get(linha).getId_competidor();
                    break;
                }
                cont++;
            }

    }

    @FXML
    private void btnAdicionarGol1(ActionEvent event){
        qtdGols1 += 1;
        qtdGolsTime1.setText(Integer.toString(qtdGols1));
        cadastraMomento1();
        txtTempo1.clear();
    }

    @FXML
    private void btnAdicionarGol2(ActionEvent event){
        qtdGols2 += 1;
        qtdGolsTime2.setText(Integer.toString(qtdGols2));
        cadastraMomento2();
        txtTempo2.clear();
    }

    @FXML
    private void btnVoltar(ActionEvent event) throws Exception{
        Tela12SelecionarPartida tela12 = new Tela12SelecionarPartida();
        fechaTela();
        tela12.start(new Stage());

    }

    @FXML
    private void btnAvancar(ActionEvent event) throws Exception{
        MomentoPartidaFXMLController.setPartida(partida);
        Tela21MomentoPartida tela21 = new Tela21MomentoPartida();
        setPlacar();
        fechaTela();
        tela21.start(new Stage());
    }

    private void fechaTela(){
        Tela20DefinirResultados.getStage().close();
    }
  
    private void cadastraMomento1(){
        MomentoDaPontuacaoDAO mDao =  new MomentoDaPontuacaoDAO();

        mDao.cadastrarMomentoPart(idJogador1, txtTempo1.getText(), partida.getId_part());
    }

    private void cadastraMomento2(){
        MomentoDaPontuacaoDAO mDao =  new MomentoDaPontuacaoDAO();

        mDao.cadastrarMomentoPart(idJogador2, txtTempo2.getText(), partida.getId_part());
    }

    private void setPlacar(){
        int qtd1, qtd2;
        PartidaDao partidaDao = new PartidaDao();
        String placar = qtdGols1 + " x " + qtdGols2;

        if(qtdGols1 == 0){
            String gols1 = 0 + "";
            qtd1 = Integer.parseInt(gols1);
        } else{
            String gols1 = qtdGols1 + "";
            qtd1 = Integer.parseInt(gols1);
        }

        if(qtdGols2 == 0){
            String gols2 = 0 + "";
            qtd2 = Integer.parseInt(gols2);
        } else{
            String gols2 = qtdGols2 + "";
            qtd2 = Integer.parseInt(gols2);
        }

        if(qtd1 > qtd2){
            partidaDao.setPlacar(placar, partida.getId_part());
            partidaDao.setTimeVencedor(partida.getFk_time1Dinamico(), partida.getId_part());
        } else{
            partidaDao.setPlacar(placar, partida.getId_part());
            partidaDao.setTimeVencedor(partida.getFk_time2Dinamico(), partida.getId_part());
        }

    }

    
}

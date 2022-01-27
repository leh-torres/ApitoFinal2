/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela8_CadastrarJogadores;

import classes.Jogadores;
import classes.Usuario;
import dao.JogadoresDao;
import dao.TimeDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class CadJogadoresFXMLController implements Initializable {

    @FXML
    private Label nome_usuario;

    @FXML
    private ImageView logo_usuario;

    @FXML
    private TextField nome_jogador;

    @FXML
    private Button btn_adicionar_jogador;

    @FXML
    private Button btn_concluir_cadastro;

    @FXML
    private ListView lista_jogadores;

    private Usuario usuario = new Usuario();
    private Jogadores jogado = new Jogadores();
    private JogadoresDao jogadoresDao = new JogadoresDao();
    private TimeDao timeDao = new TimeDao();
    private ArrayList<String> jogadores = new ArrayList<>();
    private ObservableList<String> jogador;
    private int cont = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }

    @FXML
    private void acaoBtnAdicionarJogadores(ActionEvent event) {
        if (nome_jogador != null) {
            jogadores.add(nome_jogador.getText());
            nome_jogador.setText("");
            switch (cont) {
                case 0:
                    jogador = FXCollections.observableArrayList(jogadores.get(0));
                    break;

                case 1:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1));
                    break;

                case 2:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2));
                    break;

                case 3:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3));
                    break;

                case 4:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4));
                    break;

                case 5:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5));
                    break;

                case 6:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6));
                    break;

                case 7:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7));
                    break;

                case 8:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8));
                    break;

                case 9:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9));
                    break;

                case 10:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10));
                    break;

                case 11:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11));
                    break;

                case 12:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12));
                    break;

                case 13:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13));
                    break;

                case 14:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14));
                    break;

                case 15:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15));
                    break;

                case 16:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16));
                    break;

                case 17:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17));
                    break;

                case 18:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18));
                    break;

                case 19:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19));
                    break;

                case 20:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20));
                    break;

                case 21:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21));
                    break;

                case 22:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21),
                            jogadores.get(22));
                    break;

                case 23:
                    jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                            jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                            jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                            jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21),
                            jogadores.get(22), jogadores.get(23));
                    break;
            }

            lista_jogadores.refresh();
            lista_jogadores.setItems(jogador);

            cont++;
        } else {
            JOptionPane.showMessageDialog(null, "Digite um nome no campo de texto!");
        }
    }

    @FXML
    private void acaoBtnAdicionarJogadoresTecla(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            if (nome_jogador != null) {
                jogadores.add(nome_jogador.getText());
                nome_jogador.setText("");
                switch (cont) {
                    case 0:
                        jogador = FXCollections.observableArrayList(jogadores.get(0));
                        break;

                    case 1:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1));
                        break;

                    case 2:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2));
                        break;

                    case 3:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3));
                        break;

                    case 4:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4));
                        break;

                    case 5:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5));
                        break;

                    case 6:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6));
                        break;

                    case 7:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7));
                        break;

                    case 8:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8));
                        break;

                    case 9:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9));
                        break;

                    case 10:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10));
                        break;

                    case 11:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11));
                        break;

                    case 12:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12));
                        break;

                    case 13:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13));
                        break;

                    case 14:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14));
                        break;

                    case 15:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15));
                        break;

                    case 16:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16));
                        break;

                    case 17:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17));
                        break;

                    case 18:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18));
                        break;

                    case 19:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19));
                        break;

                    case 20:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20));
                        break;

                    case 21:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21));
                        break;

                    case 22:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21),
                                jogadores.get(22));
                        break;

                    case 23:
                        jogador = FXCollections.observableArrayList(jogadores.get(0), jogadores.get(1), jogadores.get(2), jogadores.get(3),
                                jogadores.get(4), jogadores.get(5), jogadores.get(6), jogadores.get(7), jogadores.get(8), jogadores.get(9),
                                jogadores.get(10), jogadores.get(11), jogadores.get(12), jogadores.get(13), jogadores.get(14), jogadores.get(15),
                                jogadores.get(16), jogadores.get(17), jogadores.get(18), jogadores.get(19), jogadores.get(20), jogadores.get(21),
                                jogadores.get(22), jogadores.get(23));
                        break;
                }

                lista_jogadores.refresh();
                lista_jogadores.setItems(jogador);

                cont++;
            } else {
                JOptionPane.showMessageDialog(null, "Digite um nome no campo de texto!");
            }
        }
    }

    @FXML
    private void acaoBtnCadastrarJogadores(ActionEvent event) {
        for (int i = 0; i < 24; i++) {
            jogado.setNome_competidor(jogadores.get(i));
            jogadoresDao.cadastrarJogador();
        }
    }

}

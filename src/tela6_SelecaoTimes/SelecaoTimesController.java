/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela6_SelecaoTimes;

import classes.Competicao;
import classes.Time;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.SelecaoTimesDao;
import dao.TimeDao;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tela7_CadastrarTime.Tela07CadastrarTime;
import tela9_Sorteio.Tela09Sorteio;

/**
 *
 * @author eroti
 */
public class SelecaoTimesController implements Initializable {

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
    private Button btn_cadastrar_time;

    @FXML
    private ListView lista;

    @FXML
    private TextField barra_pesquisa;

    private ArrayList<Time> listaTime = new ArrayList<>();
    private ArrayList<Time> listaTimeSelecionados = new ArrayList<>();
    private ObservableList<String> time;
    private CampeonatoDao campeonatoDao = new CampeonatoDao();
    private SelecaoTimesDao timesSelecionados = new SelecaoTimesDao();
    private Usuario usuario = new Usuario();
    private boolean verifica;

    int cont = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
        
        Competicao.setId_comp_aux(campeonatoDao.getId());
        
        lista.setVisible(false);

        listaTimeSelecionados = Competicao.getTimesSelecionados();
        if (listaTimeSelecionados.size() > 0) {
            cont = listaTimeSelecionados.size();
            switch (cont) {

                case 1:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    
                    cont ++;
                    break;

                case 2:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    
                    cont ++;
                    break;

                case 3:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    cont ++;
                    break;

                case 4:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    time4.setImage(listaTimeSelecionados.get(3).getImagem_time());
                    
                    cont ++;
                    break;

                case 5:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    time4.setImage(listaTimeSelecionados.get(3).getImagem_time());
                    time5.setImage(listaTimeSelecionados.get(4).getImagem_time());                    
                    cont ++;
                    break;

                case 6:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    time4.setImage(listaTimeSelecionados.get(3).getImagem_time());
                    time5.setImage(listaTimeSelecionados.get(4).getImagem_time());
                    time6.setImage(listaTimeSelecionados.get(5).getImagem_time());
                    
                    cont ++;
                    break;

                case 7:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    time4.setImage(listaTimeSelecionados.get(3).getImagem_time());
                    time5.setImage(listaTimeSelecionados.get(4).getImagem_time());
                    time6.setImage(listaTimeSelecionados.get(5).getImagem_time());
                    time7.setImage(listaTimeSelecionados.get(6).getImagem_time());
                    
                    cont ++;
                    break;

                case 8:
                    time1.setImage(listaTimeSelecionados.get(0).getImagem_time());
                    time2.setImage(listaTimeSelecionados.get(1).getImagem_time());
                    time3.setImage(listaTimeSelecionados.get(2).getImagem_time());
                    time4.setImage(listaTimeSelecionados.get(3).getImagem_time());
                    time5.setImage(listaTimeSelecionados.get(4).getImagem_time());
                    time6.setImage(listaTimeSelecionados.get(5).getImagem_time());
                    time7.setImage(listaTimeSelecionados.get(6).getImagem_time());
                    time8.setImage(listaTimeSelecionados.get(7).getImagem_time());
                    
                    cont ++;
                    break;
            }
        }
    }

    @FXML
    private void acaoBtnAvancar(ActionEvent event) {
        if (listaTimeSelecionados.size() == 8) {
            Competicao.setTimesSelecionados(listaTimeSelecionados);
            if (timesSelecionados.cadastrarTimesSelecionados() == true) {
                Tela09Sorteio tela = new Tela09Sorteio();
                fecha();

                try {
                    tela.start(new Stage());
                } catch (IOException ex) {
                    Logger.getLogger(SelecaoTimesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade de times selecionados inválido!"
                    + " "
                    + "Selecione 8 times");
        }
    }

    @FXML
    private void acaoBtnCadastrarTime(ActionEvent event) {
        Competicao.setTimesSelecionados(listaTimeSelecionados);
        
        Tela07CadastrarTime tela = new Tela07CadastrarTime();
        fecha();

        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(SelecaoTimesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void capturarElemento(MouseEvent e) {
        
        verifica = false;
        
        if (listaTimeSelecionados.size() < 8) {

            int linha = lista.getSelectionModel().getSelectedIndex();
            if (linha >= 0) {

                switch (cont) {

                    case 1:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time1.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 2:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true; 
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time2.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 3:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time3.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 4:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time4.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 5:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time5.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 6:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time6.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 7:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time7.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;

                    case 8:
                        for(int i=0; i<listaTimeSelecionados.size() ; i++ ){
                            if(listaTime.get(linha) == listaTimeSelecionados.get(i)){
                                verifica = true;
                                JOptionPane.showMessageDialog(null, "Time já selecionado!");
                            }
                        }
                        if(verifica == false){
                            time8.setImage(listaTime.get(linha).getImagem_time());
                            listaTimeSelecionados.add(listaTime.get(linha));
                            cont++;
                        }
                        break;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Quantidade máxima de times selecionados!");
        }
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

    private void fecha() {
        Tela06SelecaoTimes.getStage().close();
    }

}

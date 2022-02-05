/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela10_SelecionarCampeonato;

import classes.Competicao;
import classes.Partida;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.PartidaDao;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tela14_Perfil.Tela14Perfil;
import tela15_Campeonato.Tela15Campeonato;

import javax.swing.JOptionPane;
import tela12_SelecionarPartida.Tela12SelecionarPartida;

import tela5_CadastrarCampeonato.Tela05CadastrarCampeonato;

/**
 *
 * @author eroti
 */
public class SelecionarCampeonatoController implements Initializable {
    
    Usuario usuario = new Usuario();
    
    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
    btn12, btn13, btn14, btn15, btn_cad;
    
    private ArrayList<Competicao> listaComp = new ArrayList<>();
    private CampeonatoDao competicao = new CampeonatoDao();
    
    @FXML
    private void funcaoBtnCad(ActionEvent event) {
        Tela05CadastrarCampeonato tela = new Tela05CadastrarCampeonato();
        fecha();
        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tela 5 não iniciada" + ex);
        }
    }

    @FXML
    private void funcaoBtn1(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(0).getId_comp());
        setArrayList(listaComp.get(0).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn2(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(1).getId_comp());
        setArrayList(listaComp.get(1).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn3(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(2).getId_comp());
        setArrayList(listaComp.get(2).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn4(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(3).getId_comp());
        setArrayList(listaComp.get(3).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn5(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(4).getId_comp());
        setArrayList(listaComp.get(4).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn6(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(5).getId_comp());
        setArrayList(listaComp.get(5).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn7(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(6).getId_comp());
        setArrayList(listaComp.get(6).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn8(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(7).getId_comp());
        setArrayList(listaComp.get(7).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn9(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(8).getId_comp());
        setArrayList(listaComp.get(8).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn10(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(9).getId_comp());
        setArrayList(listaComp.get(9).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn11(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(10).getId_comp());
        setArrayList(listaComp.get(10).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn12(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(11).getId_comp());
        setArrayList(listaComp.get(11).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn13(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(12).getId_comp());
        setArrayList(listaComp.get(12).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn14(ActionEvent event){
        Competicao.setId_comp_aux(listaComp.get(13).getId_comp());
        setArrayList(listaComp.get(13).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn15(ActionEvent event){   
        Competicao.setId_comp_aux(listaComp.get(14).getId_comp());
        setArrayList(listaComp.get(14).getId_comp());
        Tela15Campeonato h = new Tela15Campeonato();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
        listaComp = competicao.verificaCampeonatoAberto();
              
        switch (listaComp.size()) {
            case 15:                
                btn15.setText(listaComp.get(14).getNome_comp());
                btn14.setText(listaComp.get(13).getNome_comp());
                btn13.setText(listaComp.get(12).getNome_comp());
                btn12.setText(listaComp.get(11).getNome_comp());
                btn11.setText(listaComp.get(10).getNome_comp());
                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                break;
                
            case 14:
                btn15.setDisable(true);
                btn15.setVisible(false);
                
                btn14.setText(listaComp.get(13).getNome_comp());
                btn13.setText(listaComp.get(12).getNome_comp());
                btn12.setText(listaComp.get(11).getNome_comp());
                btn11.setText(listaComp.get(10).getNome_comp());
                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 13:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                
                btn13.setText(listaComp.get(12).getNome_comp());
                btn12.setText(listaComp.get(11).getNome_comp());
                btn11.setText(listaComp.get(10).getNome_comp());
                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 12:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                
                btn12.setText(listaComp.get(11).getNome_comp());
                btn11.setText(listaComp.get(10).getNome_comp());
                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 11:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);

                btn11.setText(listaComp.get(10).getNome_comp());
                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 10:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);

                btn10.setText(listaComp.get(9).getNome_comp());
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 9:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                        
                btn9.setText(listaComp.get(8).getNome_comp());
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 8:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                        
                btn8.setText(listaComp.get(7).getNome_comp());
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 7:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                        
                btn7.setText(listaComp.get(6).getNome_comp());
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 6:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                
                btn6.setText(listaComp.get(5).getNome_comp());
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 5:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                
                btn5.setText(listaComp.get(4).getNome_comp());
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 4:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                btn5.setDisable(true);
                btn5.setVisible(false);
                
                btn4.setText(listaComp.get(3).getNome_comp());
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());

                break;
            case 3:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                btn5.setDisable(true);
                btn5.setVisible(false);
                btn4.setDisable(true);
                btn4.setVisible(false);
                        
                btn3.setText(listaComp.get(2).getNome_comp());
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 2:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                btn5.setDisable(true);
                btn5.setVisible(false);
                btn4.setDisable(true);
                btn4.setVisible(false);
                btn3.setDisable(true);
                btn3.setVisible(false);
                
                btn2.setText(listaComp.get(1).getNome_comp());
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            case 1:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                btn5.setDisable(true);
                btn5.setVisible(false);
                btn4.setDisable(true);
                btn4.setVisible(false);
                btn3.setDisable(true);
                btn3.setVisible(false);
                btn2.setDisable(true);
                btn2.setVisible(false);
                
                btn1.setText(listaComp.get(0).getNome_comp());
                
                break;
            default:
                btn15.setDisable(true);
                btn15.setVisible(false);
                btn14.setDisable(true);
                btn14.setVisible(false);
                btn13.setDisable(true);
                btn13.setVisible(false);
                btn12.setDisable(true);
                btn12.setVisible(false);
                btn11.setDisable(true);
                btn11.setVisible(false);
                btn10.setDisable(true);
                btn10.setVisible(false);
                btn9.setDisable(true);
                btn9.setVisible(false);
                btn8.setDisable(true);
                btn8.setVisible(false);
                btn7.setDisable(true);
                btn7.setVisible(false);
                btn6.setDisable(true);
                btn6.setVisible(false);
                btn5.setDisable(true);
                btn5.setVisible(false);
                btn4.setDisable(true);
                btn4.setVisible(false);
                btn3.setDisable(true);
                btn3.setVisible(false);
                btn2.setDisable(true);
                btn2.setVisible(false);
                btn1.setDisable(true);
                btn1.setVisible(false);
                
                break;
        }    
    }
    
    private void fecha(){
        Tela10SelecionarCampeonato.getStage().close();
    }

    @FXML
    private void perfilUsuario(MouseEvent event){
        Tela14Perfil telaPerfil = new Tela14Perfil();
        
        try {
            telaPerfil.start(new Stage());
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    /**
     * Metódo que busca todas as partidas daquela competição no banco
     * e seta na competição
     * @param idCompeticao
     */
    private void setArrayList(int idCompeticao)
    {   
        PartidaDao partidaDao = new PartidaDao();
        ArrayList<Partida> listaDeRetorno = new ArrayList<>();

        listaDeRetorno = partidaDao.getListaPartidas(idCompeticao);
        
        if(listaDeRetorno != null)
        {
            Competicao.setListaPartidasDaCompeticao(listaDeRetorno);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Telas.tela10_SelecionarCampeonato;

import classes.Competicao;
import classes.Usuario;
import dao.BuscaCompeticaoDao;
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

import Telas.tela5_CadastrarCampeonato.Tela05CadastrarCampeonato;

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
    private Button btn9;
    
    @FXML
    private Button btn10;
    
    @FXML
    private Button btn11;
    
    @FXML
    private Button btn12;
    
    @FXML
    private Button btn13;
    
    @FXML
    private Button btn14;
    
    @FXML
    private Button btn15;
    
    @FXML
    private Button btn_cad;
    
    ArrayList<Competicao> listaComp = new ArrayList<>();
    BuscaCompeticaoDao competicao = new BuscaCompeticaoDao();
    
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
    /*
    @FXML
    public void funcaoBtn1(ActionEvent event){

        competicao.
        (listaComp.get(0).getId_competicao());
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn2(ActionEvent event){
        comp2.setIdSelecionaCampeonato(listaComp.get(1).getId_competicao());
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    @FXML
    public void funcaoBtn3(ActionEvent event){

        Home h = new Home();
        comp3.setIdSelecionaCampeonato(listaComp.get(2).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    public void funcaoBtn4(ActionEvent event){
        Home h = new Home();
        comp4.setIdSelecionaCampeonato(listaComp.get(3).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    public void funcaoBtn5(ActionEvent event){
        
        Home h = new Home();
        comp5.setIdSelecionaCampeonato(listaComp.get(4).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn6(ActionEvent event){
        Home h = new Home();
        comp6.setIdSelecionaCampeonato(listaComp.get(5).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn7(ActionEvent event){
        Home h = new Home();
        comp7.setIdSelecionaCampeonato(listaComp.get(6).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn8(ActionEvent event){
        Home h = new Home();
        comp8.setIdSelecionaCampeonato(listaComp.get(7).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void funcaoBtn9(ActionEvent event){
        Home h = new Home();
        comp9.setIdSelecionaCampeonato(listaComp.get(8).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn10(ActionEvent event){
        Home h = new Home();
        comp10.setIdSelecionaCampeonato(listaComp.get(9).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @FXML
    public void funcaoBtn11(ActionEvent event){
        
        Home h = new Home();
        comp11.setIdSelecionaCampeonato(listaComp.get(10).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
         }
        
    }
    
    @FXML
    public void funcaoBtn12(ActionEvent event){
        Home h = new Home();
        comp12.setIdSelecionaCampeonato(listaComp.get(11).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    @FXML
    public void funcaoBtn13(ActionEvent event){
        Home h = new Home();
        comp13.setIdSelecionaCampeonato(listaComp.get(12).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    @FXML
    public void funcaoBtn14(ActionEvent event){
        Home h = new Home();
        comp14.setIdSelecionaCampeonato(listaComp.get(13).getId_competicao());
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    public void funcaoBtn15(ActionEvent event){
    
    }*/
    
    
    
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
    
}
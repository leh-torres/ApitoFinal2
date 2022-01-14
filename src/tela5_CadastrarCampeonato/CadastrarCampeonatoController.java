/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela5_CadastrarCampeonato;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tela6_SelecaoTimes.Tela06SelecaoTimes;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;

/**
 *
 * @author eroti
 */
public class CadastrarCampeonatoController implements Initializable {
    
    Usuario usuario = new Usuario();
    
    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    @FXML
    private TextField nome_campeonato;
    
    @FXML
    private TextField premiacao;
    
    @FXML
    private Label quantidade_times;
    
    @FXML
    private TextField descricao_campeonato;
    
    CampeonatoDao campeonatoDao = new CampeonatoDao();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }    
    
    @FXML
    private void acaoBtnVoltar(ActionEvent event){
        Tela10SelecionarCampeonato tela = new Tela10SelecionarCampeonato();
        fecha();
        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tela 10 não iniciada" + ex);
        }
    }
    
    @FXML
    private void acaoBtnAvancar(ActionEvent event){
        
        Competicao competicao = new Competicao();
        competicao.setNome_comp(nome_campeonato.getText());
        competicao.setPremiacao_comp(premiacao.getText());
        competicao.setQuantidade_times_comp(8);
        competicao.setDescricao_comp(descricao_campeonato.getText());
        
        
        campeonatoDao.cadastrarComp(competicao);
        
        Tela06SelecaoTimes tela = new Tela06SelecaoTimes();
        fecha();
        try {
            tela.start(new Stage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tela 10 não iniciada" + ex);
        }
    }
    
    private void fecha(){
        Tela05CadastrarCampeonato.getStage().close();
    }
}

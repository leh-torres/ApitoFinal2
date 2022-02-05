/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela16_EditarCampeonato;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarCampeonatoFXMLController implements Initializable {
    
    @FXML
    private TextField nome_campeonato,premiacao_campeonato,descricao_campeonato;
    
    @FXML
    private CheckBox seletor_nome,seletor_premiacao, seletor_descricao;
    
    @FXML
    private Button btn_inicio,btn_selecionar_partidas,btn_excluir_campeonato,btn_voltar,btn_salvar;
    
    @FXML
    private Label nome_usuario;
    
    @FXML
    private ImageView logo_usuario;
    
    private Usuario usuario = new Usuario();
    private CampeonatoDao competicaoDao = new CampeonatoDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }
    
     @FXML
    private void acaoDoCheck(ActionEvent event){
        if(seletor_nome.isSelected()){
            nome_campeonato.setEditable(true);
        } else{
            nome_campeonato.setEditable(false);
        }

        if(seletor_descricao.isSelected()){
            descricao_campeonato.setEditable(true);
        } else{
            descricao_campeonato.setEditable(false);
        }

        if(seletor_premiacao.isSelected()){
            premiacao_campeonato.setEditable(true);
        } else{
            premiacao_campeonato.setEditable(false);
        }
    }
    
    @FXML
    private void acaoSalvar(ActionEvent event){

        if(seletor_nome.isSelected()){
            competicaoDao.atualizaNome(nome_campeonato.getText(),Competicao.getId_comp_aux() );
        } 
        if(seletor_descricao.isSelected()){
            competicaoDao.atualizaDescricao(descricao_campeonato.getText(), Competicao.getId_comp_aux());
        }
        if(seletor_premiacao.isSelected()){
            competicaoDao.atualizaPremiacao(premiacao_campeonato.getText(), Competicao.getId_comp_aux());
        }        
        
        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(os) com sucesso!");
        refreshScreen();
    }
    
    
    
    @FXML 
    private void btnVoltar(ActionEvent event){
        Home h = new Home();
        fecha();
        try {
            h.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void fecha(){
        Tela16EditarCampeonato.getStage().close();
    }
    
    private void refreshScreen(){
        Tela16EditarCampeonato tela2 = new Tela16EditarCampeonato();
        fecha();

        try {
            tela2.start(new Stage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }
    }

}

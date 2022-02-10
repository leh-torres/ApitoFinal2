/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela18_EditarPerfil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classes.Usuario;
import dao.CampeonatoDao;
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela4_CriarCampeonato.Tela04CriarCampeonato;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class EditarPerfilFXMLController implements Initializable {

    @FXML
    private CheckBox checkNome, checkSobrenome, checkEmail, checkSenha, checkFoto;

    @FXML
    private TextField txtNome, txtSobrenome, txtEmail, txtSenha;

    @FXML
    private ImageView imageFoto;

    @FXML
    private Button btnSelecionaFoto;

    private String path = null;
    private static FileInputStream fis = null;
    private FileChooser fileChooser = new FileChooser();
    private Image foto;
    private boolean retorno;
    private Usuario usuario = new Usuario();
    private CampeonatoDao compDao =  new CampeonatoDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    /**
     * **Método para ao marcar os checkBoxs escrever no TextFild e botões sejam liberados**
     * @param event
     */
    @FXML
    private void acaoDoCheck(ActionEvent event){
        if(checkNome.isSelected()){
            txtNome.setEditable(true);
        } else{
            txtNome.setEditable(false);
        }

        if(checkSobrenome.isSelected()){
            txtSobrenome.setEditable(true);
        } else{
            txtSobrenome.setEditable(false);
        }

        if(checkEmail.isSelected()){
            txtEmail.setEditable(true);
        } else{
            txtEmail.setEditable(false);
        }

        if(checkSenha.isSelected()){
            txtSenha.setEditable(true);
        } else{
            txtSenha.setEditable(false);;
        }

        if(checkFoto.isSelected()){
            btnSelecionaFoto.setDisable(false);   
        } else{
            btnSelecionaFoto.setDisable(true);
        }
    }

    /**
     * **Método para seleciona uma nova Foto**
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void getNovaFoto(ActionEvent event) throws FileNotFoundException{
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null){
            System.out.println("Deu tudo certo");
        } else{
            System.out.println("Arquivo não é válido!");
        }

        path = selectedFile.getAbsolutePath(); 

        foto = new Image(selectedFile.toURI().toString());
        imageFoto.setImage(foto);

        File file = new File(path);
        fis = new FileInputStream(file);

    }

    /**
     * **Método para atulizar os campos escolhidos***
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnAtualiza(ActionEvent event) throws Exception{
        Usuario usuario = new Usuario();
        UsuarioDao userDao = new UsuarioDao();

        if(checkNome.isSelected()){
            userDao.editarNome(txtNome.getText(), usuario.getId_usuario());
        } 
        if(checkSobrenome.isSelected()){
            userDao.editarSObrenome(txtSobrenome.getText(), usuario.getId_usuario());
        }
        if(checkEmail.isSelected()){
            userDao.editarEmail(txtEmail.getText(), usuario.getId_usuario());
        }
        if(checkSenha.isSelected()){
            usuario.criptografaSenha(txtSenha.getText());
            userDao.editarSenha(usuario.getSenha(), usuario.getId_usuario());
        }
        if(checkFoto.isSelected()){
            try {
                userDao.editarImagem(fis, usuario.getId_usuario());
                usuario.setImagem(foto);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, "Dado(os) atualizado(s) com sucesso!!");
        trocarTela();
    }

    @FXML
    private void btnVoltar(ActionEvent event) throws Exception{

        retorno = compDao.verificaCapeonato(usuario.getId_usuario());

        if(retorno == true){
            Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
            fechaTela();
            tela10.start(new Stage());
        } else{
            Tela04CriarCampeonato tela4 = new Tela04CriarCampeonato();
            fechaTela();
            tela4.start(new Stage());
        }
        
    }

    private void fechaTela(){
        Tela18EditarPerfil.getStage().close();
    }

    private void trocarTela() throws Exception{
        retorno = compDao.verificaCapeonato(usuario.getId_usuario());

        if(retorno == true){
            Tela10SelecionarCampeonato selecionaCampeonatos = new Tela10SelecionarCampeonato();
            fechaTela(); 
            selecionaCampeonatos.start(new Stage());
        } else{
            Tela04CriarCampeonato criarCampeonato = new Tela04CriarCampeonato();
            fechaTela();
            criarCampeonato.start(new Stage());
        }
    }
    
}

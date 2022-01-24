/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela3_Cadastro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;

import apitofinal.ApitoFinal;
import classes.Usuario;
import dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class FXMLCadastroController implements Initializable {

    @FXML
    ImageView imageAvatar;

    private static FileInputStream fis = null;
    private String path = null;
    private FileChooser fc = new FileChooser();
    private Image image;
    Usuario user = new Usuario();
    UsuarioDao userDao = new UsuarioDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnEscolherImagem(ActionEvent event){
        File seletedFile = fc.showOpenDialog(null);

        if(seletedFile != null){
            System.out.println("Deu tudo certo");
        } else{
            System.out.println("Arquivo não é válido!");
        }

        path = seletedFile.getAbsolutePath(); 

        image = new Image(seletedFile.toURI().toString());
        imageAvatar.setImage(image);

    }

    @FXML
    private void btnCadastrarUsuario(ActionEvent event) throws FileNotFoundException, PacketTooBigException{
        
        try {
            boolean retornoCad;

            File selectFile = new File(path);
            fis = new FileInputStream(selectFile);

       
            retornoCad = userDao.cadastrarUsuario(user.getNome(), user.getSobrenome(), user.getEmail(), user.getSenha(), fis);
            if(retornoCad == true){
                user.setImagem(image);
                ApitoFinal telaInicial = new ApitoFinal();
                fechaTela();

                try {
                    telaInicial.start(new Stage());
                } catch (Exception e) {
                    System.out.println("Erro ao voltar para a tela inicial: " + e);
                }
            } else{
                Usuario userLimpo = new Usuario();
                user = userLimpo;
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecione uma imagem!");
        } catch(PacketTooBigException p){
            JOptionPane.showMessageDialog(null, "AVISO" + "\n" + "Arquivo maior que o permitido, por favor selecione um menor.");
        }
           
    }

    private void fechaTela(){
        Tela3_Cadastro.getStage().close();
    }
    
}

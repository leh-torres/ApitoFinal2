/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela22_MaisInfo;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.SelecaoTimesDao;
import dao.TimeDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author RonaldoMatos
 */
public class MaisInfoFXMLController implements Initializable {

    @FXML
    private Label nome_usuario, nome_campeonato, descricao_campeonato, premiacao_campeonato;
    
    @FXML
    private ImageView logo_usuario,time1,time2,time3,time4,time5,time6,time7,time8;
    
    private Usuario usuario = new Usuario();
    private CampeonatoDao campeonatoDao = new CampeonatoDao();
    private TimeDao timeDao = new TimeDao();
    private SelecaoTimesDao selecaoTimeDao = new SelecaoTimesDao();
    private int [] ids = null;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Competicao.setId_comp_aux(campeonatoDao.getId());
        ids = selecaoTimeDao.getIds(Competicao.getId_comp_aux(), usuario.getId_usuario());
        
        nome_campeonato.setText(campeonatoDao.getNome(Competicao.getId_comp_aux()));
        descricao_campeonato.setText(campeonatoDao.getDescricao(Competicao.getId_comp_aux()));
        premiacao_campeonato.setText(campeonatoDao.getPremiacao(Competicao.getId_comp_aux()));
        
        time1.setImage(timeDao.getImagem(ids[0]));
        time2.setImage(timeDao.getImagem(ids[1]));
        time3.setImage(timeDao.getImagem(ids[2]));
        time4.setImage(timeDao.getImagem(ids[3]));
        time5.setImage(timeDao.getImagem(ids[4]));
        time6.setImage(timeDao.getImagem(ids[5]));
        time7.setImage(timeDao.getImagem(ids[6]));
        time8.setImage(timeDao.getImagem(ids[7]));
        
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());
    }    
    
}

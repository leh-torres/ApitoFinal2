/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tela12_SelecionarPartida;

import classes.Competicao;
import classes.Usuario;
import dao.CampeonatoDao;
import dao.PartidaDao;
import dao.TimeDao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tela10_SelecionarCampeonato.Tela10SelecionarCampeonato;
import tela15_Campeonato.Tela15Campeonato;
import tela16_EditarCampeonato.Tela16EditarCampeonato;
import tela17_ExcluirCampeonato.Tela17ExcluirCampeonato;
import tela20_DefinirResultado.DefinirResultadoFXMLController;
import tela20_DefinirResultado.Tela20DefinirResultados;

/**
 *
 * @author eroti
 */
public class SelecionarPartidaController implements Initializable {
    
    @FXML
    private Label nome_usuario, labelNomeCampeonato;

    @FXML
    private ImageView logo_usuario, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, 
        time11, time12, time13, time14;
    
    @FXML
    private Label label;
    
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7;

    private Usuario usuario = new Usuario();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelNomeCampeonato.setText(getNomeComp());
        nome_usuario.setText(usuario.getNome());
        logo_usuario.setImage(usuario.getImagem());

        setTimes();
        carregaImagensTimes();
    }

    //Botões centrais

    @FXML
    private void btnVs1(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(0));  
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs2(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(1)); 
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs3(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(2));  
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs4(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(3));  
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs5(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(4));  
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs6(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(5));  
        trocaTelaBotãoVS();
    }

    @FXML
    private void btnVs7(ActionEvent event) throws Exception
    {
        DefinirResultadoFXMLController.setPartida(Competicao.getListaPartidasDaCompeticao().get(6));  
        trocaTelaBotãoVS();
    }

    
    //Botões laterais

    /**
     * Método para trocar para a tela inicio
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnInicio(ActionEvent event) throws Exception
    {
        Tela15Campeonato tela15 = new Tela15Campeonato();
        fechaTela();
        tela15.start(new Stage());
    }

    /**
     * Método para trocar para a tela editar campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnEditarCampeonato(ActionEvent event) throws Exception
    {
        Tela16EditarCampeonato tela16 = new Tela16EditarCampeonato();
        fechaTela();
        tela16.start(new Stage());
    }

    /**
     * Método para mudar para a tela Excluir Campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnExcluirCampeonato(ActionEvent event) throws Exception
    {
        Tela17ExcluirCampeonato tela17 = new Tela17ExcluirCampeonato();
        fechaTela();
        tela17.start(new Stage());
    }

    /**
     * Método para mudar para a tela Selecionar Campeonato
     * @param event
     * @throws Exception
     */
    @FXML
    private void btnVoltar(ActionEvent event) throws Exception
    {
        Tela10SelecionarCampeonato tela10 = new Tela10SelecionarCampeonato();
        tela10.start(new Stage());
    }



    /**
     * Retorna o nome da Competição
     * @return
     */
    private String getNomeComp(){
        CampeonatoDao campDao = new CampeonatoDao();
        return "    " + campDao.getNome(Competicao.getId_comp_aux());
    } 

    /**
     * Método para carregar a imagens dos times
     */
    private void carregaImagensTimes()
    {
        TimeDao timeDao = new TimeDao();

        time1.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time1Dinamico()));
        time2.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(0).getFk_time2Dinamico()));

        time3.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time1Dinamico()));
        time4.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(1).getFk_time2Dinamico()));

        time5.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time1Dinamico()));
        time6.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(2).getFk_time2Dinamico()));

        time7.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time1Dinamico()));
        time8.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(3).getFk_time2Dinamico()));

        if(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time1Dinamico() != 0){
            time9.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time1Dinamico()));
        }
        if(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time2Dinamico() != 0){
            time10.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(4).getFk_time2Dinamico()));
        }
        if(Competicao.getListaPartidasDaCompeticao().get(5).getFk_time1Dinamico() != 0){
            time11.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(5).getFk_time1Dinamico()));
        }
        if(Competicao.getListaPartidasDaCompeticao().get(5).getFk_time2Dinamico() != 0){
            time12.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(5).getFk_time2Dinamico()));
        }
        if(Competicao.getListaPartidasDaCompeticao().get(6).getFk_time1Dinamico() != 0){
            time13.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(6).getFk_time1Dinamico()));
        }
        if(Competicao.getListaPartidasDaCompeticao().get(6).getFk_time2Dinamico() != 0){
            time14.setImage(timeDao.getImagem(Competicao.getListaPartidasDaCompeticao().get(6).getFk_time2Dinamico()));
        }
    }

    /**
     * Método para fechar a tela atual
     */
    private void fechaTela()
    {
        Tela12SelecionarPartida.getStage().close();
    }

    /**
     * Método para mudar para a tela Definir Resultados
     * @throws Exception
     */
    private void trocaTelaBotãoVS() throws Exception
    {
        Tela20DefinirResultados tela20 = new Tela20DefinirResultados();
        fechaTela();
        tela20.start(new Stage());
    }

    private void setTimes(){
        PartidaDao partidaDao = new PartidaDao();

        if(Competicao.getListaPartidasDaCompeticao().get(0).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(0).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(0).getFk_time1Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(0).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(0).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(0).getFk_time2Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(0).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
            }
        }

        if(Competicao.getListaPartidasDaCompeticao().get(1).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(1).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(1).getFk_time1Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(1).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(1).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(1).getFk_time2Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(1).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(5).getId_part());
            }
        }

        if(Competicao.getListaPartidasDaCompeticao().get(2).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(2).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(2).getFk_time1Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(2).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(2).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(2).getFk_time2Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(2).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
            }
        }

        if(Competicao.getListaPartidasDaCompeticao().get(3).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(3).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(3).getFk_time1Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(3).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(3).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(3).getFk_time2Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(3).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(6).getId_part());
            }
        }

        if(Competicao.getListaPartidasDaCompeticao().get(4).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(4).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(4).getFk_time1Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(4).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(7).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(4).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(4).getFk_time2Dinamico()){
                partidaDao.setTime1(Competicao.getListaPartidasDaCompeticao().get(4).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(7).getId_part());
            }
        }

        if(Competicao.getListaPartidasDaCompeticao().get(5).getTime_vencedor() != 0){
            if(Competicao.getListaPartidasDaCompeticao().get(5).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(5).getFk_time1Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(5).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(7).getId_part());
            } else if(Competicao.getListaPartidasDaCompeticao().get(5).getTime_vencedor() == Competicao.getListaPartidasDaCompeticao().get(5).getFk_time2Dinamico()){
                partidaDao.setTime2(Competicao.getListaPartidasDaCompeticao().get(5).getTime_vencedor(), Competicao.getListaPartidasDaCompeticao().get(7).getId_part());
            }
        }
    }
    
}

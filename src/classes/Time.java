/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javafx.scene.image.Image;

/**
 *
 * @author rayla
 */
public class Time {
    private static int id_time_aux;
    private int id_time;
    private String nome_time;
    private Image imagem_time;
    private String abreviacao_time;
    private int fk_usuario;
    private int fk_competidor;

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public String getNome_time() {
        return nome_time;
    }

    public void setNome_time(String nome_time) {
        this.nome_time = nome_time;
    }

    public Image getImagem_time() {
        return imagem_time;
    }

    public void setImagem_time(Image imagem_time) {
        this.imagem_time = imagem_time;
    }

    public String getAbreviacao_time() {
        return abreviacao_time;
    }

    public void setAbreviacao_time(String abreviacao_time) {
        this.abreviacao_time = abreviacao_time;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getFk_competidor() {
        return fk_competidor;
    }

    public void setFk_competidor(int fk_competidor) {
        this.fk_competidor = fk_competidor;
    }

    public static int getId_time_aux() {
        return id_time_aux;
    }

    public static void setId_time_aux(int id_time_aux) {
        Time.id_time_aux = id_time_aux;
    }
    
}

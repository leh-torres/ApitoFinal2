/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author rayla
 */
public class Competicao {
    
    private int id_comp;
    private String nome_comp;
    private String descricao_comp;
    private String premiacao_comp;
    private String data_ini_comp;
    private String data_termi_comp;
    private String situacao_comp;
    private int quantidade_times_comp;
    private int fk_usuario;
    private static ArrayList<Time> timesSelecionados = new ArrayList<>();

    public int getId_comp() {
        return id_comp;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public String getNome_comp() {
        return nome_comp;
    }

    public void setNome_comp(String nome_comp) {
        this.nome_comp = nome_comp;
    }

    public String getDescricao_comp() {
        return descricao_comp;
    }

    public void setDescricao_comp(String descricao_comp) {
        this.descricao_comp = descricao_comp;
    }

    public String getPremiacao_comp() {
        return premiacao_comp;
    }

    public void setPremiacao_comp(String premiacao_comp) {
        this.premiacao_comp = premiacao_comp;
    }

    public String getData_ini_comp() {
        return data_ini_comp;
    }

    public void setData_ini_comp(String data_ini_comp) {
        this.data_ini_comp = data_ini_comp;
    }

    public String getData_termi_comp() {
        return data_termi_comp;
    }

    public void setData_termi_comp(String data_termi_comp) {
        this.data_termi_comp = data_termi_comp;
    }

    public String getSituacao_comp() {
        return situacao_comp;
    }

    public void setSituacao_comp(String situacao_comp) {
        this.situacao_comp = situacao_comp;
    }

    public int getQuantidade_times_comp() {
        return quantidade_times_comp;
    }

    public void setQuantidade_times_comp(int quantidade_times_comp) {
        this.quantidade_times_comp = quantidade_times_comp;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    

    public ArrayList<Time> getTimesSelecionados() {
        return timesSelecionados;
    }

    public void setTimesSelecionados(ArrayList<Time> timesSelecionados) {
        this.timesSelecionados = timesSelecionados;
    }
    
    
    
}

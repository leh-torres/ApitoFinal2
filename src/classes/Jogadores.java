/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author rayla
 */
public class Jogadores {
    
    private int id_competidor;
    private String nome_competidor;
    private int fk_time;

    public int getId_competidor() {
        return id_competidor;
    }

    public int getFk_time() {
        return fk_time;
    }

    public void setFk_time(int fk_time) {
        this.fk_time = fk_time;
    }

    public String getNome_competidor() {
        return nome_competidor;
    }

    public void setNome_competidor(String nome_competidor) {
        this.nome_competidor = nome_competidor;
    }

    public void setId_competidor(int id_competidor) {
        this.id_competidor = id_competidor;
    }

    
           
}

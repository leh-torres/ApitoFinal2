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
    private static String nome_competidor;
    private static int fk_time;

    public int getId_competidor() {
        return id_competidor;
    }

    public void setId_competidor(int id_competidor) {
        this.id_competidor = id_competidor;
    }

    public String getNome_competidor() {
        return nome_competidor;
    }

    public void setNome_competidor(String nome_competidor) {
        Jogadores.nome_competidor = nome_competidor;
    }

    public static int getFk_time() {
        return fk_time;
    }

    public static void setFk_time(int fk_time) {
        Jogadores.fk_time = fk_time;
    }
           
}

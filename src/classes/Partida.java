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
public class Partida {
    
    private int id_part;
    private String data_part;
    private String horario_part;
    private String local_part;
    private String placar_part;
    private static int fk_comp;
    private static int fk_time1;
    private static int fk_time2;
    private int fk_momento_da_pontuacao;


    private int fk_compDinamico;
    private int fk_time1Dinamico;
    private int fk_time2Dinamico;

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }

    public String getData_part() {
        return data_part;
    }

    public void setData_part(String data_part) {
        this.data_part = data_part;
    }

    public String getHorario_part() {
        return horario_part;
    }

    public void setHorario_part(String horario_part) {
        this.horario_part = horario_part;
    }

    public String getLocal_part() {
        return local_part;
    }

    public void setLocal_part(String local_part) {
        this.local_part = local_part;
    }

    public String getPlacar_part() {
        return placar_part;
    }

    public void setPlacar_part(String placar_part) {
        this.placar_part = placar_part;
    }

    public static int getFk_comp() {
        return fk_comp;
    }

    public static void setFk_comp(int fk_comp) {
        Partida.fk_comp = fk_comp;
    }

    public static int getFk_time1() {
        return fk_time1;
    }

    public static void setFk_time1(int fk_time1) {
        Partida.fk_time1 = fk_time1;
    }

    public static int getFk_time2() {
        return fk_time2;
    }

    public static void setFk_time2(int fk_time2) {
        Partida.fk_time2 = fk_time2;
    }

    
    public int getFk_momento_da_pontuacao() {
        return fk_momento_da_pontuacao;
    }

    public void setFk_momento_da_pontuacao(int fk_momento_da_pontuacao) {
        this.fk_momento_da_pontuacao = fk_momento_da_pontuacao;
    }


    public int getFk_time2Dinamico() {
        return fk_time2Dinamico;
    }

    public void setFk_time2Dinamico(int fk_time2Dinamico) {
        this.fk_time2Dinamico = fk_time2Dinamico;
    }

    public int getFk_time1Dinamico() {
        return fk_time1Dinamico;
    }

    public void setFk_time1Dinamico(int fk_time1Dinamico) {
        this.fk_time1Dinamico = fk_time1Dinamico;
    }

    public int getFk_compDinamico() {
        return fk_compDinamico;
    }

    public void setFk_compDinamico(int fk_compDinamico) {
        this.fk_compDinamico = fk_compDinamico;
    }
    
}

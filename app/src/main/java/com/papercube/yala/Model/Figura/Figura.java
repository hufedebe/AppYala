package com.papercube.yala.Model.Figura;

/**
 * Created by Hudeya on 31/03/2018.
 */

public class Figura {
    private int idFigura;

    private String nombreFigura;
    private int cantidadFigura;
    private String pais;
    private String tipo;


    public Figura (){

    }

    public Figura (int idFigura, String nombreFigura, int cantidadFigura, String pais, String tipo){
        this.idFigura = idFigura;
        this.nombreFigura = nombreFigura;
        this.cantidadFigura = cantidadFigura;
        this.pais = pais;
        this.tipo = tipo ;

    }

    public int getIdFigura() {
        return idFigura;
    }

    public void setIdFigura(int idFigura) {
        this.idFigura = idFigura;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public int getCantidadFigura() {
        return cantidadFigura;
    }

    public void setCantidadFigura(int cantidadFigura) {
        this.cantidadFigura = cantidadFigura;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

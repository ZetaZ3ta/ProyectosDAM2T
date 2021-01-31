/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model;


/**
 *
 * @author IvánJM
 */
public class Asiento {
    
    private String idAsiento;
    private Vuelo numVuelo;
    private Boolean lleno;

    public Asiento(String idAsiento, Vuelo numVuelo, Boolean lleno) {
        this.idAsiento = idAsiento;
        this.numVuelo =  numVuelo;
        this.lleno = lleno;
    }

    public Asiento() {
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Vuelo getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(Vuelo numVuelo) {
        this.numVuelo = numVuelo;
    }

    public boolean getLleno() {
        return lleno;
    }

    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", numVuelo=" + numVuelo + ", lleno=" + lleno + '}';
    }
    
    
    
}

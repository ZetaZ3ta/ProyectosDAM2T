/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Aplicacio.Model;

import m06.uf4.practica.Aplicacio.Model.Vuelo;

/**
 *
 * @author IvánJM
 */
public class Asiento {
    
    private String idAsiento;
    private Vuelo numVuelo;
    private Boolean lleno;

    /**
     *
     * @param idAsiento
     * @param numVuelo
     * @param lleno
     */
    public Asiento(String idAsiento, Vuelo numVuelo, Boolean lleno) {
        this.idAsiento = idAsiento;
        this.numVuelo =  numVuelo;
        this.lleno = lleno;
    }

    /**
     *
     */
    public Asiento() {
    }

    /**
     *
     * @return
     */
    public String getIdAsiento() {
        return idAsiento;
    }

    /**
     *
     * @param idAsiento
     */
    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    /**
     *
     * @return
     */
    public Vuelo getNumVuelo() {
        return numVuelo;
    }

    /**
     *
     * @param numVuelo
     */
    public void setNumVuelo(Vuelo numVuelo) {
        this.numVuelo = numVuelo;
    }

    /**
     *
     * @return
     */
    public boolean getLleno() {
        return lleno;
    }

    /**
     *
     * @param lleno
     */
    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", numVuelo=" + numVuelo + ", lleno=" + lleno + '}';
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author IvánJM
 */
public class Vuelo {

    private int numVuelo;
    private int capacidad;
    private LocalDate fecha_hora;

    public Vuelo(int numVuelo, int capacidad, LocalDate fecha_hora) {
        this.numVuelo = numVuelo;
        this.capacidad = capacidad;
        this.fecha_hora = fecha_hora;
    }

    public Vuelo() {
    }

    /**
     * @return the numVuelo
     */
    public int getNumVuelo() {
        return numVuelo;
    }

    /**
     * @param numVuelo the numVuelo to set
     */
    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    /**
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the fecha_hora
     */
    public LocalDate getFecha_hora() {
        return fecha_hora;
    }

    /**
     * @param fecha_hora the fecha_hora to set
     */
    public void setFecha_hora(LocalDate fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "numVuelo=" + numVuelo + ", capacidad=" + capacidad + ", fecha_hora=" + fecha_hora + '}';
    }

    
    
}

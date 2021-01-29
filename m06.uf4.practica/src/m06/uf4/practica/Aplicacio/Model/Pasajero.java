/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Aplicacio.Model;

/**
 *
 * @author IvánJM
 */
public class Pasajero {
    private String DNI;
    private String nombre;
    private String apellido;
    private Vuelo numVuelo;
    private Asiento idAsiento;

    public Pasajero(String DNI, String nombre, String apellido, Vuelo numVuelo, Asiento idAsiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numVuelo = new Vuelo();
        this.idAsiento = new Asiento();
    }

    public Pasajero() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Vuelo getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(Vuelo numVuelo) {
        this.numVuelo = numVuelo;
    }

    public Asiento getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Asiento idAsiento) {
        this.idAsiento = idAsiento;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", numVuelo=" + numVuelo + ", idAsiento=" + idAsiento + '}';
    }
    
    
    
}

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
    private String IDbillete;

    /**
     *
     * @param DNI
     * @param nombre
     * @param apellido
     * @param numVuelo
     * @param idAsiento
     * @param IDbillete
     */
    public Pasajero(String DNI, String nombre, String apellido, Vuelo numVuelo, Asiento idAsiento, String IDbillete) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numVuelo = numVuelo;
        this.idAsiento = idAsiento;
        this.IDbillete = IDbillete;
    }

    /**
     *
     * @param DNI
     * @param nombre
     * @param apellido
     */
    public Pasajero(String DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public String getIDbillete() {
        return IDbillete;
    }

    /**
     *
     * @param IDbillete
     */
    public void setIDbillete(String IDbillete) {
        this.IDbillete = IDbillete;
    }

    /**
     *
     */
    public Pasajero() {
    }

    /**
     *
     * @return
     */
    public String getDNI() {
        return DNI;
    }

    /**
     *
     * @param DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public Asiento getIdAsiento() {
        return idAsiento;
    }

    /**
     *
     * @param idAsiento
     */
    public void setIdAsiento(Asiento idAsiento) {
        this.idAsiento = idAsiento;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", numVuelo=" + numVuelo + ", idAsiento=" + idAsiento + '}';
    }

}

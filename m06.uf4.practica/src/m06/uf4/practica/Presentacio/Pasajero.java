/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

/**
 *
 * @author leandroparedes
 */
public class Pasajero {

    private String nom;
    private String prApellido;
    private String sgApellido;
    private String dni;

    public Pasajero(String nom, String primerCognom, String segonCognom, String dni) {
        this.nom = nom;
        this.prApellido = primerCognom;
        this.sgApellido = segonCognom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrApellido() {
        return prApellido;
    }

    public void setPrApellido(String prApellido) {
        this.prApellido = prApellido;
    }

    public String getSgApellido() {
        return sgApellido;
    }

    public void setSgApellido(String sgApellido) {
        this.sgApellido = sgApellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

   
}

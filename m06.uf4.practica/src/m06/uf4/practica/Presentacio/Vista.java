/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

import java.util.Scanner;

/**
 *
 * @author leandroparedes
 */
public class Vista {

    private String pasajerNom;
    private String pasajeroApellido;
    private String pasajeroSegundoApellido;
    private String pasajeroDNI;

    private Pasajero pasajero;

    public Vista(Pasajero b) {

        this.pasajero = b;
        pasajerNom = "";
        pasajeroApellido = "";
        pasajeroSegundoApellido = "";
        pasajeroDNI="";
    }

    public void getDades() {
        boolean sortir = false;

        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nom?");
            pasajerNom = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Primer cognom?");
            pasajeroApellido = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Segon cognom?");
            pasajeroSegundoApellido = scanner.nextLine();
            
             scanner = new Scanner(System.in);
            System.out.println("Dni?");
            pasajeroSegundoApellido = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Dades correctes? (s/n)");
            String s = scanner.nextLine();
            if (s.toUpperCase().equals("S")) {
                sortir = true;
            }

        } while (!sortir);

    }

    public boolean getSortir() {
        boolean ret = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Salir? (s/n)");
        String s = scanner.nextLine();
        if (s.toUpperCase().equals("S")) {
            ret = true;
        }

        return ret;
    }

    public String getNom() {
        return pasajerNom;
    }

    public void setNom(String nombre) {
        this.pasajerNom = nombre;
    }

    public String getPrimerApellido() {
        return pasajeroApellido;
    }

    public void setPrimerApellido(String prApellido) {
        this.pasajeroApellido = prApellido;
    }

    public String getSegundoApellido() {
        return pasajeroSegundoApellido;
    }

    public void setSegundoApellido(String sgApellido) {
        this.pasajeroSegundoApellido = sgApellido;
    }

    public String getPasajeroDNI() {
        return pasajeroDNI;
    }

    public void setPasajeroDNI(String pasajeroDNI) {
        this.pasajeroDNI = pasajeroDNI;
    }
    

    public void muestraDatos() {
        System.out.println("============================");
        System.out.println("Nom: " + pasajero.getNom());
        System.out.println("Primer Apellido: " + pasajero.getPrApellido());
        System.out.println("Segundo Apellido: " + pasajero.getSgApellido());
        System.out.println("Dni " + pasajero.getDni());
        System.out.println("============================");
    }
}

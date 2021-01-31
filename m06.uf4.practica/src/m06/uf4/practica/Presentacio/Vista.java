/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

import java.util.Scanner;
import m06.uf4.practica.Aplicacio.Model.Asiento;
import m06.uf4.practica.Aplicacio.Model.Pasajero;
import m06.uf4.practica.Aplicacio.Model.Vuelo;

/**
 *
 * @author leandroparedes
 */

public class Vista {

    private String pasajerNom;
    private String pasajeroApellido;
    private String pasajeroDNI;

  

    private Pasajero pasajero;
    private Asiento asiento;

    public String getPasajerNom() {
        return pasajerNom;
    }

    public void setPasajerNom(String pasajerNom) {
        this.pasajerNom = pasajerNom;
    }

    public String getPasajeroApellido() {
        return pasajeroApellido;
    }

    public void setPasajeroApellido(String pasajeroApellido) {
        this.pasajeroApellido = pasajeroApellido;
    }

    public String getPasajeroDNI() {
        return pasajeroDNI;
    }

    public void setPasajeroDNI(String pasajeroDNI) {
        this.pasajeroDNI = pasajeroDNI;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    private Vuelo vuelo;

    public Vista(Pasajero b, Vuelo v, Asiento a) {

        this.pasajero = b;
        pasajerNom = "";
        pasajeroApellido = "";
        pasajeroDNI = "";

    }

    /*public void getVuelo() {
        boolean salir = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vuelo");
            numeroVuelo = scanner.nextInt();
            
            scanner = new Scanner(System.in);
            System.out.println("Datos correctos? (s/n)");
            String s = scanner.nextLine();
            
            if (s.toUpperCase().equals("S")) {
                salir = true;
            }

        } while (!salir);
    }

    public void getAsiento() {
        boolean salir = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Asiento");
            idAsiento = scanner.nextLine();
            
            scanner = new Scanner(System.in);
            System.out.println("Datos correctos? (s/n)");
            String s = scanner.nextLine();
            
            if (s.toUpperCase().equals("S")) {
                salir = true;
            }

        } while (!salir);
    }*/

    public void getDades() {
        boolean salir = false;

        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nombre?");
            pasajerNom = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Apellidos?");
            pasajeroApellido = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Dni?");
            pasajeroDNI = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Datos correctos? (s/n)");
            String s = scanner.nextLine();
            if (s.toUpperCase().equals("S")) {
                salir = true;
            }

        } while (!salir);

    }

    public boolean getSalir() {
        boolean ret = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Salir? (s/n)");
        String s = scanner.nextLine();
        if (s.toUpperCase().equals("S")) {
            ret = true;
        }

        return ret;
    }

    

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void muestraVuelo() {
        System.out.println("============================");
        System.out.println("Vuelos");
        System.out.println("Numero de vuelo" + vuelo.getNumVuelo());
        System.out.println("============================");
    }

    public void muestraAsientosDisponibles() {
        System.out.println("============================");
        System.out.println("Asientos disponibles");
        System.out.println("Numero de asiento" + asiento.getIdAsiento());
        System.out.println("============================");
    }

    public void muestraBillete() {
        System.out.println("============================");
        System.out.println("Billete" + pasajero.getIDbillete());
        System.out.println("Nom: " + pasajero.getNombre());
        System.out.println("Primer Apellido: " + pasajero.getApellido());
        System.out.println("Dni: " + pasajero.getDNI());
        System.out.println("Vuelo: " + pasajero.getNumVuelo());
        System.out.println("Numeor Asiento" + pasajero.getIdAsiento());
        System.out.println("============================");
    }
}

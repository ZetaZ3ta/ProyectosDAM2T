/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.triocalavera.maven.m06.uf4.practica.Presentacio;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.AplicacionException;
import com.triocalavera.maven.m06.uf4.practica.Aplicacio.*;
import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model.*;
import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Reglas.reglasPasajero;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leandroparedes
 */
public class controlador {
// Crearemos 3 arraysList de cada tipo de objeto
    static ArrayList<Vuelo> arrayVuelo;
    static ArrayList<Pasajero> arrayPasajeros;
    static ArrayList<Asiento> arrayAsiento;

    static Scanner scanner = new Scanner(System.in);

    /**
     * Crearemos objeteos de Vuelo,, Asiento,Pasajero 
     * llamaremos al metodo cargarVuelo, despues el vuelo seleccionado no devolvará un objeto tipo vuelo que lo guararenos en nuestro objeto vuelo 
     * verificaremos si hay asientos disponibles pasandoles el vuelo, seleccionará asiento nos devolverña un asiento, pediremos los datos del pasajero 
     * crearemos el billete apartir del vuelo, asiento y pasajero. 
     * Preguntaremos si ha acabado su turno para acabaar el programa 
     * @param args
     */
    public static void main(String[] args) {
        boolean acabarTurno = false;
        String StrAcabarTurno;
        Vuelo v;
        Asiento as;
        Pasajero pas;
        do {
            try {

                cargarVuelo();
                v = seleccionarVuelo();

                verificacionAsientoDisponible(v);
                cargarAsientos(v);
                as = seleccionarAsiento();
                pas = datosPasajero();
                crearBillete(v, as, pas);

                System.out.println("Ha acabado el turno?");
                System.out.println("¿s/n?");
                StrAcabarTurno = scanner.nextLine().toLowerCase();
                acabarTurno = acabar(StrAcabarTurno);
            } catch (AplicacionException ex) {
                System.out.println(ex.toString());
            }

        } while (!acabarTurno);
    }
/* Le pasaremos un objeto tipo Vuelo, este metodo recorrera la array de asientos y si hay algun asiento que nos dira que hay disponibilidad 
sino nos lanzará una excepción 
*/
    
    private static void verificacionAsientoDisponible(Vuelo v) throws AplicacionException {

        boolean disponibilidad = false;
        arrayAsiento = LogicAsiento.getAsientos(v.getNumVuelo());
        for (Asiento asiento : arrayAsiento) {
            if (asiento.getNumVuelo().getNumVuelo() == v.getNumVuelo()) {
                if (!asiento.getLleno()) {
                    disponibilidad = true;
                }
            }
        }
        if (!disponibilidad) {
            throw new AplicacionException("No hay asientos Disponibles");
        }

    }
    /**
    * Metodo que creará un billete recibira todos los objetos Vuelo, Asiento, Pasajero 
    * se creara un billete unico, se creara el objeto pasajero y lo insertara, tambien modificando el asiento para que no este disponible
    * imprimiremos todo 
    * 
    */

    private static void crearBillete(Vuelo v, Asiento as, Pasajero pas) {
        try {

            String IDbillete = v.getCapacidad() + as.getIdAsiento() + pas.getApellido().substring(0, 2);
            System.out.println("================");
            System.out.println("Su billete se ha creado correctamente");
            as = new Asiento(as.getIdAsiento(), v, true);
            Pasajero pasajero = new Pasajero(pas.getDNI(), pas.getNombre(), pas.getApellido(), v, as, IDbillete);
            LogicPasajero.insertarPasajero(pasajero);
            LogicAsiento.modificarAsiento(as);

            System.out.println("Numero de billete: " + pasajero.getIDbillete()
                    + "\n" + "Dni pasajero: " + pasajero.getDNI()
                    + "\n" + "Nombre: " + pasajero.getNombre()
                    + "\n" + "Apellido: " + pasajero.getApellido()
                    + "\n" + "Numero de vuelo: " + pasajero.getNumVuelo().getNumVuelo()
                    + "\n" + "Asiento: " + pasajero.getIdAsiento().getIdAsiento()
            );
            System.out.println("\n================");

        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }
    }
/*
* caragara los vuelos para elegir 
*/
    private static void cargarVuelo() {
        System.out.println("================");
        try {
            arrayVuelo = LogicVuelo.getVuelos();
            for (Vuelo vuelo : arrayVuelo) {
                System.out.println("Vuelo: " + vuelo.getNumVuelo());
            }
            System.out.println("================");
        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }

    }
/**
* metodo que pedita todos los datos del pasagero, se verificara el DNI
*/
    private static Pasajero datosPasajero() {
        String nombre = "", apellido = "", dni = "", respuesta;
        boolean datosCorrectos = false;

        do {
            try {

                System.out.println("================");
                System.out.println("Datos del pasajero");
                System.out.println("Nombre?");
                nombre = scanner.nextLine();
                System.out.println("Apellido?");
                apellido = scanner.nextLine();
                System.out.println("Dni?");
                dni = scanner.nextLine();
                reglasPasajero.DNI(dni);
                System.out.println("¿los datos son correctos?");
                System.out.println("¿s/n?");
                respuesta = scanner.nextLine().toLowerCase();
                datosCorrectos = acabar(respuesta);
            } catch (AplicacionException e) {
                mostrarInfo(e.toString());
            }

        } while (!datosCorrectos);
        Pasajero pas = new Pasajero(dni, nombre, apellido);
        return pas;
    }
/*
* metodo que verifica la respuesta del usuario al usuario si acaba 
*/
    private static boolean acabar(String respuesta) {
        if (respuesta.equals("s")) {
            return true;
        }
        return false;
    }
/*
* metodo que que pide al usuario el vuelo, si no tiene asiento creado, los creara 
*/
    private static Vuelo seleccionarVuelo() {
        int vuelo;
        Vuelo vuel = new Vuelo();
        System.out.println("Seleccione un Vuelo");
        vuelo = scanner.nextInt();
        try {
            for (Vuelo v : arrayVuelo) {
                if (v.getNumVuelo() == vuelo) {
                    arrayAsiento = LogicAsiento.getAsientos(vuelo);
                    if (arrayAsiento.size() < 1) {
                        generarAsientos(v);
                    }
                    vuel = v;
                }
            }
        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }
        return vuel;
    }
    /**
    * Metodo que generará los asientos, se le pasará el objeto Vuelo 
    */

    private static void generarAsientos(Vuelo v) throws AplicacionException {

        for (int i = 0; i < v.getCapacidad(); i++) {
            Asiento a = new Asiento(v.getNumVuelo() + "as" + i, v, false);
            LogicAsiento.insertarAsiento(a);
        }
    }
/**
* Carga los asientos dependiendo del numero de vuelo, si el asiento esta disponible lo imprimirá
*/
    private static void cargarAsientos(Vuelo vuelo) {
        int vueloAsiento;
        System.out.println("================");
        try {
            arrayAsiento = LogicAsiento.getAsientos(vuelo.getNumVuelo());

            for (Asiento asiento : arrayAsiento) {
                vueloAsiento = asiento.getNumVuelo().getNumVuelo();
                    if (!asiento.getLleno()) {
                        System.out.println(asiento.getIdAsiento());
                    }
            }
            System.out.println("================");

        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }
    }
/**
* Metodo que retornará un asiento, pedira al usaurio que seleccioné un asiento y recorreremos la array hasta encontrar el asiento si no hay asiento lo volveremos ha preguntar
* so lo encontramos as = Asiento y retornaremos as 
*/
    private static Asiento seleccionarAsiento() {

        boolean asientoDisponible = false;
        scanner.nextLine();
        String Strasiento;
        Asiento as = new Asiento();
        do {

            System.out.println("Seleccione un Asiento");
            Strasiento = scanner.nextLine();
            for (Asiento asiento : arrayAsiento) {
                if (asiento.getIdAsiento().equals(Strasiento)) {
                    System.out.println("Asiento Seleccionado Correctamente ");
                    as = asiento;
                    asientoDisponible = true;
                }

            }
        } while (!asientoDisponible);

        return as;
    }

    /**
     * Muestra un error
     *
     * @param txt
     */
    private static void mostrarInfo(String txt) {
        System.out.println("Error: " + txt);

    }

}

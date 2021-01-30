/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import m06.uf4.practica.Aplicacio.*;
import m06.uf4.practica.Aplicacio.Model.*;

/**
 *
 * @author leandroparedes
 */
public class controlador implements Initializable {

    private Label label;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String vuelo, asiento;
        cargarVuelo();
        vuelo = seleccionarVuelo();
        cargarAsientos(vuelo);
        asiento = seleccionarAsiento();
    }

    ArrayList<Vuelo> arrayVuelo;
    ArrayList<Pasajero> arrayPasajeros;
    ArrayList<Asiento> arrayAsiento;

    DriverMySql conn;
    Scanner scanner = new Scanner(System.in);

    private void cargarVuelo() {
        try {
            arrayVuelo = LogicVuelo.getVuelos();
            for (Vuelo vuelo : arrayVuelo) {
                vuelo.toString();
            }
        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }

    }

    private String seleccionarVuelo() {
        String vuelo;
        System.out.println("Seleccione Vuelo");
        vuelo = scanner.nextLine();
        return vuelo;
    }

    private void cargarAsientos(String vuelo) {
        String vueloAsiento = "";
        try {
            arrayAsiento = LogicAsiento.getAsientos();
            for (Asiento asiento : arrayAsiento) {
                vueloAsiento = asiento.getNumVuelo().toString();
                if (vueloAsiento.equals(vuelo)) {
                    if (!asiento.getLleno()) {
                        asiento.toString();
                    }
                }
            }

        } catch (AplicacionException e) {
            mostrarInfo(e.toString());
        }
    }

    private String seleccionarAsiento() {

        String asiento;
        System.out.println("Seleccione Asiento");
        asiento = scanner.nextLine();
        return asiento;
    }
/*
    public controlador(Vista v, Vuelo vuel, Asiento as, Pasajero p) throws AplicacionException {
        pasajero = p;
        vuelo = vuel;
        asiento = as;
        vista = v;

        initView();
    }*/

    /*  public void initView() throws AplicacionException {
        cargarRegistros();

    }

    public void initController() throws AplicacionException {

        boolean acabado = false;

        do {
            vista.muestraVuelo();
            cargarVuelos();

            vista.muestraAsientosDisponibles();

            cargarRegistros();
            vista.getDades();
            guardarRegistro();
            acabado = vista.getSalir();
        } while (!acabado);
    }

    private void cargarVuelos() throws AplicacionException {
        vista.setVuelo(vuelo);
    }


    /*recull del pasajero i actualitza la vista
    private void cargarRegistros() throws AplicacionException {
        vuelo.getVuelos();
        vista.setNom(pasajero.getNombre());
        vista.setPrimerApellido(pasajero.getPrApellido());
        vista.setSegundoApellido(pasajero.getSgApellido());
        vista.setPasajeroDNI(pasajero.getDni());
    }

    /*recull de la vista i desa al pasajero
    private void guardarRegistro() {
        pasajero.setNom(vista.getNom());
        pasajero.setPrApellido(vista.getPrimerApellido());
        pasajero.setSgApellido(vista.getSegundoApellido());
        pasajero.setDni(vista.getPasajeroDNI());
    }

    public static void main(String[] args) throws AplicacionException {
        Vuelo vuelo = new Vuelo(0, 0, Timestamp.from(Instant.MIN));
        Asiento asiento = new Asiento("", vuelo, Boolean.TRUE);
        Pasajero pasajero = new Pasajero("", "", "", vuelo, asiento, "");

        Vista v = new Vista(pasajero, vuelo, asiento);
        controlador c = new controlador(v, vuelo, asiento, pasajero);
        c.initController();
    }
     */
    private void mostrarInfo(String txt) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info:");
        alert.setContentText(txt);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        alert.showAndWait();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author leandroparedes
 */
public class controlador  {
    
   /* private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  */  
    private Pasajeromvc pasajero;
    private Vista vista;
    
     public controlador(Pasajeromvc p, Vista v ) {
        pasajero = p;
        vista = v;
        initView();
    }

    public void initView() {
        cargarRegistros();
        
    }

    public void initController() {
       
        boolean acabado = false;
        
        do
        {
            vista.muestraDatos();
            cargarRegistros();
            vista.getDades();
            guardarRegistro();
            acabado = vista.getSortir();
        }
        while (!acabado);
    }
    
    /*recull del pasajero i actualitza la vista*/
    private void cargarRegistros() {
        vista.setNom(pasajero.getNom());
        vista.setPrimerApellido(pasajero.getPrApellido());
        vista.setSegundoApellido(pasajero.getSgApellido());
        vista.setPasajeroDNI(pasajero.getDni());
    }

    /*recull de la vista i desa al pasajero*/
    private void guardarRegistro() {
        pasajero.setNom(vista.getNom());
        pasajero.setPrApellido(vista.getPrimerApellido());
        pasajero.setSgApellido(vista.getSegundoApellido());
        pasajero.setDni(vista.getPasajeroDNI());
    }
    
     public static void main(String[] args) {
        Pasajeromvc pasajero = new Pasajeromvc("", "", "","");
        Vista v = new Vista(pasajero);
        controlador c = new controlador(pasajero, v);
        c.initController();
    }
}

    


package com.triocalavera.maven.m06.uf4.practica.Aplicacio;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model.Pasajero;
import com.triocalavera.maven.m06.uf4.practica.Dades.DatosException;
import com.triocalavera.maven.m06.uf4.practica.Dades.PasajeroSQL;
import java.util.ArrayList;


/**
 *
 * @author ZetaZeta
 */
public class LogicPasajero {

    public static ArrayList<Pasajero> getPasajeros() throws AplicacionException {
        try {
            DriverMySql conn;
            ArrayList<Pasajero> ret;

            conn = DriverMySql.getInstance();
            ret = PasajeroSQL.cargarPasajero(conn.getConnection());

            return ret;
        } catch (DatosException ex) {
            throw new AplicacionException("Error cargando pasajeros!");
        }

    }

    public static void insertarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.insertarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando pasajeros!");
        }
    }

    public static void eliminarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.eliminarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando pasajeros!");
        }
    }

    public static void modificarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.actualizarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando pasajeros!");
        }
    }

}

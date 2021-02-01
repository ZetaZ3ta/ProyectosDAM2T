package com.triocalavera.maven.m06.uf4.practica.Aplicacio;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model.Vuelo;
import com.triocalavera.maven.m06.uf4.practica.Dades.DatosException;
import com.triocalavera.maven.m06.uf4.practica.Dades.VueloSQL;
import java.util.ArrayList;

/**
 *
 * @author Victor Paz
 */
public class LogicVuelo {

    /**
     * Metodo para obtener todos los vuelos que hay en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @return
     * @throws AplicacionException
     */
    public static ArrayList<Vuelo> getVuelos() throws AplicacionException {
        try {
            DriverMySql conn;
            ArrayList<Vuelo> ret;

            conn = DriverMySql.getInstance();
            ret = VueloSQL.cargarVuelo(conn.getConnection());

            return ret;
        } catch (DatosException ex) {
            throw new AplicacionException("Error cargando vuelos!");
        }
    }

    /**
     * Metodo para insertar un vuelo en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param v
     * @throws AplicacionException
     */
    public static void insertarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.insertarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando vuelo!");
        }
    }

    /**
     * Metodo para eliminar un vuelo de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param v
     * @throws AplicacionException
     */
    public static void eliminarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.eliminarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error eliminando vuelo!");
        }
    }

    /**
     * Metodo para modificar un vuelo de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param v
     * @throws AplicacionException
     */
    public static void modificarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.actualizarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error modificando vuelo!");
        }
    }
}

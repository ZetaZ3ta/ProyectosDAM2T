package com.triocalavera.maven.m06.uf4.practica.Aplicacio;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model.Asiento;
import java.util.ArrayList;
import com.triocalavera.maven.m06.uf4.practica.Aplicacio.AplicacionException;
import com.triocalavera.maven.m06.uf4.practica.Dades.AsientoSQL;
import com.triocalavera.maven.m06.uf4.practica.Dades.DatosException;

/**
 *
 * @author Victor Paz
 */
public class LogicAsiento {

    /**
     * Metodo para obtener todos los asientos que hay en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param numVuelo
     * @return
     * @throws AplicacionException
     */
    public static ArrayList<Asiento> getAsientos(int numVuelo) throws AplicacionException {
        try {
            DriverMySql conn;
            ArrayList<Asiento> ret;

            conn = DriverMySql.getInstance();
            ret = AsientoSQL.cargarAsiento(conn.getConnection(),numVuelo);

            return ret;
        } catch (DatosException ex) {
            throw new AplicacionException("Error cargando asientos!");
        }

    }

    /**
     * Metodo para insertar un asiento en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param a
     * @throws AplicacionException
     */
    public static void insertarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.insertarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando asiento!");
        }
    }

    /**
     * Metodo para eliminar un asiento de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param a
     * @throws AplicacionException
     */
    public static void eliminarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.eliminarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error eliminando asiento!");
        }
    }

    /**
     * Metodo para modificar un asiento de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param a
     * @throws AplicacionException
     */
    public static void modificarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.actualizarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error modificando asiento!");
        }
    }

}

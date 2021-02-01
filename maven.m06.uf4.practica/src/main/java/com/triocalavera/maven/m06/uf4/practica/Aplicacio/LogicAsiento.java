package com.triocalavera.maven.m06.uf4.practica.Aplicacio;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.Model.Asiento;
import java.util.ArrayList;
import com.triocalavera.maven.m06.uf4.practica.Aplicacio.AplicacionException;
import com.triocalavera.maven.m06.uf4.practica.Dades.AsientoSQL;
import com.triocalavera.maven.m06.uf4.practica.Dades.DatosException;


/**
 *
 * @author ZetaZeta
 */
public class LogicAsiento {

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


    public static void insertarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.insertarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando asientos!");
        }
    }

    public static void eliminarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.eliminarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error eliminando asientos!");
        }
    }

    public static void modificarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.actualizarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error modificando asientos!");
        }
    }

}
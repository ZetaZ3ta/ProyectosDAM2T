package m06.uf4.practica.Aplicacio;

import java.util.ArrayList;
import m06.uf4.practica.Aplicacio.Model.Pasajero;
import m06.uf4.practica.Dades.DatosException;
import m06.uf4.practica.Dades.PasajeroSQL;

/**
 *
 * @author Victor Paz
 */
public class LogicPasajero {

    /**
     * Metodo para obtener todos los pasajeros que hay en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @return
     * @throws AplicacionException
     */
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

    /**
     * Metodo para insertar un pasajero en la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param p
     * @throws AplicacionException
     */
    public static void insertarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.insertarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando pasajero!");
        }
    }

    /**
     * Metodo para eliminar un pasajero de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param p
     * @throws AplicacionException
     */
    public static void eliminarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.eliminarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error eliminando pasajero!");
        }
    }

    /**
     * Metodo para modificar un pasajero de la BBDD
     * Desde aqui llamaremos al metodo en la capa de datos donde se hace la query
     * @param p
     * @throws AplicacionException
     */
    public static void modificarPasajero(Pasajero p) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            PasajeroSQL.actualizarPasajero(conn.getConnection(), p);
        } catch (DatosException ex) {
            throw new AplicacionException("Error modificando pasajero!");
        }
    }

}

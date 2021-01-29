package m06.uf4.practica.Aplicacio;

import java.util.ArrayList;
import m06.uf4.practica.Aplicacio.Model.Vuelo;
import m06.uf4.practica.Dades.DatosException;
import m06.uf4.practica.Dades.VueloSQL;

/**
 *
 * @author ZetaZeta
 */
public class LogicVuelo {

    public ArrayList<Vuelo> getVuelos() throws AplicacionException {
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

    public static void insertarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.insertarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando vuelo!");
        }
    }

    public static void eliminarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.eliminarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando vuelo!");
        }
    }

    public static void modificarVuelo(Vuelo v) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            VueloSQL.actualizarVuelo(conn.getConnection(), v);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando vuelo!");
        }
    }
}

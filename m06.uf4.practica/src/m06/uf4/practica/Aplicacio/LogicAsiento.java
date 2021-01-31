package m06.uf4.practica.Aplicacio;

import java.util.ArrayList;
import m06.uf4.practica.Aplicacio.Model.Asiento;
import m06.uf4.practica.Dades.AsientoSQL;
import m06.uf4.practica.Dades.DatosException;

/**
 *
 * @author ZetaZeta
 */
public class LogicAsiento {

    /**
     *
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
     *
     * @param a
     * @throws AplicacionException
     */
    public static void insertarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.insertarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error insertando asientos!");
        }
    }

    /**
     *
     * @param a
     * @throws AplicacionException
     */
    public static void eliminarAsiento(Asiento a) throws AplicacionException {
        try {
            DriverMySql conn;
            conn = DriverMySql.getInstance();

            AsientoSQL.eliminarAsiento(conn.getConnection(), a);
        } catch (DatosException ex) {
            throw new AplicacionException("Error eliminando asientos!");
        }
    }

    /**
     *
     * @param a
     * @throws AplicacionException
     */
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

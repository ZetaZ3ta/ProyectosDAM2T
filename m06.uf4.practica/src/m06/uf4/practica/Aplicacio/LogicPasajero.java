package m06.uf4.practica.Aplicacio;

import java.util.ArrayList;
import m06.uf4.practica.Aplicacio.Model.Pasajero;

/**
 *
 * @author ZetaZeta
 */
public class LogicPasajero {

    DriverMySql conn;

    public LogicPasajero(DriverMySql c) throws AplicacionException {
        if (c.getConnection() == null) {
            throw new AplicacionException("Sense connexió a BBDD");
        } else {
            this.conn = c;
        }
    }

    public ArrayList<Pasajero> getPasajeros() throws AplicacionException {
//        ArrayList<Pasajero> ret = PasajeroSQL.selectAlumnes(conn.getConnection());
        ArrayList<Pasajero> ret = null;
        return ret;

    }

    public static void insertarPasajero() {

    }

    public static void eliminarPasajero() {

    }

    public static void modificarPasajero() {

    }

}

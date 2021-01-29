package m06.uf4.practica.Aplicacio;

import java.util.ArrayList;
import m06.uf4.practica.Aplicacio.Model.Asiento;

/**
 *
 * @author ZetaZeta
 */
public class LogicAsiento {

    DriverMySql conn;

    public LogicAsiento(DriverMySql c) throws AplicacionException {
        if (c.getConnection() == null) {
            throw new AplicacionException("Sense connexió a BBDD");
        } else {
            this.conn = c;
        }
    }

    public ArrayList<Asiento> getAsientos() throws AplicacionException {
//        ArrayList<Pasajero> ret = PasajeroSQL.selectAlumnes(conn.getConnection());
        ArrayList<Asiento> ret = null;
        return ret;

    }

    public static void insertarAsiento() {

    }

    public static void eliminarAsiento() {

    }

    public static void modificarAsiento() {

    }
}

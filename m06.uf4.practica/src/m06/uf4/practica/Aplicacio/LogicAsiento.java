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

    
    
    public static ArrayList<Asiento> getAsientos() throws AplicacionException {
        try {
            DriverMySql conn;
            ArrayList<Asiento> ret;

            conn = DriverMySql.getInstance();
            ret = AsientoSQL.cargarAsiento(conn.getConnection());

            return ret;
        } catch (DatosException ex) {
            throw new AplicacionException("Error cargando asientos!");
        }

    }
    
    public static ArrayList<Asiento> getAsientDisponible() throws AplicacionException{
           try {
            DriverMySql conn;
            ArrayList<Asiento> ret;
            conn = DriverMySql.getInstance();
            ret = AsientoSQL.cargarAsiento(conn.getConnection());
            
               for (Asiento asiento : ret) {
                   if (!asiento.getLleno()) {
                       System.out.println("Asiento" + asiento.getIdAsiento() );
                   }
               }

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

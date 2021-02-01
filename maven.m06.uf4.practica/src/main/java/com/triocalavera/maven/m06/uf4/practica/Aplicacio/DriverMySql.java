package m06.uf4.practica.Aplicacio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leandroparedes
 */
public class DriverMySql {

    private static volatile DriverMySql instance = null;

    String bddd = "m06uf4p1";
    String usuario = "TrioCalavera";
    String pswd = "ElTrioCalaverita";

    private Connection conn = null;

    /**
     * Metodo para coger la instancia de la BBDD con el patron Singleton
     *
     * @return @throws AplicacionException
     */
    public static DriverMySql getInstance() throws AplicacionException {
        if (instance == null) {

            synchronized (DriverMySql.class) {
                if (instance == null) {
                    instance = new DriverMySql();
                }
            }
        }

        return instance;
    }

    /**
     * Con este metodo cogemos la conexion a la BBDD
     * @return @throws AplicacionException
     */
    public Connection getConnection() throws AplicacionException {
        Connection ret = ConnectarBD();

        return ret;
    }

    private DriverMySql() throws AplicacionException {
        this.ConnectarBD();
    }

    /**
     * Se conecta a una base de datos mysql y gestiona su conexión.
     *
     * @return Connection
     * @throws SQLException
     */
    private Connection ConnectarBD() throws AplicacionException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bddd + "?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, pswd);
        } catch (SQLException ex) {
            throw new AplicacionException("Error ConnectarBD: " + ex.toString());
        }

        return conn;
    }

    /**
     * Cierra la conexión
     *
     * @throws AplicacionException
     */
    public void closeConnection() throws AplicacionException {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw new AplicacionException("Error inicialitzant connexió: " + ex.toString());
        }
    }

}

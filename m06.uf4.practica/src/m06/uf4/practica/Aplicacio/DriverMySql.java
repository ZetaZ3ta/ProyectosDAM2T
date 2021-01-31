/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Aplicacio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverMySql {

    private static volatile DriverMySql instance = null;

    String bddd = "m06uf4p1";
    String usuario = "TrioCalavera";
    String pswd = "ElTrioCalaverita";

    private Connection conn = null;

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

    public Connection getConnection() throws AplicacionException {
        Connection ret = null;

        ret = ConnectarBD();

        return ret;
    }

    private DriverMySql() throws AplicacionException {
        this.ConnectarBD();
    }

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

    public void closeConnection() throws AplicacionException {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw new AplicacionException("Error inicialitzant connexió: " + ex.toString());
        }
    }

}

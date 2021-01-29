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

    // Per seguretat aquestes dades s'haurien de llegir directament de l'usuari
    String bddd = "m06uf4p1";
    String usuario = "TrioCalavera";
    String pswd = "ElTrioCalaverita";

    Connection conn = null;

    public Connection getConnection() {
        return conn;
    }

    public DriverMySql() throws AplicacionException {

        this.conn = ConnectarBD();
    }

    /**
     * Connecta a una BD mysql i gestiona la connexió
     *
     * @return objecte Connection
     * @throws SQLException
     */
    private Connection ConnectarBD() throws AplicacionException {
        Connection ret = null;

        try {
            ret = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bddd + "?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, pswd);
        } catch (SQLException ex) {
            throw new AplicacionException("Error ConnectarBD: " + ex.toString());
        }

        return ret;
    }

    public void closeConnection() throws AplicacionException {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw new AplicacionException("Error inicialitzant connexió: " + ex.toString());
        }
    }
}



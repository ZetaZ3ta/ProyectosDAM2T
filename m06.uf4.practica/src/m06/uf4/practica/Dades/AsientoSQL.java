/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Dades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import m06.uf4.practica.Aplicacio.AplicacionException;
import m06.uf4.practica.Aplicacio.DriverMySql;
import m06.uf4.practica.Aplicacio.Model.Asiento;
import m06.uf4.practica.Aplicacio.Model.Vuelo;

/**
 *
 * @author IvánJM
 */
public class AsientoSQL {

    public static void insertarAsiento(Connection con, Asiento a) throws DatosException {
        Statement sentencia;
        int id;
        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM asiento");
            ResultSet rs = sentencia.getResultSet();
            rs.moveToInsertRow();
            rs.updateString("idAsiento", a.getIdAsiento());
            rs.updateInt("numVuelo", a.getNumVuelo().getNumVuelo());
            rs.updateBoolean("Lleno", a.getLleno());

            rs.insertRow();
        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

        public static ArrayList<Asiento> cargarAsiento(Connection con) throws DatosException {
        ArrayList<Asiento> ret = new ArrayList<>();

        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM asiento");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {

                Vuelo v = new Vuelo(rs.getInt("numVuelo"), rs.getInt("capacidad"), rs.getTimestamp("Fecha y Hora"));

                ret.add(new Asiento(rs.getString("idAsiento"), v, rs.getBoolean("Lleno")));

            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
        return ret;
    }

    public static void actualizarAsiento(Connection con, Asiento a) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM asiento where idAsiento='" + a.getIdAsiento() + "'");
            ResultSet rs = sentencia.getResultSet();
            if (rs.next()) {
                rs.updateString("idAsiento", a.getIdAsiento());
                rs.updateInt("numVuelo", a.getNumVuelo().getNumVuelo());
                rs.updateBoolean("Lleno", a.getLleno());

                rs.updateRow();
            } else {
                throw new DatosException("El asiento " + a + "no se a encontrado");
            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

    public static void eliminarAsiento(Connection con, Asiento a) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM asiento where idAsiento = '" + a.getIdAsiento() + "'";
            sentencia.executeQuery(sql);
            ResultSet rs = sentencia.getResultSet();
            if (rs.next()) {
                rs.deleteRow();
            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

}

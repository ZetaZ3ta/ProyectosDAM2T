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
import m06.uf4.practica.Aplicacio.Model.Asiento;
import m06.uf4.practica.Aplicacio.Model.Pasajero;
import m06.uf4.practica.Aplicacio.Model.Vuelo;

/**
 *
 * @author IvánJM
 */
public class VueloSQL {

    public static void insertarVuelo(Connection con, Vuelo v) throws DatosException {
        Statement sentencia;
        int id;
        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM vuelo");
            ResultSet rs = sentencia.getResultSet();
            rs.moveToInsertRow();
            rs.updateInt("numVuelo", v.getNumVuelo());
            rs.updateInt("capacidad", v.getNumVuelo());
            rs.updateTimestamp("Fecha y Hora", v.getFecha_hora());

            rs.insertRow();
        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

    public static ArrayList<Vuelo> cargarVuelo(Connection con) throws DatosException {
        ArrayList<Vuelo> ret = new ArrayList<>();

        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM vuelo");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {

                ret.add(new Vuelo(rs.getInt("numVuelo"), rs.getInt("capacidad"), rs.getTimestamp("Fecha y Hora")));

            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
        return ret;
    }

    public static void actualizarVuelo(Connection con, Vuelo v) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM vuelo where numVuelo='" + v.getNumVuelo() + "'");
            ResultSet rs = sentencia.getResultSet();
            if (rs.next()) {
                rs.updateInt("numVuelo", v.getNumVuelo());
                rs.updateInt("capacidad", v.getCapacidad());
                rs.updateTimestamp("Fecha y Hora", v.getFecha_hora());

                rs.updateRow();
            } else {
                throw new DatosException("El vuelo " + v + "no se a encontrado");
            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

    public static void eliminarVuelo(Connection con, Vuelo v) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM vuelo where numVuelo = '" + v.getNumVuelo() + "'";
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

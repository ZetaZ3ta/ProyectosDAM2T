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
public class PasajeroSQL {

    public static void insertarPasajero(Connection con, Pasajero p) throws DatosException {
        Statement sentencia;
        int id;
        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM pasajero");
            ResultSet rs = sentencia.getResultSet();
            rs.moveToInsertRow();
            rs.updateString("DNI", p.getDNI());
            rs.updateString("Nombre", p.getNombre());
            rs.updateString("Apellido", p.getApellido());
            rs.updateInt("numVuelo", p.getNumVuelo().getNumVuelo());
            rs.updateString("idAsiento", p.getIdAsiento().getIdAsiento());
            rs.updateString("IDbillete", p.getIDbillete());

            rs.insertRow();
        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

    public static ArrayList<Pasajero> cargarPasajero(Connection con) throws DatosException {
        ArrayList<Pasajero> ret = new ArrayList<>();

        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM asiento");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {

                Vuelo v = new Vuelo(rs.getInt("numVuelo"), rs.getInt("capacidad"), rs.getTimestamp("Fecha y Hora"));
                Asiento a = new Asiento(rs.getString("idAsiento"), v, rs.getBoolean("Lleno"));
                ret.add(new Pasajero(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellido"), v, a, rs.getString("IDbillete")));

            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
        return ret;
    }

    public static void actualizarPasajero(Connection con, Pasajero p) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sentencia.executeQuery("SELECT * FROM pasajero where DNI='" + p.getDNI() + "'");
            ResultSet rs = sentencia.getResultSet();
            if (rs.next()) {
                rs.updateString("DNI", p.getDNI());
                rs.updateString("Nombre", p.getNombre());
                rs.updateString("Apellido", p.getApellido());
                rs.updateInt("numVuelo", p.getNumVuelo().getNumVuelo());
                rs.updateString("idAsiento", p.getIdAsiento().getIdAsiento());
                rs.updateString("IDbillete", p.getIDbillete());

                rs.updateRow();
            } else {
                throw new DatosException("El pasajero " + p + "no se a encontrado");
            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
    }

    public static void eliminarPasajero(Connection con, Pasajero p) throws DatosException {
        Statement sentencia;

        try {
            sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM pasajero where ID = '" + p.getDNI() + "'";
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

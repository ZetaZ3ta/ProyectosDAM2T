/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Dades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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

              //  Vuelo v = new Vuelo(rs.getInt("numVuelo"), rs.getInt("capacidad"), rs.("Fecha y Hora"));

                ret.add(new Asiento(rs.getString("idAsiento"), getVuelo(rs.getInt("numVuelo"), con), rs.getBoolean("Lleno")));
            }

        } catch (SQLException ex) {
            throw new DatosException("Error: " + ex.toString());
        }
        return ret;
    }
        
        public static Vuelo getVuelo(int numVuelo, Connection conn) throws DatosException {

        Vuelo vuelo = null;
        try {
            String nomBD = conn.getCatalog();
            PreparedStatement preparedStatement;
            String sql = "SELECT * FROM " + nomBD + ".Vuelo  WHERE numVuelo= ? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numVuelo);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                vuelo = new Vuelo(rs.getInt("numVuelo"), rs.getInt("capacidad"),rs.getDate("FechaHora").toLocalDate());
            }
        } catch (SQLException e) {
           throw new DatosException("Error: " + e.toString());
        }

        return vuelo;

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

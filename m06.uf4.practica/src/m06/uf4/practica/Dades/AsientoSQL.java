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

/**
 *
 * @author IvánJM
 */ /*
public class AsientoSQL {

    public boolean registrarAsiento(Asiento a) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO Asiento values ('" + a.getIdAsiento() + "','" + a.getNumVuelo() + "','" + a.getLleno() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase AsientoSQL (método registrar asiento)");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Asiento> listarAsiento() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Vuelo";

        List<Asiento> listaVuelo = new ArrayList<Asiento>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Asiento a = new Asiento();
                a.getIdAsiento(rs.getInt(1));
                a.getNumVuelo(rs.getInt(2));
                a.getLleno(rs.getBoolean(3));
                listaVuelo.add(a);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase AsientoSQL (método listar asiento)");
            e.printStackTrace();
        }

        return listaVuelo;
    }

    public boolean actualizarAsiento(Asiento a) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE Asiento SET idAsiento='" + a.getIdAsiento() + "', numVuelo='" + a.getNumVuelo() + "',"
                + "lleno='" + a.getLleno() + "'" + " WHERE ID=" + a.getIdAsiento();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error en la clase AsientoSQL (método actualizar asiento)");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminarAsiento(Asiento a) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM Asiento WHERE ID=" + a.getIdAsiento();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error en la clase AsientoSQL (método eliminar asiento)");
            e.printStackTrace();
        }
        return eliminar;
    }

}
*/
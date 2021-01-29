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
    
}
/*
    public boolean registrarPasajero(Pasajero p) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO Pasajero values ('" + p.getDNI() + "','" + p.getNombre() + "','"
                + p.getApellido() + "','" + p.getIdAsiento() + "','" + p.getNumVuelo() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase PasajeroSQL (método registrar pasajero)");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Pasajero> listarPasajero() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Pasajero";

        List<Pasajero> listaPasajero = new ArrayList<Pasajero>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pasajero p = new Pasajero();
                p.getDNI(rs.getString(1));
                p.getNombre(rs.getString(2));
                p.getApellido(rs.getString(3));
                p.getNumVuelo(rs.getInt(4));
                p.getIdAsiento(rs.getInt(5));

                listaPasajero.add(p);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase PasajeroSQL (método listar pasajero)");
            e.printStackTrace();
        }

        return listaPasajero;
    }

    public boolean actualizarPasajero(Pasajero p) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE Pasajero SET DNI='" + p.getDNI() + "', Nombre='" + p.getNombre() + "'," + "Apellido='" + p.getApellido() + "', numVuelo='"
                + p.getNumVuelo() + "', idAsiento='" + p.getIdAsiento() + "'" + "WHERE ID=" + p.getDNI();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error en la clase PasajeroSQL (método actualizar pasajero)");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminarPasajero(Pasajero p) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM Pasajero WHERE ID=" + p.getDNI();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error en la clase PasajeroSQL (método eliminar pasajero)");
            e.printStackTrace();
        }
        return eliminar;
    }

}
*/
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
import m06.uf4.practica.Aplicacio.Model.Vuelo;

/**
 *
 * @author IvánJM
 */ /*
public class VueloDaoSQL {


    public boolean registrarVuelo(Vuelo v) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO Vuelo values ('" + v.getNumVuelo() + "','"+ v.getCapacidad() + "','" + v.getFecha_hora() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en la clase VueloDaoSQL (método registrar vuelo)");
            e.printStackTrace();
        }
        return registrar;
    }


    public List<Vuelo> listarVuelo() {
       Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Vuelo";
		
		List<Vuelo> listaVuelo= new ArrayList<Vuelo>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Vuelo v = new Vuelo();
                                v.setNumVuelo(rs.getInt(1));
				v.setCapacidad(rs.getInt(2));
				v.setFecha_hora(rs.getTimestamp(3));
				listaVuelo.add(v);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error en la clase VueloDaoSQL (método listar vuelo)");
			e.printStackTrace();
		}
		
		return listaVuelo;
    }


    public boolean actualizarVuelo(Vuelo v) {
       Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE Vuelo SET numVuelo='"+v.getNumVuelo()+"', capacidad='"+v.getCapacidad()+"', Fecha y Hora='"+v.getFecha_hora()+"'" +" WHERE ID="+v.getNumVuelo();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error en la clase VueloDaoSQL (método actualizar vuelo)");
			e.printStackTrace();
		}		
		return actualizar;
    }


    public boolean eliminarVuelo(Vuelo v) {
        Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM Vuelo WHERE ID="+v.getNumVuelo();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error en la clase VueloDaoSQL (método eliminar vuelo)");
			e.printStackTrace();
		}		
		return eliminar;
    }

}
*/
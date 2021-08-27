package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import Logica.Rol;

public class DAORol {
	private static final String ALL_ROL = "Select * from rol";
	private static final String ROL_NOMBRE = "Select * from rol where nombre=?";
	private static final String ROL_ID = "Select * from rol where id_rol=?";
	private static final String INSERT_ROL = "INSERT INTO ROL(ID_ROL,NOMBRE,DESCRIPCION) VALUES(SEQ_ID_ROL.nextval,?,?)";
	private static final String DELETE_ROL = "DELETE FROM ROL WHERE NOMBRE = ?";
	private static final String UPDATE_ROL = "UPDATE ROL SET NOMBRE=?, DESCRIPCION=? WHERE ID_ROL=?";

	
	public static List<Rol> ListarRol() {

		LinkedList<Rol> Roles = new LinkedList<Rol>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_ROL);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Rol r = new Rol();
				r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
				r.setNombre(resultado.getString("Nombre"));

				r.setDescripcion(resultado.getString("Descripcion"));

				Roles.add(r);
			}
			return Roles;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Rol BuscarRolPorNombre(String nombre) {
		Rol r = new Rol();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ROL_NOMBRE);
			statement.setString(1, nombre);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {

				r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
				r.setNombre(resultado.getString("Nombre"));

				r.setDescripcion(resultado.getString("Descripcion"));
			}
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Rol BuscarRolId(String id) {

		Rol r = new Rol();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ROL_ID);
			statement.setString(1, id);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {

				r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
				r.setNombre(resultado.getString("Nombre"));

				r.setDescripcion(resultado.getString("Descripcion"));
			}
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
//Alta rol
	public static boolean CargarRol(Rol datos) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_ROL);

			statement.setString(1, datos.getNombre());
			statement.setString(2, datos.getDescripcion());

			try {
			int filasIngresadas = statement.executeUpdate();
			
				System.out.println("Se insentaron: " + filasIngresadas + " filas");
				return filasIngresadas > 0;
			}catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
		} catch (SQLException e) {
			// Bloque catch generado automáticamente
			e.printStackTrace();
			return false;
		}
	}

//Eliminar un rol por su nombre
	public static boolean delete(String nombre) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_ROL);

			statement.setString(1, nombre);

			int resultado = statement.executeUpdate();
			return resultado > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

//Método para editar los datos de un rol 

	public static boolean edit(Rol r) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_ROL);
			
		
			statement.setString(1,r.getNombre());
			statement.setString(2,r.getDescripcion());
			statement.setInt(3,r.getId());
			
			int resultado = statement.executeUpdate();
			return resultado > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
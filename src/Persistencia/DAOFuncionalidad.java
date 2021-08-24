package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Logica.Funcionalidad;

public class DAOFuncionalidad {
	private static final String ALL_FUNCIONALIDAD = "SELECT * FROM FUNCIONALIDAD";

	private static final String FUNCIONALIDAD_NOMBRE = "SELECT * FROM FUNCIONALIDAD WHERE NOMBRE=?";
	private static final String FUNCIONALIDAD_ID = "SELECT * FROM FUNCIONALIDAD WHERE ID_FUNCIONALIDAD=?";
	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO ROL(ID_ROL,NOMBRE,DESCRIPCION) VALUES(SEQ_ID_ROL.nextval,?,?)";
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM ROL WHERE NOMBRE = ?";

	public static List<Funcionalidad> ListarRol() {

		LinkedList<Funcionalidad> funcionalidades = new LinkedList<Funcionalidad>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_FUNCIONALIDAD);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Funcionalidad f = new Funcionalidad();
				f.setId(Integer.parseInt(resultado.getString("ID_FUNCIONALIDAD")));
				f.setNombre(resultado.getString("NOMBRE"));

				f.setDescripcion(resultado.getString("DESCRIPCION"));

				funcionalidades.add(f);
			}
			return funcionalidades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Funcionalidad BuscarFuncionalidadPorNombre(String nombre) {
		Funcionalidad f = new Funcionalidad();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FUNCIONALIDAD_NOMBRE);
			statement.setString(1, nombre);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {

				f.setId(Integer.parseInt(resultado.getString("ID_FUNCIONALIDAD")));
				f.setNombre(resultado.getString("NOMBRE"));

				f.setDescripcion(resultado.getString("DESCRIPCION"));
			}
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Funcionalidad BuscarFuncionalidadId(String id) {

		Funcionalidad f = new Funcionalidad();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FUNCIONALIDAD_ID);
			statement.setString(1, id);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {

				f.setId(Integer.parseInt(resultado.getString("ID_FUNCIONALIDAD")));
				f.setNombre(resultado.getString("NOMBRE"));

				f.setDescripcion(resultado.getString("DESCRIPCION"));
			}
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// Alta funcionalidad
	public static boolean CargarFuncionalidad(Funcionalidad datos) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);

			statement.setString(1, datos.getNombre());
			statement.setString(2, datos.getDescripcion());

			int filasIngresadas = statement.executeUpdate();

			System.out.println("Se insentaron: " + filasIngresadas + " filas");
			return filasIngresadas > 0;
		} catch (SQLException e) {
			// Bloque catch generado automáticamente
			e.printStackTrace();
			return false;
		}
	}

	// Eliminar una funcionalidad por su nombre
	public static boolean delete(String nombre) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);

			statement.setString(1, nombre);

			int resultado = statement.executeUpdate();
			return resultado > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

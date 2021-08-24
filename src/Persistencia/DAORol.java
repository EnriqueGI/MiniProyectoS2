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
	private static final String ROL_ID= "Select * from rol where id_rol=?";
	
	
	public static List<Rol> ListarRol(){
		
		LinkedList<Rol>  Roles = new LinkedList<Rol>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_ROL);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				Rol r = new Rol();
				r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
				r.setNombre (resultado.getString("Nombre"));
			
				r.setDescripcion(resultado.getString("Descripcion"));
			
				Roles.add(r);
			}
			return Roles;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
public static Rol BuscarRolPorNombre(String nombre){
		
	    Rol r = new Rol();
	  
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ROL_NOMBRE);
			statement.setString(1,nombre);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
		
				r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
				r.setNombre (resultado.getString("Nombre"));
			
				r.setDescripcion(resultado.getString("Descripcion"));				
			}
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
public static Rol BuscarRolId(String id){
	
    Rol r = new Rol();
  
	try {
		PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ROL_ID);
		statement.setString(1,id);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
	
			r.setId(Integer.parseInt(resultado.getString("Id_Rol")));
			r.setNombre (resultado.getString("Nombre"));
		
			r.setDescripcion(resultado.getString("Descripcion"));				
		}
		return r;
	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
	
}
	
	
	
	
	
	
	
	
	
	public static boolean Cargargar(Rol datos) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("");
			
		    /*statement.setString(1, datos.getDocumento());
			statement.setString(2, datos.getApellido1());
			statement.setString(3, datos.getApellido2());
			statement.setString(4, datos.getNombre1());
			statement.setString(5, datos.getNombre1());
			statement.setString(6, String.valueOf(datos.getFechaNac()));
			statement.setString(7, datos.getClave());
			statement.setInt(8, datos.getRol().getId());
			statement.setString(9, datos.getMail());
			
			

			int filasIngresadas = statement.executeUpdate();

			System.out.println("Se insentaron: " + filasIngresadas + " filas");
			return filasIngresadas >0;
			*/
			return false;
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	

}

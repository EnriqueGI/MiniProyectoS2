package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Logica.Funcionalidad;
import Logica.Rol;



public class DAOFuncionalidad {

    private static final String ALL_FUNCIONALIDAD = "SELECT * FROM FUNCIONALIDAD";
	
	private static final String FUNCIONALIDAD_NOMBRE = "SELECT * FROM FUNCIONALIDAD WHERE NOMBRE=?";
	
	private static final String ID_MAX = "SELECT MAX (ID_FUNCIONALIDAD) FROM FUNCIONALIDAD";
	
	private static final String BUSCAR_FUNCIONALIDAD = "SELECT * FROM FUNCIONALIDAD WHERE NOMBRE=?";
	
	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) VALUES (SEQ_ID_FUNCIONALIDAD.nextval,?,?)";
	
	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDAD SET NOMBRE=?, DESCRIPCION=? WHERE ID_FUNCIONALIDAD=?";
	
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM FUNCIONALIDAD WHERE ID_FUNCIONALIDAD = ?";
	
	public static LinkedList<Funcionalidad> findAll(){
		LinkedList<Funcionalidad>  funcionalidades = new LinkedList<Funcionalidad>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_FUNCIONALIDAD);
			
			ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
            	Funcionalidad f = new Funcionalidad();
				f.setId(Integer.parseInt(resultado.getString("Id_Funcionalidad")));
				f.setNombre(resultado.getString("NOMBRE"));
				f.setDescripcion(resultado.getString("DESCRIPCION"));
				
				funcionalidades.add(f);
			}
		
		
		return funcionalidades;
	  
		}catch(SQLException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}
	
public static String Funcionalidades() {
		
		String Funcionalidades = "";
		 
		 for (Funcionalidad f: DAOFuncionalidad.findAll()) {
			 
			 Funcionalidades += "  -----  " + f;
		 }
		return Funcionalidades;
	}


public static String findFuncionalidad(String NOMBRE) {
	String resultado = "";
	
	 try {
		 PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_FUNCIONALIDAD);
		 statement.setString(1, NOMBRE);
		 
		 
		 ResultSet res = statement.executeQuery();
		 
		 while (res.next()) {
				
			    int id = res.getInt("ID_FUNCIONALIDAD");
				String nombre = res.getString("NOMBRE");
				String Descripcion = res.getString("DESCRIPCION");
				
				
				
		resultado = "Persona [id=" + id + "nombre=" + nombre + ", documentoPersona=" + Descripcion + "]";		
		
		
		return resultado;
		 }
		 
}catch(SQLException l) {
	  l.printStackTrace();
}
	return resultado;
	
}
public static int maximo (){
	
	int maximo = 0;
	ResultSet res =null;
	
	 try {
		 PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ID_MAX);
		 
		 res = statement.executeQuery();
		 
		 while(res.next()) {
			 
			 maximo = res.getInt(1);
			 
		 }
		 
		 
	 }catch (SQLException l) {
		  l.printStackTrace();
	 }
	return maximo;
}
public static boolean insert(Funcionalidad f) {
	
	try {
		PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);
		
		statement.setString(1, f.getNombre());
		statement.setString(2, f.getDescripcion());
		
		int result = statement.executeUpdate();
		
		return result>0;
		
		} catch(SQLException r) {
			  r.printStackTrace();
			  return false;
		}
}
public static boolean edit(Funcionalidad g) {
	try {
		PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);
		
				statement.setString(1, g.getNombre());
				statement.setString(2, g.getDescripcion());
				statement.setInt(3,g.getID());
				
				int retorno = statement.executeUpdate();
				
				return retorno>0;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}	
	
}
public static boolean delete(int Id) {
	try {
		PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);
		
			statement.setInt(1, Id);
			int retorno = statement.executeUpdate();
			
			return retorno > 0;
			
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
}
}

}
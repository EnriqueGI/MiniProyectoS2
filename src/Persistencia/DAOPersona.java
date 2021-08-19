package Persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Logica.Persona;



public class DAOPersona {
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA"
			+ "(id_persona, DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC, CLAVE, ID_ROL,MAIL) "
			+ "VALUES(SEQ_ID_PERSONA.nextval,?,?,?,?,?,?,?,?,?)";
	private static final String LOGIN = "SELECT * FROM PERSONA WHERE mail=? AND clave=?";
	
	
	// LOGIN

	public static int Login(String mail, String clve) {
		Persona  p = new Persona();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(LOGIN);
			statement.setString(1,mail);
			statement.setString(2,clve);
			
			
			ResultSet resultado = statement.executeQuery();
			int x =0;
			while(resultado.next()) {
				x = resultado.getInt("ID_ROL");
			
			}
			return x;
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	
	
	
	
	public static boolean Cargargar(Persona datos) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONA);
			
			statement.setString(1, datos.getDocumento());
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
			
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	

}

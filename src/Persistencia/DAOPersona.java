package Persistencia;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import Logica.Persona;
import Logica.Rol;




public class DAOPersona {
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA"
			+ "(id_persona, DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC, CLAVE, ID_ROL,MAIL) "
			+ "VALUES(SEQ_ID_PERSONA.nextval,?,?,?,?,?,?,?,?,?)";
	
	
	private static final String LOGIN = "SELECT * FROM PERSONA WHERE mail=? AND clave=?";
	
	
	private static final String ALL_PERSONAS= "Select * from persona order by Id_Persona";
	
	private static final String BUSCAR_PERSONA= "SELECT * FROM PERSONA WHERE APELLIDO1=? AND NOMBRE1=?";
	
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, CLAVE=?,MAIL=? WHERE ID_PERSONA=(select id_persona from persona where documento=?)";
	
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE DOCUMENTO=?"; 

	
	// LOGIN

	public static int Login(String mail, String clve) {
	
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONA);
			
			statement.setString(1, datos.getDocumento());
			statement.setString(2, datos.getApellido1());
			statement.setString(3, datos.getApellido2());
			statement.setString(4, datos.getNombre1());
			statement.setString(5, datos.getNombre1());
			String fecha = datos.getFechaNac().format(formatter);
			statement.setString(6, fecha);
			statement.setString(7, datos.getClave());
			statement.setInt(8, datos.getRol().getId());
			statement.setString(9, datos.getMail());
			
			

			int filasIngresadas = statement.executeUpdate();

			System.out.println("Se insentaron: " + filasIngresadas + " filas");
			return filasIngresadas >0;
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	// Método para mostrar todas las persona
	
	public static LinkedList<Persona> findAll(){
		LinkedList<Persona>  personas = new LinkedList<Persona>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				Persona p = new Persona();
		
				p.setDocumento(resultado.getString("Documento"));
			
				p.setApellido1(resultado.getString("Apellido1"));
				p.setApellido2(resultado.getString("Apellido1"));
				p.setNombre1(resultado.getString("Nombre1"));
				p.setNombre2(resultado.getString("Nombre2"));
				p.setMail(resultado.getString("Mail"));
				Rol r =DAORol.BuscarRolId(resultado.getString("Id_Rol"));
				p.setRol(r);
				personas.add(p);
			}
			return personas;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	// Método que busca una persna poe primer nombre y apellido

	public static Persona findPersona(String apellido1, String nombre1) {
		Persona  p = new Persona();

		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA);
			
			
			
			statement.setString(1,apellido1);
			statement.setString(2,nombre1);
			
			
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				
				p.setDocumento(resultado.getString("Documento"));
				p.setApellido1(resultado.getString("Apellido1"));
				p.setApellido2(resultado.getString("Apellido1"));
				p.setNombre1(resultado.getString("Nombre1"));
				p.setNombre2(resultado.getString("Nombre2"));
				//p.setFechaNac( resultado.getDate("Fecha_Nac") );
				p.setMail(resultado.getString("Mail"));
			
			}
			return p;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	// Método para actualizar los datos de una persona 
	
	public static boolean edit(Persona p) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);
			
		
			statement.setString(1,p.getDocumento());
			statement.setString(2,p.getApellido1());
			statement.setString(3,p.getApellido2());
			statement.setString(4,p.getNombre1());
			statement.setString(5,p.getNombre2());
			//statement.setString(6,String.valueOf(p.getFechaNac()));
			statement.setString(6,p.getClave());
			statement.setString(7,p.getMail());
			statement.setString(8,p.getDocumento());
			
			int resultado = statement.executeUpdate();
			return resultado > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	// Método para eliminar una persona

	public static boolean delete(String documento) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONA);
			
		
			statement.setString(1,documento);
		
			
			int resultado = statement.executeUpdate();
			return resultado > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	
	

}

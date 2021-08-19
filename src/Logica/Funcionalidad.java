package Logica;

public class Funcionalidad {
	private String nombre;
	private String descripcion;
	
	//Constructores
	public Funcionalidad(){
		
	}
	public Funcionalidad(String nombre,String descripcion){
		this.nombre= nombre;
		this.descripcion = descripcion;
	}
	
	//Getters y setters
	public String getNombre(){
		return this.nombre;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public void setNombre(String n){
		this.nombre = n;	
	}
	public void setDescripcion(String d){
		this.descripcion = d;
	}
	

	
}

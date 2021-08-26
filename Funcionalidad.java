package Logica;

public class Funcionalidad {
	private int id;
	private String nombre;
	private String descripcion;
	private Rol rol;
	
	
	//Constructores
	public Funcionalidad(int id, String nombre, String descripcion){
		this.nombre= nombre;
		this.descripcion = descripcion;
		
	}
	public Funcionalidad(String nombre, String descripcion){
		this.nombre= nombre;
		this.descripcion = descripcion;
		
	}
	public Funcionalidad(String nombre,String descripcion, Rol rol){
		this.nombre= nombre;
		this.descripcion = descripcion;
		this.rol = rol;
	}
	
	//Getters y setters
	public String getNombre(){
		return this.nombre;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public Rol getRol() {
		return this.rol;
	}
	public void setRol(Rol rol) {
	    this.rol = rol;
	}
	public void setNombre(String n){
		this.nombre = n;	
	}
	public void setDescripcion(String d){
		this.descripcion = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Funcionalidad [id=" + id  + "Nombre=" + nombre + ", Descripcion=" + descripcion +"]";
	}
	
}

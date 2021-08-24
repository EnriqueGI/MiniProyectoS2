package Logica;
import java.util.LinkedList;

public class Rol {
	private int id;
	private String nombre;
	private String descripcion;
	private LinkedList<Persona> empleados;
	private LinkedList<Funcionalidad> funcionalidades;
	
	public Rol() {
		
	}
	public Rol(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
}

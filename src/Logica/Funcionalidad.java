package Logica;

import java.util.LinkedList;

public class Funcionalidad {
	private long id;
	private String nombre;
	private String descripcion;
	LinkedList<Rol> listaRoles = new LinkedList<Rol>();
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
	public LinkedList<Rol> getListaRoles() {
		return listaRoles;
	}
	public void setListaRoles(LinkedList<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}
	@Override
	
	
	public String toString() {
		return "Funcionalidad [nombre=" + nombre + ", descripcion=" + descripcion + ", listaRoles=" + listaRoles + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	
}

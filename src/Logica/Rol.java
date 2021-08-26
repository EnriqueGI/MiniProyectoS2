package Logica;

import java.util.LinkedList;

public class Rol {
	private int id;
	private String nombre;
	private String descripcion;
	LinkedList <Persona> listaPersonas = new LinkedList<Persona>();
	LinkedList <Funcionalidad> listaFuncionalidad = new LinkedList<Funcionalidad>();
	
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
	
	
	
	
	public LinkedList<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(LinkedList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
	
	public LinkedList<Funcionalidad> getListaFuncionalidad() {
		return listaFuncionalidad;
	}
	public void setListaFuncionalidad(LinkedList<Funcionalidad> listaFuncionalidad) {
		this.listaFuncionalidad = listaFuncionalidad;
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
}

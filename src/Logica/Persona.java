package Logica;


import java.time.LocalDate;



public class Persona {
	private String documento;
	private String apellido1;
	private String apellido2;
	private String nombre1;
	private String nombre2;
	private LocalDate fechaNac;
	private String clave;
	private String mail;
	private Rol rol;
	
	//Constructores
	public Persona() {
		
	}
	public Persona(String documento,String apellido1,String apellido2,
	String nombre1, String nombre2,LocalDate fechaNac,String clave,String mail, Rol rol) {
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fechaNac = fechaNac;
		this.clave = clave;
		this.mail = mail;
		this.setRol(rol);
	}
	
	//Getters y setters
	public String getDocumento(){
		return documento;
	}
	public String getApellido1(){
		return apellido1;
	}
	public String getApellido2(){
		return apellido2;
	}
	public String getNombre1(){
		return nombre1;
	}
	public String getNombre2(){
		return nombre2;
	}
	public LocalDate getFechaNac(){
		return fechaNac;
	}
	public String getClave(){
		return clave;
	}
	public String getMail(){
		return mail;
	}
	public void setDocumento(String d){
		this.documento = d;
	}
	public void setApellido1(String a1){
		this.apellido1 = a1;
	}
	public void setApellido2(String a2){
		this.apellido2 = a2;
	}
	public void setNombre1(String n1){
		this.nombre1 = n1;
	}
	public void setNombre2(String n2){
		this.nombre2 = n2;
	}
	public void setFechaNac(LocalDate f){
		this.fechaNac = f;
	}
	public void setClave(String c){
		this.clave = c;
	}
	public void setMail(String m){
		this.mail = m;
	}
	
	//Metodos
	public String toString(){
		return "Nombres: " + nombre1 + ", " + nombre2 + " Apellidos: " + apellido1 + ", " + apellido2;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
}

package Presentacion;

import java.awt.EventQueue;

import Logica.Persona;
import Persistencia.DAOPersona;

public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//  Login
	
	public static int Login(String mail, String clave) {
		return DAOPersona.Login(mail, clave);
	}
	
	// Método para cargar una persona
  public static boolean CargarPersona(Persona p) {
	  return DAOPersona.Cargargar(p);
  }
}

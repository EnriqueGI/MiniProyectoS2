package Presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import Logica.Funcionalidad;
import Persistencia.DAOFuncionalidades;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class JFucnionalidad {

	private JFrame frame;
	private JTextField mainDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFucnionalidad window = new JFucnionalidad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFucnionalidad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Buscar = new JButton("Buscar");
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buscar.setBounds(304, 37, 89, 23);
		frame.getContentPane().add(Buscar);
		
		JButton Modificar = new JButton("Modificar");
		Modificar.setBounds(304, 82, 89, 23);
		frame.getContentPane().add(Modificar);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.setBounds(304, 132, 89, 23);
		frame.getContentPane().add(Eliminar);
		
		JButton Agregar = new JButton("Agregar");
		Agregar.setBounds(304, 177, 89, 23);
		frame.getContentPane().add(Agregar);
		
		JButton listarFuncionalidades = new JButton("Listar Funcionalidades");
		listarFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		listarFuncionalidades.setBounds(59, 23, 164, 23);
		frame.getContentPane().add(listarFuncionalidades);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 65, 284, 74);
		frame.getContentPane().add(scrollPane_2);
		
		mainDisplay = new JTextField();
		scrollPane_2.setViewportView(mainDisplay);
		mainDisplay.setColumns(10);
		scrollPane_2.setVisible(false);
		
		String Funciones = DAOFuncionalidades.Funcionalidades();
		
		scrollPane_2.setVisible(false);
		
		
	
		listarFuncionalidades.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainDisplay.setText(null);
				scrollPane_2.setVisible(true);
				mainDisplay.setText(Funciones);
			
			
			}
		
		
	});
	
	Buscar.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
	    
	  String nombre_1 = JOptionPane.showInputDialog("Nombre: ");
	    String busquedaFuncion = DAOFuncionalidades.findFuncionalidad(nombre_1);
	
		mainDisplay.setText(null);
		scrollPane_2.setVisible(true);
		mainDisplay.setText(busquedaFuncion);
    }
		
	});
	
	Agregar.addActionListener (new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			mainDisplay.setText(null);
			scrollPane_2.setVisible(true);
			
			int id = DAOFuncionalidades.maximo(); 
			
			id++;
			
			String nombre = JOptionPane.showInputDialog("Nombre de la Funcionalidad: ");
			String descripcion = JOptionPane.showInputDialog("Descripcion de la Funcionalidad: ");
			
			Funcionalidad g = new Funcionalidad( nombre, descripcion);
			
			if (DAOFuncionalidades.insert(g)) {
				
				mainDisplay.setText("Funcionalidad ingresada cone exito");
			}else {
				mainDisplay.setText("No se pudo ingresar la funcionalidad");	
			}
		}
});
	
	Modificar.addActionListener (new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainDisplay.setText(null);
			scrollPane_2.setVisible(true);
			String id_1_String = JOptionPane.showInputDialog("ID de la Funcionalidad la cual desea Modificar: ");
			
			int id_1 = Integer.parseInt(id_1_String);
			
			String nombre = JOptionPane.showInputDialog("Nuevo nombre de la Funcionalidad: ");
			String descripcion = JOptionPane.showInputDialog("Nueva descripcion de la Funcionalidad: ");
			
			Funcionalidad g = new Funcionalidad( nombre, descripcion);
			
            if (DAOFuncionalidades.edit(g)) {	
				mainDisplay.setText("Funcionalidad editada cone exito");
			}else {
				mainDisplay.setText("No se pudo editar la funcionalidad");	
			}
		}
});
	Eliminar.addActionListener (new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainDisplay.setText(null);
			scrollPane_2.setVisible(true);
			
			String id_2_String = JOptionPane.showInputDialog("ID de la Persona a la Cual se Desea Eliminar: ");
			
			int id_2 = Integer.parseInt(id_2_String);
			
			if (DAOFuncionalidades.delete(id_2)) {	
				mainDisplay.setText("Funcionalidad eliminada cone exito");
			}else {
				mainDisplay.setText("No se pudo eliminar la funcionalidad");	
			}
		}
});
	
}

}
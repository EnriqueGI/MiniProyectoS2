package Presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Persona;
import Logica.Rol;
import Persistencia.DAOPersona;
import Persistencia.DAORol;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class JfPersona extends JFrame {
    
	private JComboBox comboRol;
	private JPanel contentPane;
	private JTextArea textDocumento;
	private JTextArea textA1;
	private JTextArea textA2;
	private JTextArea textN1;
	private JTextArea textN2;
	private JTextArea textFecha;
	private JTextArea textCorreo;
	private JTextArea textClave;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfPersona frame = new JfPersona();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JfPersona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(23, 11, 393, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocumento.setForeground(Color.WHITE);
		lblDocumento.setBounds(41, 43, 83, 14);
		panel.add(lblDocumento);
		
		JLabel lblApellido = new JLabel("Apellido1");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(41, 80, 83, 14);
		panel.add(lblApellido);
		
		JLabel lblApellido_2 = new JLabel("Apellido2");
		lblApellido_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_2.setForeground(Color.WHITE);
		lblApellido_2.setBounds(41, 105, 83, 14);
		panel.add(lblApellido_2);
		
		JLabel lblNombre = new JLabel("Nombre1");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(41, 139, 83, 14);
		panel.add(lblNombre);
		
		JLabel lblNombre_2 = new JLabel("Nombre2");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2.setForeground(Color.WHITE);
		lblNombre_2.setBounds(41, 173, 83, 14);
		panel.add(lblNombre_2);
		
		JLabel lblNombre_2_1 = new JLabel("Fecha Nacimiento");
		lblNombre_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1.setForeground(Color.WHITE);
		lblNombre_2_1.setBounds(41, 207, 143, 14);
		panel.add(lblNombre_2_1);
		
		JLabel lblNombre_2_1_1 = new JLabel("Rol");
		lblNombre_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1.setForeground(Color.WHITE);
		lblNombre_2_1_1.setBounds(41, 240, 104, 14);
		panel.add(lblNombre_2_1_1);
		
		JLabel lblNombre_2_1_1_1 = new JLabel("Correo");
		lblNombre_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1_1.setForeground(Color.WHITE);
		lblNombre_2_1_1_1.setBounds(41, 274, 104, 14);
		panel.add(lblNombre_2_1_1_1);
		
		JLabel lblNombre_2_1_1_2 = new JLabel("Clave");
		lblNombre_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1_2.setForeground(Color.WHITE);
		lblNombre_2_1_1_2.setBounds(41, 307, 104, 14);
		panel.add(lblNombre_2_1_1_2);
		
		textDocumento = new JTextArea();
		textDocumento.setBounds(194, 38, 150, 23);
		panel.add(textDocumento);
		
		textA1 = new JTextArea();
		textA1.setBounds(194, 72, 150, 23);
		panel.add(textA1);
		
		textA2 = new JTextArea();
		textA2.setBounds(194, 104, 150, 23);
		panel.add(textA2);
		
		textN1 = new JTextArea();
		textN1.setBounds(194, 138, 150, 23);
		panel.add(textN1);
		
		textN2 = new JTextArea();
		textN2.setBounds(194, 172, 150, 23);
		panel.add(textN2);
		
		 textFecha = new JTextArea();
		textFecha.setBounds(194, 206, 150, 23);
		panel.add(textFecha);
		
		 textCorreo = new JTextArea();
		textCorreo.setBounds(194, 273, 150, 23);
		panel.add(textCorreo);
		
		textClave = new JTextArea();
		textClave.setBounds(194, 306, 150, 23);
		panel.add(textClave);
		
		comboRol = new JComboBox();
		comboRol.setBounds(194, 238, 150, 22);
		panel.add(comboRol);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(499, 76, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(499, 124, 132, 23);
		contentPane.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona  p = new Persona();
				p = null;
				if(!textA1.getText().equals("") && !textN1.getText().equals("") ) {
					p = DAOPersona.findPersona(textA1.getText(), textN1.getText());
					
					if(p.getDocumento()!= null) {
						textDocumento.setText(p.getDocumento());
						textA2.setText(p.getApellido2());
						textN2.setText(p.getNombre2());
						textFecha.setText(String.valueOf(p.getFechaNac()));
						textCorreo.setText(p.getMail());
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "No se encontró una persona con esos datos");
						
						Limpiar();
					}
				
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe ingrear 1° nombre y 1° apellido ");
				}
				
				
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(499, 30, 132, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(499, 169, 132, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("...");
		lblNewLabel.setBounds(509, 229, 49, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(23, 379, 132, 23);
		contentPane.add(btnListar);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			Persona p = new Persona();
			
			p.setDocumento(textDocumento.getText());
			p.setApellido1(textA1.getText());
			p.setApellido2(textA2.getText());
			p.setNombre1(textN1.getText());
			p.setNombre2(textN2.getText());
			LocalDate fecha = LocalDate.of(2018, 10, 30);
			p.setFechaNac(fecha);
			p.setClave(textClave.getText());
			p.setMail(textCorreo.getText());
			Rol r = new Rol();
			r =DAORol.BuscarRolPorNombre(comboRol.getSelectedItem().toString());
			System.out.println(r);
			p.setRol(r);
			
			DAOPersona.Cargargar(p);
				
			}
			
			// método que carga el combobox de los Roles
			
		});
		
		
		
	}
	public void cargarRoles(List<Rol> Roles) {
		for(Rol n: Roles)
		comboRol.addItem(n.getNombre());
		
	}
	
	// Métodos para limpiar las cajas de texto
	
	public void Limpiar() {
		textDocumento.setText("");
		textA1.setText("");
		textA2.setText("");
		textN1.setText("");
		textN2.setText("");
		textFecha.setText("");
		textCorreo.setText("");
	}
	
}

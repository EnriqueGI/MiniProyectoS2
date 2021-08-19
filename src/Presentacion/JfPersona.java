package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Persona;
import Logica.Rol;


import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class JfPersona extends JFrame {

	private JPanel contentPane;
	JTextArea textDocumento;
	JTextArea textA1;
	JTextArea textA2;
	JTextArea textN1;
	JTextArea textN2;
	JTextArea textFecha;
	JTextArea textCorreo;
	JTextArea textClave;
	JTextArea textRol;
	

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
		panel.setBounds(10, 27, 393, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			Persona p = new Persona();
			
			p.setDocumento(textDocumento.getText());
			p.setApellido1(textA1.getText());
			p.setApellido2(textA2.getText());
			p.setNombre1(textN1.getText());
			p.setNombre2(textN2.getText());
			
			p.setFechaNac(LocalDate.parse(textFecha.getText()));
			p.setClave(textClave.getText());
			p.setMail(textCorreo.getText());
			Rol r = new Rol();
			r.setId(Integer.parseInt(textRol.getText()));
			p.setRol(r);
		    Principal.CargarPersona(p);
				
			}
		});
		btnNewButton.setBounds(138, 337, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(41, 43, 83, 14);
		panel.add(lblDocumento);
		
		JLabel lblApellido = new JLabel("Apellido1");
		lblApellido.setBounds(41, 80, 83, 14);
		panel.add(lblApellido);
		
		JLabel lblApellido_2 = new JLabel("Apellido2");
		lblApellido_2.setBounds(41, 105, 83, 14);
		panel.add(lblApellido_2);
		
		JLabel lblNombre = new JLabel("Nombre1");
		lblNombre.setBounds(41, 149, 83, 14);
		panel.add(lblNombre);
		
		JLabel lblNombre_2 = new JLabel("Nombre2");
		lblNombre_2.setBounds(41, 183, 83, 14);
		panel.add(lblNombre_2);
		
		JLabel lblNombre_2_1 = new JLabel("Fecha Nacimiento");
		lblNombre_2_1.setBounds(41, 208, 104, 14);
		panel.add(lblNombre_2_1);
		
		JLabel lblNombre_2_1_1 = new JLabel("Rol");
		lblNombre_2_1_1.setBounds(41, 231, 104, 14);
		panel.add(lblNombre_2_1_1);
		
		JLabel lblNombre_2_1_1_1 = new JLabel("Correo");
		lblNombre_2_1_1_1.setBounds(41, 261, 104, 14);
		panel.add(lblNombre_2_1_1_1);
		
		JLabel lblNombre_2_1_1_2 = new JLabel("Clave");
		lblNombre_2_1_1_2.setBounds(41, 281, 104, 14);
		panel.add(lblNombre_2_1_1_2);
		
		textDocumento = new JTextArea();
		textDocumento.setBounds(148, 38, 150, 23);
		panel.add(textDocumento);
		
		textA1 = new JTextArea();
		textA1.setBounds(148, 75, 150, 23);
		panel.add(textA1);
		
		textA2 = new JTextArea();
		textA2.setBounds(148, 110, 150, 23);
		panel.add(textA2);
		
		textN1 = new JTextArea();
		textN1.setBounds(148, 144, 150, 23);
		panel.add(textN1);
		
		textN2 = new JTextArea();
		textN2.setBounds(148, 178, 150, 23);
		panel.add(textN2);
		
		 textFecha = new JTextArea();
		textFecha.setBounds(148, 203, 150, 23);
		panel.add(textFecha);
		
		textRol = new JTextArea();
		textRol.setBounds(148, 231, 150, 23);
		panel.add(textRol);
		
		 textCorreo = new JTextArea();
		textCorreo.setBounds(148, 261, 150, 23);
		panel.add(textCorreo);
		
		textClave = new JTextArea();
		textClave.setBounds(148, 295, 150, 23);
		panel.add(textClave);
		
		JLabel lblNewLabel = new JLabel("...");
		lblNewLabel.setBounds(148, 375, 49, 14);
		panel.add(lblNewLabel);
	}

}

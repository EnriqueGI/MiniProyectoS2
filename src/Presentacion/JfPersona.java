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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class JfPersona extends JFrame {
    private JComboBox comboDia;
    private JComboBox comboMes;
    private JComboBox comboAño;
	private JComboBox comboRol;
	private JPanel contentPane;
	private JTextArea textDocumento;
	private JTextArea textA1;
	private JTextArea textA2;
	private JTextArea textN1;
	private JTextArea textN2;
	private JTextArea textCorreo;
	private JTextArea textClave;
	private JTable table;
	

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
		textDocumento.setBounds(194, 38, 189, 23);
		panel.add(textDocumento);
		
		textA1 = new JTextArea();
		textA1.setBounds(194, 72, 189, 23);
		panel.add(textA1);
		
		textA2 = new JTextArea();
		textA2.setBounds(194, 104, 189, 23);
		panel.add(textA2);
		
		textN1 = new JTextArea();
		textN1.setBounds(194, 138, 189, 23);
		panel.add(textN1);
		
		textN2 = new JTextArea();
		textN2.setBounds(194, 172, 189, 23);
		panel.add(textN2);
		
		 textCorreo = new JTextArea();
		textCorreo.setBounds(194, 273, 189, 23);
		panel.add(textCorreo);
		
		textClave = new JTextArea();
		textClave.setBounds(194, 306, 189, 23);
		panel.add(textClave);
		
		comboRol = new JComboBox();
		comboRol.setBounds(194, 238, 150, 22);
		panel.add(comboRol);
		
	 comboDia = new JComboBox();
		comboDia.setBounds(194, 205, 45, 22);
		panel.add(comboDia);
		
		 comboMes = new JComboBox();
		comboMes.setBounds(251, 205, 45, 22);
		panel.add(comboMes);
		
		 comboAño = new JComboBox();
		comboAño.setBounds(306, 205, 77, 22);
		panel.add(comboAño);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(499, 76, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p = new Persona();
				
				if(textDocumento.getText().equals("") || textA1.getText().equals("") ||
						textA2.getText().equals("") || textN1.getText().equals("") ||
						textN2.getText().equals("") || textClave.getText().equals("") ||
						textCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios");
				
				}else {
					
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
					
					
					
					if(DAOPersona.edit(p)) {
						JOptionPane.showMessageDialog(null, "Se actualizó la persona");
					}else {
						JOptionPane.showMessageDialog(null, "NO existe una persona con ese documento");
					}
					
				}
				
				
				
				
			}
		});
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
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(!textDocumento.getText().equals("")) {
				if(DAOPersona.delete(textDocumento.getText())){
					JOptionPane.showMessageDialog(null, "Se eliminí la persona");
				}else {
					JOptionPane.showMessageDialog(null, "No hay una persona con ese documento");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Debe ingresar un documento");
			}
				
				
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(499, 169, 132, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("...");
		lblNewLabel.setBounds(509, 229, 49, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

			
				((DefaultTableModel) table.getModel()).setNumRows(0);

				for (Persona p : DAOPersona.findAll()) {

					
					Object[] fila = new Object[7];
					
					fila[0] = String.valueOf(p.getDocumento());
					fila[1] = String.valueOf(p.getApellido1());
					fila[2] = String.valueOf(p.getApellido2());
					fila[3] = String.valueOf(p.getNombre1());
					fila[4] = String.valueOf(p.getNombre2());
					fila[5] = String.valueOf(p.getRol().getNombre());
					fila[6] = String.valueOf(p.getMail());

					((DefaultTableModel) table.getModel()).addRow(fila);

				}
				
				
				
			}
		});
		
		
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(23, 379, 132, 23);
		contentPane.add(btnListar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 434, 810, 166);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 26, 748, 129);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Rol", "Mail"
			}
		));
		scrollPane.setViewportView(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			if(textDocumento.getText().equals("") || textA1.getText().equals("") ||
					textA2.getText().equals("") || textN1.getText().equals("") ||
					textN2.getText().equals("") || textClave.getText().equals("") ||
					textCorreo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios");
				
			}else {
				
				
				Persona p = new Persona();
				
				p.setDocumento(textDocumento.getText());
				p.setApellido1(textA1.getText());
				p.setApellido2(textA2.getText());
				p.setNombre1(textN1.getText());
				p.setNombre2(textN2.getText());
				LocalDate fecha = LocalDate.of(Integer.parseInt(comboAño.getSelectedItem().toString()),
						Integer.parseInt(comboMes.getSelectedItem().toString()),
						Integer.parseInt(comboDia.getSelectedItem().toString()));
				p.setFechaNac(fecha);
				p.setClave(textClave.getText());
				p.setMail(textCorreo.getText());
				Rol r = new Rol();
				r =DAORol.BuscarRolPorNombre(comboRol.getSelectedItem().toString());
				
				p.setRol(r);
				
				if (DAOPersona.Cargargar(p)) {
					JOptionPane.showMessageDialog(null, "Se cargó correctamente la persona");
				}else {
					JOptionPane.showMessageDialog(null, "No se cargó la persona");
				}
				
				
			}
		
				
			}
			
			
			
		});
		
		
		
	}
	public void cargarRoles(List<Rol> Roles) {
		for(Rol n: Roles)
		comboRol.addItem(n.getNombre());
		
	}
	
	// cargar combo fecha
	public void cargarComboFecha() {
		for(int i =1 ; i < 32; i++) {
		comboDia.addItem(i);
		
		}
		for(int i =1 ; i <13 ; i++) {
			comboMes.addItem(i);
			
			}
		
		for(int i =1940 ; i <2022 ; i++) {
			comboAño.addItem(i);
			
			}
		
		
	}
	
	// Métodos para limpiar las cajas de texto
	
	public void Limpiar() {
		textDocumento.setText("");
		textA1.setText("");
		textA2.setText("");
		textN1.setText("");
		textN2.setText("");
		
		textCorreo.setText("");
	}
}

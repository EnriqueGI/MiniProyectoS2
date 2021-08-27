package Presentacion;
import Logica.Persona;
import Logica.Rol;
import Persistencia.DAOPersona;
import Persistencia.DAORol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

public class jfRol extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboRol;
	private JTextArea textNomRol;
	private JTextArea textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfRol frame = new jfRol();
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
	public jfRol() {
		setBounds(100, 100, 733, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 427, 181);
		contentPane.add(panel);
		
		JLabel lblNomRol = new JLabel("Nombre rol:");
		lblNomRol.setForeground(Color.WHITE);
		lblNomRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomRol.setBounds(41, 43, 83, 14);
		panel.add(lblNomRol);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(41, 80, 83, 14);
		panel.add(lblDescripcion);
		
		textNomRol = new JTextArea();
		textNomRol.setBounds(172, 40, 189, 23);
		panel.add(textNomRol);
		
		textDescripcion = new JTextArea();
		textDescripcion.setBounds(172, 77, 189, 23);
		panel.add(textDescripcion);
		
		comboRol = new JComboBox();
		comboRol.setBounds(172, 111, 93, 22);
		panel.add(comboRol);
		
		JLabel lblID = new JLabel("ID a editar:");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(41, 115, 83, 14);
		panel.add(lblID);
		
		
		JButton btnAltaRol = new JButton("Cargar");
		btnAltaRol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rol r = new Rol();
				if(textNomRol.getText().equals("")  || textDescripcion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios");
				}else {
					r.setNombre(textNomRol.getText()) ;
					r.setDescripcion(textDescripcion.getText());
					
					if(DAORol.CargarRol(r)) {
						JOptionPane.showMessageDialog(null, "Se agrego el rol correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar el rol");
					}
				}
			}
		});
		btnAltaRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaRol.setBounds(486, 76, 132, 23);
		contentPane.add(btnAltaRol);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rol r = new Rol();
				if(textNomRol.getText().equals("")  || textDescripcion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios");
				}else {
					r.setNombre(textNomRol.getText()) ;
					r.setDescripcion(textDescripcion.getText());
					
					Rol r2 = new Rol();
					r2 = DAORol.BuscarRolId(comboRol.getSelectedItem().toString());
					r.setId(r2.getId());
					
					if(DAORol.edit(r)) {
						JOptionPane.showMessageDialog(null, "Se modifico el rol correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo modificar el rol");
					}
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(486, 124, 132, 23);
		contentPane.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rol r = new Rol();
				r = null;
				if(!textNomRol.getText().equals("")) {
					r = DAORol.BuscarRolPorNombre(textNomRol.getText());
					
					if(r.getId() != 0) {
						textNomRol.setText(r.getNombre());
						textDescripcion.setText(r.getDescripcion());
					}else {
						JOptionPane.showMessageDialog(null, "No se encontró un rol con esos datos");
						
						Limpiar();
					}}
				}
			});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(486, 30, 132, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textNomRol.getText().equals("")) {
					if(DAORol.delete(textNomRol.getText())){
						JOptionPane.showMessageDialog(null, "Se elimino el rol");
					}else {
						JOptionPane.showMessageDialog(null, "No hay un rol con ese nombre");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
				}	
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(486, 169, 132, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblError = new JLabel("...");
		lblError.setBounds(486, 203, 49, 14);
		contentPane.add(lblError);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(-29, 254, 810, 166);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 26, 748, 129);
		panel_1.add(scrollPane);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				((DefaultTableModel) table.getModel()).setNumRows(0);

				for (Rol r : DAORol.ListarRol()) {

					
					Object[] fila = new Object[3];
					
					fila[0] = String.valueOf(r.getId());
					fila[1] = String.valueOf(r.getNombre());
					fila[2] = String.valueOf(r.getDescripcion());

					((DefaultTableModel) table.getModel()).addRow(fila);

				}
				
				
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(43, 202, 132, 23);
		contentPane.add(btnListar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_ROL", "NOMBRE", "DESCRIPCION"
			}
		));
		scrollPane.setViewportView(table);
	}

	public void cargarIdRol(List<Rol> listarRol) {
	
		for(Rol r : listarRol) {
			comboRol.addItem(String.valueOf(r.getId()));
		}
		
	}
	
	public void Limpiar() {
		textNomRol.setText("");
		textDescripcion.setText("");
		}
}

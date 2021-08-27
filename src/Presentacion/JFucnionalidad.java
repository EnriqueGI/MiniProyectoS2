package Presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import Logica.Funcionalidad;
import Logica.Persona;
import Persistencia.DAOFuncionalidades;
import Persistencia.DAOPersona;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFucnionalidad {

	private JFrame frame;
	private JTable table;

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
		frame.setBounds(100, 100, 892, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton Buscar = new JButton("Buscar");
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Buscar.setBounds(672, 35, 89, 23);
		frame.getContentPane().add(Buscar);

		JButton Modificar = new JButton("Modificar");
		Modificar.setBounds(672, 80, 89, 23);
		frame.getContentPane().add(Modificar);

		JButton Eliminar = new JButton("Eliminar");
		Eliminar.setBounds(672, 130, 89, 23);
		frame.getContentPane().add(Eliminar);

		JButton Agregar = new JButton("Agregar");
		Agregar.setBounds(672, 175, 89, 23);
		frame.getContentPane().add(Agregar);

		JButton listarFuncionalidades = new JButton("Listar Funcionalidades");
		listarFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((DefaultTableModel) table.getModel()).setNumRows(0);

				for (Funcionalidad p : DAOFuncionalidades.findAll()) {

					Object[] fila = new Object[3];

					fila[0] = String.valueOf(p.getId());
					fila[1]	=String.valueOf(p.getNombre());
					fila[2] = String.valueOf(p.getDescripcion());
			

					((DefaultTableModel) table.getModel()).addRow(fila);

				}
			}
		});
		listarFuncionalidades.setBounds(294, 175, 164, 23);
		frame.getContentPane().add(listarFuncionalidades);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(28, 228, 810, 166);
		frame.getContentPane().add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 26, 748, 129);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Descripci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);

		Buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                Funcionalidad f = new Funcionalidad();
				String nombre_1 = JOptionPane.showInputDialog("Nombre: ");
				f = DAOFuncionalidades.findFuncionalidad(nombre_1);

				((DefaultTableModel) table.getModel()).setNumRows(0);

				

					Object[] fila = new Object[7];

					fila[0] = String.valueOf(f.getId());
					fila[1]	=String.valueOf(f.getNombre());
					fila[2] = String.valueOf(f.getDescripcion());
			

					((DefaultTableModel) table.getModel()).addRow(fila);

				
				

			}

		});

		Agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nombre = JOptionPane.showInputDialog("Nombre de la Funcionalidad: ");
				String descripcion = JOptionPane.showInputDialog("Descripcion de la Funcionalidad: ");

				Funcionalidad g = new Funcionalidad(nombre, descripcion);

				if (DAOFuncionalidades.insert(g)) {
					JOptionPane.showMessageDialog(null, "Se agregó la funcionalidad");

				} else {
					JOptionPane.showMessageDialog(null, "No se puedo agregar la funcionalidad");
				}
			}
		});

		Modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Id de la funcionalidad a modificar: ");
				
				int idElininar = Integer.parseInt(id);
				String nombre = JOptionPane.showInputDialog("Nuevo nombre de la Funcionalidad: ");
				String descripcion = JOptionPane.showInputDialog("Nueva descripcion de la Funcionalidad: ");

				Funcionalidad f = new Funcionalidad();
				
				f.setId(idElininar);
				f.setNombre(nombre);
				f.setDescripcion(descripcion);

				if (DAOFuncionalidades.edit(f)) {
					JOptionPane.showMessageDialog(null, "Se actualizó la funcionalidad");
				} else {
					JOptionPane.showMessageDialog(null, "No se puedo actualizar la funcionalidad");
				}
			}
		});
		Eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nombre = JOptionPane.showInputDialog("ID de la Persona a la Cual se Desea Eliminar: ");

			

				if (DAOFuncionalidades.delete(nombre)) {
					JOptionPane.showMessageDialog(null, "Se eliminó la funcionalidad");
				} else {
					JOptionPane.showMessageDialog(null, " la funcionalidad");
				}
			}
		});

	}
}
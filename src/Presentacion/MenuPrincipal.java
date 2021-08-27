package Presentacion;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.DAORol;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class MenuPrincipal extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 647);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Menu.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.menu);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JfPersona fP = new JfPersona();
			    fP.cargarRoles(DAORol.ListarRol());
			    fP.cargarComboFecha();
				
				fP.setVisible(true);
			
				
				
			}
		});
		panel.setBackground(UIManager.getColor("MenuItem.background"));
		panel.setBounds(83, 200, 241, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personas");
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel.setBounds(49, 96, 115, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.menu);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jfRol fr = new jfRol();
				
				fr.setVisible(true);
			}
		});
		panel_1.setBackground(UIManager.getColor("MenuItem.background"));
		panel_1.setLayout(null);
		panel_1.setBounds(399, 200, 241, 202);
		contentPane.add(panel_1);
		
		JLabel lblVentas = new JLabel("Roles");
		lblVentas.setForeground(SystemColor.activeCaptionText);
		lblVentas.setBackground(Color.WHITE);
		lblVentas.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblVentas.setBounds(68, 96, 115, 30);
		panel_1.add(lblVentas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.menu);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFucnionalidad window = new JFucnionalidad();
				window.main(null);
			
				
				
				
			}
		});
		panel_2.setBackground(UIManager.getColor("MenuItem.background"));
		panel_2.setLayout(null);
		panel_2.setBounds(700, 200, 252, 202);
		contentPane.add(panel_2);
		
		JLabel lblCompras = new JLabel("Funcionalidades");
		lblCompras.setForeground(SystemColor.activeCaptionText);
		lblCompras.setBackground(Color.WHITE);
		lblCompras.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblCompras.setBounds(31, 96, 170, 45);
		panel_2.add(lblCompras);
	}
}

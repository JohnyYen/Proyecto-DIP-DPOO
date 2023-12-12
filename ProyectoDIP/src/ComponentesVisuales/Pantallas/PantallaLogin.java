package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ComponentesVisuales.Componentes.Boton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Logica.*;

public class PantallaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private Juego miJuego;
	
	public PantallaLogin(Juego juego) {
		this.miJuego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 253);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/FondoMenuPrincipal.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(91, 23, 80, 14);
		contentPane.add(lblUsuario);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(101, 104, 165, 20);
		contentPane.add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(101, 48, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:  ");
		lblContrasea.setBounds(91, 79, 88, 14);
		contentPane.add(lblContrasea);
		
		Boton botonSalir = new Boton("Salir", 100, 100, 50, 50);
		botonSalir.setSize(117, 34);
		botonSalir.setLocation(113, 151);
		contentPane.add(botonSalir);
		
		Boton botonLogin = new Boton("Login", 100, 100, 50, 50);
		botonLogin.setSize(100, 34);
		botonLogin.setLocation(240, 151);
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaProfesores profesores = new PantallaProfesores(miJuego);
				dispose();
				profesores.setVisible(true);
			}
		});
		contentPane.add(botonLogin);
		
		//Boton botonCrearUsuario = new Boton("Crear Usuario", 100, 200, 100, 100);
		//contentPane.add(botonCrearUsuario);
	}
}

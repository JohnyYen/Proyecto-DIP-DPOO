package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(36, 11, 112, 29);
		contentPane.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(36, 72, 112, 29);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(36, 112, 164, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(36, 41, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Boton botonCrear = new Boton("Crear Usuario", 150, 150, 70, 70);
		botonCrear.setBounds(20, 163, 199, 37);
		contentPane.add(botonCrear);
		
		Boton botonCancelar = new Boton("Cancelar", 150, 150, 100, 100);
		botonCancelar.setBounds(229, 163, 150, 37);
		contentPane.add(botonCancelar);
		
		
	}
}

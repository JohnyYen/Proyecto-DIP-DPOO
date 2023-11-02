package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_1;
	private JTextField textField;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(57, 23, 80, 14);
		contentPane.add(lblUsuario);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(57, 104, 165, 20);
		contentPane.add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(57, 48, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:  ");
		lblContrasea.setBounds(57, 79, 88, 14);
		contentPane.add(lblContrasea);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaProfesores profesores = new PantallaProfesores();
				profesores.setVisible(true);
			}
		});
		btnLogin.setBounds(178, 135, 68, 23);
		contentPane.add(btnLogin);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(100, 135, 68, 23);
		contentPane.add(btnSalir);
	}
}

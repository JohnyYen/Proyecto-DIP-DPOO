package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import Logica.Juego;
import Logica.Validacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario(juego);
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
	public CrearUsuario(Juego juego) {
		this.juego = juego;
		final Validacion validacion = new Validacion();
		
		setTitle("Hello World!: Crear Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 38, 79, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(37, 63, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(37, 116, 100, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 144, 185, 20);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBounds(28, 188, 109, 23);
		contentPane.add(rdbtnProfesor);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] texto = passwordField.getPassword();
				boolean correcto = validacion.esValidaContrasenia(texto);
				if(correcto && validacion.esUsuarioCorrecto(textField.getText())){
					juego.crearUsuario()
				}
				else{
					System.out.println("Noooooo");
				}
			
			}
		});
		btnCrearUsuario.setBounds(252, 188, 115, 34);
		contentPane.add(btnCrearUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(142, 188, 100, 34);
		contentPane.add(btnCancelar);
	}
}

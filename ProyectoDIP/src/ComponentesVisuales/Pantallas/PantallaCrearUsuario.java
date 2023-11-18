package ComponentesVisuales.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import Logica.Juego;
import Logica.Validacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ComponentesVisuales.Componentes.BotonExtendido;

import java.awt.Font;

public class PantallaCrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Juego miJuego;

	
	public PantallaCrearUsuario(final Juego juego) {
		setTitle("Hello World! : Crear Usuario");
		this.miJuego = juego;
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
		
		final JRadioButton profesor = new JRadioButton("Profesor");
		profesor.setBounds(28, 188, 109, 23);
		contentPane.add(profesor);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(142, 188, 100, 34);
		contentPane.add(btnCancelar);
		
		BotonExtendido btnxtndCrearUsuario = new BotonExtendido();
		btnxtndCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] texto = passwordField.getPassword();
				boolean correcto = validacion.esValidaContrasenia(texto);
				if(validacion.esUsuarioCorrecto(textField.getText())){
					if(profesor.isSelected()){
						miJuego.crearUsuario(textField.getText(), "Pasworrd", true);
						PantallaProfesores frame = new PantallaProfesores(miJuego);
						dispose();
						frame.setVisible(true);
					}
					else{
						miJuego.crearUsuario(textField.getText(), "Pasworrd", true);
						MenuPrincipal frame = new MenuPrincipal(miJuego);
						dispose();
						frame.setVisible(true);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Error en la creación de usuario, la contraseña tiene que minimo dos números, una letra mayúscula, y tres letras minúscuñas");
				}
			}
		});
		btnxtndCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnxtndCrearUsuario.setText("Crear Usuario");
		btnxtndCrearUsuario.setBounds(252, 188, 172, 34);
		contentPane.add(btnxtndCrearUsuario);
	}
}

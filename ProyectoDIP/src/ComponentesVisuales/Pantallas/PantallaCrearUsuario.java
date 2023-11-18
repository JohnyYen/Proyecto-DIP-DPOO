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
		setBounds(100, 100, 487, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 11, 79, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(20, 36, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 67, 100, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 95, 185, 20);
		contentPane.add(passwordField);
		
		final JRadioButton profesor = new JRadioButton("Profesor");
		profesor.setBounds(21, 143, 109, 23);
		contentPane.add(profesor);
		
		BotonExtendido btnxtndCrearUsuario = new BotonExtendido();
		btnxtndCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacion.esUsuarioCorrecto(textField.getText()) && validacion.esValidaContrasenia(passwordField.getText().toCharArray())){
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
<<<<<<< HEAD
					JOptionPane.showMessageDialog(null, "Error en la creación de usuario, la contraseña tiene\n que tener minimo dos números, una letra mayúscula, y tres letras minúsculas, y el nombre\n de Usuario tiene que tener mínimo dos carácteres");
=======
					JOptionPane.showMessageDialog(null, "Error en la creación de usuario, el usuario debe tener al menos tres caracteres y la contraseña tiene que tener minimo dos números, una letra mayúscula, y tres letras minúsculas");
>>>>>>> f12298cc8df6e83354aaa2fb5a81a7023d0010e8
				}
			}
		});
		btnxtndCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnxtndCrearUsuario.setText("Crear Usuario");
		btnxtndCrearUsuario.setBounds(223, 188, 238, 34);
		contentPane.add(btnxtndCrearUsuario);
		
		JLabel lblEresProfesor = new JLabel("Eres Profesor:");
		lblEresProfesor.setBounds(20, 122, 110, 14);
		contentPane.add(lblEresProfesor);
		
		BotonExtendido btnxtndCancelar = new BotonExtendido();
		btnxtndCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnxtndCancelar.setText("Cancelar");
		btnxtndCancelar.setBounds(10, 188, 216, 34);
		contentPane.add(btnxtndCancelar);
	}
}

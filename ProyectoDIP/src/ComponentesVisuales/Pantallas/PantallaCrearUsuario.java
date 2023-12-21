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
import javax.swing.Timer;

import Logica.Juego;
import Logica.Validacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ComponentesVisuales.Componentes.BotonExtendido;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaCrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Juego miJuego;
	private boolean tocado = false, toca = false;

	
	public PantallaCrearUsuario(final Juego juego) {
		setTitle("Hello World! : Crear Usuario");
		this.miJuego = juego;
		final Validacion validacion = new Validacion();
		
		setTitle("Hello World!: Crear Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 487, 300);
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(20, 11, 79, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setText("Escribe tu nombre de usuario");
		textField.setEditable(false);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!toca){
					textField.setText("");
					textField.setEditable(true);
					toca = true;
				}
			}
		});
		textField.setBounds(20, 36, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(20, 67, 100, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!tocado){
					passwordField.setEchoChar('\u2022');
					passwordField.setText("");
					passwordField.setEditable(true);
					tocado = true;
				}
			}
		});
		passwordField.setText("Introduce la contraseña");
		passwordField.setEditable(false);
		passwordField.setEchoChar('\u0000');
		passwordField.setBounds(20, 95, 185, 20);
		contentPane.add(passwordField);
		
		final JRadioButton profesor = new JRadioButton("Profesor");
		profesor.setForeground(Color.WHITE);
		profesor.setBorderPainted(false);
		profesor.setFocusPainted(false);
		profesor.setContentAreaFilled(false);
		profesor.setBounds(21, 143, 109, 23);
		contentPane.add(profesor);
		
		BotonExtendido btnxtndCrearUsuario = new BotonExtendido();
		btnxtndCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacion.esUsuarioCorrecto(textField.getText()) && validacion.esValidaContrasenia(passwordField.getText().toCharArray())){
					if(profesor.isSelected()){
						miJuego.crearUsuario(textField.getText(), passwordField.getText(), true);
						PantallaProfesores frame = new PantallaProfesores(miJuego);
						dispose();
						frame.setVisible(true);
					}
					else{
						miJuego.crearUsuario(textField.getText(), passwordField.getText(), false);
						MenuPrincipal frame = new MenuPrincipal(miJuego);
						
						dispose();
						frame.setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Error en la creación de usuario, la contraseña tiene\n que tener minimo dos números, una letra mayúscula, y tres letras minúsculas, y el nombre\n de Usuario tiene que tener mínimo dos carácteres");
				}
			}
		});
		btnxtndCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnxtndCrearUsuario.setText("Crear Usuario");
		btnxtndCrearUsuario.setBounds(223, 188, 238, 34);
		contentPane.add(btnxtndCrearUsuario);
		
		JLabel lblEresProfesor = new JLabel("Eres Profesor:");
		lblEresProfesor.setForeground(Color.WHITE);
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
		
		JButton btnNewButton = new JButton("ver");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setEchoChar('\u0000');
				Timer timer = new Timer(500, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						passwordField.setEchoChar('\u2022');
					}
				});
				timer.start();
			}
		});
		btnNewButton.setBounds(223, 92, 62, 23);
		contentPane.add(btnNewButton);
	}
}

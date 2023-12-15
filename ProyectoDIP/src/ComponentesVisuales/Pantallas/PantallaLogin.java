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
import javax.swing.Timer;

import ComponentesVisuales.Componentes.Boton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Logica.*;

import java.awt.Color;

import ComponentesVisuales.Componentes.BotonExtendido;

public class PantallaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField textField;
	private Juego miJuego;
	
	public PantallaLogin(Juego juego) {
		this.miJuego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 510, 300);
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
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(91, 23, 80, 14);
		contentPane.add(lblUsuario);
		
		password = new JPasswordField();
		password.setBounds(101, 104, 165, 20);
		contentPane.add(password);
		
		textField = new JTextField();
		textField.setBounds(101, 48, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:  ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(91, 79, 88, 14);
		contentPane.add(lblContrasea);
		
		BotonExtendido btnxtndLogin = new BotonExtendido();
		btnxtndLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(miJuego.getUsuario().getNombreUsuario()) && password.getText().equals(miJuego.getUsuario().getPassword())){
					dispose();
					if(miJuego.getUsuario().getEsProfesor()){
						
						PantallaProfesores frame = new PantallaProfesores(miJuego);
						frame.setVisible(true);
					}
					else{
						MenuPrincipal frame = new MenuPrincipal(miJuego);
						frame.setVisible(true);
					}
				}
			}
		});
		btnxtndLogin.setText("Login");
		btnxtndLogin.setBounds(253, 190, 231, 32);
		contentPane.add(btnxtndLogin);
		
		BotonExtendido btnxtndSalir = new BotonExtendido();
		btnxtndSalir.setText("Salir");
		btnxtndSalir.setBounds(10, 190, 233, 32);
		contentPane.add(btnxtndSalir);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password.setEchoChar('\u0000');
				Timer timer = new Timer(500, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						password.setEchoChar('*');;
					}
				});
				timer.start();
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(276, 103, 24, 23);
		contentPane.add(btnNewButton);
		
	}
}

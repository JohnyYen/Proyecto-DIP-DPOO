package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.Boton;
import Recursos.CustomFont;
import ComponentesVisuales.Componentes.BotonExtendido;
import ComponentesVisuales.Componentes.BarraMenu;

public class PantallaProfesores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonExtendido botonSalir;
	private JLabel titulo;
	
	public PantallaProfesores() {
		setTitle("Hello World!: Modo Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		
		BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nueva Fuente
		CustomFont cf = new CustomFont();
		
		titulo = new JLabel("Hello World!");
		titulo.setBounds(236, 106, 415, 101);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(cf.MyFont(1, 50));
		contentPane.add(titulo);
		
		BotonExtendido botonEditar = new BotonExtendido();
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaModificaciones frame = new PantallaModificaciones();
				dispose();
				frame.setVisible(true);
			}
		});
		botonEditar.setText("Editar Niveles");
		botonEditar.setBounds(290, 203, 241, 40);
		contentPane.add(botonEditar);
		
		botonSalir = new BotonExtendido();
		botonSalir.setText("Salir");
		botonSalir.setBounds(290, 254, 241, 40);
		contentPane.add(botonSalir);
		
		
	}
}

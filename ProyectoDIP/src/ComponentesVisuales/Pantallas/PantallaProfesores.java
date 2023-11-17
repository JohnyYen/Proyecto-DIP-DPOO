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

public class PantallaProfesores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PantallaProfesores() {
		setTitle("Hello World!: Modo Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nueva Fuente
		CustomFont cf = new CustomFont();
		
		JLabel titulo = new JLabel("Hello World!");
		titulo.setBounds(158, 72, 188, 39);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(cf.MyFont(1, 50));
		titulo.setBounds(183, 104, 348, 101);
		contentPane.add(titulo);
		
		BotonExtendido btnxtndEditarNiveles = new BotonExtendido();
		btnxtndEditarNiveles.setText("Editar Niveles");
		btnxtndEditarNiveles.setBounds(128, 216, 209, 28);
		contentPane.add(btnxtndEditarNiveles);
		
		
	}
}

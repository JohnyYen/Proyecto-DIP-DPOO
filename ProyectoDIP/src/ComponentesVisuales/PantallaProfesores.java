package ComponentesVisuales;

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

public class PantallaProfesores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PantallaProfesores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Boton editarNiveles = new Boton("Editar Niveles", 200,200, 10, 10);
		editarNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaModificaciones tabla = new TablaModificaciones();
				dispose();
				tabla.setVisible(true);
			}
		});
		editarNiveles.setBounds(158, 179, 204, 39);
		contentPane.add(editarNiveles);
		
		Boton verEstudiantes = new Boton("Ver Estudiantes", 200,200, 10, 60);
		verEstudiantes.setBounds(148, 229, 214, 39);
		contentPane.add(verEstudiantes);
		
		//Nueva Fuente
		CustomFont cf = new CustomFont();
		
		JLabel titulo = new JLabel("Hello World!");
		titulo.setBounds(158, 72, 188, 39);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(cf.MyFont(1, 50));
		titulo.setBounds(183, 104, 348, 101);
		contentPane.add(titulo);
		
		
	}

	
	
}

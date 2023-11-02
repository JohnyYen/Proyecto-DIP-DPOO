package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaProfesores extends JFrame {

	private JPanel contentPane;
	
	public PantallaProfesores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Boton editarNiveles = new Boton("Editar Niveles", 250,250, 10, 10);
		editarNiveles.setBounds(148, 110, 204, 39);
		contentPane.add(editarNiveles);
		
		Boton verEstudiantes = new Boton("Ver Estudiantes", 250,250, 10, 60);
		verEstudiantes.setBounds(148, 160, 214, 39);
		contentPane.add(verEstudiantes);
	}

	
	
}

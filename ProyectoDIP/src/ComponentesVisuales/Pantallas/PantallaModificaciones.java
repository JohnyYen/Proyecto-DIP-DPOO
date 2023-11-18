package ComponentesVisuales.Pantallas;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import Logica.Juego;
import Util.PreguntaNivelUno;
import Util.PreguntaTableModel;
import Util.PreguntaTableModelSegundoNivel;

import javax.swing.JScrollPane;

import ComponentesVisuales.Componentes.BotonExtendido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaModificaciones extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JTable tablaNivelDos;
	private Juego miJuego;
	
	public PantallaModificaciones(Juego juego) {
		
		this.miJuego = juego;
		setTitle("Hello World!: Editar Niveles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 900, 563);
		contentPane.add(tabbedPane);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Nivel 1", null, scrollPane, null);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		PreguntaTableModel model = new PreguntaTableModel();
		tabla.setModel(model);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Nivel 2", null, scrollPane_1, null);
		
		tablaNivelDos = new JTable();
		scrollPane_1.setViewportView(tablaNivelDos);
		PreguntaTableModelSegundoNivel modelNivelDos = new PreguntaTableModelSegundoNivel();
		tablaNivelDos.setModel(modelNivelDos);
		
		BotonExtendido btnxtndVolver = new BotonExtendido();
		btnxtndVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaProfesores frame = new PantallaProfesores(miJuego);
				dispose();
				frame.setVisible(true);
			}
		});
		btnxtndVolver.setText("Volver");
		btnxtndVolver.setBounds(551, 585, 289, 50);
		contentPane.add(btnxtndVolver);
	}
}

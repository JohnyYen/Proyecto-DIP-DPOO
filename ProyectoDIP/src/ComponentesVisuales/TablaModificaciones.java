package ComponentesVisuales;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import Util.PreguntaNivelUno;
import Util.PreguntaTableModel;

import javax.swing.JScrollPane;

public class TablaModificaciones extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable tabla;

	public static void main(String[] args){
		TablaModificaciones t = new TablaModificaciones();
		t.setVisible(true);
	}
	public TablaModificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 900, 600);
		contentPane.add(tabbedPane);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Nivel 1", null, scrollPane, null);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		PreguntaTableModel model = new PreguntaTableModel();
		tabla.setModel(model);	
		
		Nivel3Editar nivel3 = new Nivel3Editar();
		tabbedPane.add("Nivel 3", nivel3);
		
		EditarNivel4 nivel4 = new EditarNivel4();
		nivel4.setVisible(true);
		JScrollPane scroll4 = new JScrollPane();
		scroll4.setViewportView(nivel4);
		tabbedPane.add("Nivel 4", scroll4);
	}
}

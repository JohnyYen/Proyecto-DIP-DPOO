package ComponentesVisuales;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import Util.PreguntaTableModel;

public class TablaModificaciones extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPreguntas;

	public static void main(String[] args){
		TablaModificaciones t = new TablaModificaciones();
		t.setVisible(true);
	}
	public TablaModificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		tablaPreguntas = new JTable();
		PreguntaTableModel model = new PreguntaTableModel();
		tablaPreguntas.setModel(model);
		tabbedPane.add("Nivel 1", tablaPreguntas);
	}
}

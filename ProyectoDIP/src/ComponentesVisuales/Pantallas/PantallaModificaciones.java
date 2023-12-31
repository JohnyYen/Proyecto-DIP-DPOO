package ComponentesVisuales.Pantallas;

import java.awt.ScrollPane;
import Util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import Logica.*;
import Util.PreguntaTableModel;
import Util.PreguntaTableModelSegundoNivel;
import javax.swing.JScrollPane;
import ComponentesVisuales.Componentes.BotonExtendido;
import ComponentesVisuales.Componentes.EditarNivel3;
import ComponentesVisuales.Componentes.EditarNivel4;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PantallaModificaciones extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Validacion validacion;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JTable tablaNivelDos;
	private Juego miJuego;
	private PreguntaTableModel model;
	
	public PantallaModificaciones(Juego juego) {
		validacion = new Validacion();
		this.miJuego = juego;
		setTitle("Hello World!: Editar Niveles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 11, 864, 556);
		contentPane.add(tabbedPane);
		
		
		//Editar Nivel Uno
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0, 0, 102));
		tabbedPane.addTab("Nivel 1", null, scrollPane, null);
		
		tabla = new JTable();
		tabla.setSelectionForeground(Color.WHITE);
		tabla.setSelectionBackground(new Color(0, 0, 102));
		tabla.setForeground(Color.WHITE);
		tabla.setBackground(new Color(0, 0, 153));
		scrollPane.setViewportView(tabla);
		model = new PreguntaTableModel(miJuego.getInformacionJuego().getPreguntasNivelUno());
		tabla.setModel(model);
		
		
		//Editar Nivel Dos
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Nivel 2", null, scrollPane_1, null);
		
		tablaNivelDos = new JTable();
		tablaNivelDos.setSelectionForeground(new Color(255, 255, 255));
		tablaNivelDos.setSelectionBackground(new Color(0, 0, 204));
		tablaNivelDos.setForeground(Color.WHITE);
		tablaNivelDos.setBackground(new Color(0, 0, 153));
		scrollPane_1.setViewportView(tablaNivelDos);
		final PreguntaTableModelSegundoNivel modelNivelDos = new PreguntaTableModelSegundoNivel(miJuego.getInformacionJuego().getPreguntasNivelDos());
		tablaNivelDos.setModel(modelNivelDos);
		
		//Editar Nivel Tres
		final EditarNivel3 editarTres = new EditarNivel3(miJuego.getInformacionJuego().getCartas());
		tabbedPane.addTab("Nivel 3",editarTres);
		
		//Editar Nivel Cuatro
		final EditarNivel4 editarCuatro = new EditarNivel4(miJuego.getInformacionJuego().getObjetos());
		tabbedPane.addTab("Nivel 4",editarCuatro);
		
		BotonExtendido Volver = new BotonExtendido();
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(contentPane, "Estas seguro que vas a salir? Los cambios sin guardar se van a perder", "Confirmaci�n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					PantallaProfesores frame = new PantallaProfesores(miJuego);
					dispose();
					frame.setVisible(true);
				}
				
			}
		});
		Volver.setText("Volver");
		Volver.setBounds(551, 585, 289, 50);
		contentPane.add(Volver);
		
		BotonExtendido Guardar = new BotonExtendido();
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacion.casillasVaciasEnTablas(model, modelNivelDos) && validacion.validarCarta(editarTres.getNuevasCartas())){
					miJuego.getInformacionJuego().setPreguntasNivelUno(model.getPreguntas());
					miJuego.getInformacionJuego().setPreguntasNivelDos(modelNivelDos.getPreguntas());
					miJuego.getInformacionJuego().setCartas(editarTres.getNuevasCartas());
					miJuego.getInformacionJuego().setObjetos(editarCuatro.getNuevosObjetos());
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error en la edici�n de alg�n nivel, REVISE BIEN!");
				}
			}
		});
		Guardar.setText("Guardar");
		Guardar.setBounds(288, 585, 225, 38);
		contentPane.add(Guardar);
	}
}

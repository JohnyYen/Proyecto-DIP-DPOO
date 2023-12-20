package ComponentesVisuales.Componentes;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.glass.ui.Menu;

import ComponentesVisuales.Niveles.CuartoNivel;
import ComponentesVisuales.Niveles.PrimerNivel;
import ComponentesVisuales.Niveles.SegundoNivel;
import ComponentesVisuales.Niveles.TercerNivel;
import ComponentesVisuales.Pantallas.MenuPrincipal;
import ComponentesVisuales.Pantallas.PantallaProfesores;
import Logica.Juego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarraMenu extends JMenuBar{
	private static JFrame frame;
	private static Juego juego;
	private static JFrame actual;
	public BarraMenu() {
		
		JMenu menuOpciones = new JMenu("Opciones");
		JMenu menuNiveles = new JMenu("Niveles");
		JMenu menuPuntuaciones = new JMenu("Puntuaciones");
		JMenu menuEditar = new JMenu("Editar Niveles");
		JMenu menuEspecial = new JMenu("Acceso Especial");
		
		this.add(menuOpciones);
		this.add(menuNiveles);
		this.add(menuPuntuaciones);
		this.add(menuEditar);
		this.add(menuEspecial);
		
		JMenuItem guardarPartida = new JMenuItem("Guardar Partida");
		guardarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frame instanceof MenuPrincipal){
					MenuPrincipal.guardarEstado(actual);
				}
				else if (frame instanceof PantallaProfesores){
					PantallaProfesores.guardarEstado(actual);
				}
			}
		});
		//JMenuItem configuraciones = new JMenuItem("Configuraciones");
		JMenuItem volver = new JMenuItem("Volver a Menú");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame menu = null;
				if(frame instanceof MenuPrincipal){
					menu = new MenuPrincipal(juego);
					
				}
				else if (frame instanceof PantallaProfesores){
					menu = new PantallaProfesores(juego);
					
				}
				actual.dispose();
				menu.setVisible(true);
			}
		});
		JMenu resolucion = new JMenu("Resolucion");
		JMenuItem baja = new JMenuItem("800x600");
		JMenuItem media = new JMenuItem("1024x758");
		JMenuItem alta = new JMenuItem("1280x720");
		
		resolucion.add(baja);
		resolucion.add(media);
		resolucion.add(alta);
		menuOpciones.add(guardarPartida);
		menuOpciones.add(volver);
		menuOpciones.add(resolucion);
		
		
		JMenuItem itemNivelUno = new JMenuItem("Nivel 1");
		itemNivelUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
				PrimerNivel item = new PrimerNivel(juego);
				item.setVisible(true);
			}
		});
		JMenuItem itemNivelDos = new JMenuItem("Nivel 2");
		itemNivelDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
				SegundoNivel item = new SegundoNivel(juego);
				item.setVisible(true);
			}
		});
		JMenuItem itemNivelTres = new JMenuItem("Nivel 3");
		itemNivelTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
				TercerNivel item = new TercerNivel(juego);
				item.setVisible(true);
			}
		});
		JMenuItem itemNivelCuatro = new JMenuItem("Nivel 4");
		itemNivelCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
				CuartoNivel item = new CuartoNivel(juego);
				item.setVisible(true);
			}
		});
		
		if(frame instanceof PantallaProfesores){
			itemNivelUno.setEnabled(true);
			itemNivelDos.setEnabled(true);
			itemNivelTres.setEnabled(true);
			itemNivelCuatro.setEnabled(true);
		}
		else{
			itemNivelUno.setEnabled(false);
			itemNivelDos.setEnabled(false);
			itemNivelTres.setEnabled(false);
			itemNivelCuatro.setEnabled(false);
		}
		
		
		menuNiveles.add(itemNivelUno);
		menuNiveles.add(itemNivelDos);
		menuNiveles.add(itemNivelTres);
		menuNiveles.add(itemNivelCuatro);
		
		JMenuItem puntuacionNivelUno = new JMenuItem("Score Nivel 1");
		JMenuItem puntuacionNivelDos = new JMenuItem("Score Nivel 2");
		JMenuItem puntuacionNivelTres = new JMenuItem("Score Nivel 3");
		JMenuItem puntuacionNivelCuatro = new JMenuItem("Score Nivel 4");
		
		menuPuntuaciones.add(puntuacionNivelUno);
		menuPuntuaciones.add(puntuacionNivelDos);
		menuPuntuaciones.add(puntuacionNivelTres);
		menuPuntuaciones.add(puntuacionNivelCuatro);
		
		JMenuItem editarNivelUno = new JMenuItem("Editar Nivel 1");
		JMenuItem editarNivelDos = new JMenuItem("Editar Nivel 2");
		JMenuItem editarNivelTres = new JMenuItem("Editar Nivel 3");
		JMenuItem editarNivelCuatro = new JMenuItem("Editar Nivel 4");
		
		menuEditar.add(editarNivelUno);
		menuEditar.add(editarNivelDos);
		menuEditar.add(editarNivelTres);
		menuEditar.add(editarNivelCuatro);
		
		JMenuItem accessoAdmin = new JMenuItem("Acceso Admin");
		accessoAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaProfesores p = new PantallaProfesores(juego);
				actual.dispose();
				p.setVisible(true);
			}
		});
		menuEspecial.add(accessoAdmin);
	}
	
	public static void guardarFrameActual(JFrame windows){
		frame = windows;
	}
	public static void guardarEstadoActual(JFrame jf){
		actual = jf;
	}
	public static void guardarJuegoActual(Juego game){juego = game;}
}

package ComponentesVisuales.Componentes;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenu extends JMenuBar{
	public BarraMenu() {
		
		JMenu menuOpciones = new JMenu("Opciones");
		JMenu menuNiveles = new JMenu("Niveles");
		JMenu menuPuntuaciones = new JMenu("Puntuaciones");
		JMenu menuEditar = new JMenu("Editar Niveles");
		
		this.add(menuOpciones);
		this.add(menuNiveles);
		this.add(menuPuntuaciones);
		this.add(menuEditar);		
		
		JMenuItem guardarPartida = new JMenuItem("Guardar Partida");
		JMenuItem configuraciones = new JMenuItem("Configuraciones");
		JMenuItem volver = new JMenuItem("Volver a Menú");
		JMenu resolucion = new JMenu("Resolucion");
		JMenuItem baja = new JMenuItem("800x600");
		JMenuItem media = new JMenuItem("1024x758");
		JMenuItem alta = new JMenuItem("1280x720");
		
		resolucion.add(baja);
		resolucion.add(media);
		resolucion.add(alta);
		menuOpciones.add(guardarPartida);
		menuOpciones.add(configuraciones);
		menuOpciones.add(volver);
		menuOpciones.add(resolucion);
		
		
		JMenuItem itemNivelUno = new JMenuItem("Nive 1");
		JMenuItem itemNivelDos = new JMenuItem("Nivel 2");
		JMenuItem itemNivelTres = new JMenuItem("Nivel 3");
		JMenuItem itemNivelCuatro = new JMenuItem("Nivel 4");
		
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
	}

}

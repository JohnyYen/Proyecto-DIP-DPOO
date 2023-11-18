package ComponentesVisuales.Componentes;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelRespuestasNivelDos extends JLabel {
	private static final long serialVersionUID = 1L;
	private BotonExtendidoNivel2 opcion1, opcion2, opcion3;
	
	public LabelRespuestasNivelDos(){
		super();
		opcion1 = new BotonExtendidoNivel2();
		opcion2 = new BotonExtendidoNivel2();
		opcion3 = new BotonExtendidoNivel2();
		add(opcion1);
		add(opcion2);
		add(opcion3);
	}
}

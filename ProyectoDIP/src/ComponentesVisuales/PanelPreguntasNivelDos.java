package ComponentesVisuales;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanelPreguntasNivelDos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BotonExtendidoNivel2 opcion1, opcion2, opcion3;
	
	public PanelPreguntasNivelDos(){
		super();
		setLayout(null);
		
		opcion1 = new BotonExtendidoNivel2();
		opcion1.setBounds(55, 60, 495, 64);
		add(opcion1);
		
		opcion2 = new BotonExtendidoNivel2();
		opcion2.setBounds(55, 292, 495, 64);
		add(opcion2);
		
		opcion3 = new BotonExtendidoNivel2();
		opcion3.setBounds(66, 163, 495, 64);
		add(opcion3);
		
		
	}
	
	public BotonExtendidoNivel2 getOpcion1() {
		return opcion1;
	}

	public BotonExtendidoNivel2 getOpcion2() {
		return opcion2;
	}

	public BotonExtendidoNivel2 getOpcion3() {
		return opcion3;
	}

	public void paintComponent(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/CuadroDialogos.png"));
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
}

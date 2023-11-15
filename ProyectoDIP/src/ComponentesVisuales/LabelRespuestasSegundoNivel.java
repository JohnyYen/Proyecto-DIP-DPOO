package ComponentesVisuales;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import Logica.ControladorSegundoNivel;


public class LabelRespuestasSegundoNivel extends JLabel{
	private static final long serialVersionUID = 1L;
	private Boton opcion1, opcion2, opcion3;
	
	
	public LabelRespuestasSegundoNivel(ControladorSegundoNivel controlador, int x, int y, int ancho, int alto){
		//Crear los  botones
		int preguntaActual = controlador.getPreguntaActual();
		opcion1 = new Boton(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(0), 700, 450, 50,0);
		opcion2 = new Boton(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(1), 700, 450, 50, 100);
		opcion3 = new Boton(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(2), 700, 450, 50, 100);
		add(opcion1);
		add(opcion2);
		add(opcion3);
		this.setBounds(x,y,ancho,alto);
	}
	
	public void ponerRespuestas(ControladorSegundoNivel controlador) {
		int preguntaActual = controlador.getPreguntaActual();
		opcion1.setText(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(0));
		opcion2.setText(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(1));
		opcion3.setText(controlador.getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(2));
	}

	public Boton getOpcion1() {
		return opcion1;
	}
	
	public Boton getOpcion2() {
		return opcion2;
	}

	public Boton getOpcion3() {
		return opcion3;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image im = Toolkit.getDefaultToolkit().getImage("src/Recursos/CuadroDialogos.png");
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
}

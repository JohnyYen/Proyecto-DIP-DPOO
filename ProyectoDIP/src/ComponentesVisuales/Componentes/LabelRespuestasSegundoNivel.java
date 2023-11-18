package ComponentesVisuales.Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ComponentesVisuales.Componentes.Boton;
import Recursos.CustomFont;
import Util.Pregunta;

public class LabelRespuestasSegundoNivel extends JLabel{
	private static final long serialVersionUID = 1L;
	private Boton opcion1, opcion2, opcion3;
	
	
	public LabelRespuestasSegundoNivel(int x, int y, int ancho, int alto){
		//Crear los  botones
		opcion1 = new Boton("<html>Un bucle -for- siempre ejecuta un número fijo de iteraciones,<br> mientras que un bucle -while- depende de una condición.", 700, 450, 50,0);
		opcion2 = new Boton("<html>Un bucle -for- solo se utiliza para contar, mientras que un<br> bucle -while- se utiliza para otras tareas.", 700, 450, 50, 100);
		opcion3 = new Boton("<html>Un bucle -while- siempre ejecuta un número fijo de iteraciones,<br> mientras que un bucle -for- depende de una condición.", 700, 450, 50, 100);
		add(opcion1);
		add(opcion2);
		add(opcion3);
		this.setBounds(x,y,ancho,alto);
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

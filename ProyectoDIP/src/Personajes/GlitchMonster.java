package Personajes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GlitchMonster extends Villana{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GlitchMonster(int x, int y, int ancho, int alto, int cantVidas) {
		super(x, y, ancho, alto, cantVidas);
		// TODO Auto-generated constructor stub
	}

	public void setGlitchMonster(){
		super.dibujar(getGraphics(), "src/Recursos/");
		

	}
	
	public void dibujar(Graphics g, String url) {
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
	
	
	protected void paintComponent(Graphics g) {
		Image im = Toolkit.getDefaultToolkit().getImage("src/Recursos/");
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
	
}

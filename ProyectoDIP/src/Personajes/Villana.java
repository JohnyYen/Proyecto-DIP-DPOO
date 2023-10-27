package Personajes;

import java.awt.*;

public class Villana extends Personaje{
	
	private static final long serialVersionUID = 1L;
	
	public Villana(int x, int y, int ancho, int alto, int cantVidas){
		super(x, y, ancho, alto, cantVidas);
	}
	
	public void setVillanaNormal(){
		super.dibujar(getGraphics(), "src/Recursos/Villana1Normal.png");
		

	}
	
	public void dibujar(Graphics g, String url) {
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
	
	
	protected void paintComponent(Graphics g) {
		Image im = Toolkit.getDefaultToolkit().getImage("src/Recursos/EnemigoNormal.png");
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
	
}

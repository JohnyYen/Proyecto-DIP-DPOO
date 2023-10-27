package Personajes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Heroe extends Personaje {

	public Heroe(int x, int y, int ancho, int largo, int cantVida) {
		super(x,y,ancho,largo, cantVida);
	}
	
	protected void paintComponent(Graphics g) {
		Image im = Toolkit.getDefaultToolkit().getImage("src/Recursos/HeroeNormal.png");
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
}

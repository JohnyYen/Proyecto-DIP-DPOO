package Personajes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public abstract class Personaje extends JPanel {
	private static final long serialVersionUID = 1L;
	protected int cantVidas;
	
	public Personaje(int cantVidas) {
		this.cantVidas = cantVidas;
		this.setOpaque(false);
	}
	
	public void dibujar(Graphics g, String url) {
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
	
	
	public int getVidas(){return cantVidas;}
	public void perderVida(){cantVidas--;}
}

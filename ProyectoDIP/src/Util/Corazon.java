package Util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Corazon extends JPanel{
	private String urlLleno = "src/Recursos/CorazonLleno.png";
	private String urlVacio = "src/Recursos/CorazonVacio.png";
	
	public Corazon(){
		dibujar(this.getGraphics(), urlLleno);
	}
	
	public void setVacio(){
		dibujar(getGraphics(), urlVacio);
	}
	private void dibujar(Graphics g, String url) {
		Image im = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(im, 0, 0, 25, 25, this);
	}
}

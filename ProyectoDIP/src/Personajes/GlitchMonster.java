package Personajes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GlitchMonster extends Personaje{
	private ImageIcon imagen; 
	private static final long serialVersionUID = 1L;


	public GlitchMonster(int x, int y, int ancho, int alto, int cantVidas) {
		super(cantVidas);
	cantVidas = getCantVidas();
	ancho = 198;
	alto=178;
	x = 571;
	y = 380;
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
public int getCantVidas(){
	return cantVidas =3;
	
}
	
	@Override
	public void setNormal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGano() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPerdio() {
		// TODO Auto-generated method stub
		
	}
	
}

package Util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Corazon extends JPanel{
	private String urlLleno = "src/Recursos/CorazonLleno.png";
	private String urlVacio = "src/Recursos/CorazonVacio.png";
	private  ImageIcon imagen;
	public Corazon(){
		try{
			BufferedImage img = ImageIO.read(new File(urlLleno));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		this.setOpaque(false);
	}
	
	public void setVacio(){
		imagen = new ImageIcon(urlVacio);
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		imagen.paintIcon(this, g, 0, 0);
	}
}

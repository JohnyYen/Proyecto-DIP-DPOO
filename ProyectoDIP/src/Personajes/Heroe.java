package Personajes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Heroe extends Personaje {
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;
	public Heroe() {
		super(3);
		super.urlNormal = "src/Recursos/Heroe/HeroeNormal.png";
		try{
			BufferedImage img = ImageIO.read(new File(urlNormal));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void setNormal(){
		imagen = new  ImageIcon(urlNormal);
		repaint();
	}
	public void setGano(){
		//Sin implementar
	}
	public void setPerdio(){
		//Sin implementar
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
	}
}

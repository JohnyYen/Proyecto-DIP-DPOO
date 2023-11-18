package Personajes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Medusa extends Personaje {
	private static final long serialVersionUID = -2540840992724142083L;
	private ImageIcon imagen;

	public Medusa(){
		super(5);
		urlNormal = "src/Recursos/Medusa/MedusaNormal.png";
		urlGano = "src/Recursos/Medusa/MedusaNormal.png";
		urlPerdio = "src/Recursos/Medusa/MedusaNormal.png";
		try{
			BufferedImage img = ImageIO.read(new File(urlNormal));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void setNormal(){
		imagen = new  ImageIcon(urlNormal);
		repaint();
	}
	
	@Override
	public void setGano(){
		imagen = new ImageIcon(urlGano);
		repaint();
	}
	
	@Override
	public void setPerdio(){
		imagen = new ImageIcon(urlPerdio);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
	}
}

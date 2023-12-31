package Personajes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Cleopatra extends Personaje{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;
	private String urlSorprendida;
	public Cleopatra(){
		super(5);
		urlNormal = "src/Recursos/Cleopatra/CleopatraNormal.png";
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
		//Sin implementar
	}
	@Override
	public void setPerdio(){
		//Sin implementar
	}
	public void setSorprendida(){
		//Sin implementar
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
	}
	
}

package Personajes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Dullahan extends Personaje {

	private ImageIcon imagen;
	
	public Dullahan(){
		super(2);
		super.urlNormal = "src/Recursos/Dullahan/DullahanNormal.png";
		try{
			BufferedImage img = ImageIO.read(new File(urlNormal));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
	}

	
	@Override
	public void setNormal(){
		imagen = new  ImageIcon(urlNormal);
		repaint();
	}

	@Override
	public void setGano() {
		// Sin implementar aun

	}

	@Override
	public void setPerdio() {
		//Sin implementar aun

	}
	
	
}

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
    
	
	public GlitchMonster(int vida){
		super(vida);
		super.urlNormal = "src/Recursos/monstruo.jpg";
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

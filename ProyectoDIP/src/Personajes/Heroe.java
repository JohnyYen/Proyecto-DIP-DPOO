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

	private String urlNormal = "src/Recursos/HeroeNormal";
	private ImageIcon imagen;
	public Heroe() {
		super(3);
		
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
		imagen.paintIcon(this, g, 0, 0);
	}
}

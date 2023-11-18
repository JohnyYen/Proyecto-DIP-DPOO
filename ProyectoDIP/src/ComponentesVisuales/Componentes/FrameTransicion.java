package ComponentesVisuales.Componentes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FrameTransicion extends JPanel {

	private String urlImagenes[];
	private int frameActual, cantDialogos;
	private ImageIcon imagen;
	public FrameTransicion(){
		frameActual = 0;
		cantDialogos = 0;
		urlImagenes = new String[3];
		urlImagenes[0] = "src/Recursos/Primera.png";
		urlImagenes[1] = "src/Recursos/Segunda.png";
		urlImagenes[2] = "src/Recursos/Tercera.png";
		
		try{
			BufferedImage img = ImageIO.read(new File(urlImagenes[frameActual]));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void aumentarFrame(){
		cantDialogos++;
		if(cantDialogos < 9){
			imagen = new  ImageIcon(urlImagenes[0]);
			repaint();
		}
		else if(cantDialogos > 9 && cantDialogos < 18){
			imagen = new  ImageIcon(urlImagenes[1]);
			repaint();
		}
		else if(cantDialogos > 19 && cantDialogos < 28){
			imagen = new  ImageIcon(urlImagenes[2]);
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
	}
}

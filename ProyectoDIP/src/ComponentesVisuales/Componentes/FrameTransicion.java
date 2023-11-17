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
		if(++cantDialogos == 15){
			imagen = new  ImageIcon(urlImagenes[++frameActual]);
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

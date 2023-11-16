package ComponentesVisuales;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BotonExtendidoNivel2 extends BotonExtendido {
	public BotonExtendidoNivel2(){
		super();
		urlLiberado = "src/Recursos/NBotones.png";
		urlPresionado = "src/Recursos/BotonPressedNivel2.png";
		insertarEfecto();
	}

	public void insertarEfecto(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try{
					BufferedImage img = ImageIO.read(new File(urlPresionado));
					imagen = new ImageIcon(img);
					setIcon(imagen);
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try{
					BufferedImage img = ImageIO.read(new File(urlLiberado));
					imagen = new ImageIcon(img);
					setIcon(imagen);
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}

		});
	}
}

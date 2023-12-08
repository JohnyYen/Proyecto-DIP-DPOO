package ComponentesVisuales.Componentes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BotonExtendidoNivel2 extends BotonExtendido {
	
	private static final long serialVersionUID = 1L;

	public BotonExtendidoNivel2(){
		super();
		urlLiberado = "src/Recursos/BotonNivel2.png";
		urlPresionado = "src/Recursos/BotonPressedNivel2.png";
		
		try{
			BufferedImage img = ImageIO.read(new File(urlLiberado));
			imagen = new ImageIcon(img);
			setIcon(imagen);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
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

package ComponentesVisuales.Componentes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonExtendidoNivelCuatro extends BotonExtendido {
	public BotonExtendidoNivelCuatro(){
		super();
		this.urlPresionado = "src/Recursos/BotonNivelCuatroPressed.png";
		this.urlLiberado = "src/Recursos/BotonNivelCuatroRealesed.png";
		
		try{
			BufferedImage img = ImageIO.read(new File(urlLiberado));
			imagen = new ImageIcon(img);
			setIcon(imagen);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public BotonExtendidoNivelCuatro(String nombre) {
		super();
		this.urlPresionado = "src/Recursos/BotonNivelCuatroPressed.png";
		this.urlLiberado = "src/Recursos/BotonNivelCuatroRealesed.png";
		
		try{
			BufferedImage img = ImageIO.read(new File(urlLiberado));
			imagen = new ImageIcon(img);
			setIcon(imagen);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}

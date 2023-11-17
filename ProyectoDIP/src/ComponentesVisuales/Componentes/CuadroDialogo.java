package ComponentesVisuales.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Recursos.CustomFont;
import javax.swing.JPanel;
import java.awt.Component;

public class CuadroDialogo extends JLabel{

	private TextPanel textoPanel;
	private ImageIcon imagen;
	public CuadroDialogo(){
		super();
		CustomFont mf = new CustomFont();
		this.setFont(mf.MyFont(1, 15));
		this.setForeground(Color.RED);
		
		textoPanel = new TextPanel();
		
		try{
			BufferedImage img = ImageIO.read(new File("src/Recursos/CuadroDialogos.png"));
			imagen = new ImageIcon(img);
			this.setIcon(imagen);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		this.setOpaque(false);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		
	}
	public CuadroDialogo(String text){
		this();
		setText(text);
	}
}

package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Recursos.CustomFont;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class btnprueba extends JButton {

	protected ImageIcon imagen;
	protected  String urlPresionado, urlLiberado;
	protected  JTextArea texto;
	
	public btnprueba() {
		CustomFont cf = new CustomFont();
		urlLiberado = "src/Recursos/NBotones.png";
		urlPresionado = "src/Recursos/BotonPressed.png";
				
		try{
			BufferedImage img = ImageIO.read(new File(urlLiberado));
			imagen = new ImageIcon(img);
			setIcon(imagen);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		insertarEfecto();
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		
		JPanel panelTexto = new JPanel(new BorderLayout());
		panelTexto.setOpaque(false);
		
		// Un Jlabel para poner el texto en el medio del boton
 
		
		
		texto = new JTextArea();
		texto.setFont(cf.MyFont(1, 20));
		texto.setForeground(Color.LIGHT_GRAY);
		texto.setLineWrap(true);
		texto.setFocusable(false);
		texto.setEditable(false);
		texto.setOpaque(false);
		//texto.setHorizontalAlignment(SwingConstants.CENTER);
		//texto.setVerticalAlignment(SwingConstants.CENTER);
		panelTexto.add(texto, BorderLayout.CENTER);
		
		this.add(panelTexto);
		
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
	
	@Override
	public void setText(String text) {
		texto.setText(text);
	}

}

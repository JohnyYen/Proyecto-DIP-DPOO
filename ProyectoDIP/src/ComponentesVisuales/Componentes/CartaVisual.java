package ComponentesVisuales.Componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Util.Carta;

import com.sun.crypto.provider.DESCipher;
import javax.swing.BoxLayout;

public class CartaVisual extends JPanel {

	private Point punto;
	private TextPanel titulo;
	private Carta carta;
	public CartaVisual() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		titulo = new TextPanel();
		add(titulo);
		
		
	}

	public Carta getCarta(){return this.carta;}
	public void setCarta(Carta carta){
		if(carta == null)
			throw new NullPointerException();
		else{
			this.carta = new Carta(carta.getNombre(), carta.getFuncionalidad(), carta.getCodigo());
			titulo.setText(carta.getNombre());
		}
	}

	public void agregarEfecto(){
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				punto = new Point(e.getXOnScreen(), e.getYOnScreen());
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen() - punto.x/2;
				int y = e.getYOnScreen() - punto.y/2;
				
				setLocation(x, y);
			}
		});
	}
}

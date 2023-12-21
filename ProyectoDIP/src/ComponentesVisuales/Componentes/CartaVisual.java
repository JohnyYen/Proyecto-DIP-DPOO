package ComponentesVisuales.Componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Logica.Carta;
import Recursos.CustomFont;

import com.sun.crypto.provider.DESCipher;

import javax.swing.BoxLayout;
import javax.swing.border.Border;

public class CartaVisual extends JPanel {

	private Point punto;
	private TextPanel titulo;
	private Carta carta;
	private boolean cartaUsada;
	public CartaVisual() {
		cartaUsada = false;
		CustomFont mf = new CustomFont();
		setBackground(new Color(0, 51, 102));
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		this.setBorder(border);
		//this.setFont(mf.MyFont(1, 30));
		titulo = new TextPanel();
		titulo.setFocusable(false);
		titulo.setBounds(10, 10, 182, 25);
		titulo.setForeground(Color.white);
		titulo.setBackground(Color.black);
		add(titulo);
		
		
	}

	public boolean esUsadaCarta(){return this.cartaUsada;}
	public void usarCarta(){this.cartaUsada = true;}
	public void liberarCarta(){this.cartaUsada = false;}
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

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

public class CartaVisual extends JPanel {

	private String urlReverso;
	private ImageIcon imagen;
	private Point punto;
	private TextPanel titulo, descripcion;
	private Carta carta;
	public CartaVisual() {
		urlReverso = "src/Recursos/reversoCarta.png";
		try{
			BufferedImage img = ImageIO.read(new File(urlReverso));
			imagen = new ImageIcon(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		titulo = new TextPanel();
		descripcion = new TextPanel();
		
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

	public Carta getCarta(){return this.carta;}
	public void voltearCarta(Carta carta){
		imagen = null;
		repaint();
		this.carta = new Carta(carta.getNombre(), carta.getFuncionalidad(), carta.getCodigo());
		titulo.setText(this.carta.getNombre());
		descripcion.setText(this.carta.getFuncionalidad());
		this.add(titulo);
	}
	
	public TextPanel getTitulo(){return titulo;}
	public TextPanel getDescripcion(){return descripcion;}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		if(imagen != null)
			imagen.paintIcon(this, g, 0, 0);
		else{
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

}

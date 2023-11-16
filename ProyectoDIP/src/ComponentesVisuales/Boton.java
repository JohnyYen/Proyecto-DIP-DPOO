package ComponentesVisuales;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Recursos.CustomFont;
public class Boton extends JButton{
	
	private static final long serialVersionUID = 1L;
	//Coger las imagenes
	private ImageIcon icono = new ImageIcon("src/Recursos/NBotones.png");
	private ImageIcon iconoPressed = new ImageIcon("src/Recursos/BotonPressed.png");
	
	public Boton(String text, int ancho, int alto, int x, int y){
		CustomFont cf = new CustomFont();
		
		// Redimensionar las imagenes para que se adapten a los botones
		Image icon = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		Image iconPressed = iconoPressed.getImage().getScaledInstance(ancho-10, alto/2, Image.SCALE_SMOOTH);
		
		// Los metodos necesarios para diseñar el boton
		this.setIcon(new ImageIcon(icon));
		insertarEfecto(iconPressed, icon);
		this.setPreferredSize(new Dimension(ancho, alto));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setBounds(new Rectangle(x, y, ancho, alto));
		this.setLayout(new OverlayLayout(this) );
		
		
		JPanel panelTexto = new JPanel(new BorderLayout());
		panelTexto.setOpaque(false);
		
		// Un Jlabel para poner el texto en el medio del boton
		JLabel texto = new JLabel(text);
		texto.setFont(cf.MyFont(1, 20));
		texto.setForeground(Color.LIGHT_GRAY);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		panelTexto.add(texto, BorderLayout.CENTER);
		
		this.add(panelTexto);
		
	}
	
	// Función para dar un efecto dinamico a los botones
	// Cuando esta presionado cambia a una imagen y cuando se libera el boton cambia a la otra imagen
	public void insertarEfecto(final Image iconPressed,final Image icon){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setIcon(new ImageIcon(iconPressed));
			}
		});
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent arg0) {
				setIcon(new ImageIcon(icon));
			}
			
		});
	}
	
}

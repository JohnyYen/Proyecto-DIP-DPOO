package ComponentesVisuales.Niveles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Recursos.CustomFont;
import ComponentesVisuales.CartaVisual;

public class TercerNivel extends JFrame {

	private JPanel contentPane;
	private JPanel setCarta1Enemigo;
	private JPanel setCarta2Enemigo;
	private JPanel setCarta3Enemigo;
	private JLabel cuadroDialogos; 
	private JLabel cuadroDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TercerNivel frame = new TercerNivel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TercerNivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Carta
		CartaVisual cartaUno = new CartaVisual();
		cartaUno.setBounds(31, 173, 63, 89);
		contentPane.add(cartaUno);
		
		CartaVisual cartaDos = new CartaVisual();
		cartaDos.setBounds(104, 173, 63, 89);
		contentPane.add(cartaDos);
		
		CartaVisual cartaTres = new CartaVisual();
		cartaTres.setBounds(31, 294, 63, 89);
		contentPane.add(cartaTres);
		
		CartaVisual cartaCuatro = new CartaVisual();
		cartaCuatro.setBounds(104, 293, 63, 89);
		contentPane.add(cartaCuatro);
		
		setCarta1Enemigo = new JPanel();
		setCarta1Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta1Enemigo.setBackground(Color.WHITE);
		setCarta1Enemigo.setBounds(301, 245, 63, 89);
		contentPane.add(setCarta1Enemigo);
		
		setCarta2Enemigo = new JPanel();
		setCarta2Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta2Enemigo.setBackground(Color.WHITE);
		setCarta2Enemigo.setBounds(395, 245, 63, 89);
		contentPane.add(setCarta2Enemigo);
		
		setCarta3Enemigo = new JPanel();
		setCarta3Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta3Enemigo.setBackground(Color.WHITE);
		setCarta3Enemigo.setBounds(492, 245, 63, 89);
		contentPane.add(setCarta3Enemigo);
		
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		cuadroDescripcion = new JLabel("Hola");
		cuadroDescripcion.setBounds(165, 447, 502, 68);
		diseniarLabel(cuadroDescripcion);
		contentPane.add(cuadroDescripcion);
		
	}
	
	public void diseniarLabel(JLabel cuadro){
		ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
		Image iconLabel = imagenLabel.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH);
		
		CustomFont mf = new CustomFont();
		cuadro.setFont(mf.MyFont(1, 15));
		cuadro.setForeground(Color.WHITE);
		
		cuadro.setText("Tengo que hacer el proyecto de DPOO");
		cuadro.setBounds(257, 73, 450, 115);
		cuadro.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		cuadro.setVerticalTextPosition(SwingConstants.CENTER);
		cuadro.setHorizontalTextPosition(SwingConstants.CENTER);
		//cuadroDialogos.setPreferredSize (new Dimension(200,200)); 
		contentPane.add(cuadro);
	}
	
	public void reversoCarta(JPanel carta){
	}
	
	public void agregarEventoCarta(JPanel carta){
	}
}

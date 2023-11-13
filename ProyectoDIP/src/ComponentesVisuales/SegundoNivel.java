package ComponentesVisuales;

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

public class SegundoNivel extends JFrame {

	private JPanel contentPane;
	private JPanel setCarta1;
	private JPanel setCarta2;
	private JPanel setCarta3;
	private JPanel setCarta1Enemigo;
	private JPanel setCarta2Enemigo;
	private JPanel setCarta3Enemigo;
	private JLabel cuadroDialogos; 
	private JLabel cuadroDescripcion;
	private JPanel Carta;
	private JPanel Carta2;
	private JPanel Carta3;
	private JPanel Carta4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundoNivel frame = new SegundoNivel();
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
	public SegundoNivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setCarta1 = new JPanel();
		setCarta1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta1.setBackground(Color.WHITE);
		setCarta1.setBounds(299, 308, 84, 109);
		contentPane.add(setCarta1);
		
		setCarta2 = new JPanel();
		setCarta2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta2.setBackground(Color.WHITE);
		setCarta2.setBounds(393, 308, 84, 109);
		contentPane.add(setCarta2);
		
		setCarta3 = new JPanel();
		setCarta3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta3.setBackground(Color.WHITE);
		setCarta3.setBounds(487, 308, 84, 109);
		contentPane.add(setCarta3);
		
		setCarta1Enemigo = new JPanel();
		setCarta1Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta1Enemigo.setBackground(Color.WHITE);
		setCarta1Enemigo.setBounds(299, 173, 84, 109);
		contentPane.add(setCarta1Enemigo);
		
		setCarta2Enemigo = new JPanel();
		setCarta2Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta2Enemigo.setBackground(Color.WHITE);
		setCarta2Enemigo.setBounds(393, 173, 84, 109);
		contentPane.add(setCarta2Enemigo);
		
		setCarta3Enemigo = new JPanel();
		setCarta3Enemigo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta3Enemigo.setBackground(Color.WHITE);
		setCarta3Enemigo.setBounds(487, 173, 84, 109);
		contentPane.add(setCarta3Enemigo);
		
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		cuadroDescripcion = new JLabel("New label");
		cuadroDescripcion.setBounds(165, 447, 502, 68);
		diseniarLabel(cuadroDescripcion);
		contentPane.add(cuadroDescripcion);
		
		Carta = new JPanel();
		Carta.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Carta.setBackground(Color.WHITE);
		Carta.setBounds(10, 173, 84, 109);
		contentPane.add(Carta);
		
		Carta2 = new JPanel();
		Carta2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Carta2.setBackground(Color.WHITE);
		Carta2.setBounds(116, 173, 84, 109);
		contentPane.add(Carta2);
		
		Carta3 = new JPanel();
		Carta3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Carta3.setBackground(Color.WHITE);
		Carta3.setBounds(10, 308, 84, 109);
		contentPane.add(Carta3);
		
		Carta4 = new JPanel();
		Carta4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Carta4.setBackground(Color.WHITE);
		Carta4.setBounds(116, 308, 84, 109);
		contentPane.add(Carta4);
		
		reversoCarta(Carta);
		reversoCarta(Carta2);
		reversoCarta(Carta3);
		reversoCarta(Carta4);
		
		agregarEventoCarta(Carta);
		agregarEventoCarta(Carta2);
		agregarEventoCarta(Carta3);
		agregarEventoCarta(Carta4);
	}
	
	public void diseniarLabel(JLabel cuadro){
		ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
		Image iconLabel = imagenLabel.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH);
		
		CustomFont mf = new CustomFont();
		cuadro.setFont(mf.MyFont(1, 15));
		cuadro.setForeground(Color.WHITE);
		
		cuadro.setText("Tengo que hacer el proyecto de DPOO");
		cuadro.setBounds(217, 11, 450, 115);
		cuadro.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		cuadro.setVerticalTextPosition(SwingConstants.CENTER);
		cuadro.setHorizontalTextPosition(SwingConstants.CENTER);
		//cuadroDialogos.setPreferredSize (new Dimension(200,200)); 
		contentPane.add(cuadro);
	}
	
	public void reversoCarta(JPanel carta){
		JLabel label = new JLabel();
		label.setSize(carta.getWidth(), carta.getHeight());
		Image imagen = new ImageIcon("src/Recursos/reversoCarta.png").getImage().getScaledInstance(carta.getWidth(), carta.getHeight()-5, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imagen));
		carta.add(label);
	}
	
	public void agregarEventoCarta(JPanel carta){
		carta.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
	}
}

package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Niveles.SegundoNivel;
import Logica.Juego;
import Recursos.CustomFont;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCarga extends JFrame {

	private JPanel contentPane;
	private JProgressBar bar;
	private static Juego miJuego;
	
	public PantallaCarga(Juego juego) {
		this.miJuego = juego;
		setTitle("Hello World!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			//Dibujar el Fondo
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(SegundoNivel.class.getResource("/Recursos/FondoCarga.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CustomFont cf = new CustomFont();
		
		JLabel helloWorld = new JLabel("Hello World!");
		helloWorld.setForeground(Color.WHITE);
		helloWorld.setFont(cf.MyFont(1, 100));
		helloWorld.setBounds(102, 235, 678, 81);
		contentPane.add(helloWorld);
		
		bar = new JProgressBar();
		bar.setBounds(10, 588, 864, 23);
		bar.setMinimum(0);
		bar.setForeground(Color.BLUE);
		bar.setMaximum(100);
		bar.setStringPainted(true);
		
		
		final Timer timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = bar.getValue()+1;
				if(bar.getValue() == 100){
					PantallaCrearUsuario frame = new PantallaCrearUsuario(miJuego);
					frame.setVisible(true);
					
				}
				if(value <= bar.getMaximum()) bar.setValue(value);
				
			}
		});
		contentPane.add(bar);
		timer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bar.getValue() == 100){
					timer.stop();
					dispose();
				}
				
			}
		});
		timer.start();
	}
	
	public static void setJuego(Juego juego){
		miJuego = juego;
	}
}
package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.FrameTransicion;
import ComponentesVisuales.Niveles.PrimerNivel;
import Logica.Juego;
import Recursos.CustomFont;

public class PantallaTransicion extends JFrame {

	private JLabel cuadroDialogos;
	private JLabel BotonZ;
	private JLabel BotonX;
	private ArrayList<String> dialogos;
	private KeyListener tocarTecla;
	private FileReader file;
	private BufferedReader buffer;
	private FrameTransicion frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = null;
					Juego.crearJuego();
					PantallaTransicion frame = new PantallaTransicion(Juego.obtenerJuego());
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
	public PantallaTransicion(final Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		frame = new FrameTransicion();
		try{
			file = new FileReader("src/DialogosTransicion.txt");
			buffer = new BufferedReader(file);
		}
		catch(IOException e){
			 
		}
		
		tocarTecla = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'z'){
					try{
						if(buffer.ready())
							cuadroDialogos.setText(buffer.readLine());
					}
					catch(IOException a){
						
					}
				}
				if(e.getKeyChar() == 'x'){
					PrimerNivel pri = new PrimerNivel(juego);
					dispose();
					pri.setVisible(true);
				}
				
			}
		};
		CustomFont myfont = new CustomFont();
		this.addKeyListener(tocarTecla);
		BotonZ = new JLabel("Z -> Continuar");
		BotonZ.setForeground(Color.black);
		BotonZ.setBounds(154, 464, 131, 50);
		BotonZ.setFont(myfont.MyFont(1, 15));
		
		BotonX = new JLabel("X -> Saltar");
		BotonX.setBounds(295, 464, 138, 50);
		BotonX.setFont(myfont.MyFont(1, 15));
		BotonX.setForeground(Color.black);
		frame.setLayout(null);
		
		frame.add(BotonX);
		frame.add(BotonZ);
		
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
	}
	
	
	public void getDialogos(){
		dialogos = new ArrayList<>();
		dialogos.add("Tengo que terminar el proyecto de DPOO");
		dialogos.add("Si no la profesora me da 2");
		dialogos.add("Me falta poco");
	}
	
	public void diseniarLabel(JLabel dialogos){
		ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
		Image iconLabel = imagenLabel.getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
		
		CustomFont mf = new CustomFont();
		cuadroDialogos.setFont(mf.MyFont(1, 15));
		cuadroDialogos.setForeground(Color.WHITE);
		
		try{
			cuadroDialogos.setText("Gola");
		}
		catch(Exception e){
			
		}
		cuadroDialogos.setBounds(100, 350, 500, 200);
		cuadroDialogos.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		cuadroDialogos.setVerticalTextPosition(SwingConstants.CENTER);
		cuadroDialogos.setHorizontalTextPosition(SwingConstants.CENTER);
		//cuadroDialogos.setPreferredSize (new Dimension(200,200)); 
		frame.add(cuadroDialogos);
	}

}

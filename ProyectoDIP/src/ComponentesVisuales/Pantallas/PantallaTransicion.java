package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

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
import ComponentesVisuales.Componentes.CuadroDialogo;
import ComponentesVisuales.Componentes.TextPanel;
import ComponentesVisuales.Componentes.BotonExtendido;

public class PantallaTransicion extends JFrame {
	private JLabel BotonZ;
	private JLabel BotonX;
	private FileReader file;
	private BufferedReader buffer;
	private FrameTransicion frame;
	private TextPanel textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PantallaTransicion frame = new PantallaTransicion();
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
	public PantallaTransicion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		frame = new FrameTransicion();
		
		//TextPane para los dialogos
		textPane = new TextPanel();
		textPane.setForeground(Color.RED);
		textPane.setText("Tengo que hacer el proyecto de DPOO");
		textPane.setBounds(10, 580, 480, 70);
		frame.add(textPane);
		
		try{
			file = new FileReader("src/Textos/DialogosTransicion.txt");
			buffer = new BufferedReader(file);
		}
		catch(IOException e){
			 e.printStackTrace();
		}
		
		CustomFont myfont = new CustomFont();
	
		BotonZ = new JLabel("Z -> Continuar");
		BotonZ.setForeground(Color.black);
		BotonZ.setBounds(10, 519, 131, 50);
		BotonZ.setFont(myfont.MyFont(1, 15));
		
		BotonX = new JLabel("X -> Saltar");
		BotonX.setBounds(151, 519, 138, 50);
		BotonX.setFont(myfont.MyFont(1, 15));
		BotonX.setForeground(Color.black);
		frame.setLayout(null);
		
		//frame.add(BotonX);
		//frame.add(BotonZ);
		
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		
		getContentPane().setLayout(null);
		
		BotonExtendido teclaZ = new BotonExtendido();
		teclaZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.print("Hola");
					if(buffer.ready()){
						textPane.setText(buffer.readLine());
						frame.aumentarFrame();
					}
					else{
						//PrimerNivel primerNivel = new PrimerNivel(juego);
						dispose();
						//primerNivel.setVisible(true);
					}
			    }
				catch(IOException a){
					
				}
			}
		});
		teclaZ.setText("Z - Continuar");
		teclaZ.setBounds(10, 490, 231, 28);
		frame.add(teclaZ);
		
		BotonExtendido btnxtndXSaltar = new BotonExtendido();
		btnxtndXSaltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PrimerNivel pri = new PrimerNivel(juego);
				dispose();
				//pri.setVisible(true);
			}
		});
		btnxtndXSaltar.setText("X - Saltar");
		btnxtndXSaltar.setBounds(243, 490, 231, 28);
		frame.add(btnxtndXSaltar);
		
		eventoTeclado();
		this.setLocationRelativeTo(null);
	}
	
	public void eventoTeclado(){
		this.requestFocus();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent tecla) {
				System.out.print("Hola");
				if(tecla.getKeyCode() == KeyEvent.VK_Z){
					try{
						System.out.print("Hola");
						if(buffer.ready()){
							textPane.setText(buffer.readLine());
							frame.aumentarFrame();
						}
						else{
							//PrimerNivel primerNivel = new PrimerNivel(juego);
							dispose();
							//primerNivel.setVisible(true);
						}
							
					}
					catch(IOException a){
						
					}
				}
				if(tecla.getKeyCode() == KeyEvent.VK_X){
					//PrimerNivel pri = new PrimerNivel(juego);
					dispose();
					//pri.setVisible(true);
				}
				
			}
		});
	}
}

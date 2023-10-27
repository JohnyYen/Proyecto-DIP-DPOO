package ComponentesVisuales;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Recursos.CustomFont;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Boton botonNuevoJuego;
	private Boton botonReanudarPartida;
	private Boton botonCuriosidades;
	private Boton botonSalir;
	private Boton botonOpciones;
	private JLabel titulo;
	private static Frame save;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 700, 576);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/FondoMenuPrincipal.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//Nueva Fuente
		CustomFont cf = new CustomFont();
		
		//Titulo
		titulo = new JLabel("Hello World!");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(cf.MyFont(1, 50));
		titulo.setBounds(183, 104, 348, 101);
		contentPane.add(titulo);
		
		//Boton Nuevo Juego
		botonNuevoJuego = new Boton("Nuevo Juego", 300, 300, 200, 250);
		botonNuevoJuego.setBounds(202, 216, 280, 61);
		botonNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transicion transicion = new Transicion();
				dispose();
				transicion.setVisible(true);
			}
		});
		contentPane.add(botonNuevoJuego);
		
		//Botón Reanudar Partida
		botonReanudarPartida = new Boton("Reanudar Partida", 300, 300, 200, 300);
		botonReanudarPartida.setBounds(202, 263, 280, 61);
		botonReanudarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Validar en caso que el save este vacio
				try{
					 dispose();
					((JFrame)save).setVisible(true);
				}catch(NullPointerException a){
					//Se vuelve a abrir la ventana
					setVisible(true);
					JOptionPane.showMessageDialog(null, "No hay partida guardada"); //Se muestra mensaje de error
				}
				
			}
		});
		contentPane.add(botonReanudarPartida);
		
		//Botón Opciones
		botonOpciones = new Boton("Opciones", 300, 300, 200, 350);
		botonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOpciones menuOpciones = new MenuOpciones();
				dispose();
				menuOpciones.setVisible(true);
			}
		});
		botonOpciones.setBounds(202, 322, 280, 53);
		contentPane.add(botonOpciones);
		
		//Botón de Curiosidades
		botonCuriosidades = new Boton("Curiosidades", 300, 300, 200, 400);
		botonCuriosidades.setBounds(202, 374, 280, 53);
		botonCuriosidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curiosidades curiosidades = new Curiosidades();
				dispose();
				curiosidades.setVisible(true);
			}
		});
		contentPane.add(botonCuriosidades);
		
		//Botón para salir del Juego
		botonSalir = new Boton("Salir", 300, 300, 200, 450);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Se comprueba que el usuario de verdad quiere salir del juego 
				if(JOptionPane.showConfirmDialog(contentPane, "Estas seguro que vas a salir?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) dispose();
			}
		});
		botonSalir.setBounds(202, 424, 280, 61);
		contentPane.add(botonSalir);
		
		//Modificaciones al Frame
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage());
		
	}
	
	//Guardar la instancia de la partida en una variable estatica para modificar el valor en la Clase
	public static void guardarEstado(Frame partidaGuardada){
		save = partidaGuardada;
	}

}

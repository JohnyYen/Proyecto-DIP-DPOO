package ComponentesVisuales.Pantallas;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.Boton;
import Logica.Juego;
import Recursos.CustomFont;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import ComponentesVisuales.Componentes.BotonExtendido;
import ComponentesVisuales.Componentes.BarraMenu;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titulo;
	private static Frame save;
	private BotonExtendido botonNuevoJuego;
	private BotonExtendido botonReanudar;
	private BotonExtendido botonOpciones;
	private BotonExtendido botonCuriosidades;
	private BotonExtendido botonSalir;
	private Juego miJuego;

	
	public MenuPrincipal(Juego juego) {
		this.miJuego = juego;
		setTitle("Hello World!: Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		
		BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
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
		
		botonNuevoJuego = new BotonExtendido();
		botonNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaTransicion transicion = new PantallaTransicion(miJuego);
				dispose();
				transicion.setVisible(true);
			}
		});
		botonNuevoJuego.setText("Nuevo Juego");
		botonNuevoJuego.setBounds(202, 238, 252, 28);
		contentPane.add(botonNuevoJuego);
		
		botonReanudar = new BotonExtendido();
		botonReanudar.addActionListener(new ActionListener() {
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
		botonReanudar.setText("Reanudar Partida");
		botonReanudar.setBounds(202, 280, 252, 28);
		contentPane.add(botonReanudar);
		
		botonOpciones = new BotonExtendido();
		botonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOpciones menuOpciones = new MenuOpciones(miJuego);
				dispose();
				menuOpciones.setVisible(true);
			}
		});
		botonOpciones.setText("Opciones");
		botonOpciones.setBounds(202, 326, 252, 28);
		contentPane.add(botonOpciones);
		
		botonCuriosidades = new BotonExtendido();
		botonCuriosidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCuriosidades curiosidades = new PantallaCuriosidades(miJuego);
				dispose();
				curiosidades.setVisible(true);
			}
		});
		botonCuriosidades.setText("Curiosidades");
		botonCuriosidades.setBounds(202, 376, 252, 28);
		contentPane.add(botonCuriosidades);
		
		botonSalir = new BotonExtendido();
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se comprueba que el usuario de verdad quiere salir del juego 
				if(JOptionPane.showConfirmDialog(contentPane, "Estas seguro que vas a salir?", "Confirmaci�n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) dispose();
			}
		});
		botonSalir.setText("Salir");
		botonSalir.setBounds(202, 415, 252, 28);
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
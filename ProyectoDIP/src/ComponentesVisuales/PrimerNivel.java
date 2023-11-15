
package ComponentesVisuales;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.*;
import Personajes.Heroe;
import Personajes.Villana;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimerNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego juego;
	private JPanel contentPane;
	private SubMenu submenu;
	private LabelRespuestas labelRespuestas;
	private LabelPreguntas labelPreguntas;
	private Villana villana;
	
	public PrimerNivel(final Juego juego) {
		this.juego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 700, 700);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			//Dibujar el Fondo
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(PrimerNivel.class.getResource("/Recursos/FondoPrimerNivel.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Personajes
		//Sprite de la Villana
		villana = new Villana(500, 150, 250, 200, 6);
		contentPane.add(villana);
		
		//Sprite del heroe
		Heroe heroe = new Heroe(20, 450, 250, 250, 3);
		contentPane.add(heroe);
		
		//Controlador del Juego
		juego.crearControladorNivelUno(heroe, villana);
		
		//El submenu del juego
		submenu = new SubMenu(this, true);
		contentPane.add(submenu);
		submenu.setVisible(false);
		
		//Bot�n de Men�
		JButton botonMenu = new JButton();
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!submenu.isVisible()) submenu.setVisible(true);
			}
		});
		botonMenu.setBounds(550,-50,200,200);
		diseniarBoton(botonMenu);
		contentPane.add(botonMenu);
		
		
		//Label donde se ven las preguntas
		labelPreguntas = new LabelPreguntas(200, 150, 400, 150, juego.getInformacionJuego().getPreguntasNivelUno());
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
		contentPane.add(labelPreguntas);
			
		//Label donde estan las respuestas
		labelRespuestas = new LabelRespuestas(200, 500, 400,150 );
		labelRespuestas.getBotonVerdadero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(juego.getControladorNivelUno().analizarRespuesta(true))
					juego.getControladorNivelUno().quitarVidaVillano();
				else juego.getControladorNivelUno().quitarVidaHeroe();
				
				labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
			}
		});
		
		labelRespuestas.getBotonFalso().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(juego.getControladorNivelUno().analizarRespuesta(false))
					juego.getControladorNivelUno().quitarVidaVillano();
				else juego.getControladorNivelUno().quitarVidaHeroe();
				
				labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
			}
		});
		
		contentPane.add(labelRespuestas);	
	
		//Modificaciones al Frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage()); 
	}
	
	private void diseniarBoton(JButton boton){
		ImageIcon icono = new ImageIcon("src/Recursos/MenuPrincipalBoton.png");
		boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		boton.setBorderPainted(false);
		boton.setFocusPainted(false);
		boton.setContentAreaFilled(false);
		boton.setLayout(new OverlayLayout(boton) );
	}

}
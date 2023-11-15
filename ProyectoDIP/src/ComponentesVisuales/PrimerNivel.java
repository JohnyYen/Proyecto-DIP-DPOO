
package ComponentesVisuales;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.*;
import Personajes.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Util.Corazon;

public class PrimerNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego juego;
	private JPanel contentPane;
	private SubMenu submenu;
	private LabelRespuestas labelRespuestas;
	private LabelPreguntas labelPreguntas;
	
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
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(560, 101, 124, 158);
		contentPane.add(cleopatra);
		
		Heroe heroe = new Heroe();
		heroe.setBounds(63, 481, 172, 138);
		contentPane.add(heroe);
		
		//Controlador
		juego.crearControladorNivelUno(heroe, cleopatra);
		//El submenu del juego
		submenu = new SubMenu(this, true);
		contentPane.add(submenu);
		submenu.setVisible(false);
		
		//Botón de Menú
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
		
		Corazon corazon = new Corazon();
		corazon.setBounds(10, 11, 36, 37);
		contentPane.add(corazon);
		
		Corazon corazon_1 = new Corazon();
		corazon_1.setBounds(55, 11, 36, 37);
		contentPane.add(corazon_1);
		
		Corazon corazon_2 = new Corazon();
		corazon_2.setBounds(106, 11, 36, 37);
		contentPane.add(corazon_2);
		
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

package ComponentesVisuales;

import java.awt.*;


import javax.swing.border.EmptyBorder;

import Logica.Juego;
import Personajes.Cleopatra;
import Personajes.Heroe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;

public class SegundoNivel extends JFrame {

	private static final long serialVersionUID = -4285398109221870651L;
	private JPanel contentPane;
	private LabelPreguntas labelPreguntas;
	private LabelRespuestasSegundoNivel labelRespuestas;
	private SubMenu submenu;
	private Juego juego;

	public SegundoNivel(final Juego juego) {
		this.juego = juego;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 786, 565);
		setBounds(300, 20, 920, 700);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			//Dibujar el Fondo
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(SegundoNivel.class.getResource("/Recursos/FondoSegundoNivel.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setSize(new Dimension(1500, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(793, 91, 268, 246);
		contentPane.add(cleopatra);
		
		Heroe heroe = new Heroe();
		heroe.setBounds(28, 457, 305, 308);
		contentPane.add(heroe);
		
		//Controlador Segundo Nivel
		juego.crearControladorNivelDos(heroe, cleopatra);
		
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
		botonMenu.setBounds(733,-77,200,200);
		diseniarBoton(botonMenu);
		contentPane.add(botonMenu);
	
		//Label donde se ven las preguntas
		labelPreguntas = new LabelPreguntas(juego.getInformacionJuego().getPreguntasNivelDos(),200, 150, 400, 150);
		labelPreguntas.setPreferredSize(new Dimension(400, 300));
		labelPreguntas.setBounds(new Rectangle(200, 150, 400, 500));
		labelPreguntas.setSize(new Dimension(450, 179));
		labelPreguntas.setSize(450, 179);
		labelPreguntas.setLocation(345, 102);
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.ponerPregunta(juego.getControladorNivelDos().darPregunta());
		contentPane.add(labelPreguntas);
		
		//label de las respuestas
		labelRespuestas = new LabelRespuestasSegundoNivel(juego.getControladorNivelDos(), 200, 1000, 400,150);
		labelRespuestas.getOpcion3().setLocation(new Point(30, 225));
		labelRespuestas.getOpcion3().setSize(new Dimension(700, 100));
		labelRespuestas.getOpcion2().setLocation(new Point(30, 150));
		labelRespuestas.getOpcion2().setSize(new Dimension(700, 100));
		labelRespuestas.getOpcion1().setLocation(new Point(30, 70));
		labelRespuestas.getOpcion1().setSize(new Dimension(700, 100));
		labelRespuestas.getOpcion1().setAlignmentY(Component.BOTTOM_ALIGNMENT);
		labelRespuestas.setSize(748, 408);
		labelRespuestas.setLocation(166, 263);
		contentPane.add(labelRespuestas);		
		
		labelRespuestas.getOpcion1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		labelRespuestas.getOpcion2().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		labelRespuestas.getOpcion3().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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

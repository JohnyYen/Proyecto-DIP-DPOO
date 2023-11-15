package ComponentesVisuales;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.InformacionJuego;
import Logica.InformacionJuegoActual;
import Logica.Juego;
import Personajes.Heroe;
import Personajes.Villana;
import Util.PreguntaNivelDos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SegundoNivel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4285398109221870651L;
	private JPanel contentPane;
	private LabelPreguntas labelPreguntas;
	private LabelRespuestasSegundoNivel labelRespuestas;
	private Villana villana;
	private SubMenu submenu;

	public SegundoNivel(Juego juego) {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		villana = new Villana(500, 150, 250, 200, 6);
		villana.setLocation(654, 71);
		contentPane.add(villana);
		
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
		labelPreguntas = new LabelPreguntas(juego.getInformacionJuego().getPreguntaNivelDos(),200, 150, 400, 150);
		labelPreguntas.setLocation(345, 102);
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.setText("<html>�En qu� se diferencian los bucles<br> -for- y -while- en programaci�n?</html>");
		contentPane.add(labelPreguntas);
		
		Heroe heroe = new Heroe(20, 450, 250, 250, 3);
		heroe.setLocation(0, 468);
		contentPane.add(heroe);		
		
		labelRespuestas = new LabelRespuestasSegundoNivel(200, 1000, 400,150);
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

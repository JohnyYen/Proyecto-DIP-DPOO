
package ComponentesVisuales.Niveles;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.LabelPreguntas;
import ComponentesVisuales.Componentes.LabelRespuestas;
import ComponentesVisuales.Pantallas.SubMenu;
import Logica.*;
import Personajes.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Util.Corazon;
import ComponentesVisuales.Componentes.BarraMenu;

public class PrimerNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego juego;
	private JPanel contentPane;
	private LabelRespuestas labelRespuestas;
	private LabelPreguntas labelPreguntas;
	private ArrayList<Corazon> corazones;
	private ArrayList<Corazon> corazonesVillano;
	private Corazon corazon_5;
	private Corazon corazon_4;
	private Corazon corazon_2;
	private Corazon corazon_3;
	private Corazon corazon_1;
	private Corazon corazon;
	
	public PrimerNivel(final Juego juego) {
		setTitle("Hello World! : Primer Nivel");
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
		
		corazones = new ArrayList<Corazon>();
		corazonesVillano = new ArrayList<Corazon>();
		
		BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Personajes
		final Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(560, 101, 124, 158);
		contentPane.add(cleopatra);
		
		final Heroe heroe = new Heroe();
		heroe.setBounds(63, 481, 172, 138);
		contentPane.add(heroe);
		
		//Controlador
		juego.crearControladorNivelUno(heroe, cleopatra);
		
		
		//Label donde se ven las preguntas
		labelPreguntas = new LabelPreguntas(200, 150, 400, 150);
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
		contentPane.add(labelPreguntas);
			
		//Label donde estan las respuestas
		labelRespuestas = new LabelRespuestas(200, 500, 400,150 );
		labelRespuestas.getBotonVerdadero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
					
				if(juego.getControladorNivelUno().analizarRespuesta(true)){
					juego.getControladorNivelUno().quitarVidaVillano();
					corazonesVillano.get(cleopatra.getVidas()).setVacio();	
					
				}
					
				else {
					juego.getControladorNivelUno().quitarVidaHeroe();
					corazones.get(heroe.getVidas()).setVacio();
				}
				
				labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
			}
		});
		
		labelRespuestas.getBotonFalso().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
					
				if(juego.getControladorNivelUno().analizarRespuesta(false)){
					juego.getControladorNivelUno().quitarVidaVillano();
					corazonesVillano.get(cleopatra.getVidas()).setVacio();
				}
					
				else {
					juego.getControladorNivelUno().quitarVidaHeroe();
					corazones.get(heroe.getVidas()).setVacio();
				}
				
				labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
			}
		});
		
		contentPane.add(labelRespuestas);	
		
		//Corazones Heroe
		crearCorazonesHeroe();
		
		//Corazones Villano
		crearCorazonesVillano();
		
		//Modificaciones al Frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage()); 
	}
	
	private void crearCorazonesHeroe(){
		corazones.add(new Corazon());
		corazones.get(0).setBounds(10, 11, 36, 37);
		contentPane.add(corazones.get(0));
		
		corazones.add(new Corazon());
		corazones.get(1).setBounds(55, 11, 36, 37);
		contentPane.add(corazones.get(1));
		
		corazones.add(new Corazon());
		corazones.get(2).setBounds(106, 11, 36, 37);
		contentPane.add(corazones.get(2));
	}
	
	private void crearCorazonesVillano(){
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(0).setBounds(659, 290, 25, 26);
		contentPane.add(corazonesVillano.get(0));
		
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(1).setBounds(659, 327, 25, 26);
		contentPane.add(corazonesVillano.get(1));
		
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(2).setBounds(624, 290, 25, 26);
		contentPane.add(corazonesVillano.get(2));
		
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(3).setBounds(624, 327, 25, 26);
		contentPane.add(corazonesVillano.get(3));
		
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(4).setBounds(589, 290, 25, 26);
		contentPane.add(corazonesVillano.get(4));
		
		corazonesVillano.add(new Corazon());
		corazonesVillano.get(5).setBounds(589, 327, 25, 26);
		contentPane.add(corazonesVillano.get(5));
	}
	
	private void diseniarBoton(JButton boton){
		ImageIcon icono = new ImageIcon("src/Recursos/MenuPrincipalBoton.png");
	}
}

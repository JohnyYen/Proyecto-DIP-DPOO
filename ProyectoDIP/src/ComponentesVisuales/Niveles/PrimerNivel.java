
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

	import Util.ControladorCorazones;
	import Util.Corazon;
	import ComponentesVisuales.Componentes.BarraMenu;

	public class PrimerNivel extends JFrame {

		private static final long serialVersionUID = 1L;
		private Juego Mijuego;
		private JPanel contentPane;
		private LabelRespuestas labelRespuestas;
		private LabelPreguntas labelPreguntas;
		private ControladorCorazones corazonesNivel;
		private Corazon villano1;
		private Corazon villano2;
		private Corazon villano3;
		private Corazon villano4;
		private Corazon villano5;
		private Corazon villano6;
		private Corazon heroe1;
		private Corazon heroe2;
		private Corazon heroe3;
		
		public PrimerNivel(final Juego juego) {
			setTitle("Hello World! : Primer Nivel");
			this.Mijuego = juego;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 20, 900, 700);
			contentPane = new JPanel(){
				private static final long serialVersionUID = 1L;

				//Dibujar el Fondo
				public void paintComponent(Graphics g) {
					Image img = Toolkit.getDefaultToolkit().getImage(PrimerNivel.class.getResource("/Recursos/FondoPrimerNivel.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};		
			BarraMenu barraMenu = new BarraMenu();
			setJMenuBar(barraMenu);
			
			corazonesNivel = new ControladorCorazones();
			
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
						corazonesNivel.quitarVidaVillano();
						
					}
						
					else {
						juego.getControladorNivelUno().quitarVidaHeroe();
						corazonesNivel.quitarVidaHeroe();
					}
					
					labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
				}
			});
			
			labelRespuestas.getBotonFalso().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent action) {
						
					if(juego.getControladorNivelUno().analizarRespuesta(false)){
						juego.getControladorNivelUno().quitarVidaVillano();
						corazonesNivel.quitarVidaVillano();
					
					}
						
					else {
						juego.getControladorNivelUno().quitarVidaHeroe();
						corazonesNivel.quitarVidaHeroe();
						
					}
					
					labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
				}
			});
			
			contentPane.add(labelRespuestas);	
			
			
			
			crearCorazonesHeroe();
			crearCorazonVillano();
			
			//Modificaciones al Frame
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage()); 
		}
		
		public void crearCorazonesHeroe(){
			
			heroe1 = new Corazon();
			corazonesNivel.agregarCorarazonHeroe(heroe1);
			corazonesNivel.getLastCorazonHeroe().setBounds(26, 397, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonHeroe());
			
			heroe2 = new Corazon();
			corazonesNivel.agregarCorarazonHeroe(heroe2);
			corazonesNivel.getLastCorazonHeroe().setBounds(60, 397, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonHeroe());
			
			heroe3 = new Corazon();
			corazonesNivel.agregarCorarazonHeroe(heroe3);
			corazonesNivel.getLastCorazonHeroe().setBounds(100, 397, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonHeroe());
			contentPane.add(corazonesNivel.getLastCorazonHeroe());
			
		}
		
		public void crearCorazonVillano(){
			villano1 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano1);
			corazonesNivel.getLastCorazonVillano().setBounds(428, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
			villano2 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano2);
			corazonesNivel.getLastCorazonVillano().setBounds(473, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
			villano3 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano3);
			corazonesNivel.getLastCorazonVillano().setBounds(515, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
			villano4 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano4);
			corazonesNivel.getLastCorazonVillano().setBounds(560, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
			villano5 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano5);
			corazonesNivel.getLastCorazonVillano().setBounds(608, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
			villano6 = new Corazon();
			corazonesNivel.agregarCorazonVillano(villano6);
			corazonesNivel.getLastCorazonVillano().setBounds(643, 63, 25, 25);
			contentPane.add(corazonesNivel.getLastCorazonVillano());
			
		}
	}

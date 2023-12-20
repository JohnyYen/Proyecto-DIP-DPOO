
package ComponentesVisuales.Niveles;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import ComponentesVisuales.Componentes.LabelPreguntas;
import ComponentesVisuales.Componentes.LabelRespuestas;
import Logica.*;
import Personajes.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Util.ControladorCorazones;
import Util.Corazon;
import ComponentesVisuales.Componentes.BarraMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimerNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private Juego Mijuego;
	private boolean mensajeHecho = false;
	private JPanel contentPane;
	private LabelRespuestas labelRespuestas;
	private LabelPreguntas labelPreguntas;
	private ControladorCorazones corazonesNivel;
	private Juego miJuego;
	public PrimerNivel(Juego juego) {
		
		this.miJuego = juego;
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
		
		//Barra de menú
		BarraMenu barraMenu = new BarraMenu();
		BarraMenu.guardarEstadoActual(this);
		barraMenu.getMenu(1).getItem(0).setEnabled(true);
		BarraMenu.guardarJuegoActual(Mijuego);
		setJMenuBar(barraMenu);
		
		//Controlador de corrazones
		corazonesNivel = new ControladorCorazones();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Personajes
		//Cleopatra
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(560, 101, 124, 158);
		contentPane.add(cleopatra);
		
		//Heroe
		Heroe heroe = new Heroe();
		heroe.setBounds(63, 481, 172, 138);
		contentPane.add(heroe);
		
		//Controlador
		juego.crearControladorNivelUno(3, 6);
		
		
		//Label donde se ven las preguntas
		labelPreguntas = new LabelPreguntas(200, 150, 400, 150);
		labelPreguntas.setForeground(Color.WHITE);
		labelPreguntas.setBounds(44, 150, 556, 150);
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.ponerPregunta(juego.getControladorNivelUno().darPregunta());
		contentPane.add(labelPreguntas);
			
		//Label donde estan las respuestas
		labelRespuestas = new LabelRespuestas(200, 500, 400,150 );
		labelRespuestas.addMouseListener(new MouseAdapter() {
			//Si el mouse entra en el componente
			//Comprueba si ya se termino el nivel para pasar al siguiente en caso de ganar
			//En caso de perder se queda en el mismo
			@Override
			public void mouseEntered(MouseEvent e) {
				//Si gana
				if(Mijuego.getControladorNivelUno().finalizarPartida() > 0){
					dispose();
					SegundoNivel frame = new SegundoNivel(Mijuego);
					frame.setVisible(true);
				}
				//Si pierde
				else if(Mijuego.getControladorNivelUno().finalizarPartida() < 0){
					dispose();
					PrimerNivel frame = new PrimerNivel(Mijuego);
					frame.setVisible(true);
				}
			}
			
			//Si el mouse sale del componente realiza lo mismo que en el metodo anterior
			@Override
			public void mouseExited(MouseEvent e) {
				if(Mijuego.getControladorNivelUno().finalizarPartida() > 0){
					dispose();
					SegundoNivel frame = new SegundoNivel(Mijuego);
					frame.setVisible(true);
				}
				else if(Mijuego.getControladorNivelUno().finalizarPartida() < 0){
					dispose();
					PrimerNivel frame = new PrimerNivel(Mijuego);
					frame.setVisible(true);
				}
			}
		});
		labelRespuestas.getBotonVerdadero().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				//Si toca el boton verdadero comprueba si la respuesta es correcta
				//y dependiendo de ello quita vida a los personajes
				if(miJuego.getControladorNivelUno().analizarRespuesta(true)){
					miJuego.getControladorNivelUno().quitarVidaVillano();
					corazonesNivel.quitarVidaVillano();
					
				}
					
				else {
					miJuego.getControladorNivelUno().quitarVidaHeroe();
					corazonesNivel.quitarVidaHeroe();
				}
				
				//Coloca una nueva pregunta
				labelPreguntas.ponerPregunta(miJuego.getControladorNivelUno().darPregunta());
			}
		});
		
		
		labelRespuestas.getBotonFalso().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
									
				//Si toca el boton verdadero comprueba si la respuesta es correcta
				//y dependiendo de ello quita vida a los personajes
				if(miJuego.getControladorNivelUno().analizarRespuesta(false)){
					miJuego.getControladorNivelUno().quitarVidaVillano();
					corazonesNivel.quitarVidaVillano();
				
				}		
				else {
					miJuego.getControladorNivelUno().quitarVidaHeroe();
					corazonesNivel.quitarVidaHeroe();
					
				}				
				
				//Coloca una nueva pregunta
				labelPreguntas.ponerPregunta(miJuego.getControladorNivelUno().darPregunta());
			}
		});
		
		contentPane.add(labelRespuestas);	
		
		//Crear y pone en la pantalla los corazones de los personajes
		crearCorazonesHeroe();
		crearCorazonVillano();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//En caso que el mouse se mueva por la pantalla y se haya terminado el nivel
				//Se pasa al siguiente Nivel si ganó o se queda en el mismo si perdió
				if(Mijuego.getControladorNivelUno().finalizarPartida() > 0){
					dispose();
					SegundoNivel frame = new SegundoNivel(Mijuego);
					frame.setVisible(true);
				}
				else if(Mijuego.getControladorNivelUno().finalizarPartida() < 0){
					dispose();
					PrimerNivel frame = new PrimerNivel(Mijuego);
					frame.setVisible(true);
				}
			}
		});
		
		//Un timer para colocar una nota informativa de lo que consiste el nivel al cabo de 1 seg
		Timer timer = new Timer(1000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mensajeHecho){
					JOptionPane.showMessageDialog(null, "Para combatir con Sphinxx tendrás que ganarle en su juego.\n"
							+ "Ella te hará una serie de preguntas de lógica informática y tendrás que responder\n"
							+ "lo más acertado posible. Buena Suerte.");
					mensajeHecho = true;
				}
					
				
			}
		});
		timer.start();
		
		//Modificaciones al Frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage()); 
	}
	
	public void crearCorazonesHeroe(){
		
		//Crear los corazones del Heroe
		corazonesNivel.agregarCorarazonHeroe(new Corazon());
		corazonesNivel.getLastCorazonHeroe().setBounds(26, 397, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonHeroe());
		
		corazonesNivel.agregarCorarazonHeroe(new Corazon());
		corazonesNivel.getLastCorazonHeroe().setBounds(60, 397, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonHeroe());
		
		corazonesNivel.agregarCorarazonHeroe(new Corazon());
		corazonesNivel.getLastCorazonHeroe().setBounds(100, 397, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonHeroe());
		contentPane.add(corazonesNivel.getLastCorazonHeroe());
		
	}
	
	public void crearCorazonVillano(){
		
		//Crea los corazones de la Villana
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(428, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(473, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(515, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(560, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(608, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
		corazonesNivel.agregarCorazonVillano(new Corazon());
		corazonesNivel.getLastCorazonVillano().setBounds(643, 63, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());
		
	}
}

package ComponentesVisuales.Niveles;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.BarraMenu;
import ComponentesVisuales.Componentes.LabelPreguntas;
import Logica.Juego;
import Personajes.Heroe;
import Personajes.Medusa;
import Recursos.AudioClip;
import Util.ControladorCorazones;
import Util.Corazon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import ComponentesVisuales.Componentes.BotonExtendidoNivel2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SegundoNivel extends JFrame {

	private static final long serialVersionUID = -4285398109221870651L;
	private JPanel contentPane;
	private boolean mensajeHecho = false;
	private LabelPreguntas labelPreguntas;
	private Juego miJuego;
	private boolean seTermino = false;
	private BotonExtendidoNivel2 opcion1;
	private BotonExtendidoNivel2 opcion2;
	private BotonExtendidoNivel2 opcion3;
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
	private Thread thread;
	private AudioClip audio;

	public SegundoNivel(final Juego juego) {

		this.miJuego = juego;
		setTitle("Hello World! : Segundo Nivel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
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

		//Barra de menu
		BarraMenu barraMenu = new BarraMenu();
		BarraMenu.guardarEstadoActual(this);
		barraMenu.getMenu(1).getItem(0).setEnabled(true);
		barraMenu.getMenu(1).getItem(1).setEnabled(true);
		barraMenu.getMenu(1).getItem(2).setEnabled(true);
		barraMenu.getMenu(1).getItem(3).setEnabled(true);
		BarraMenu.guardarJuegoActual(miJuego);
		setJMenuBar(barraMenu);

		//Se crea el villano
		Medusa medusa = new Medusa();
		medusa.setBounds(753, 70, 268, 246);
		contentPane.add(medusa);

		//Se crea el heroe
		Heroe heroe = new Heroe();
		heroe.setBounds(28, 457, 305, 308);
		contentPane.add(heroe);

		//Controlador Segundo Nivel
		miJuego.crearControladorNivelDos(3, 6);

		//Controlador de Corazones
		corazonesNivel = new ControladorCorazones();

		//Label donde se ven las preguntas
		labelPreguntas = new LabelPreguntas(200, 150, 400, 150);
		labelPreguntas.setBackground(Color.WHITE);
		labelPreguntas.setForeground(Color.WHITE);
		labelPreguntas.setPreferredSize(new Dimension(400, 300));
		labelPreguntas.setBounds(new Rectangle(345, 102, 480, 179));
		labelPreguntas.setSize(new Dimension(450, 179));
		labelPreguntas.setSize(450, 179);
		labelPreguntas.setLocation(345, 102);
		//labelPreguntas.setHorizontalAlignment(SwingConstants.BOTTOM);
		labelPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreguntas.ponerPregunta(juego.getControladorNivelDos().darPregunta());
		contentPane.add(labelPreguntas);

		//Posible respuesta 1
		opcion1 = new BotonExtendidoNivel2();
		opcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!seTermino){
					if(juego.getControladorNivelDos().analizarRespuesta(juego.getControladorNivelDos().getPreguntas().get(juego.getControladorNivelDos().getPreguntaActual()).getPosiblesRespuestas().get(0))){
						juego.getControladorNivelDos().quitarVidaVillano();
						corazonesNivel.quitarVidaVillano();
					}else{
						juego.getControladorNivelDos().quitarVidaHeroe();
						corazonesNivel.quitarVidaHeroe();
					}

					if(miJuego.getControladorNivelDos().finalizarPartida() != 0) seTermino = true;
					else{
						labelPreguntas.ponerPregunta(juego.getControladorNivelDos().darPregunta());
						ponerPosiblesRespuestas();
					}
				}
			}
		});
		opcion1.setBounds(180, 305, 645, 115);
		contentPane.add(opcion1);

		//Posible respuesta 2
		opcion2 = new BotonExtendidoNivel2();
		opcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!seTermino){
					if(miJuego.getControladorNivelDos().analizarRespuesta(miJuego.getControladorNivelDos().getPreguntas().get(juego.getControladorNivelDos().getPreguntaActual()).getPosiblesRespuestas().get(1))){
						miJuego.getControladorNivelDos().quitarVidaVillano();
						corazonesNivel.quitarVidaVillano();
					}else{
						miJuego.getControladorNivelDos().quitarVidaHeroe();
						corazonesNivel.quitarVidaHeroe();
					}

					if(miJuego.getControladorNivelDos().finalizarPartida() != 0) seTermino = true;
					else{
						labelPreguntas.ponerPregunta(miJuego.getControladorNivelDos().darPregunta());
						ponerPosiblesRespuestas();
					}
				}
			}
		});
		opcion2.setBounds(180, 420, 645, 115);
		contentPane.add(opcion2);

		//Posible respuesta 3
		opcion3 = new BotonExtendidoNivel2();
		opcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!seTermino){
					if(miJuego.getControladorNivelDos().analizarRespuesta(miJuego.getControladorNivelDos().getPreguntas().get(juego.getControladorNivelDos().getPreguntaActual()).getPosiblesRespuestas().get(2))){
						miJuego.getControladorNivelDos().quitarVidaVillano();
						corazonesNivel.quitarVidaVillano();
					}else{
						miJuego.getControladorNivelDos().quitarVidaHeroe();
						corazonesNivel.quitarVidaHeroe();
					}

					if(miJuego.getControladorNivelDos().finalizarPartida() != 0) seTermino = true;
					else{
						labelPreguntas.ponerPregunta(miJuego.getControladorNivelDos().darPregunta());
						ponerPosiblesRespuestas();
					}


				}
			}
		});
		opcion3.setBounds(180, 535, 645, 115);
		contentPane.add(opcion3);

		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mensajeHecho){
					JOptionPane.showMessageDialog(null, "Para ganarle a Medusa tendr�s que ser inteligente y\n"
							+ "responder correctamente las preguntas, pero no te confies,\n"
							+ "este nivel no es como el anterior. Buena Suerte.");
					mensajeHecho = true;
				}


			}
		});
		timer.start();


		ponerPosiblesRespuestas();

		crearCorazonesHeroe();
		crearCorazonVillano();

		//Si gana el nivel pasa al siguiente, de lo contrario debe reintentar
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(miJuego.getControladorNivelDos().finalizarPartida() > 0){
					
					TercerNivel frame = new TercerNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
				else if(miJuego.getControladorNivelDos().finalizarPartida() < 0){
					
					SegundoNivel frame = new SegundoNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(miJuego.getControladorNivelDos().finalizarPartida() > 0){
					TercerNivel frame = new TercerNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
				else if(miJuego.getControladorNivelDos().finalizarPartida() < 0){
					SegundoNivel frame = new SegundoNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
			}
		});

	}

	//Metodo para poner las respuestas
	private void ponerPosiblesRespuestas(){
		int preguntaActual = miJuego.getControladorNivelDos().getPreguntaActual();
		opcion1.setText(miJuego.getControladorNivelDos().getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(0));
		opcion2.setText(miJuego.getControladorNivelDos().getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(1));
		opcion3.setText(miJuego.getControladorNivelDos().getPreguntas().get(preguntaActual).getPosiblesRespuestas().get(2));
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
		corazonesNivel.getLastCorazonVillano().setBounds(600, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

		villano2 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano2);
		corazonesNivel.getLastCorazonVillano().setBounds(640, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

		villano3 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano3);
		corazonesNivel.getLastCorazonVillano().setBounds(680, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

		villano4 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano4);
		corazonesNivel.getLastCorazonVillano().setBounds(720, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

		villano5 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano5);
		corazonesNivel.getLastCorazonVillano().setBounds(760, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

		villano6 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano6);
		corazonesNivel.getLastCorazonVillano().setBounds(800, 40, 25, 25);
		contentPane.add(corazonesNivel.getLastCorazonVillano());

	}
}

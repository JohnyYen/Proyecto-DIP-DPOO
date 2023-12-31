package ComponentesVisuales.Niveles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Recursos.CustomFont;
import Util.ControladorCorazones;
import ComponentesVisuales.Componentes.CartaVisual;
import ComponentesVisuales.Componentes.BarraMenu;
import ComponentesVisuales.Componentes.TextPanel;

import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;

import java.awt.*;

import Logica.Juego;
import Logica.Puntuacion;
import Personajes.Heroe;
import ComponentesVisuales.Componentes.BotonExtendido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Util.Corazon;
import Personajes.Dullahan;

public class TercerNivel extends JFrame {

	private JPanel contentPane;
	private JPanel setCarta1;
	private boolean mensajeHecho = false;
	private JPanel setCarta2;
	private JPanel setCarta3;
	private JLabel cuadroDialogos; 
	private JPanel descripcionCarta;
	private TextPanel titulo, texto;
	private Heroe heroe;
	private Juego miJuego;
	private CartaVisual cartaCuatro;
	private CartaVisual cartaTres;
	private CartaVisual cartaUno;
	private CartaVisual cartaDos;
	private boolean ocupadoSetUno, ocupadoSetDos, ocupadoSetTres;
	private ControladorCorazones controlCorazon;
	BufferedReader buffer;
	private Dullahan dullahan;

	public TercerNivel(final Juego juego) {
		setTitle("Hello World! : Tercer Nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		
		//Barra de Men�
		BarraMenu barraMenu = new BarraMenu();
		BarraMenu.guardarEstadoActual(this);
		barraMenu.getMenu(1).getItem(0).setEnabled(true);
		barraMenu.getMenu(1).getItem(1).setEnabled(true);
		barraMenu.getMenu(1).getItem(2).setEnabled(true);
		barraMenu.getMenu(1).getItem(3).setEnabled(true);
		//BarraMenu.guardarJuegoActual(miJuego);
		
		setJMenuBar(barraMenu);
		
		
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			//Dibujar el Fondo
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(PrimerNivel.class.getResource("/Recursos/FondoTercerNivel.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Las variables para verificar si las zonas donde se colocan las cartas estan ocupadas
		ocupadoSetUno = false;
		ocupadoSetDos = false;
		ocupadoSetTres = false;
		
		//Paneles de texto
		titulo = new TextPanel();
		texto = new TextPanel();
		
		//Personajes
		//Heroe
		heroe = new Heroe();
		heroe.setBounds(31, 416, 137, 150);
		contentPane.add(heroe);
		
		//Jinete
		dullahan = new Dullahan();
		dullahan.setBounds(677, 11, 197, 269);
		contentPane.add(dullahan);
		
		//Juego actual
		this.miJuego = juego;
		
		//Crear Controlador
		this.miJuego.crearControladorNivelTres(2,2);
		controlCorazon = new ControladorCorazones();
		
		//Zona donde describe la carta cuando se toca
		descripcionCarta = new JPanel();
		descripcionCarta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		descripcionCarta.setBackground(Color.WHITE);
		descripcionCarta.setBounds(193, 416, 265, 89);
		contentPane.add(descripcionCarta);
		descripcionCarta.setLayout(new BoxLayout(descripcionCarta, BoxLayout.Y_AXIS));
		descripcionCarta.add(titulo);
		descripcionCarta.add(texto);
		descripcionCarta.setVisible(false);
		
		
		//Cartas
		//Cartas 1
		cartaUno = new CartaVisual();
		cartaUno.setBounds(10, 138, 91, 124);
		cartaUno.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
		contentPane.add(cartaUno);
		
		//Carta 2
		cartaDos = new CartaVisual();
		cartaDos.setBounds(117, 138, 91, 124);
		cartaDos.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
		contentPane.add(cartaDos);
		
		//Carta 3
		cartaTres = new CartaVisual();
		cartaTres.setBounds(10, 273, 91, 124);
		cartaTres.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
		contentPane.add(cartaTres);
		
		//Carta 4
		cartaCuatro = new CartaVisual();
		cartaCuatro.setBounds(117, 273, 91, 124);
		cartaCuatro.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
		contentPane.add(cartaCuatro);
		
		//Sets de Cartas
		//SetCarta 1
		setCarta1 = new JPanel();
		setCarta1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta1.setBackground(Color.WHITE);
		setCarta1.setBounds(273, 245, 91, 124);
		contentPane.add(setCarta1);
		
		//SetCarta 2
		setCarta2 = new JPanel();
		setCarta2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta2.setBackground(Color.WHITE);
		setCarta2.setBounds(374, 245, 91, 124);
		contentPane.add(setCarta2);
		
		//SetCarta 3
		setCarta3 = new JPanel();
		setCarta3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setCarta3.setBackground(Color.WHITE);
		setCarta3.setBounds(475, 245, 91, 124);
		contentPane.add(setCarta3);
		
		//Crear el cuadro de Dialogo del nivel y dise�arlo
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		//Evento frame
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Cuando el mouse entra en contacto con el frame y se finalizo el nivel
				//Se pasa al siguiente o se mantiene en el mismo
				if(miJuego.getControladorTercerNivel().finalizarPartida() > 0) {
					CuartoNivel frame = new CuartoNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
				else if(miJuego.getControladorTercerNivel().finalizarPartida() < 0) {
					TercerNivel frame = new TercerNivel(miJuego);
					dispose();
					frame.setVisible(true);
				}
			}
		});
		
		//Eventos
		agregarEventoCartas(cartaUno);
		agregarEventoCartas(cartaDos);
		agregarEventoCartas(cartaTres);
		agregarEventoCartas(cartaCuatro );
				
		
		//Boton para comprobar la respuesta del jugador
		BotonExtendido btnxtndAceptarRespuesta = new BotonExtendido();
		btnxtndAceptarRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Se comprueba si alguna zona esta ocupada
				if(ocupadoSetUno || ocupadoSetDos || ocupadoSetTres){
					String respuestaJugador = "";
					
					//Se verifica si es la primera Carta
					//En caso de serlo se coje el codigo de la carta
					if(cartaUno.getLocation().equals(setCarta1.getLocation()) || cartaUno.getLocation().equals(setCarta2.getLocation()) || cartaUno.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaUno.getCarta().getCodigo();
					//Se verifica si es la segunda Carta
					//En caso de serlo se coje el codigo de la carta
					if(cartaDos.getLocation().equals(setCarta1.getLocation()) || cartaDos.getLocation().equals(setCarta2.getLocation()) || cartaDos.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaDos.getCarta().getCodigo();
					//Se verifica si es la tercera Carta
					//En caso de serlo se coje el codigo de la carta
					if(cartaTres.getLocation().equals(setCarta1.getLocation()) || cartaTres.getLocation().equals(setCarta2.getLocation()) || cartaTres.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaTres.getCarta().getCodigo();
					//Se verifica si es la cuarta Carta
					//En caso de serlo se coje el codigo de la carta
					if(cartaCuatro.getLocation().equals(setCarta1.getLocation()) || cartaCuatro.getLocation().equals(setCarta2.getLocation()) || cartaCuatro.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaCuatro.getCarta().getCodigo();
					
					
					//En el caso que no se haya finalizado la partida
					if(miJuego.getControladorTercerNivel().finalizarPartida() == 0){
						
						String textoRespuesta;
						try {
							//El texto de la respuesta
							textoRespuesta = buffer.readLine();
						} catch (IOException e2) {
							textoRespuesta = "Error"; 
							e2.printStackTrace();
						}
						
						//Compruebo la respuesta del jugado
						if(miJuego.getControladorTercerNivel().respuestaCorrecta(respuestaJugador, textoRespuesta)){
							miJuego.getControladorTercerNivel().quitarVidaVillano();
							controlCorazon.quitarVidaVillano();
						}
						else{
							miJuego.getControladorTercerNivel().quitarVidaHeroe();
							controlCorazon.quitarVidaHeroe();
						}
						
						//Despues se recolocan las cartas en las posiciones iniciales
						cartaUno.setBounds(10,138, 91, 124);
						cartaDos.setBounds(117, 138, 91, 124);
						cartaTres.setBounds(10, 273, 91, 124);
						cartaCuatro.setBounds(117, 273, 91, 124);
						
						cartaUno.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
						cartaDos.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
						cartaTres.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
						cartaCuatro.setCarta(miJuego.getControladorTercerNivel().repartirCarta());
						
						//Las zonas vuelven a estar desocupadas
						ocupadoSetUno = false;
						ocupadoSetDos = false;
						ocupadoSetTres = false;
						
						try {
							//Se coloca una nueva pregunta en el cuadro de dialogos
							cuadroDialogos.setText(buffer.readLine());
						}
						catch (IOException e1) {
							cuadroDialogos.setText("Ocurrio un Error");
							e1.printStackTrace();
						}
						
					}
				}
				
			}
		});
		btnxtndAceptarRespuesta.setText("Aceptar Respuesta");
		btnxtndAceptarRespuesta.setBounds(584, 371, 248, 36);
		contentPane.add(btnxtndAceptarRespuesta);
		
		
		//Corazones
		agregarCorazonesHeroe();
		agregarCorazonVillano();
		
		//Leer el fichero de las preguntas
		try{
			FileReader file = new FileReader("src/Textos/PreguntasNivelTres.txt");
			buffer = new BufferedReader(file);
			cuadroDialogos.setText(buffer.readLine());			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		//Colocar un mensaje inform�tivo de lo que consiste el nivel en 1 segundo
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mensajeHecho){
					JOptionPane.showMessageDialog(null, "La batalla con Dullahan no ser� como las otras\n"
							+ "tendr�s que resolver los problemas del jinete, con las cartas disponibles");
					mensajeHecho = true;
				}
					
				
			}
		});
		timer.start();
		
		
		
	}
	
	public void agregarEventoCartas(final CartaVisual carta){
		final Point punto = new Point(carta.getX(), carta.getY());
		carta.addMouseListener(new MouseAdapter() {
			//Si la carta es presionada sus datos, titulo y descripci�n aparecen
			//en la zona para describir la carta
			@Override
			public void mousePressed(MouseEvent e) {
				descripcionCarta.setVisible(true);
				titulo.setText(carta.getCarta().getNombre());
				texto.setText(carta.getCarta().getFuncionalidad());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//Cuando son retirado al cabo de 0.5 segundos se vacia la informaci�n
				Timer time = new Timer(500, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						texto.setText("                            ");
						titulo.setText("                           ");
						
					}
				});
				
				time.start();
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//Si a la carta se le hace Clic se verifica que zona esta disponible y
				// si la carta esta siendo usada, y despues se coloca en la zona del setCarta disponibles
				if((!ocupadoSetUno || !ocupadoSetDos || !ocupadoSetTres) && !carta.esUsadaCarta()){
					if(!ocupadoSetUno){
						carta.setBounds(setCarta1.getX(), setCarta1.getY(), 91, 124);
						ocupadoSetUno = true;
					}
					else if(!ocupadoSetDos){
						carta.setBounds(setCarta2.getX(), setCarta2.getY(), 91, 124);
						ocupadoSetDos = true;
					}
					else if(!ocupadoSetTres){
						carta.setBounds(setCarta3.getX(), setCarta3.getY(), 91, 124);
						ocupadoSetTres = true;
					}
					else{
						carta.setBounds(punto.x, punto.y, 91,124);
					}
					
					 carta.usarCarta();
				}
				//En caso que se le haga clic y esta siendo usada se coloca en su posici�n inicial
				else{
					carta.setBounds(punto.x, punto.y, 91,124);
					carta.liberarCarta();
					ocupadoSetUno = false;
				}
			}
		});
	}
	
	public void agregarCorazonesHeroe(){
		controlCorazon.agregarCorarazonHeroe(new Corazon());
		controlCorazon.getLastCorazonHeroe().setBounds(10, 581, 25, 25);
		contentPane.add(controlCorazon.getLastCorazonHeroe());
		
		controlCorazon.agregarCorarazonHeroe(new Corazon());
		controlCorazon.getLastCorazonHeroe().setBounds(51, 581, 25, 25);
		contentPane.add(controlCorazon.getLastCorazonHeroe());
	}
	
	public void agregarCorazonVillano(){
		controlCorazon.agregarCorazonVillano(new Corazon());
		controlCorazon.getLastCorazonVillano().setBounds(790, 50, 25, 25);
		contentPane.add(controlCorazon.getLastCorazonVillano());
		
		controlCorazon.agregarCorazonVillano(new Corazon());
		controlCorazon.getLastCorazonVillano().setBounds(830, 50, 25, 25);
		contentPane.add(		controlCorazon.getLastCorazonVillano());
	}
	
	public void diseniarLabel(JLabel cuadro){
		ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
		Image iconLabel = imagenLabel.getImage().getScaledInstance(450, 150, Image.SCALE_SMOOTH);
		
		CustomFont mf = new CustomFont();
		cuadro.setFont(mf.MyFont(1, 15));
		cuadro.setForeground(Color.WHITE);
		
		cuadro.setText("Tengo que hacer el proyecto de DPOO");
		cuadro.setBounds(298, 70, 450, 115);
		cuadro.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		cuadro.setVerticalTextPosition(SwingConstants.CENTER);
		cuadro.setHorizontalTextPosition(SwingConstants.CENTER);
		//cuadroDialogos.setPreferredSize (new Dimension(200,200)); 
		contentPane.add(cuadro);
	}
}

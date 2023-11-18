package ComponentesVisuales.Niveles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Recursos.CustomFont;
import Util.ControladorCorazones;
import Util.Puntuacion;
import ComponentesVisuales.Componentes.CartaVisual;
import ComponentesVisuales.Componentes.BarraMenu;
import ComponentesVisuales.Componentes.TextPanel;

import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;

import java.awt.*;

import Logica.Juego;
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
		
		//Barra de Menú
		BarraMenu barraMenu = new BarraMenu();
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
		this.miJuego.crearControladorNivelTres(heroe);
		controlCorazon = new ControladorCorazones();
		//Zona describir la carta
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
		
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		
		//Eventos
		agregarEventoCartas(cartaUno);
		agregarEventoCartas(cartaDos);
		agregarEventoCartas(cartaTres);
		agregarEventoCartas(cartaCuatro );
		
		BotonExtendido btnxtndAceptarRespuesta = new BotonExtendido();
		btnxtndAceptarRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(miJuego.getControladorTercerNivel().finalizarPartida() > 0) System.out.println("Gane");
				else if(miJuego.getControladorTercerNivel().finalizarPartida() < 0)System.out.println("Perdi");
				if(ocupadoSetUno || ocupadoSetDos || ocupadoSetTres){
					String respuestaJugador = "";
					if(cartaUno.getLocation().equals(setCarta1.getLocation()) || cartaUno.getLocation().equals(setCarta2.getLocation()) || cartaUno.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaUno.getCarta().getCodigo();
					if(cartaDos.getLocation().equals(setCarta1.getLocation()) || cartaDos.getLocation().equals(setCarta2.getLocation()) || cartaDos.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaDos.getCarta().getCodigo();
					if(cartaTres.getLocation().equals(setCarta1.getLocation()) || cartaTres.getLocation().equals(setCarta2.getLocation()) || cartaTres.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaTres.getCarta().getCodigo();
					if(cartaCuatro.getLocation().equals(setCarta1.getLocation()) || cartaCuatro.getLocation().equals(setCarta2.getLocation()) || cartaCuatro.getLocation().equals(setCarta3.getLocation()))
						respuestaJugador += cartaCuatro.getCarta().getCodigo();
					
				
					
					cartaUno.setBounds(10,138, 91, 124);
					cartaDos.setBounds(117, 138, 91, 124);
					cartaTres.setBounds(10, 273, 91, 124);
					cartaCuatro.setBounds(117, 273, 91, 124);
					ocupadoSetUno = false;
					ocupadoSetDos = false;
					ocupadoSetTres = false;
					
					try {
						cuadroDialogos.setText(buffer.readLine());
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnxtndAceptarRespuesta.setText("Aceptar Respuesta");
		btnxtndAceptarRespuesta.setBounds(584, 371, 248, 36);
		contentPane.add(btnxtndAceptarRespuesta);
		
		
		//Leer el fichero de las preguntas
		try{
			FileReader file = new FileReader("src/Textos/PreguntasNivelTres.txt");
			buffer = new BufferedReader(file);
			cuadroDialogos.setText(buffer.readLine());
			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void agregarEventoCartas(final CartaVisual carta){
		final Point punto = new Point(carta.getX(), carta.getY());
		carta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				descripcionCarta.setVisible(true);
				titulo.setText(carta.getCarta().getNombre());
				texto.setText(carta.getCarta().getFuncionalidad());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					//Thread.sleep(1000);
					texto.setText("                            ");
					titulo.setText("                           ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(!ocupadoSetUno || !ocupadoSetDos || !ocupadoSetTres){
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
				}
				else{
					carta.setBounds(punto.x, punto.y, 91,124);
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

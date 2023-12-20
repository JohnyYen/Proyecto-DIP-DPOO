package ComponentesVisuales.Niveles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import ComponentesVisuales.Componentes.BarraMenu;
import Logica.Juego;
import Personajes.GlitchMonster;
import Personajes.Heroe;
import Util.ControladorCorazones;
import Util.Corazon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

import ComponentesVisuales.Componentes.BotonExtendidoNivelCuatro;
import ComponentesVisuales.Pantallas.PantallaFinal;

public class CuartoNivel extends JFrame {
	private ArrayList<JButton> botones;
	private Juego mijuego;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private String comunicar;
	private  int ordenar;
	private Heroe heroe;
	private Corazon villano1;
	private Corazon villano2;
	private Corazon villano3;
	private Corazon heroe1;
	private Corazon heroe2;
	private Corazon heroe3;
	private JButton acceptButton; 
	private boolean mensajeHecho = false;
	private JButton button;
	private JButton botonObjeto2;
	private JButton botonObjeto3;
	private JButton botonObjeto4;
	private JButton botonObjeto5;
	private JButton botonObjeto6;
	private JButton botonObjeto7;
	private JButton botonObjeto8;
	private JButton botonObjeto9;
	private JButton botonObjeto10;
	private JLabel ComunicarLabel;
	private ControladorCorazones corazonesNivel;
	BufferedReader buffer;
	private GlitchMonster glitchMonster_1;
	private JLabel RecuerdameLabel;
	private boolean continuar;
	private JButton botonObjeto11;
	private JButton botonObjeto12;
	private BotonExtendidoNivelCuatro botonObjeto1;

	/**
	 * @wbp.parser.constructor
	 */
	public CuartoNivel(final Juego juego ){
		botones = new ArrayList<JButton>();
		setTitle("ï¿½Encuentra los objetos!");
		this.mijuego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		this.contentPane_1= new JPanel(){
			private static final long serialVersionUID = 1L;

			/*Fondo*/


			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(CuartoNivel.class.getResource("/Recursos/fondo cuarto nivel.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};		
		contentPane_1.setForeground(Color.WHITE);

		this.setContentPane(contentPane_1);

		/*Glitch*/
		contentPane_1.setLayout(null);

		glitchMonster_1 = new GlitchMonster(3);
		glitchMonster_1.setBounds(579, 380, 216, 192);
		contentPane_1.add(glitchMonster_1);

		heroe = new Heroe();


		//crear controlador
		this.mijuego.crearControladorCuartoNivel(3, 3);

		/*Peticion objetos*/

		JLabel lblNewLabel = new JLabel(this.comunicar);
		lblNewLabel.setBounds(130, 33, 568, 75);
		contentPane_1.add(lblNewLabel);

		

		BarraMenu barraMenu = new BarraMenu();
		BarraMenu.guardarEstadoActual(this);
		barraMenu.getMenu(1).getItem(0).setEnabled(true);
		barraMenu.getMenu(1).getItem(1).setEnabled(true);
		barraMenu.getMenu(1).getItem(2).setEnabled(true);
		barraMenu.getMenu(1).getItem(3).setEnabled(true);
		BarraMenu.guardarJuegoActual(mijuego);
		setJMenuBar(barraMenu);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;};


			/*Botones*/


			botonObjeto1 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(0).getNombre() );
			botonObjeto1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel(). getObjDisponibles().get(0));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(0).getNombre());
				}
			});
			botonObjeto1.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(0).getNombre());
			botonObjeto1.setBounds(10, 166, 150, 44);
			getContentPane().add(botonObjeto1);



			botonObjeto2 = new BotonExtendidoNivelCuatro( mijuego.getControladorCuartoNivel().getObjDisponibles().get(1).getNombre());
			botonObjeto2.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(1).getNombre());
			botonObjeto2.setBounds(174, 161, 126, 44);
			botonObjeto2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(1));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(1).getNombre());
				}
			});

			getContentPane().add(botonObjeto2);

			botonObjeto3 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2).getNombre());
			botonObjeto3.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2).getNombre());
			botonObjeto3.setBounds(324, 161, 126, 44);
			botonObjeto3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2).getNombre());
				}
			});
			getContentPane().add(botonObjeto3);

			botonObjeto4 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3).getNombre());
			botonObjeto4.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3).getNombre());
			botonObjeto4.setBounds(462, 161, 127, 44);
			botonObjeto4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3).getNombre());
				}
			});
			getContentPane().add(botonObjeto4);

			botonObjeto5 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4).getNombre());
			botonObjeto5.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4).getNombre());
			botonObjeto5.setBounds(601, 161, 122, 44);
			botonObjeto5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4).getNombre());
				}
			});
			getContentPane().add(botonObjeto5);

			botonObjeto6 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5).getNombre());
			botonObjeto6.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5).getNombre());
			botonObjeto6.setBounds(735, 161, 126, 44);
			botonObjeto6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5).getNombre());
				}
			});
			getContentPane().add(botonObjeto6);

			botonObjeto8 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7).getNombre());
			botonObjeto8.setBounds(174, 235, 130, 44);
			botonObjeto8.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7).getNombre());
			botonObjeto8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7).getNombre());
				}
			});

			botonObjeto7 = new BotonExtendidoNivelCuatro( mijuego.getControladorCuartoNivel().getObjDisponibles().get(6).getNombre());
			botonObjeto7.setBounds(28, 235, 123, 44);
			botonObjeto7.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6).getNombre());
			botonObjeto7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6).getNombre());
				}
			});
			getContentPane().add(botonObjeto7);
			getContentPane().add(botonObjeto8);


			botonObjeto9 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8).getNombre());
			botonObjeto9.setBounds(324, 235, 126, 44);
			botonObjeto9.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8).getNombre()); 
			botonObjeto9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8).getNombre());
				}
			});
			getContentPane().add(botonObjeto9);


			botonObjeto10 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9).getNombre());
			botonObjeto10.setBounds(472, 235, 122, 44);
			botonObjeto10.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9).getNombre());
			botonObjeto10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9).getNombre());
				}
			});
			getContentPane().add(botonObjeto10);



			botonObjeto11 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10).getNombre());
			botonObjeto11.setBounds(601, 235, 122, 44);
			botonObjeto11.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10).getNombre());
			botonObjeto11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10).getNombre());
				}
			});

			getContentPane().add(botonObjeto11);



			botonObjeto12 = new BotonExtendidoNivelCuatro(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11).getNombre());
			botonObjeto12.setBounds(735, 235, 126, 44);
			botonObjeto12.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11).getNombre());
			botonObjeto12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11).getNombre());
				}
			});

			getContentPane().add(botonObjeto12);
			//Agregar los botones al arrayList
			botones.add(botonObjeto1);	
			botones.add(botonObjeto2);
			botones.add(botonObjeto3);
			botones.add(botonObjeto4);
			botones.add(botonObjeto5);
			botones.add(botonObjeto6);
			botones.add(botonObjeto7);
			botones.add(botonObjeto8);
			botones.add(botonObjeto9);
			botones.add(botonObjeto10);
			botones.add(botonObjeto11);
			botones.add(botonObjeto12);




			ComunicarLabel = new JLabel("");
			ComunicarLabel.setForeground(Color.WHITE);
			ComunicarLabel.setBackground(Color.WHITE);
			ComunicarLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ComunicarLabel.setBounds(55, 13, 747, 84);
			ComunicarLabel.setText(mijuego.getControladorCuartoNivel().informarOrden());
			getContentPane().add(ComunicarLabel);

			JButton RehacerBoton = new BotonExtendidoNivelCuatro("Limpiar");
			RehacerBoton.setText("Limpiar");
			RehacerBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().getObjEncontrados().clear();
					RecuerdameLabel.setText(null );
				}
			});
			RehacerBoton.setBounds(104, 433, 114, 45);
			getContentPane().add(RehacerBoton);

			/*Aceptar*/

			acceptButton = new JButton("Aceptar");
			acceptButton.setBounds(274, 425, 228, 95);
			acceptButton.setText("Aceptar");
			acceptButton.setBorderPainted(false);
			acceptButton.setFocusPainted(false);
			acceptButton.setContentAreaFilled(false);
			ImageIcon icono = new ImageIcon("src/Recursos/botonrojoNivel4.png");
			Image icon = icono.getImage().getScaledInstance(acceptButton.getWidth(), acceptButton.getHeight(), Image.SCALE_SMOOTH);
			acceptButton.setIcon(new ImageIcon(icon));

			acceptButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(mijuego.getControladorCuartoNivel().finalizarPartida() == 0){
						if(mijuego.getControladorCuartoNivel().getObjEncontrados().isEmpty()){
							ComunicarLabel.setText(mijuego.getControladorCuartoNivel().prepararLabel());
						}else{
							continuar = mijuego.getControladorCuartoNivel().ordenEsCorrecto();
							ComunicarLabel.setText(mijuego.getControladorCuartoNivel().getComunicar());	
							if (continuar){
								mijuego.getControladorCuartoNivel().quitarVidaVillano();
								corazonesNivel.quitarVidaVillano();
							}else{
								mijuego.getControladorCuartoNivel().quitarVidaHeroe();
								corazonesNivel.quitarVidaHeroe();


							}
							mijuego.getControladorCuartoNivel().getObjEncontrados().clear();
							mijuego.getControladorCuartoNivel().getObjPerdidos().clear();
							mijuego.getControladorCuartoNivel().asignarObjetosPerdidos();
							
							ComunicarLabel.setText(mijuego.getControladorCuartoNivel().informarOrden());
						}

					}
					else{
						if(mijuego.getControladorCuartoNivel().finalizarPartida() == -1){
							CuartoNivel frame = new CuartoNivel(mijuego);
							dispose();
							frame.setVisible(true);
						}
						else{
							PantallaFinal frame = new PantallaFinal();
							dispose();
							frame.setVisible(true);
						}
					}
				}
			});

			getContentPane().setLayout(null);
			getContentPane().add(acceptButton);
			
			RecuerdameLabel = new JLabel("");
			RecuerdameLabel.setForeground(Color.WHITE);
			RecuerdameLabel.setBackground(Color.WHITE);
			RecuerdameLabel.setBounds(289, 342, 170, 39);
			getContentPane().add(RecuerdameLabel);

			//Un timer para colocar una nota informativa de lo que consiste el nivel al cabo de 1 seg
			Timer timer = new Timer(1000, new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!mensajeHecho){
						JOptionPane.showMessageDialog(null, "Ya estas en la recta final, solo te falta vencer al Glitch.\n"
								+ "Él te retará con un desafiante problema de ordenamiento.\n"
								+ "El orden que él te especifique tendras que seguirlo\n"
								+ " con los objetos en pantalla y cuando estes listo\n"
								+ "toca el botón rojo para vencerlo. Buena suerte");
						mensajeHecho = true;
					}


				}
			});
			timer.start();



			//Corazon 
			corazonesNivel = new ControladorCorazones();
			crearCorazonesHeroe();
			crearCorazonVillano();


	}

	public void crearCorazonesHeroe(){

		heroe1 = new Corazon();
		corazonesNivel.agregarCorarazonHeroe(heroe1);
		corazonesNivel.getLastCorazonHeroe().setBounds(27, 518, 52, 45);
		getContentPane().add(corazonesNivel.getLastCorazonHeroe());

		heroe2 = new Corazon();
		corazonesNivel.agregarCorarazonHeroe(heroe2);
		corazonesNivel.getLastCorazonHeroe().setBounds(80, 518, 52, 45);
		getContentPane().add(corazonesNivel.getLastCorazonHeroe());

		heroe3 = new Corazon();
		corazonesNivel.agregarCorarazonHeroe(heroe3);
		corazonesNivel.getLastCorazonHeroe().setBounds(131, 518, 52, 45);
		contentPane.add(corazonesNivel.getLastCorazonHeroe());
		getContentPane().add(corazonesNivel.getLastCorazonHeroe());

	}

	public void crearCorazonVillano(){
		villano1 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano1);
		corazonesNivel.getLastCorazonVillano().setBounds(695, 343, 26, 27);
		getContentPane().add(corazonesNivel.getLastCorazonVillano());

		villano2 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano2);
		corazonesNivel.getLastCorazonVillano().setBounds(721, 343, 26, 27);
		getContentPane().add(corazonesNivel.getLastCorazonVillano());

		villano3 = new Corazon();
		corazonesNivel.agregarCorazonVillano(villano3);
		corazonesNivel.getLastCorazonVillano().setBounds(747, 343, 26, 27);
		getContentPane().add(corazonesNivel.getLastCorazonVillano());}







	/**
	 * @return the ordenar
	 */
	public int getOrdenar() {
		return ordenar;
	}

	/**
	 * @param ordenar the ordenar to set
	 */
	public void setOrdenar(int ordenar) {
		this.ordenar = ordenar;
	}

	public String getComunicar() {
		return comunicar;
	}

	public void setComunicar(String comunicar) {
		this.comunicar = comunicar;
	}
}

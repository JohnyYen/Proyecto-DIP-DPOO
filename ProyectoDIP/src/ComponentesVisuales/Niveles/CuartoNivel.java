package ComponentesVisuales.Niveles;
import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Logica.*;
import ComponentesVisuales.Componentes.BarraMenu;
import Logica.Juego;
import Personajes.GlitchMonster;
import Personajes.Heroe;
import Util.ControladorCorazones;
import Util.Corazon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.awt.Font;

public class CuartoNivel extends JFrame {
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
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JLabel ComunicarLabel;
	private ControladorCorazones corazonesNivel;
	BufferedReader buffer;
	private GlitchMonster glitchMonster_1;
	private JLabel RecuerdameLabel;
	private boolean continuar;
	private JButton button_10;
	private JButton button_11;

	/**
	 * @wbp.parser.constructor
	 */
	public CuartoNivel(final Juego juego ){
		setTitle("�Encuentra los objetos!");
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
		this.mijuego.crearControladorCuartoNivel(heroe.getVidas(), glitchMonster_1.getVidas());

		/*Peticion objetos*/

		JLabel lblNewLabel = new JLabel(this.comunicar);
		lblNewLabel.setBounds(130, 33, 568, 75);
		contentPane_1.add(lblNewLabel);

		/*Aceptar*/
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.setBounds(256, 408, 271, 95);
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

					}
				}
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(acceptButton);

		/*Men�*/

		BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;};



		button = new JButton( mijuego.getControladorCuartoNivel().getObjDisponibles().get(0).getNombre());
						button.setBounds(51, 161, 108, 44);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel(). getObjDisponibles().get(0));
								RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(0).getNombre());
							}
						});
						getContentPane().add(button);
						

			button_1 = new JButton( mijuego.getControladorCuartoNivel().getObjDisponibles().get(1).getNombre());
			button_1.setBounds(196, 161, 108, 44);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(1));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(1).getNombre());
				}
			});
						
			getContentPane().add(button_1);

			button_2 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8).getNombre());
			button_2.setBounds(342, 161, 108, 44);
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(8).getNombre());
				}
			});
			getContentPane().add(button_2);

			button_3 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3).getNombre());
			button_3.setBounds(481, 161, 108, 44);
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(3).getNombre());
				}
			});
			getContentPane().add(button_3);

			button_4 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4).getNombre());
			button_4.setBounds(615, 161, 108, 44);
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(4).getNombre());
				}
			});
			getContentPane().add(button_4);

			button_5 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6).getNombre());
			button_5.setBounds(745, 161, 108, 44);
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(6).getNombre());
				}
			});
			getContentPane().add(button_5);

			button_7 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7).getNombre());
			button_7.setBounds(196, 235, 108, 44);
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(7).getNombre());
				}
			});
			
						button_6 = new JButton( mijuego.getControladorCuartoNivel().getObjDisponibles().get(2).getNombre());
						button_6.setBounds(51, 235, 108, 44);
						button_6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2));
								RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(2).getNombre());
							}
						});
						getContentPane().add(button_6);
			getContentPane().add(button_7);

			button_8 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5).getNombre());
			button_8.setBounds(342, 235, 108, 44);
			button_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(5).getNombre());
				}
			});
			getContentPane().add(button_8);

			button_9 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9).getNombre());
			button_9.setBounds(481, 235, 108, 44);
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(9).getNombre());
				}
			});
			getContentPane().add(button_9);
			
			button_10 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11).getNombre());
			button_10.setBounds(615, 235, 108, 44);
			button_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(11).getNombre());
				}
			});
			
			getContentPane().add(button_10);
			
			
			button_11 = new JButton(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10).getNombre());
			button_11.setBounds(745, 235, 108, 44);
			button_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().setObjEncontrados(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10));
					RecuerdameLabel.setText(mijuego.getControladorCuartoNivel().getObjDisponibles().get(10).getNombre());
				}
			});
			
			getContentPane().add(button_11);
									
									
									
									

			ComunicarLabel = new JLabel("");
			ComunicarLabel.setForeground(Color.WHITE);
			ComunicarLabel.setBackground(Color.WHITE);
			ComunicarLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ComunicarLabel.setBounds(55, 13, 747, 84);
			ComunicarLabel.setText(mijuego.getControladorCuartoNivel().informarOrden());
			getContentPane().add(ComunicarLabel);

			JButton RehacerBoton = new JButton("Limpiar");
			RehacerBoton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mijuego.getControladorCuartoNivel().getObjEncontrados().clear();
					RecuerdameLabel.setText(null );
				}
			});
			RehacerBoton.setBounds(143, 433, 75, 45);
			getContentPane().add(RehacerBoton);

			RecuerdameLabel = new JLabel("");
			RecuerdameLabel.setBackground(Color.WHITE);
			RecuerdameLabel.setBounds(291, 356, 170, 39);
			getContentPane().add(RecuerdameLabel);



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

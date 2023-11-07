package Iniciadora;

import java.awt.EventQueue;

import ComponentesVisuales.*;
import Logica.*;

public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void inicializarDatos(){
		InformacionJuego estadoJuego = new InformacionJuego();
		estadoJuego.crearPreguntaNivelUno("Hola", true);
		estadoJuego.crearPreguntaNivelUno("Hola2", false);
		
		InformacionJuegoActual.setEstadoJuego(estadoJuego);
	}
	
}

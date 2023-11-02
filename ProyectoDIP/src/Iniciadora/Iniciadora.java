package Iniciadora;

import java.awt.EventQueue;

import ComponentesVisuales.*
;
import Logica.EstadoJuego;
import Logica.EstadoJuegoActual;

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
		EstadoJuego estadoJuego = new EstadoJuego();
		estadoJuego.crearPreguntaNivelUno("Hola", true);
		estadoJuego.crearPreguntaNivelUno("Hola2", false);
		
		EstadoJuegoActual.setEstadoJuego(estadoJuego);
	}
	
}

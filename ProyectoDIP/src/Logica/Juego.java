package Logica;

import Personajes.*;

public class Juego {
	private InformacionJuego informacionActual;
	private Usuario usuario;
	private ControladorJuego controlador;
	private static Juego unicoJuego = null;
	
	public Juego(){
		informacionActual = new InformacionJuego();
	}
	
	public static void crearJuego(){
		if(unicoJuego == null) unicoJuego = new Juego();
		else throw new IllegalArgumentException();
	}
	
	public InformacionJuego getInformacionJuego(){
		return informacionActual;
	}
	public static Juego obtenerJuego(){
		return unicoJuego;
	}
	public void crearControladorNivelUno(Heroe heroe, Cleopatra villana){
		controlador = new ControladorPrimerNivel(heroe, villana, informacionActual);
	}
	public ControladorPrimerNivel getControladorNivelUno(){ return (ControladorPrimerNivel)controlador;}
}

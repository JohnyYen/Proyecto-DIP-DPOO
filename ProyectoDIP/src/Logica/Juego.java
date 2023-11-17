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
	
	public void crearUsuario(String nombre, String password){
		usuario = new Usuario(nombre, password);
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
	
	public void crearControladorNivelDos(Heroe heroe, Cleopatra villana){
		controlador = new ControladorSegundoNivel(heroe, villana, informacionActual);
	}

	public ControladorSegundoNivel getControladorNivelDos() {
		return (ControladorSegundoNivel)controlador;
	}
	
}

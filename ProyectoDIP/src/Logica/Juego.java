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
	
	public void crearUsuario(String nombre, String password, boolean esProfesor){
		usuario = new Usuario(nombre, password, esProfesor);
	}
	
	public Usuario getUsuario(){return this.usuario;}
	
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
		controlador = null;
		controlador = new ControladorPrimerNivel(heroe, villana, informacionActual);
	}
	public void crearControladorNivelTres(Heroe heroe){
		controlador = null;
		controlador = new ControladorTercerNivel(heroe, informacionActual);
	}
	
	public ControladorTercerNivel getControladorTercerNivel(){return (ControladorTercerNivel)controlador;}
	public ControladorPrimerNivel getControladorNivelUno(){ return (ControladorPrimerNivel)controlador;}
	
	public void crearControladorNivelDos(Heroe heroe, Medusa medusa){
		controlador = null;
		controlador = new ControladorSegundoNivel(heroe, medusa, informacionActual);
	}

	public ControladorSegundoNivel getControladorNivelDos() {
		return (ControladorSegundoNivel)controlador;
	}
	
}

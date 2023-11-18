package Logica;

import java.util.ArrayList;

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
	
	public static void crearJuego(){
		if(unicoJuego == null) unicoJuego = new Juego();
		else throw new IllegalArgumentException();
	}
	
	public InformacionJuego getInformacionJuego(){
		return informacionActual;
	}
	public Usuario getUsuario(){return this.usuario;}
	
	public void crearControladorNivelUno(int vidaHeroe, int vidaVillana){
		controlador = null;
		controlador = new ControladorPrimerNivel(vidaHeroe, vidaVillana, informacionActual);
	}
	public void crearControladorNivelTres(int vidaHeroe, int vidaDullahan){
		controlador = null;
		controlador = new ControladorTercerNivel(vidaHeroe, vidaDullahan, informacionActual);
	}
	public void crearControladorNivelDos(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorSegundoNivel(vidaHeroe, vidaVillano, informacionActual);
	}
	public ControladorSegundoNivel getControladorNivelDos(){return (ControladorSegundoNivel)controlador;}
	
	
	public void crearControladorCuartoNivel(int vidaHeroe, int vidaVillano){
		controlador = null;
		//controlador = new ControladorCuartoNivel(vidaHeroe, vidaVillano);
	}
	
	public ControladorTercerNivel getControladorTercerNivel(){return (ControladorTercerNivel)controlador;}
	public ControladorPrimerNivel getControladorNivelUno(){ return (ControladorPrimerNivel)controlador;}
	//public ControladorCuartoNivel getControladorCuartoNivel(){return (ControladorCuartoNivel)controlador;}

}
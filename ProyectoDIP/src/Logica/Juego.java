package Logica;

import java.util.ArrayList;
import Util.*;
import Personajes.*;

//Clase principal del juego, controladora de todas las funcionalidades el juego
public class Juego { 

	private InformacionJuego informacionActual;
	private Usuario usuario;
	private ControladorJuego controlador;


	public Juego(){
		informacionActual = new InformacionJuego();
	}

	//M�todo para crear Usuario
	public void crearUsuario(String nombre, String password, boolean esProfesor){
		usuario = new Usuario(nombre, password, esProfesor);
	}

	//M�todo para devolver la informaci�n del juego
	public InformacionJuego getInformacionJuego(){
		return informacionActual;
	}

	//M�todo para obtener el usuario
	public Usuario getUsuario(){return this.usuario;}


	//M�todo para crear el controlador del nivel uno
	public void crearControladorNivelUno(int vidaHeroe, int vidaVillana){
		controlador = null;
		controlador = new ControladorPrimerNivel(vidaHeroe, vidaVillana, informacionActual);
	}

	//M�todo para crear el controlador del nivel dos
	public void crearControladorNivelDos(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorSegundoNivel(vidaHeroe, vidaVillano, informacionActual);
	}

	//M�todo para crear el controlador del nivel tres
	public void crearControladorNivelTres(int vidaHeroe, int vidaDullahan){
		controlador = null;
		controlador = new ControladorTercerNivel(vidaHeroe, vidaDullahan, informacionActual);
	}

	//M�todo para crear el controlador del nivel cuatro
	public void crearControladorCuartoNivel(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorCuartoNivel(vidaHeroe, vidaVillano, informacionActual);
	}

	//Devolver el controlador del primer nivel
	public ControladorPrimerNivel getControladorNivelUno(){ return (ControladorPrimerNivel)controlador;}
	//Devolver el controlador del segundo nivel
	public ControladorSegundoNivel getControladorNivelDos(){return (ControladorSegundoNivel)controlador;}
	//Devolver el controlador del tercer nivel
	public ControladorTercerNivel getControladorTercerNivel(){return (ControladorTercerNivel)controlador;}
	//Devolver el controlador del cuarto nivel
	public ControladorCuartoNivel getControladorCuartoNivel(){return (ControladorCuartoNivel)controlador;}

}
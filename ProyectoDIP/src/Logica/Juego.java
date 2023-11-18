package Logica;

import Personajes.*;

public class Juego {
	private InformacionJuego informacionActual;
	private Usuario usuario;
	private ControladorJuego controlador;	
	public Juego(){
		informacionActual = new InformacionJuego();
	}
	
	//Crear un usuario Nuevo
	public void crearUsuario(String nombre, String password, boolean esProfesor){
		usuario = new Usuario(nombre, password, esProfesor);
	}
	
	//Obtener el usuario
	public Usuario getUsuario(){return this.usuario;}
	
	//Obtener la información del Juego
	public InformacionJuego getInformacionJuego(){
		return informacionActual;
	}
	
	//Crear el controlador del primer nivel, primero se le asigna null y despues se
	//instancia el controlador específico
	public void crearControladorNivelUno(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorPrimerNivel(vidaHeroe, vidaVillano, informacionActual);
	}
	
	//Crear el controlador del Tercer nivel, primero se le asigna null y despues se
	//instancia el controlador específico
	public void crearControladorNivelTres(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorTercerNivel(vidaHeroe, vidaVillano, informacionActual);
	}
	
	//Obtener el controlador del tercer Nivel
	public ControladorTercerNivel getControladorTercerNivel(){return (ControladorTercerNivel)controlador;}
	//Obtener el controlador del Primer Nivel
	public ControladorPrimerNivel getControladorNivelUno(){ return (ControladorPrimerNivel)controlador;}
	
	//Crear el controlador del Segundo nivel, primero se le asigna null y despues se
	//instancia el controlador específico
	public void crearControladorNivelDos(int vidaHeroe, int vidaVillano){
		controlador = null;
		controlador = new ControladorSegundoNivel(vidaHeroe, vidaVillano, informacionActual);
	}

	//Obtener el controlador del Segundo Nivel
	public ControladorSegundoNivel getControladorNivelDos() {
		return (ControladorSegundoNivel)controlador;
	}
	
}

package Logica;

import java.io.Serializable;

import javax.swing.*;

import Personajes.*;
import ComponentesVisuales.Pantallas.MenuPrincipal;

public abstract class ControladorJuego implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int vidaHeroe, vidaVillano;
	protected InformacionJuego informacionActual;
	public ControladorJuego(int vidaHeroe, int vidaVillano, InformacionJuego informacionActual){
		this.vidaHeroe = vidaHeroe;
		this.vidaVillano = vidaVillano;
		this.informacionActual = informacionActual;
	}
	
	//Método para quitar vida del heroe
	public void quitarVidaHeroe(){
		if(vidaHeroe > 0 ) vidaHeroe--;
	}
	
	//Método para quitar vida al villano
	public void quitarVidaVillano(){
		if(vidaVillano > 0) vidaVillano--;
	}
	
	//Método para verificar si la partida ya se termino
	//En caso que gano el heroe devuelve 1, en caso que gano el villano devuelve -1
	//Si nadie ha ganado devuelve 0
		public int  finalizarPartida() {
			int ganar = 0;
			if(vidaHeroe == 0) ganar = -1;
			else if(vidaVillano == 0) ganar = 1;
			return ganar;
		}
}

package Logica;

import javax.swing.*;

import Personajes.*;
import ComponentesVisuales.Pantallas.MenuPrincipal;

public abstract class ControladorJuego {
	int vidaHeroe, vidaVillano;
	protected InformacionJuego informacionActual;
	public ControladorJuego(int vidaHeroe, int vidaVillano, InformacionJuego informacionActual){
		this.vidaHeroe = vidaHeroe;
		this.vidaVillano = vidaVillano;
		this.informacionActual = informacionActual;
	}
	
	public void guardarPartida(JFrame frame){
		MenuPrincipal.guardarEstado(frame);
	}
	public void quitarVidaHeroe(){
		if(vidaHeroe > 0 ) vidaHeroe--;
	}
	public void quitarVidaVillano(){
		if(vidaVillano > 0) vidaVillano--;
	}
	public abstract int finalizarPartida();
}

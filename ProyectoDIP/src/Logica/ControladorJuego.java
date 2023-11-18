package Logica;

import javax.swing.*;

import Personajes.*;
import ComponentesVisuales.Pantallas.MenuPrincipal;

public abstract class ControladorJuego {
	protected Heroe guardarHeroe;
	protected InformacionJuego informacionActual;
	public ControladorJuego(Heroe heroe, InformacionJuego informacionActual){
		this.guardarHeroe = heroe; 
		this.informacionActual = informacionActual;
	}
	
	public void guardarPartida(JFrame parent){
		MenuPrincipal.guardarEstado(parent);
	}
	public void quitarVidaHeroe(){
		if(guardarHeroe.getVidas() > 0) guardarHeroe.perderVida();
	}
	public abstract void quitarVidaVillano();
	public abstract int finalizarPartida();
}

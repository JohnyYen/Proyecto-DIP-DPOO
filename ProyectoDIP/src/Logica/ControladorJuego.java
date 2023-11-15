package Logica;

import javax.swing.*;
import Personajes.*;
import ComponentesVisuales.MenuPrincipal;

public abstract class ControladorJuego {
	protected Heroe guardarHeroe;
	protected Villana guardarVillano;
	protected InformacionJuego informacionActual;
	public ControladorJuego(Heroe heroe, Villana villano, InformacionJuego informacionActual){
		this.guardarHeroe = heroe;
		this.guardarVillano = villano; 
		this.informacionActual = informacionActual;
	}
	
	public void guardarPartida(JFrame parent){
		MenuPrincipal.guardarEstado(parent);
	}
	public void quitarVidaHeroe(){
		if(guardarHeroe.getVidas() > 0) guardarHeroe.perderVida();
	}
	public void quitarVidaVillano(){
		if(guardarVillano.getVidas() > 0) guardarVillano.perderVida();
	}
	
}

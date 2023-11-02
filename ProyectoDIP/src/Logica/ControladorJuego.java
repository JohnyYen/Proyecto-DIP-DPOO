package Logica;

import javax.swing.*;
import Personajes.*;
import ComponentesVisuales.MenuPrincipal;

public abstract class ControladorJuego {
	protected Heroe guardarHeroe;
	protected Villana guardarVillano;
	public ControladorJuego(Heroe heroe, Villana villano){
		this.guardarHeroe = heroe;
		this.guardarVillano = villano; 
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

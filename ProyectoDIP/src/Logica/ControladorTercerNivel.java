package Logica;

import java.util.ArrayList;

import Personajes.Heroe;
import Util.*;
public class ControladorTercerNivel extends ControladorJuego{
	private int indiceCarta;
	public ControladorTercerNivel(int vidaHeroe, int vidaVillano, InformacionJuego informacionActual){
		super(vidaHeroe, vidaVillano, informacionActual);
		indiceCarta = 0;
	}
	public boolean respuestaCorrecta(String respuestaJugador, String respuesta){
		boolean correcto = false;
		if(respuestaJugador.equals(respuesta)) correcto = true;
		
		return correcto;
	}
	
	public Carta repartirCarta(){
		return informacionActual.getCartas().get(indiceCarta++);
	}
	@Override
	public int  finalizarPartida() {
		int ganar = 0;
		if(vidaHeroe == 0) ganar = -1;
		else if(vidaVillano == 0) ganar = 1;
		return ganar;
	}
	
}

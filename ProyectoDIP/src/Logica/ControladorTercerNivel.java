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
	
	//El controlador analiza la respuesta del jugador con la respuesta del problema
	public boolean respuestaCorrecta(String respuestaJugador, String respuesta){
		boolean correcto = false;
		if(respuestaJugador.equalsIgnoreCase(respuesta)) correcto = true;
		
		return correcto;
	}
	
	//El controlador reparte la carta
	public Carta repartirCarta(){
		return informacionActual.getCartas().get(indiceCarta++);
	}	
	
}

package Logica;

import java.util.ArrayList;

import Personajes.Heroe;
import Util.*;
public class ControladorTercerNivel extends ControladorJuego{
	private int indiceCarta;
	public ControladorTercerNivel(Heroe heroe, InformacionJuego informacionActual){
		super(heroe, informacionActual);
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
	public void quitarVidaVillano() {
		// TODO Auto-generated method stub
		
	}
	
}

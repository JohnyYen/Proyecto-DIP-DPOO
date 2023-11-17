package Logica;

import java.util.ArrayList;

import Util.*;
public class ControladorTercerNivel {
	private ArrayList<Carta> cartas;
	private int indiceCarta;
	public ControladorTercerNivel(){
		cartas = new ArrayList<>();
		indiceCarta = 0;
	}
	public boolean respuestaCorrecta(String respuestaJugador, String respuesta){
		boolean correcto = false;
		if(respuestaJugador.equals(respuesta)) correcto = true;
		
		return correcto;
	}
	
	public Carta repartirCarta(){
		return cartas.get(indiceCarta++);
	}
	
	
}

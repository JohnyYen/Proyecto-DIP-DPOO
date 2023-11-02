package Logica;

import java.util.ArrayList;
import Util.*;

public class EstadoJuegoActual {
	private static EstadoJuego estadoJuegoActual;
	public EstadoJuegoActual(EstadoJuego juego){
		estadoJuegoActual = juego;
	}
	public EstadoJuegoActual(){}
	
	public static void setEstadoJuego(EstadoJuego juego){
		if(!juego.equals(null)) estadoJuegoActual = juego;
		else throw new IllegalArgumentException("Error en los parametros");
	}
	
	public static ArrayList<PreguntaNivelUno> getPreguntaNivelUno(){
		return estadoJuegoActual.getPreguntasNivelUno();
	}
}

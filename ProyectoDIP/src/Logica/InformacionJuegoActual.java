package Logica;

import java.util.ArrayList;
import Util.*;

public class InformacionJuegoActual {
	private static InformacionJuego estadoJuegoActual;
	public InformacionJuegoActual(InformacionJuego juego){
		estadoJuegoActual = juego;
	}
	public InformacionJuegoActual(){}
	
	public static void setEstadoJuego(InformacionJuego juego){
		if(!juego.equals(null)) estadoJuegoActual = juego;
		else throw new IllegalArgumentException("Error en los parametros");
	}
	
	public static ArrayList<PreguntaNivelUno> getPreguntaNivelUno(){
		return estadoJuegoActual.getPreguntasNivelUno();
	}
}

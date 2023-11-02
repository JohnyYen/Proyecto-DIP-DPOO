package Logica;

import java.util.ArrayList;

import Personajes.*;
import Util.Pregunta;
public class ControladorPrimerNivel extends ControladorJuego {
	private ArrayList<Pregunta> preguntas;
	private int respuestaActual;
	
	public ControladorPrimerNivel(Heroe heroe, Villana villano, ArrayList<Pregunta> preg){
		super(heroe, villano);
		preguntas = new ArrayList<Pregunta>();
		for(Pregunta p: preg) this.preguntas.add(p);
		respuestaActual = 0;
	}
	
	public boolean analizarRespuesta(boolean respuesta){
		boolean respuestaCorrecta = false;
		if(respuesta == preguntas.get(respuestaActual++).getRespuesta()){
			respuestaCorrecta = true;
			super.quitarVidaVillano();			
		}
		else {
			super.quitarVidaHeroe();
		}
		return respuestaCorrecta;
	}
}

package Logica;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Personajes.*;
import Util.Pregunta;
import Util.PreguntaNivelUno;
public class ControladorPrimerNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelUno> preguntas;
	private int respuestaActual;
	
	public ControladorPrimerNivel(Heroe heroe, Villana villano){
		super(heroe, villano);
		preguntas.addAll(EstadoJuegoActual.getPreguntaNivelUno());
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

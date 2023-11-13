package Logica;

import java.util.ArrayList;

import Personajes.Heroe;
import Personajes.Villana;
import Util.PreguntaNivelDos;
import Util.PreguntaNivelUno;

public class ControladorSegundoNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelDos> preguntas;
	private int respuestaActual;
	
	public ControladorSegundoNivel(Heroe heroe, Villana villano) {
		super(heroe, villano);
		preguntas.addAll(InformacionJuegoActual.getPreguntaNivelDos());
		// TODO Auto-generated constructor stub
	}
	
	public boolean analizarRespuesta(String respuesta){
		boolean respuestaCorrecta = false;
		if(respuesta.equalsIgnoreCase(preguntas.get(respuestaActual).getPregunta())){
			respuestaCorrecta = true;
			super.quitarVidaVillano();			
		}
		else {
			super.quitarVidaHeroe();
		}
		return respuestaCorrecta;
	}
}

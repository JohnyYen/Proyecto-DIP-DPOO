package Logica;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import Personajes.*;
public class ControladorPrimerNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelUno> preguntasAnteriores;
	private int preguntaActual;

	public ControladorPrimerNivel(int vidaHeroe, int vidaVillano,InformacionJuego informacionActual){
		super(vidaHeroe, vidaVillano, informacionActual);
		preguntasAnteriores = new ArrayList<PreguntaNivelUno>();
	}

	//Se recibe una respuesta por parte del jugador y el controlador analiza si es la correcta
	public boolean analizarRespuesta(boolean respuesta){
		boolean respuestaFinal = false;
		if(informacionActual.getPreguntasNivelUno().get(preguntaActual).getRespuesta() == respuesta)
			respuestaFinal = true;
		return respuestaFinal;
	}

	//El controlador da las preguntas de forma aleatoria
	public String darPregunta(){
		Random random = new Random();
		int indicePregunta = random.nextInt(informacionActual.getPreguntasNivelUno().size());
		while(preguntasAnteriores.contains(informacionActual.getPreguntasNivelUno().get(indicePregunta))){
			indicePregunta = random.nextInt(informacionActual.getPreguntasNivelUno().size());
		}
		preguntasAnteriores.add(informacionActual.getPreguntasNivelUno().get(indicePregunta));
		preguntaActual = indicePregunta;
		return informacionActual.getPreguntasNivelUno().get(indicePregunta).getPregunta();
	}
}

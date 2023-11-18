package Logica;

import java.util.ArrayList;
import java.util.Random;
import Personajes.Heroe;
import Personajes.Medusa;
import Util.PreguntaNivelDos;

public class ControladorSegundoNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelDos> preguntasAnteriores;
	private int preguntaActual;
	
	public ControladorSegundoNivel(int vidaHeroe, int vidaVillano, InformacionJuego informacionActual) {
		super(vidaHeroe, vidaVillano, informacionActual);
		preguntasAnteriores = new ArrayList<PreguntaNivelDos>();
	}
	
	public boolean analizarRespuesta(String respuesta){
		boolean respuestaCorrecta = false;
		if(respuesta.equals(informacionActual.getPreguntasNivelDos().get(preguntaActual).getRespuesta())){
			respuestaCorrecta = true;
		}
		return respuestaCorrecta;
	}
	
	public String darPregunta(){
		Random random = new Random();
		int indicePregunta = random.nextInt(informacionActual.getPreguntasNivelDos().size());
		
		while(preguntasAnteriores.contains(informacionActual.getPreguntasNivelDos().get(indicePregunta)))
			indicePregunta = random.nextInt(informacionActual.getPreguntasNivelDos().size());
		
		preguntasAnteriores.add(informacionActual.getPreguntasNivelDos().get(indicePregunta));
		preguntaActual = indicePregunta;
		return informacionActual.getPreguntasNivelDos().get(indicePregunta).getPregunta();
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}
	
	public ArrayList<PreguntaNivelDos> getPreguntas() {
		return informacionActual.getPreguntasNivelDos();
	}
	
	@Override
	public int finalizarPartida(){
		int ganoHeroe = 0;
		if(vidaHeroe == 0) ganoHeroe = -1;
		else if(vidaVillano == 0) ganoHeroe = 1;
		return ganoHeroe;
	}
}

package Logica;

import java.util.ArrayList;
import java.util.Random;

import Personajes.Cleopatra;
import Personajes.Heroe;
import Util.PreguntaNivelDos;

public class ControladorSegundoNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelDos> preguntas;
	private ArrayList<PreguntaNivelDos> preguntasAnteriores;
	private int preguntaActual;
	private Cleopatra cleopatra;
	
	public ControladorSegundoNivel(Heroe heroe, Cleopatra cleopatra, InformacionJuego informacionActual) {
		super(heroe, informacionActual);
		this.cleopatra = cleopatra;
		preguntas = informacionActual.getPreguntasNivelDos();
		preguntasAnteriores = new ArrayList<PreguntaNivelDos>();
		// TODO Auto-generated constructor stub
	}
	
	public boolean analizarRespuesta(String respuesta){
		boolean respuestaCorrecta = false;
		
		if(respuesta.equalsIgnoreCase(preguntas.get(preguntaActual).getRespuesta()))
			respuestaCorrecta = true;
		
		return respuestaCorrecta;
	}
	
	public String darPregunta(){
		Random random = new Random();
		int indicePregunta = random.nextInt(preguntas.size());
		while(preguntasAnteriores.contains(preguntas.get(indicePregunta))){
			indicePregunta = random.nextInt(preguntas.size());
		}
		preguntasAnteriores.add(preguntas.get(indicePregunta));
		preguntaActual = indicePregunta;
		return preguntas.get(indicePregunta).getPregunta();
	}
	
	public void quitarVidaVillano() {
		if(cleopatra.getVidas() > 0) 
			cleopatra.perderVida();
	}
}

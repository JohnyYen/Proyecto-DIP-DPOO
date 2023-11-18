package Logica;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import Personajes.*;
import Util.Pregunta;
import Util.PreguntaNivelUno;
public class ControladorPrimerNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelUno> preguntas;
	private Cleopatra cleopatra;
	private ArrayList<PreguntaNivelUno> preguntasAnteriores;
	private int preguntaActual;
	
	public ControladorPrimerNivel(Heroe heroe,Cleopatra cleopatra,InformacionJuego informacionActual){
		super(heroe, informacionActual);
		this.cleopatra = cleopatra;
		preguntas = informacionActual.getPreguntasNivelUno();
		preguntasAnteriores = new ArrayList<PreguntaNivelUno>();
	}
	
	public boolean analizarRespuesta(boolean respuesta){
		boolean respuestaFinal = false;
		if(preguntas.get(preguntaActual).getRespuesta() == respuesta)
			respuestaFinal = true;
		return respuestaFinal;
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
	
	@Override
	public void quitarVidaVillano() {
		if(cleopatra.getVidas() > 0) {
			cleopatra.perderVida();
		}
		
	}
	@Override
	public boolean finalizarPartida(){
		boolean ganoHeroe = false;
		if(cleopatra.getVidas() == 0) ganoHeroe = true;
		
		return ganoHeroe;
	}
}

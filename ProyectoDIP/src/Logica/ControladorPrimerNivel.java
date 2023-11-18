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
	private Cleopatra cleopatra;
	private ArrayList<PreguntaNivelUno> preguntasAnteriores;
	private int preguntaActual;
	
	public ControladorPrimerNivel(Heroe heroe,Cleopatra cleopatra,InformacionJuego informacionActual){
		super(heroe, informacionActual);
		this.cleopatra = cleopatra;
		preguntasAnteriores = new ArrayList<PreguntaNivelUno>();
	}
	
	public boolean analizarRespuesta(boolean respuesta){
		boolean respuestaFinal = false;
		if(informacionActual.getPreguntasNivelUno().get(preguntaActual).getRespuesta() == respuesta)
			respuestaFinal = true;
		return respuestaFinal;
	}
	
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
	
	@Override
	public void quitarVidaVillano() {
		if(cleopatra.getVidas() > 0) {
			cleopatra.perderVida();
		}
		
	}
}

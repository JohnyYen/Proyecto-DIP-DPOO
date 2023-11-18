package Logica;

import java.util.ArrayList;
import java.util.Random;
import Personajes.Heroe;
import Personajes.Medusa;
import Util.PreguntaNivelDos;

public class ControladorSegundoNivel extends ControladorJuego {
	private ArrayList<PreguntaNivelDos> preguntas;
	private ArrayList<PreguntaNivelDos> preguntasAnteriores;
	private int preguntaActual;
	private Medusa medusa;
	
	public ControladorSegundoNivel(Heroe heroe, Medusa medusa, InformacionJuego informacionActual) {
		super(heroe, informacionActual);
		this.medusa = medusa;
		preguntas = informacionActual.getPreguntasNivelDos();
		preguntasAnteriores = new ArrayList<PreguntaNivelDos>();
		// TODO Auto-generated constructor stub
	}
	
	public boolean analizarRespuesta(String respuesta){
		boolean respuestaCorrecta = false;
		if(respuesta.equals(preguntas.get(preguntaActual).getRespuesta())){
			respuestaCorrecta = true;
		}
		return respuestaCorrecta;
	}
	
	public String darPregunta(){
		Random random = new Random();
		int indicePregunta = random.nextInt(preguntas.size());
		
		while(preguntasAnteriores.contains(preguntas.get(indicePregunta)))
			indicePregunta = random.nextInt(preguntas.size());
		
		preguntasAnteriores.add(preguntas.get(indicePregunta));
		preguntaActual = indicePregunta;
		return preguntas.get(indicePregunta).getPregunta();
	}
	
	public void quitarVidaVillano() {
		if(medusa.getVidas() > 0) 
			medusa.perderVida();
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}
	
	public ArrayList<PreguntaNivelDos> getPreguntas() {
		return preguntas;
	}
	
	@Override
	public int finalizarPartida(){
		int ganoHeroe = 0;
		if(guardarHeroe.getVidas() == 0) ganoHeroe = -1;
		else if(medusa.getVidas() == 0) ganoHeroe = 1;
		return ganoHeroe;
	}
}

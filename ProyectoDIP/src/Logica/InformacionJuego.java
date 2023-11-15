package Logica;

import java.util.ArrayList;

import Util.*;

public class InformacionJuego {
	private ArrayList<Pregunta> preguntas;
	
	public InformacionJuego(){
		preguntas = new ArrayList<Pregunta>(); 
	}
	
	public void crearPreguntaNivelUno(String texto, boolean respuesta){
		preguntas.add(new PreguntaNivelUno(texto, respuesta));
	}
	
	public void crearPreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		preguntas.add(new PreguntaNivelDos(texto, respuestas, respuestaFinal));
	}
	
	public ArrayList<PreguntaNivelUno> getPreguntasNivelUno(){
		ArrayList<PreguntaNivelUno> preguntasNivelUno = new ArrayList<PreguntaNivelUno>();
		
		for(Pregunta p : preguntas)
			if(p instanceof PreguntaNivelUno)
				preguntasNivelUno.add((PreguntaNivelUno)p);
		
		return preguntasNivelUno;
	}
	public ArrayList<PreguntaNivelDos> getPreguntasNivelDos(){
		ArrayList<PreguntaNivelDos> preguntasNivelDos = new ArrayList<PreguntaNivelDos>();
		for (Pregunta p : preguntas) {
			if(p instanceof PreguntaNivelDos)
				preguntasNivelDos.add((PreguntaNivelDos)p);
		}
		
		return preguntasNivelDos;
	}
}

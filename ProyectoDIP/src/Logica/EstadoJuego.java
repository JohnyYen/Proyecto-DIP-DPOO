package Logica;

import java.util.ArrayList;

import Util.Pregunta;

public class EstadoJuego {
	private ArrayList<Pregunta> preguntas;
	public EstadoJuego(){
		preguntas = new ArrayList<Pregunta>();
	}
	
	public void crearPregunta(String textoPregunta, boolean respuesta){
		preguntas.add(new Pregunta(textoPregunta, respuesta));
	}
	
	public boolean eliminarPregunta(Pregunta p){
		return preguntas.remove(p);		
	}
	
	public boolean modificarPregunta(Pregunta p, String nuevoTexto, boolean nuevaRespuesta){
		boolean modificado = false;
		int index = preguntas.indexOf(p);
		if (index >= 0){
			modificado = true;
			preguntas.get(index).setTexto(nuevoTexto);
			preguntas.get(index).setRespuesta(nuevaRespuesta);			
		}
		return modificado;		
	}
	
}

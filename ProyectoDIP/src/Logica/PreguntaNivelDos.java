package Logica;

import java.util.ArrayList;

//Clase usada en el nivel dos para las preguntas
public class PreguntaNivelDos extends Pregunta{
	private ArrayList<String> posiblesRespuestas;
	private String respuesta;
	
	//Constructor
	public PreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		super(texto);
		posiblesRespuestas = new ArrayList<String>();
		posiblesRespuestas.addAll(respuestas);
		this.respuesta = respuestaFinal;
	}

	//Obtener todas las posibles respuestas a la pregunta
	public ArrayList<String> getPosiblesRespuestas() {
		return posiblesRespuestas;
	}

	//Obtener la respuesta de la pregunta
	public String getRespuesta() {
		return respuesta;
	}
	
}

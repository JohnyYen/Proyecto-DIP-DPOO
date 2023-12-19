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
		setRespuesta(respuestaFinal);
	}

	//Obtener todas las posibles respuestas a la pregunta
	public ArrayList<String> getPosiblesRespuestas() {
		return posiblesRespuestas;
	}

	//Obtener la respuesta de la pregunta
	public String getRespuesta() {
		return respuesta;
	}
	
	//Establecer la respuesta correcta
	public void setRespuesta(String respuesta) {
		if (respuesta.replaceAll(" ", "").equalsIgnoreCase(""))
			throw new IllegalArgumentException("Error, No puede estar vacio");
		else 
			this.respuesta = respuesta;
	}
	
}

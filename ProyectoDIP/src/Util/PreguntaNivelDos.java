package Util;

import java.util.ArrayList;

public class PreguntaNivelDos extends Pregunta{
	private ArrayList<String> posiblesRespuestas;
	private String respuesta;
	
	public PreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		super(texto);
		posiblesRespuestas = new ArrayList<String>();
		posiblesRespuestas.addAll(respuestas);
		this.respuesta = respuestaFinal;
	}

	public ArrayList<String> getPosiblesRespuestas() {
		return posiblesRespuestas;
	}

	public String getRespuesta() {
		return respuesta;
	}
	
}

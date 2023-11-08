package Util;

import java.util.ArrayList;

public class PreguntaNivelDos extends Pregunta{
	private ArrayList<String> posiblesRespuestas;
	private String respuesta;
	
	public PreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		super(texto);
		posiblesRespuestas = respuestas;
		this.respuesta = respuestaFinal;
	}
}

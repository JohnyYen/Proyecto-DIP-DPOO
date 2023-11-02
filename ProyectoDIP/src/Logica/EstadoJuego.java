package Logica;

import java.util.ArrayList;
import Util.*;

public class EstadoJuego {
	private ArrayList<PreguntaNivelUno> preguntasNivelUno;
	private ArrayList<PreguntaNivelDos> preguntasNivelDos;
	
	public EstadoJuego(){
		preguntasNivelUno = new ArrayList<PreguntaNivelUno>();
		preguntasNivelDos = new ArrayList<PreguntaNivelDos>();
	}
	
	public ArrayList<PreguntaNivelUno> getPreguntasNivelUno(){
		return this.preguntasNivelUno;
	}
	
	public void crearPreguntaNivelUno(String texto, boolean respuesta){
		this.preguntasNivelUno.add(new PreguntaNivelUno(texto, respuesta));
	}
	
	public void crearPreguntaNivelDos(String texto, ArrayList<String> respuestas, String respuesta){
		this.preguntasNivelDos.add(new PreguntaNivelDos(texto, respuestas, respuesta));
	}
}

package Logica;

import java.util.ArrayList;

import Util.*;

public class InformacionJuego {
	private ArrayList<Pregunta> preguntas;
	private ArrayList<Carta> cartas;
	
	public InformacionJuego(){
		preguntas = new ArrayList<Pregunta>(); 
		cartas = new ArrayList<Carta>();
	}
	
	//Crear la carta
	public void crearCarta(String nombre, String funcionalidad, String codigo){
		cartas.add(new Carta(nombre, funcionalidad, codigo));
	}
	//Obtener el arrayList de cartas
	public ArrayList<Carta> getCartas(){return this.cartas;}
	
	//Crear una nueva pregunta para el nivel uno
	public void crearPreguntaNivelUno(String texto, boolean respuesta){
		preguntas.add(new PreguntaNivelUno(texto, respuesta));
	}
	
	//Crear una nueva pregunta para el nivel dos
	public void crearPreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		preguntas.add(new PreguntaNivelDos(texto, respuestas, respuestaFinal));
	}
	
	//Obtener lsa preguntas para el nivel uno
	public ArrayList<PreguntaNivelUno> getPreguntasNivelUno(){
		ArrayList<PreguntaNivelUno> preguntasNivelUno = new ArrayList<PreguntaNivelUno>();
		
		for(Pregunta p : preguntas)
			if(p instanceof PreguntaNivelUno)
				preguntasNivelUno.add((PreguntaNivelUno)p);
		
		return preguntasNivelUno;
	}
	
	//Obtener lsa preguntas para el nivel dos
	public ArrayList<PreguntaNivelDos> getPreguntasNivelDos(){
		ArrayList<PreguntaNivelDos> preguntasNivelDos = new ArrayList<PreguntaNivelDos>();
		for (Pregunta p : preguntas) {
			if(p instanceof PreguntaNivelDos)
				preguntasNivelDos.add((PreguntaNivelDos)p);
		}
		
		return preguntasNivelDos;
	}
}

package Logica;

import java.util.ArrayList;

import Util.*;


//Clase que guarda la información de todas las entidades necesarias para jugar
public class InformacionJuego {
	private ArrayList<Pregunta> preguntas;
	private ArrayList<Carta> cartas;
	private ArrayList<Objeto> objetos;
	public InformacionJuego(){
		preguntas = new ArrayList<Pregunta>(); 
		cartas = new ArrayList<Carta>();
		objetos = new ArrayList<Objeto>();
	}
	
	//Crear la carta
	public void crearCarta(String nombre, String funcionalidad, String codigo){
		cartas.add(new Carta(nombre, funcionalidad, codigo));
	}
	
	//Obtener el arrayList de cartas
	public ArrayList<Carta> getCartas(){return this.cartas;}
	
	//Agregar un nuevo arrayList de cartas
	public void setCartas(ArrayList<Carta> nuevasCartas){
		cartas.removeAll(cartas);
		cartas.addAll(nuevasCartas);
	}
	
	//Crear objeto nuevo
	public void crearObjeto(String nombre, float tamanio, String tipo){
		objetos.add(new Objeto(nombre, tamanio, tipo));
	}
	
	//Obtener el ArrayList de objetos
	public ArrayList<Objeto> getObjetos(){return this.objetos;}
	
	//Agregar una nueva lista de Objetos
	public void setObjetos(ArrayList<Objeto> nuevosObjetos){
		objetos.removeAll(objetos);
		objetos.addAll(nuevosObjetos);
	}
	
	//Crear una nueva pregunta para el nivel uno
	public void crearPreguntaNivelUno(String texto, boolean respuesta){
		preguntas.add(new PreguntaNivelUno(texto, respuesta));
	}
	
	//Crear una nueva pregunta para el nivel dos
	public void crearPreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		preguntas.add(new PreguntaNivelDos(texto, respuestas, respuestaFinal));
	}
	
	//Obtener las preguntas para el nivel uno
	public ArrayList<PreguntaNivelUno> getPreguntasNivelUno(){
		ArrayList<PreguntaNivelUno> preguntasNivelUno = new ArrayList<PreguntaNivelUno>();
		
		for(Pregunta p : preguntas)
			if(p instanceof PreguntaNivelUno)
				preguntasNivelUno.add((PreguntaNivelUno)p);
		
		return preguntasNivelUno;
	}
	
	//Agregar un ArrayList nuevo al de preguntas del nivel uno
	public void setPreguntasNivelUno(ArrayList<PreguntaNivelUno> preguntasNuevas){
		int size = preguntas.size();
		for(int i = 0; i < size; i++){
			Pregunta p = preguntas.get(i);
			if(p instanceof PreguntaNivelUno){
				this.preguntas.remove(p);
				size--;
			}
				
		}
		preguntas.addAll(preguntasNuevas);
	}
	
	//Agregar un nuevo arrayList para las preguntas del nivel dos
	public void setPreguntasNivelDos(ArrayList<PreguntaNivelDos> preguntasNuevas){
		int size = preguntas.size();
		for(int i = 0; i < size; i++){
			Pregunta p = preguntas.get(i);
			if(p instanceof PreguntaNivelDos){
				this.preguntas.remove(p);
				size--;
			}
		}
		preguntas.addAll(preguntasNuevas);
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

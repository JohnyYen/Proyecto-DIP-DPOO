package Logica;

import java.io.Serializable;
import java.util.ArrayList;

import Util.*;


//Clase que guarda la información de todas las entidades necesarias para jugar
public class InformacionJuego implements Serializable {
	
	private ArrayList<PreguntaNivelUno> preguntasNivelUno;
	private ArrayList<PreguntaNivelDos> preguntasNivelDos;
	private ArrayList<Carta> cartas;
	private ArrayList<Objeto> objetos;
	public InformacionJuego(){
		preguntasNivelDos = new ArrayList<PreguntaNivelDos>();
		preguntasNivelUno = new ArrayList<PreguntaNivelUno>();
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
		cartas.clear();
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
		objetos.clear();
		objetos.addAll(nuevosObjetos);
	}
	
	//Crear una nueva pregunta para el nivel uno
	public void crearPreguntaNivelUno(String texto, boolean respuesta){
		preguntasNivelUno.add(new PreguntaNivelUno(texto, respuesta));
	}
	
	//Crear una nueva pregunta para el nivel dos
	public void crearPreguntaNivelDos(String texto,ArrayList<String> respuestas, String respuestaFinal){
		preguntasNivelDos.add(new PreguntaNivelDos(texto, respuestas, respuestaFinal));
	}
	
	//Obtener las preguntas para el nivel uno
	public ArrayList<PreguntaNivelUno> getPreguntasNivelUno(){
		
		return preguntasNivelUno;
	}
	
	//Agregar un ArrayList nuevo al de preguntas del nivel uno
	public void setPreguntasNivelUno(ArrayList<PreguntaNivelUno> preguntasNuevas){
		preguntasNivelUno.clear();
		preguntasNivelUno.addAll(preguntasNuevas);
		
	}
	
	//Agregar un nuevo arrayList para las preguntas del nivel dos
	public void setPreguntasNivelDos(ArrayList<PreguntaNivelDos> preguntasNuevas){
		preguntasNivelDos.clear();
		preguntasNivelDos.addAll(preguntasNuevas);
	}
	
	//Obtener lsa preguntas para el nivel dos
	public ArrayList<PreguntaNivelDos> getPreguntasNivelDos(){
		
		return preguntasNivelDos;
	}
}

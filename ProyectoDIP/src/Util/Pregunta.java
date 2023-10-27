 package Util;

import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

public class Pregunta {
	private String textoPregunta;
	private boolean respuesta;
	
	public Pregunta(String texto, boolean respuesta){
		try {
			this.setTexto(texto);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textoPregunta = "Invalido";
		}
		this.respuesta = respuesta;
	}
	
	public Pregunta(){
		
	}
	
	public void setTexto(String text){
		if (text.equals(null))
			throw new IllegalArgumentException("Error, No puede estar vacio");
		else this.textoPregunta = text;
	}
	public  void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}
	
	public void agregarPreguntaRespuesta(String texto, boolean resp){
		this.setTexto(texto);
		this.respuesta = resp;
	}
	public boolean getRespuesta(){return this.respuesta;}
	public String getPregunta(){return  this.textoPregunta;}
}

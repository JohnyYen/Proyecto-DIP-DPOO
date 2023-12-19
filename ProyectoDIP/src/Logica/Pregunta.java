 package Logica;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

//Clase abstracta usada como modelo para las demás preguntaas usadas en el juego
public abstract class Pregunta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String textoPregunta;
	public Pregunta(String texto){
		try {
			this.setTexto(texto);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textoPregunta = "Invalido";
		}
	}
	public void setTexto(String text){
		if (text.replaceAll(" ", "").equalsIgnoreCase(""))
			throw new IllegalArgumentException("Error, No puede estar vacio");
		else this.textoPregunta = text;
	}
	
	public String getPregunta(){return  this.textoPregunta;}
}

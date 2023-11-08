 package Util;

import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

public class Pregunta {
	private String textoPregunta;
	public Pregunta(String texto){
		try {
			this.setTexto(texto);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			textoPregunta = "Invalido";
		}
	}
	
	public Pregunta(){}
	
	public void setTexto(String text){
		if (text.equals(null))
			throw new IllegalArgumentException("Error, No puede estar vacio");
		else this.textoPregunta = text;
	}
	
	public String getPregunta(){return  this.textoPregunta;}
}

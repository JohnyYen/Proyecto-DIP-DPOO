package Logica;

import java.util.ArrayList;

import Util.PreguntaTableModel;
import Util.PreguntaTableModelSegundoNivel;

//Clase que se usara para todas las validaciones en el juego
public class Validacion {
	
	public boolean esValidaContrasenia(char[] password){
		int cantNumeros = 0,cantLetras = 0, cantMayusculas = 0;
		
		for(char c : password){
			if(Character.isDigit(c)) cantNumeros++;
			if(Character.isLetter(c)) cantLetras++;
			if(Character.isUpperCase(c)) cantMayusculas++;
		}
		
		return ((cantNumeros >= 2)&&(cantLetras >= 3) && (cantMayusculas >=1)) ? true : false;
				
	}
	
	public boolean esUsuarioCorrecto(String usuario){
		boolean correcto = false;
		if(usuario.length() >= 3){
			int cantLetras = 0;
			for(char c : usuario.toCharArray())
				if(Character.isAlphabetic(c)) cantLetras++;
			
			if(cantLetras >= 1) correcto = true;
		}
		
		return correcto;
	}
	
	//Validar que las casillas en las tablas no este vacia
	public boolean casillasVaciasEnTablas(PreguntaTableModel nivel1, PreguntaTableModelSegundoNivel nivel2){
		boolean correcto = true;
		
		for (int i = 0; i < nivel1.getRowCount() && correcto; i++)
			if(String.valueOf(nivel1.getValueAt(i, 0)).replaceAll(" ", "").equalsIgnoreCase("") || String.valueOf(nivel1.getValueAt(i, 1)).replaceAll(" ", "").equalsIgnoreCase(""))
				correcto = false;
		
		if (correcto)
			for (int i = 0; i < nivel2.getRowCount() && correcto; i++)
				if(String.valueOf(nivel2.getValueAt(i, 0)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 1)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 2)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 3)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 4)).replaceAll(" ", "").equalsIgnoreCase(""))
					correcto = false;

		return correcto;
	}
	
	//Validar los atributos de las cartas en el modo Profesor
	public boolean validarCarta(ArrayList<Carta> cartas){
		boolean valido = true;
		
		for(int i = 0; i < cartas.size() && valido; i++){
			Carta c = cartas.get(i);
			if(c.getCodigo().replace(" ", "").equalsIgnoreCase(" ") || c.getCodigo().length() == 1) 
				valido = false;
			if(c.getNombre().replace(" ", "").equalsIgnoreCase(" ") || c.getNombre().length() < 7)
				valido = false;
			if(c.getFuncionalidad().replace(" ", "").equalsIgnoreCase(" ") || c.getFuncionalidad().length() < 15)
				valido = false;	
		}
		
		return valido;
	}
	
	//Validamos si la cadena de entrada se puede transformar a flotante
		public boolean esNumeroflotante(String input){
			
			boolean correcto = false; 
			try{
				//Se intenta convertir la cadena a un número flotante
				float numero = Float.parseFloat(input);
				
				correcto = true;
				
			}
			
			//En caso que no se logre convertir a flotante se capturará la excepción
			catch(NumberFormatException e){
				
				correcto = false;
			}
			
			return correcto; 
		}
		
}

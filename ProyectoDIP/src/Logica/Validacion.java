package Logica;

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
	
	public boolean casillasVaciasEnTablas(PreguntaTableModel nivel1, PreguntaTableModelSegundoNivel nivel2){
		boolean correcto = true;
		
		for (int i = 0; i < nivel1.getRowCount() && correcto; i++)
			if(((String)nivel1.getValueAt(i, 0)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel1.getValueAt(i, 1)).replaceAll(" ", "").equalsIgnoreCase(""))
				correcto = false;
		
		if (correcto)
			for (int i = 0; i < nivel2.getRowCount() && correcto; i++)
				if(((String)nivel2.getValueAt(i, 0)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 1)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 2)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 3)).replaceAll(" ", "").equalsIgnoreCase("") || ((String)nivel2.getValueAt(i, 4)).replaceAll(" ", "").equalsIgnoreCase(""))
					correcto = false;

		return correcto;
	}
}

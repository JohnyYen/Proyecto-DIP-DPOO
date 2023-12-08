package Logica;

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
}

package Logica;
import java.lang.String;


public class Objeto{
	private String nombre;
	private float tamaño;
	private String tipo;


public Objeto(String nombre,float tamaño, String tipo){
	setNombre(nombre);
	setTamaño(tamaño);
	setTipo(tipo);
}

public void setNombre(String nombre){
	if(nombre.trim().isEmpty())
		throw new IllegalArgumentException();
	else
		this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}
public float getTamaño() {
	return tamaño;
}

public void setTamaño(float tamaño) {
if(tamaño > 0|| tamaño < 1000){
	this.tamaño = tamaño;}
else {
throw new IllegalArgumentException ("Error. Solo valores superiores a 0 e inferiores a 1000");
}
}



/**
 * @return the tipo
 */
public String getTipo() {
	return tipo;
}



/**
 * @param tipo the tipo to set
 */
public void setTipo(String tipo) {
	this.tipo = tipo;
}






}

package Util;
import java.lang.String;


public class Objetos {
private String nombre;
private float tamaño;


public Objetos(String nombre,float tamaño){
	setNombre(nombre);
	setTamaño(tamaño);
}



public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
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






}

package Util;
import java.lang.String;


public class Objetos {
private String nombre;
private float tama�o;
private String tipo;


public Objetos(String nombre,float tama�o){
	setNombre(nombre);
	setTama�o(tama�o);
}



public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getTama�o() {
	return tama�o;
}

public void setTama�o(float tama�o) {
if(tama�o > 0|| tama�o < 1000){
	this.tama�o = tama�o;}
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

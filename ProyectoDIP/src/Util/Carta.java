package Util;

public class Carta {
	private String nombre;
	
	public Carta(String nombre){
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombre = nombre;
	}
	
	public String getNombre(){ return this.nombre;}
}

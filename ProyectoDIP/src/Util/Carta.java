package Util;

public class Carta {
	private String nombre, funcionalidad;
	
	public Carta(String nombre, String funcionalidad){
		this.setNombre(nombre);
		
	}
	
	public void setNombre(String nombre){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombre = nombre;
	}
	
	public String getFuncionalidad(){ return this.funcionalidad;}
	
	public void setFuncionalidad(String funcionalidad){
		if(funcionalidad.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.funcionalidad = funcionalidad;
	}
	
	public String getNombre(){ return this.nombre;}
}

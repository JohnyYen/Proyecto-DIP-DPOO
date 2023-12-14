package Logica;

import java.io.Serializable;

public class Carta implements Serializable{
	private String nombre, funcionalidad, codigo;
	
	public Carta(String nombre, String funcionalidad, String codigo){
		this.setNombre(nombre);
		this.setFuncionalidad(funcionalidad);
		this.setCodigo(codigo);
		
	}
	
	public void setCodigo(String codigo){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.codigo = codigo;
	}
	
	public String getCodigo(){return this.codigo;}
	
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

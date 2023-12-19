package Logica;

import java.io.Serializable;

public class Usuario implements Serializable{
	private String nombreUsuario, password;
	boolean esProfesor;
	
	public Usuario(String nombreUsuario, String password, boolean esProfesor){
		this.setNombre(nombreUsuario);
		this.setPassword(password);
		this.esProfesor = esProfesor;
	}
	
	public void setPassword(String contrasenia){
		if(contrasenia.replaceAll(" ", "").equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.password = contrasenia;
	}
	
	public String getPassword(){return this.password;}
	
	public void setNombre(String nombre){
		if(nombre.replaceAll(" ", "").equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombreUsuario = nombre;
	}
	
	public boolean getEsProfesor(){return this.esProfesor;}
	
	public String getNombreUsuario(){ return this.nombreUsuario;}
}

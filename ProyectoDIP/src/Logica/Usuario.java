package Logica;

public class Usuario {
	private String nombreUsuario, password;
	boolean esProfesor;
	
	public Usuario(String nombreUsuario, String password, boolean esProfesor){
		this.setNombre(nombreUsuario);
		this.password = password;
		this.esProfesor = esProfesor;
	}
	
	public void setPassword(String contrasenia){
		if(contrasenia.trim().equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.password = contrasenia;
	}
	
	public String getPassword(){return this.password;}
	
	public void setNombre(String nombre){
		if(nombre.trim().equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombreUsuario = nombre;
	}
	
	public String getNombreUsuario(){ return this.nombreUsuario;}
}

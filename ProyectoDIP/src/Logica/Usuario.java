package Logica;

public class Usuario {
	private String nombreUsuario, password;
	boolean esProfesor;
	
	public Usuario(String nombreUsuario, String password, boolean esProfesor){
		this.setNombre(nombreUsuario);
		this.password = password;
		this.esProfesor = esProfesor;
	}
	
	public void setNombre(String nombre){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombreUsuario = nombre;
	}
	
	public String getNombreUsuario(){ return this.nombreUsuario;}
}

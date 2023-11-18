package Logica;

public class Usuario {
	private String nombreUsuario, password;
	
	public Usuario(String nombreUsuario, String password){
		this.setNombre(nombreUsuario);
		this.password = password;
	}
	
	public void setNombre(String nombre){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombreUsuario = nombre;
	}
	
	public String getNombreUsuario(){ return this.nombreUsuario;}
}

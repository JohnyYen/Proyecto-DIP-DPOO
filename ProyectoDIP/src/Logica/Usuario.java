package Logica;

public class Usuario {
	private String nombreUsuario;
	
	public Usuario(String nombreUsuario){
		this.setNombre(nombreUsuario);
	}
	
	public void setNombre(String nombre){
		if(nombre.equalsIgnoreCase(""))
			throw new IllegalArgumentException();
		else
			this.nombreUsuario = nombre;
	}
	
	public String getNombreUsuario(){ return this.nombreUsuario;}
}

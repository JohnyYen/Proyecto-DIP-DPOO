package ControladoresJuego;

public class Estudiante {
	private String nombreUsuario;
	
	public Estudiante(String nombreUsuario){
		this.setNombreUsuario(nombreUsuario);
	}
	
	public void setNombreUsuario(String usuario){
		if (!usuario.contains("")) this.nombreUsuario = usuario;
	}
}

package Logica;

import java.util.ArrayList;



public class Profesor {
	private EstadoJuego estadoJuego;
	private ArrayList<Estudiante> estudiantes;
	private String nombre;
	public Profesor(String nombre){
		estadoJuego = new EstadoJuego();
		estudiantes = new ArrayList<Estudiante>();
		this.setNombre(nombre);	
	}
	
	private void setNombre(String nombre){
		if (!nombre.contains("")) this.nombre = nombre;
	}
}

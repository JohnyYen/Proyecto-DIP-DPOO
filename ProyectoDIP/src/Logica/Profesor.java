package Logica;

import java.util.ArrayList;



public class Profesor {
	private InformacionJuego informacionJuego;
	private ArrayList<Estudiante> estudiantes;
	private String nombre;
	public Profesor(String nombre){
		informacionJuego = new InformacionJuego();
		estudiantes = new ArrayList<Estudiante>();
		this.setNombre(nombre);	
	}
	
	private void setNombre(String nombre){
		if (!nombre.contains("")) this.nombre = nombre;
	}
}

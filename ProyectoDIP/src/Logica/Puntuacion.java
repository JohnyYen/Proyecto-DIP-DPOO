package Logica;

public class Puntuacion {
	
	private int nivel, respuestasCorrectas, respuestasIncorrectas;
	
	public Puntuacion(int nivel){
		this.nivel = nivel;
		this.respuestasCorrectas = 0;
		this.respuestasIncorrectas = 0;
	}
	
	//Obtener el promedio de las respuestas correctas
	public double promedioRespuestasCorrectas(){
		return (double)(respuestasCorrectas/(respuestasCorrectas+respuestasIncorrectas));
	}
	
	//Obtener el promedio de las respuestas incorrectas
	public double promedioRespuestasIncorrectas(){
		return (double)(respuestasIncorrectas/(respuestasCorrectas+respuestasIncorrectas));
	}
	
	public int getRespuestasCorrectas(){
		return this.respuestasCorrectas;
	}
	
	public int getRespuestasIncorrectas(){
		return this.respuestasIncorrectas;
	}
}

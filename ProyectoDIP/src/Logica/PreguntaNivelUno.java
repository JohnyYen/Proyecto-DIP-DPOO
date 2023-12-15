package Logica;

//Clase usada en el nivel uno para las preguntas
public class PreguntaNivelUno extends Pregunta {
	private boolean respuesta;
	
	//Constructor si la respuesta es boolean
	public PreguntaNivelUno(String pregunta, boolean respuesta){
		super(pregunta);
		this.respuesta = respuesta;
	}
	
	//Constructor si la respuesta es String
	public PreguntaNivelUno(String pregunta, String respuesta){
		super(pregunta);
		this.respuesta = Boolean.parseBoolean(respuesta);
	}
	
	//Obtener la respuesta
	public boolean getRespuesta(){return this.respuesta;}
	
	
	public  void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}
	
	public void agregarPreguntaRespuesta(String texto, boolean resp){
		this.setTexto(texto);
		this.respuesta = resp;
	}
}

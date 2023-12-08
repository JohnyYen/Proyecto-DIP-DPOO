package Logica;

public class PreguntaNivelUno extends Pregunta {
	private boolean respuesta;
	
	public PreguntaNivelUno(String pregunta, boolean respuesta){
		super(pregunta);
		this.respuesta = respuesta;
	}
	
	public PreguntaNivelUno(String pregunta, String respuesta){
		super(pregunta);
		this.respuesta = Boolean.parseBoolean(respuesta);
	}
	public boolean getRespuesta(){return this.respuesta;}
	
	public  void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}
	
	public void agregarPreguntaRespuesta(String texto, boolean resp){
		this.setTexto(texto);
		this.respuesta = resp;
	}
}

package Logica;
import java.io.Serializable;
import java.lang.String;


public class Objeto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private float tamanio;
	private String tipo;


	public Objeto(String nombre,float tamanio, String tipo){
		setNombre(nombre);
		setTamaño(tamanio);
		setTipo(tipo);
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getTamanio() {
		return tamanio;
	}

	public void setTamaño(float tamanio) {
		if(tamanio > 0|| tamanio < 1000){
			this.tamanio = tamanio;}
		else {
			throw new IllegalArgumentException ("Error. Solo valores superiores a 0 e inferiores a 1000");
		}
	}



	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}



	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}






}

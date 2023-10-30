package ControladoresJuego;

public class EstadoJuegoActual {
	private static EstadoJuego estadoJuegoActual;
	public EstadoJuegoActual(EstadoJuego juego){
		estadoJuegoActual = juego;
	}
	public EstadoJuegoActual(){}
	
	public static void setEstadoJuego(EstadoJuego juego){
		if(!juego.equals(null)) estadoJuegoActual = juego;
		else throw new IllegalArgumentException("Error en los parametros");
	}
}

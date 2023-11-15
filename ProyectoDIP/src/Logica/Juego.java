package Logica;

public class Juego {
	private InformacionJuego informacionActual;
	private Usuario usuario;
	private ControladorJuego controlador;
	private static Juego unicoJuego = null;
	
	private Juego(){
		informacionActual = new InformacionJuego();
	}
	
	public static void crearJuego(){
		if(unicoJuego == null) unicoJuego = new Juego();
		else throw new IllegalArgumentException();
	}
	
	public InformacionJuego getInformacionJuego(){
		return informacionActual;
	}
	public static Juego obtenerJuego(){
		return unicoJuego;
	}
}

package Iniciadora;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ComponentesVisuales.Niveles.*;
import ComponentesVisuales.Pantallas.PantallaProfesores;
import Logica.*;

public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {  
					Juego juego = new Juego();
					inicializarDatosPrimerNivel(juego);
					//PrimerNivel primerNivel = new PrimerNivel(juego);
					PantallaProfesores frame = new PantallaProfesores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void inicializarDatosPrimerNivel(Juego juego){
		try{
			FileReader file = new FileReader("src/Textos/PreguntasNivelUno.txt");
			BufferedReader buffer = new BufferedReader(file);
			String textoPregunta, textoRespuesta;
			while(buffer.ready()){
				textoPregunta = buffer.readLine();
				textoRespuesta = buffer.readLine();
				juego.getInformacionJuego().crearPreguntaNivelUno(textoPregunta, Boolean.parseBoolean(textoRespuesta));
			}
			buffer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}

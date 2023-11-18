package Iniciadora;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ComponentesVisuales.Niveles.*;
import ComponentesVisuales.Pantallas.PantallaProfesores;
import Logica.*;
import Util.PreguntaNivelDos;

public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {  
					Juego juego = new Juego();
					inicializarDatosPrimerNivel(juego);
					inicializarDatosSegundoNivel(juego);
					//PrimerNivel primerNivel = new PrimerNivel(juego);
					SegundoNivel segundoNivel = new SegundoNivel(juego);
					
					//primerNivel.setVisible(true);
					segundoNivel.setVisible(true);
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
	
	public static void inicializarDatosSegundoNivel(Juego juego) {
		try{
			FileReader file = new FileReader("src/Textos/PreguntasNivelDos.txt");
			BufferedReader buffer = new BufferedReader(file);
			String textoPregunta, textoRespuesta;
			ArrayList<String> posiblesRespuestas = new ArrayList<String>();
			
			while(buffer.ready()){
				textoPregunta = buffer.readLine();
				textoRespuesta = buffer.readLine();
				posiblesRespuestas.clear();
				
				for (int i = 0; i < 3; i++) 
					posiblesRespuestas.add(buffer.readLine());
				
				juego.getInformacionJuego().crearPreguntaNivelDos(textoPregunta, posiblesRespuestas, textoRespuesta);
			}
			
			buffer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}

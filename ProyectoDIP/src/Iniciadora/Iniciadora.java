
package Iniciadora;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ComponentesVisuales.Niveles.CuartoNivel;
import ComponentesVisuales.Niveles.PrimerNivel;
import ComponentesVisuales.Niveles.SegundoNivel;
import ComponentesVisuales.Niveles.TercerNivel;
import ComponentesVisuales.Pantallas.PantallaCarga;
import ComponentesVisuales.Pantallas.PantallaProfesores;
import Logica.*;

public class Iniciadora {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Juego juego;
				PantallaCarga frame;
				try {  	
					ObjectInputStream stream = new ObjectInputStream(new FileInputStream("src/Textos/partidaGuardada.json"));
					juego = (Juego)stream.readObject();
					stream.close();
				} catch (Exception e) {
					juego = new Juego();
					inicializarDatosPrimerNivel(juego);
					inicializarDatosTercerNivel(juego);
					inicializarDatosSegundoNivel(juego);
					inicializarDatosCuartoNivel(juego);
				}
				frame = new PantallaCarga(juego);
				frame.setVisible(true);
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
	
	public static void inicializarDatosTercerNivel(Juego juego){
		try{
			FileReader file = new FileReader("src/Textos/Cartas.txt");
			BufferedReader buffer = new BufferedReader(file);
			String nombre, funcionalidad, codigo;
			while(buffer.ready()){
				nombre = buffer.readLine();
				funcionalidad = buffer.readLine();
				codigo = buffer.readLine();
				juego.getInformacionJuego().crearCarta(nombre, funcionalidad, codigo);
			}
			buffer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void inicializarDatosCuartoNivel(Juego juego) {
	    try {
	        FileReader fr = new FileReader("src/Textos/parametrosObjetos.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String nombre, tipo;
	        float tamanio;
	        while(br.ready()) {
	        	nombre = br.readLine();
	        	tamanio = Float.parseFloat(br.readLine());
	        	tipo = br.readLine();
	        	juego.getInformacionJuego().crearObjeto(nombre, tamanio, tipo);
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}

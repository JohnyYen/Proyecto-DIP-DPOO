package Logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Personajes.*;
import Util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ControladorCuartoNivel extends ControladorJuego {
private ArrayList <Objeto> objDisponibles ;
private ArrayList<Objeto>objPerdidos;	
private	ArrayList<Objeto> objEncontrados;



public ControladorCuartoNivel(int vidaHeroe, int vidaVillano, InformacionJuego informacionActual ) {
		super(vidaHeroe, vidaVillano, informacionActual);
			
		objDisponibles = new ArrayList<Objeto>();
		objPerdidos = new ArrayList<Objeto>();
		objEncontrados  = new ArrayList<Objeto>();
		procesarArchivoTexto();
		asignarObjetosPerdidos();
	}



public ArrayList <Objeto> getObjDisponibles() {
	return objDisponibles;
}



public void setObjDisponibles(ArrayList <Objeto> objDisponibles) {
	this.objDisponibles = objDisponibles;
}



public ArrayList<Objeto> getObjEncontrados() {
	return objEncontrados;
}



 void setObjEncontrados(Objeto objEncontrados) {
	 if (this.objEncontrados.size() < 4) {
	 this.objEncontrados.add(objEncontrados);
	 } else {
	      this.objEncontrados.clear();
	    }
}



public ArrayList<Objeto> getObjPerdidos() {
	return objPerdidos;
}



public void setObjPerdidos(ArrayList<Objeto> objPerdidos) {
	this.objPerdidos = objPerdidos;
}




public void asignarObjetosPerdidos() {
    Collections.shuffle(objDisponibles); 
    for (int i = 0; i < 4; i++) {
    	objPerdidos.add(objDisponibles.get(i)); 
    }
}



	
public boolean ordenEsCorrecto(int control, ArrayList<Objeto> objPerdidos,ArrayList<Objeto> objEncontrados){
	boolean orden = true;

	if(objEncontrados.size()!= objPerdidos.size()){
		orden = false;
		
	}else{
	
	switch(control){
	case 1: mismOrden(  objPerdidos,objEncontrados);
		
		break;
		
	case 2: ordenInverso(objPerdidos,objEncontrados);
		break;
		
		
	case 3: mayorMenor(objEncontrados);
		break;
	
	case 4: menorMayor(objEncontrados);
		
		break;
		
		default:
		orden = false;	
		super.quitarVidaHeroe();
	}
	}
	
	if(orden == true){
		quitarVidaVillano();
		
	}
	
	return orden;
	
	
	
}	
	



public ArrayList<Objeto> procesarArchivoTexto() {
    ArrayList<Objeto> objDisponibles = new ArrayList<>();

    try {
        File archivo = new File("src/Recursos/parametrosObjetos.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(","); 
            if (partes.length == 3) {
                String nombre = partes[0].trim();
                int tamaño = Integer.parseInt(partes[1].trim());
                String tipo = partes[2].trim();
                Objeto obj = new Objeto(nombre, tamaño, tipo);
                objDisponibles.add(obj);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return objDisponibles;
}






public boolean mismOrden( ArrayList<Objeto> objPerdidos,ArrayList<Objeto> objEncontrados){
	boolean correcto = true;
	
	for(int i=0;i<4 && correcto != false;i++){
		if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(i).getNombre()))){
			correcto = false;
		}
	}
	
	
	return correcto;}






public boolean ordenInverso( ArrayList<Objeto> objPerdidos,ArrayList<Objeto> objEncontrados){
boolean correcto = true;
	
for(int i=0;i<4 && correcto != false;i++){
	if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(4-i).getNombre()))){
		correcto = false;
	}
}
	
	
	return correcto;}



public boolean mayorMenor( ArrayList<Objeto> objEncontrados){
boolean correcto = true;

for(int i=1;i<4 && correcto != false;i++){
	if(objEncontrados.get(i).getTamanio() < objEncontrados.get(i-1).getTamanio()){
		correcto = false;
	}
}
	
	
	return correcto;}




public boolean menorMayor(ArrayList<Objeto> objEncontrados){
boolean correcto = true;
	
	
for(int i=1;i<4 && correcto != false;i++){
	if(objEncontrados.get(i).getTamanio() > objEncontrados.get(i-1).getTamanio()){
		correcto = false;
	}
}
	
	return correcto;}
	
	
}

package Logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Personajes.Heroe;
import Personajes.Villana;
import Util.Objetos;



public class ControladorCuartoNivel extends ControladorJuego {

private ArrayList <Objetos> objDisponibles ;
private ArrayList<Objetos>objPerdidos;	
private	ArrayList<Objetos> objEncontrados;


public ControladorCuartoNivel(Heroe heroe, Villana villano,ArrayList <Objetos> objPerdidos,ArrayList <Objetos> objEncontrados,ArrayList <Objetos> objDisponibles ) {
		super(heroe, villano);
			
		objDisponibles = new ArrayList <Objetos>(12);
		objPerdidos = new ArrayList<Objetos>(4);
		objEncontrados  = new ArrayList<Objetos>(4);
		asignarObjetosPerdidos();
		
	}



public ArrayList <Objetos> getObjDisponibles() {
	return objDisponibles;
}



public void setObjDisponibles(ArrayList <Objetos> objDisponibles) {
	this.objDisponibles = objDisponibles;
}



public ArrayList<Objetos> getObjEncontrados() {
	return objEncontrados;
}



public void setObjEncontrados(ArrayList<Objetos> objEncontrados) {
	this.objEncontrados = objEncontrados;
}



public ArrayList<Objetos> getObjPerdidos() {
	return objPerdidos;
}



public void setObjPerdidos(ArrayList<Objetos> objPerdidos) {
	this.objPerdidos = objPerdidos;
}




public void asignarObjetosPerdidos() {
    Collections.shuffle(objDisponibles); 
    for (int i = 0; i < 4; i++) {
    	objPerdidos.add(objDisponibles.get(i)); 
    }
}




public ArrayList<String> obtenerInfo() {
    ArrayList<String> informacion = new ArrayList<>();
    for (Objetos objeto : objPerdidos) {
        String info = "Nombre: " + objeto.getNombre() + ", Tipo: " + objeto.getTipo() + ", Tamaño: " + objeto.getTamaño();
        informacion.add(info);
    }
    return informacion;
}


	
public boolean ordenEsCorrecto(int control, ArrayList<Objetos> objPerdidos,ArrayList<Objetos> objEncontrados){
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
		super.quitarVidaVillano();
	}
	
	return orden;
	
	
	
}	
	
public boolean mismOrden( ArrayList<Objetos> objPerdidos,ArrayList<Objetos> objEncontrados){
	boolean correcto = true;
	
	for(int i=0;i<4 && correcto != false;i++){
		if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(i).getNombre()))){
			correcto = false;
		}
	}
	
	
	return correcto;}



public boolean ordenInverso( ArrayList<Objetos> objPerdidos,ArrayList<Objetos> objEncontrados){
boolean correcto = true;
	
for(int i=0;i<4 && correcto != false;i++){
	if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(4-i).getNombre()))){
		correcto = false;
	}
}
	
	
	return correcto;}



public boolean mayorMenor( ArrayList<Objetos> objEncontrados){
boolean correcto = true;

for(int i=1;i<4 && correcto != false;i++){
	if(objEncontrados.get(i).getTamaño() < objEncontrados.get(i-1).getTamaño()){
		correcto = false;
	}
}
	
	
	return correcto;}




public boolean menorMayor(ArrayList<Objetos> objEncontrados){
boolean correcto = true;
	
	
for(int i=1;i<4 && correcto != false;i++){
	if(objEncontrados.get(i).getTamaño() > objEncontrados.get(i-1).getTamaño()){
		correcto = false;
	}
}
	
	return correcto;}




	
	
}

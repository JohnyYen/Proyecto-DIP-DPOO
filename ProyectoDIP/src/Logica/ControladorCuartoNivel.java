package Logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import Personajes.*;
import Personajes.Heroe;
import Personajes.Cleopatra;
import Util.Objetos;
import ComponentesVisuales.Niveles.CuartoNivel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ControladorCuartoNivel extends ControladorJuego {
private GlitchMonster monster;
private ArrayList <Objetos> objDisponibles ;
private ArrayList<Objetos>objPerdidos;	
private	ArrayList<Objetos> objEncontrados;



public ControladorCuartoNivel(Heroe heroe,GlitchMonster monster,InformacionJuego info,ArrayList <Objetos> objPerdidos,ArrayList <Objetos> objEncontrados,ArrayList <Objetos> objDisponibles ) {
		super(heroe, info);
			
		objDisponibles = new ArrayList <Objetos>(12);
		objPerdidos = new ArrayList<Objetos>(4);
		objEncontrados  = new ArrayList<Objetos>(4);
		procesarArchivoTexto();
		asignarObjetosPerdidos();
	    CuartoNivel cuart = new CuartoNivel( objDisponibles,objPerdidos,objEncontrados);
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



 void setObjEncontrados(Objetos objEncontrados) {
	 if (this.objEncontrados.size() < 4) {
	 this.objEncontrados.add(objEncontrados);
	 } else {
	      this.objEncontrados.clear();
	    }
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
		quitarVidaVillano();
		
	}
	
	return orden;
	
	
	
}	
	



public ArrayList<Objetos> procesarArchivoTexto() {
    ArrayList<Objetos> objDisponibles = new ArrayList<>();

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
                Objetos obj = new Objetos(nombre, tamaño, tipo);
                objDisponibles.add(obj);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return objDisponibles;
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




@Override
public void quitarVidaVillano() {
	if(monster.getCantVidas() > 0) {
		monster.setCantVidas();
	}
	
}
@Override
public int finalizarPartida() {
	// TODO Auto-generated method stub
	return 0;
}



/**
 * @return the monster
 */
public GlitchMonster getMonster() {
	return monster;
}



/**
 * @param monster the monster to set
 */
public void setMonster(GlitchMonster monster) {
	this.monster = monster;
}




	
	
}

package Logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



import Personajes.*;
import Util.Objetos;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ControladorCuartoNivel extends ControladorJuego {
private GlitchMonster monster;
public ArrayList <Objetos> objDisponibles ;
private ArrayList<Objetos>objPerdidos;	
private	ArrayList<Objetos> objEncontrados;
private String comunicar;



public ControladorCuartoNivel(Heroe heroe,GlitchMonster monster,InformacionJuego info ) {
		super(heroe, info);
			
		objDisponibles = new ArrayList <Objetos>(12);
		objPerdidos = new ArrayList<Objetos>(4);
		objEncontrados  = new ArrayList<Objetos>(4);
		objDisponibles.addAll(procesarArchivoTexto());
		asignarObjetosPerdidos();
        this.monster = monster;
	   
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



 public void setObjEncontrados(Objetos objEncontrados) {
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



	
public boolean ordenEsCorrecto(int accept,int control, ArrayList<Objetos> objPerdidos,ArrayList<Objetos> objEncontrados){
	boolean orden = true;
if (accept ==1){
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
		
	}}
	
	return orden;
	
	
	
}	
	



public ArrayList<Objetos> procesarArchivoTexto() {
    ArrayList<Objetos> objDisponibles = new ArrayList<>();

    try {
        File archivo = new File("src/Textos/parametrosObjetos.txt");
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


public int informarOrden(){
	int control = -1;
	Random r =new Random();
   control = (int)(r.nextDouble()*10-6);
	
   switch(control){
	case 1: this.setComunicar("El orden seleccionado es: mismo orden") ;
		
		break;
		
	case 2: this.setComunicar("El orden seleccionado es: orden inverso");
		break;
		
		
	case 3: this.setComunicar("El orden seleccionado es: ascendente");
		break;
		

	
		
		default: this.setComunicar("El orden seleccionado es: descendente")
			
			 ;
			
	}
return control;
   
}




/**
 * @return the comunicar
 */
public String getComunicar() {
	return comunicar;
}


/**
 * @param comunicar the comunicar to set
 */
public void setComunicar(String comunicar) {
	this.comunicar = comunicar;
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

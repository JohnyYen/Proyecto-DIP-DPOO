package Logica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



import Personajes.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ControladorCuartoNivel extends ControladorJuego {


	private int control;
	private ArrayList<Objeto> objPerdidos;	
	private	ArrayList<Objeto> objEncontrados;
	private String comunicar;
	private String tusObjetos;



	public ControladorCuartoNivel(int vidaHeroe,int vidaMonster,InformacionJuego info ) {
		super(vidaHeroe,vidaMonster, info);
		objPerdidos = new ArrayList<Objeto>(4);
		objEncontrados  = new ArrayList<Objeto>(4);
		asignarObjetosPerdidos();

	}

	//Obtener los objetos disponibles
	public ArrayList <Objeto> getObjDisponibles() {
		return this.informacionActual.getObjetos();
	}

	//Obtener los objetos encontrados
	public ArrayList<Objeto> getObjEncontrados() {
		return objEncontrados;
	}

	//Agregar objetos encontrados
	public void setObjEncontrados(Objeto objEncontrados) {
		if (this.objEncontrados.size() < 4) {
			this.objEncontrados.add(objEncontrados);
		} else {
			this.objEncontrados.clear();
		}
	}


	//Devolver los objetos perdidos
	public ArrayList<Objeto> getObjPerdidos() {
		return objPerdidos;
	}

	//Setear objetos perdidos
	public void setObjPerdidos(ArrayList<Objeto> objPerdidos) {
		this.objPerdidos = objPerdidos;
	}

	//Asignar objetos perdidos entre los objetos disponibles
	public void asignarObjetosPerdidos() {
		Collections.shuffle(getObjDisponibles()); 
		for (int i = 0; i < 4; i++) {
			objPerdidos.add(getObjDisponibles().get(i)); 
		}
	}


	public String prepararLabel(){

		return comunicar = objPerdidos.get(0).getNombre()+ " "+  objPerdidos.get(0).getTamanio()+ " " + objPerdidos.get(1).getNombre()+" "+ objPerdidos.get(1).getTamanio()+" "+ objPerdidos.get(2).getNombre()+" "+objPerdidos.get(2).getTamanio()+" "+objPerdidos.get(3).getNombre()
				+" "+objPerdidos.get(3).getTamanio();

	}

	//Comprobar que el orden es correcto
	public boolean ordenEsCorrecto(){
		boolean orden = true;
		if(objEncontrados.size() != objPerdidos.size()){
			orden = false;

		}else{

			switch(control){
			case 1: 
				orden = mismOrden();

				break;

			case 2: 
				orden = ordenInverso();
				break;


			case 3: 
				orden = mayorMenor();
				break;

			case 4: 
				orden = menorMayor();

				break;

			default:
				orden = false;

			}

			if(orden ){

				comunicar = "�Felicitaciones, solo un poco m�s!";
			}
			else {
				comunicar = "Qu� decepcionante �Es que no puedes hacerlo mejor?";
			}}

		return orden;}


	//Informar el orden en el que el jugador tiene que ordenar los objetos
	public String informarOrden(){
		control = -1;
		Random r = new Random();
		control = r.nextInt(4);

		switch(control){
		case 1: this.setComunicar("El orden seleccionado es: MISMO ORDEN") ;

		break;

		case 2: this.setComunicar("El orden seleccionado es: ORDEN INVERSO");
		break;


		case 3: this.setComunicar("El orden seleccionado es: ASCENDENTE");
		break;

		default: this.setComunicar("El orden seleccionado es: DESCENDENTE");

		}
		return comunicar;

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


	// COMPROBAR LOS ORDENES

	//Comprobar que los objetos esten ordenados de la misma forma
	public boolean mismOrden(){
		boolean correcto = true;

		for(int i=0;i<4 && correcto != false;i++){
			if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(i).getNombre()))){
				correcto = false;
			}
		}


		return correcto;
	}
	
	//Comprobar que el orden es el inverso a los objetos mostrados
	public boolean ordenInverso( ){
		boolean correcto = true;

		for(int i=0;i<4 && correcto != false;i++){
			if(!(objEncontrados.get(i).getNombre().equalsIgnoreCase(objPerdidos.get(3
					-i).getNombre()))){
				correcto = false;
			}
		}


		return correcto;}



	public boolean mayorMenor( ){
		boolean correcto = true;

		for(int i=1;i<4 && correcto != false;i++){
			if(objEncontrados.get(i).getTamanio() < objEncontrados.get(i-1).getTamanio()){
				correcto = false;
			}
		}


		return correcto;
	}

	public boolean menorMayor(){
		boolean correcto = true;


		for(int i=1;i<4 && correcto != false;i++){
			if(objEncontrados.get(i).getTamanio() > objEncontrados.get(i-1).getTamanio()){
				correcto = false;
			}
		}

		return correcto;
	}

	public void setControl(int control) {
		this.control = control;
	}
}

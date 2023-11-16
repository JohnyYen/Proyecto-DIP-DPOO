package Util;

import java.util.ArrayList;

public class ControladorCorazones {
	private ArrayList<Corazon> corazonHeroe;
	private ArrayList<Corazon> corazonVillano;
	private int indiceVidaHeroe, indiceVidaVillano;
	
	public ControladorCorazones(ArrayList<Corazon> corazonH, ArrayList<Corazon> corazonV){
		corazonHeroe.addAll(corazonH);
		corazonVillano.addAll(corazonV);
		
		indiceVidaHeroe = 0;
		indiceVidaVillano = 0;
	}
	
	public void quitarVidaHeroe(){
		corazonHeroe.get(indiceVidaHeroe).setVacio();
	}
	
	
}

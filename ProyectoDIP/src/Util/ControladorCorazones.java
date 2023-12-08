package Util;

import java.util.ArrayList;

public class ControladorCorazones {
	private ArrayList<Corazon> corazonHeroe;
	private ArrayList<Corazon> corazonVillano;
	private int indiceVidaHeroe, indiceVidaVillano;
	
	public ControladorCorazones(){		
		corazonHeroe = new ArrayList<Corazon>();
		corazonVillano = new ArrayList<Corazon>();
		indiceVidaHeroe = 0;
		indiceVidaVillano = 0;
	}
	
	public void quitarVidaHeroe(){
		if(indiceVidaHeroe < corazonHeroe.size()){
			corazonHeroe.get(indiceVidaHeroe++).setVacio();
		}
	}
	
	public void quitarVidaVillano(){
		if(indiceVidaVillano < corazonVillano.size()){
			corazonVillano.get(indiceVidaVillano++).setVacio();
		}
	}
	
	public Corazon getLastCorazonHeroe(){
		return corazonHeroe.get(corazonHeroe.size()-1);
	}
	public Corazon getLastCorazonVillano(){
		return corazonVillano.get(corazonVillano.size()-1);
	}
	
	public void agregarCorarazonHeroe(Corazon corazon){
		corazonHeroe.add(corazon);
	}
	public void agregarCorazonVillano(Corazon corazon){
		corazonVillano.add(corazon);
	}
	
}

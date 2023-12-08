package Util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Logica.PreguntaNivelDos;
import Logica.PreguntaNivelUno;

public class PreguntaTableModelSegundoNivel extends DefaultTableModel{
	
	public PreguntaTableModelSegundoNivel(ArrayList<PreguntaNivelDos> preguntas){
		String[] columNames = {"Enunciado", "Respuesta Correcta" ,"Respuesta 1", "Respuesta 2", "Respuesta 3"};
		this.setColumnIdentifiers(columNames);
		for (PreguntaNivelDos p : preguntas) {
			Object[] row = {p.getPregunta(), p.getRespuesta(), p.getPosiblesRespuestas().get(0), p.getPosiblesRespuestas().get(1), p.getPosiblesRespuestas().get(2)};
			addRow(row);
		}
	}
	
	public void adicionar(PreguntaNivelDos p){
		Object[] row = {p.getPregunta(), p.getRespuesta(), p.getPosiblesRespuestas().get(0), p.getPosiblesRespuestas().get(1), p.getPosiblesRespuestas().get(2)};
		addRow(row);
	}
	
}

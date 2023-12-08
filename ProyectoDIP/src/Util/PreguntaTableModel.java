package Util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Logica.PreguntaNivelUno;

public class PreguntaTableModel extends DefaultTableModel{
	
	public PreguntaTableModel(ArrayList<PreguntaNivelUno> preguntas){
		String[] columNames = {"Enunciado", "Respuesta"};
		this.setColumnIdentifiers(columNames);
		for(PreguntaNivelUno p: preguntas){
			Object[] row = {p.getPregunta(), p.getRespuesta()};
			addRow(row);
		}
	}
	
	public void adicionar(PreguntaNivelUno p){
		Object[] row = {p.getPregunta(), p.getRespuesta()};
		addRow(row);
	}
}

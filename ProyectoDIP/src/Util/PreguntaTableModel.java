package Util;

import javax.swing.table.DefaultTableModel;

import Logica.PreguntaNivelUno;

public class PreguntaTableModel extends DefaultTableModel{
	
	public PreguntaTableModel(){
		String[] columNames = {"Enunciado", "Respuesta"};
		this.setColumnIdentifiers(columNames);
	}
	
	public void adicionar(PreguntaNivelUno p){
		Object[] row = {p.getPregunta(), p.getRespuesta()};
		addRow(row);
	}
}

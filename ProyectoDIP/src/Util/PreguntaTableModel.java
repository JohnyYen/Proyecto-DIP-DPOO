package Util;

import javax.swing.table.DefaultTableModel;

public class PreguntaTableModel extends DefaultTableModel{
	
	public PreguntaTableModel(){
		String[] columNames = {"Enunciado", "Respuesta"};
		this.setColumnIdentifiers(columNames);
	}
	
	public void adicionar(Pregunta p){
		Object[] row = {p.getPregunta(), p.getRespuesta()};
		addRow(row);
	}
}

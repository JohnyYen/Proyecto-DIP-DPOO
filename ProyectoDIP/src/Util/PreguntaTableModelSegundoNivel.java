package Util;

import javax.swing.table.DefaultTableModel;

public class PreguntaTableModelSegundoNivel extends DefaultTableModel{
	public PreguntaTableModelSegundoNivel(){
		String[] columNames = {"Enunciado", "Respuesta Correcta" ,"Respuesta 1", "Respuesta 2", "Respuesta 3"};
		this.setColumnIdentifiers(columNames);
	}
	
}

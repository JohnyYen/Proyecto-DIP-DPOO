
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
	
	public ArrayList<PreguntaNivelUno> getPreguntas(){
		ArrayList<PreguntaNivelUno> preguntas = new ArrayList<PreguntaNivelUno>();
		for(int i = 0; i < this.getRowCount(); i++){
			String texto = (String)this.getValueAt(i, 0);
			System.out.println(texto);
			if(this.getValueAt(i, 1) instanceof String){
				String respuesta = (String)this.getValueAt(i, 1);
				preguntas.add(new PreguntaNivelUno(texto,respuesta));
			}
			else if (this.getValueAt(i, 1) instanceof Boolean){
				boolean respuesta = (boolean)this.getValueAt(i, 1);
				preguntas.add(new PreguntaNivelUno(texto,respuesta));
			}
			
			
			
		}
		return preguntas;
	}
}

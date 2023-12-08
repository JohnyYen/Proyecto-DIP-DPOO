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

	public ArrayList<PreguntaNivelDos> getPreguntas() {
		ArrayList<PreguntaNivelDos> preguntas = new ArrayList<PreguntaNivelDos>();
		
		for (int i = 0; i < this.getRowCount(); i++) {
			String textoPregunta = (String)this.getValueAt(i, 0);
			String textoRespuesta = (String)this.getValueAt(i, 1);
			String posibleRespuesta1 = agregarEtiquetaHTML((String)this.getValueAt(i, 2));
			String posibleRespuesta2 = agregarEtiquetaHTML((String)this.getValueAt(i, 3));
			String posibleRespuesta3 = agregarEtiquetaHTML((String)this.getValueAt(i, 4));
			ArrayList<String> posiblesRespuestas = new ArrayList<String>();
			posiblesRespuestas.add(posibleRespuesta1);
			posiblesRespuestas.add(posibleRespuesta2);
			posiblesRespuestas.add(posibleRespuesta3);
			preguntas.add(new PreguntaNivelDos(textoPregunta, posiblesRespuestas, textoRespuesta));
			posiblesRespuestas.clear();
		}
		
		return preguntas;
	}
	
	private String agregarEtiquetaHTML(String texto) {
        if (!texto.startsWith("<html>")) {
            texto = "<html>" + texto;
        }
        return texto;
    }
	
}

package Util;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CuriosidadesTableModel extends DefaultTableModel{
	
	public CuriosidadesTableModel(){
		
		String[] columNames = {"Imagen", "Descripción"};
		this.setColumnIdentifiers(columNames);
	}
	
	public void adicionar(ImageIcon imagen, String texto){
		Object[] row = {imagen, texto};
		addRow(row);
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
}

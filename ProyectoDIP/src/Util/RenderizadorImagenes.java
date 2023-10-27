package Util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderizadorImagenes extends DefaultTableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable tabla, Object value,
			boolean isSelect, boolean hasFocus, int row, int column) {
		if (value instanceof ImageIcon) setIcon((ImageIcon) value);
		else setText("");
		return this;
	}
		
	
	
}

package ComponentesVisuales.Componentes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.View;

import Recursos.CustomFont;

public class TextPanel extends JTextArea {
	public TextPanel(){
		
		this.setEditable(false); //Que no sea editable
		this.setLineWrap(true); //Que acepte los saltos de lineas
		this.setWrapStyleWord(true);
		
		CustomFont mf = new CustomFont();
		this.setFont(mf.MyFont(1, 15));		
		this.setOpaque(false);
		this.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		
	}
	
	@Override
	public void setText(String texto) {
		//Reemplazar todos los \n con saltos de Linea
		String textoModificado = texto.replaceAll("\\n", System.lineSeparator());
		try{
			//Cambiar el texto del componente
			super.setText(textoModificado);			
		}
		catch( NullPointerException e){
			e.printStackTrace();
		}		
	}
	
	

}

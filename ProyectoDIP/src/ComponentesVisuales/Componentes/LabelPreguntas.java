package ComponentesVisuales.Componentes;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import Logica.Pregunta;
import Logica.PreguntaNivelDos;
import Logica.PreguntaNivelUno;
import Recursos.*;

public class LabelPreguntas extends JLabel{
	private static final long serialVersionUID = 1L;
	private TextPanel textoPanel;
	private ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
	
	public LabelPreguntas(int x, int y, int ancho, int alto){
		Image iconLabel = imagenLabel.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		textoPanel = new TextPanel();
		this.setLayout(null);
		textoPanel.setBounds(120,70,ancho-100, alto);
		
		
		
		this.add(textoPanel);
		CustomFont mf = new CustomFont();
		this.setFont(mf.MyFont(1, 18));
		this.setForeground(Color.WHITE);
		
		this.setBounds(x, y, ancho, alto);
		this.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setPreferredSize (new Dimension(ancho,alto));   
		textoPanel.setForeground(Color.WHITE);	
		
	}

	public void ponerPregunta(String texto){
		textoPanel.setText(texto);
	}
}

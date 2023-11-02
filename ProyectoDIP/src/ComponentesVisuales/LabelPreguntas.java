package ComponentesVisuales;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import Recursos.*;
import Util.Pregunta;
import Util.PreguntaNivelDos;
import Util.PreguntaNivelUno;

public class LabelPreguntas extends JLabel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Pregunta> preguntas;
	private int PreguntaActual;
	private ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
	
	private LabelPreguntas(int x, int y, int ancho, int alto){
		Image iconLabel = imagenLabel.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		PreguntaActual = 0;
		
		CustomFont mf = new CustomFont();
		this.setFont(mf.MyFont(1, 15));
		this.setForeground(Color.WHITE);
		
		this.setBounds(x, y, ancho, alto);
		this.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setPreferredSize (new Dimension(ancho,alto));   
			
		
	}
	
	public LabelPreguntas(int x, int y, int ancho, int alto, ArrayList<PreguntaNivelUno> preguntas){
		this(x,y,ancho,alto);
		this.preguntas.addAll(preguntas);
	}
	
	public LabelPreguntas(ArrayList<PreguntaNivelDos> preguntas, int x, int y, int ancho, int alto){
		this(x,y,ancho,alto);
		this.preguntas.addAll(preguntas);
	}

	public void ponerPregunta(){
		if(PreguntaActual < preguntas.size()){
			setText(preguntas.get(PreguntaActual++).getPregunta());
		}
		else JOptionPane.showMessageDialog(null, "Se terminaron las preguntas");
	}
	public int getPreguntaActual(){return this.PreguntaActual;}
	public ArrayList<Pregunta> getPreguntas(){return this.preguntas;}
}

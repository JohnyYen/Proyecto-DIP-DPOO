package ComponentesVisuales;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import Recursos.*;
import Util.Pregunta;

public class LabelPreguntas extends JLabel{
	private static final long serialVersionUID = 1L;
	private ArrayList<Pregunta> preguntas;
	private int PreguntaActual;
	private ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
	
	public LabelPreguntas(int x, int y, int ancho, int alto){
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
			
		preguntas = new ArrayList<Pregunta>();
		llenarPreguntas();
		
	}
	
	
	private void llenarPreguntas(){
		preguntas.add(new Pregunta("Si x = 5 es cierto que ( x > 3 && x < 7)?", true));
			
		preguntas.add(new Pregunta("Si x < 2 entonces (x > 0 && x < 3)?", false));
		
		preguntas.add(new Pregunta("Si x = 1 && y = 2 es cierto que (++x - y > -1)?", false));
		
		preguntas.add(new Pregunta("Si x = 1 y y = 2 es cierto que despues de 5 ciclos x vale 6?", true));
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

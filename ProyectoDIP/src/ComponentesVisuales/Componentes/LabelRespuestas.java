package ComponentesVisuales.Componentes;
import java.awt.*;
import javax.swing.*;

public class LabelRespuestas extends JLabel {
	
	private static final long serialVersionUID = 1L;
	//Los botones de Verdadero/Falso
	private Boton verdadero, falso;
	
	public LabelRespuestas(int x, int y, int ancho, int alto){
		//Crear los dos botones
		verdadero = new Boton("Verdadero", 150, 150, 50,0);
		falso = new Boton("Falso", 150, 150, 200, 0);
		add(verdadero);
		add(falso);
		this.setBounds(x,y,ancho,alto);
	}
	
	public Boton getBotonVerdadero(){return this.verdadero;}
	public Boton getBotonFalso(){return this.falso;}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image im = Toolkit.getDefaultToolkit().getImage("src/Recursos/CuadroDialogos.png");
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
	}
}

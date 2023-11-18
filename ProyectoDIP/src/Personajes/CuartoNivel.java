package ComponentesVisuales.Niveles;
import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.border.LineBorder;

import Logica.ControladorCuartoNivel;

public class CuartoNivel extends JFrame {
	private JPanel contentPane;
	private String comunicar;
	 private  int ordenar;
	
	public CuartoNivel(){
		setTitle("¡Encuentra los objetos!");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		/*Fondo*/
        ImageIcon backgroundImage = new ImageIcon("src/recursos/FondoCuartoNivel.png");
        getContentPane().setLayout(null);


        
        /*Glitch*/
        JPanel GlitchPanel = new JPanel();
        GlitchPanel.setLayout(new FlowLayout());
        GlitchPanel.setBounds(562, 389, 201, 188);
        GlitchPanel.setBackground(Color.WHITE);
        getContentPane().add(GlitchPanel);
    
        ImageIcon GlitchImage = new ImageIcon("C:\\Users\\mirai\\Downloads\\Telegram Desktop\\1970935159_13046848.png");
        Image image = GlitchImage.getImage();
        int newWidth = 198; 
        int newHeight = 178; 
        Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
 
        ImageIcon resizedImageGlitch = new ImageIcon(newImage);
        
        JLabel GlitchLabel = new JLabel(resizedImageGlitch);
        GlitchLabel.setBounds(571, 380, 192, 178);
        GlitchPanel.add(GlitchLabel);
    
        
        /*Peticion objetos*/
        
       JPanel labelPanel = new JPanel();
        labelPanel.setBounds(56, 49, 580, 75);
        labelPanel.setBackground(Color.WHITE); 
        getContentPane().add(labelPanel);
        labelPanel.setLayout(null);
        
        
        JLabel lblNewLabel = new JLabel(this.comunicar);
        lblNewLabel.setBounds(12, 0, 568, 75);
        labelPanel.add(lblNewLabel);
        
        /*Aceptar*/
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.setBounds(247, 443, 253, 75);
        getContentPane().add(acceptButton);
        
        /*Menú*/
        JButton menuButton = new JButton("Menú");
        menuButton.setBounds(700, 20, 80, 30);
        getContentPane().add(menuButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 167, 809, 171);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton button = new JButton("Sill\u00F3n");
        button.setBounds(66, 23, 108, 44);
        panel.add(button);
        
        JButton button_1 = new JButton("Cascabel");
        button_1.setBounds(211, 23, 108, 44);
        panel.add(button_1);
        
        JButton button_2 = new JButton("Arbusto");
        button_2.setBounds(357, 23, 108, 44);
        panel.add(button_2);
        
        JButton button_3 = new JButton("Reloj");
        button_3.setBounds(496, 23, 108, 44);
        panel.add(button_3);
        
        JButton button_4 = new JButton("Sombrero");
        button_4.setBounds(630, 23, 108, 44);
        panel.add(button_4);
        
        JButton button_5 = new JButton("Sombrilla");
        button_5.setBounds(66, 97, 108, 44);
        panel.add(button_5);
        
        JButton button_6 = new JButton("Silla");
        button_6.setBounds(211, 97, 108, 44);
        panel.add(button_6);
        
        JButton button_7 = new JButton("Sill\u00F3n");
        button_7.setBounds(357, 97, 108, 44);
        panel.add(button_7);
        
        JButton button_8 = new JButton("Sill\u00F3n");
        button_8.setBounds(496, 97, 108, 44);
        panel.add(button_8);
        
        JButton button_9 = new JButton("Sill\u00F3n");
        button_9.setBounds(630, 97, 108, 44);
        panel.add(button_9);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 882, 653);
        getContentPane().add(backgroundLabel);

        
        
	}
	
	public void mostrarInfo(ControladorCuartoNivel controlador,JPanel labelPanel) {
         ArrayList<String> informacionObjetos = controlador.obtenerInfo();
         for (int i = 0; i < informacionObjetos.size(); i++) {
             JLabel label = new JLabel(informacionObjetos.get(i));
             labelPanel.add(label);
         }
     }
        
	
	public void informarOrden(){
		int control = 0;
		Random r =new Random();
	   control = (int)(r.nextDouble()*10-5);
		
	   switch(control){
		case 1: this.comunicar = "El orden seleccionado es: de forma ascendente" ;
			
			break;
			
		case 2: this.comunicar = "El orden seleccionado es: de forma ascendente";
			break;
			
			
		case 3: this.comunicar = "El orden seleccionado es: de forma ascendente";
			break;
			
		case 4: this.comunicar = "El orden seleccionado es: de forma ascendente";
			
			break;
		
			
			default: this.comunicar = "El orden seleccionado es: de forma ascendente"
				
				 ;
				
		}
	   
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuartoNivel frame = new CuartoNivel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @return the ordenar
	 */
	public int getOrdenar() {
		return ordenar;
	}

	/**
	 * @param ordenar the ordenar to set
	 */
 public void setOrdenar(int ordenar) {
		this.ordenar = ordenar;
	}

	public String getComunicar() {
		return comunicar;
	}

	public void setComunicar(String comunicar) {
		this.comunicar = comunicar;
	}
}

package ComponentesVisuales;
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

import javax.swing.border.LineBorder;

import Logica.ControladorCuartoNivel;

public class CuartoNivel extends JFrame {
	private JPanel contentPane;
	
	public CuartoNivel(){
		setTitle("¡Encuentra los objetos!");
        setSize(843, 660);
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
        labelPanel.setLayout(new FlowLayout()); 
        labelPanel.setBounds(64, 58, 551, 53);
        labelPanel.setBackground(Color.WHITE); 
        getContentPane().add(labelPanel);
       
       
        
	   /*Botones para los objetos*/
        
        JButton Obj1Boton = new JButton("Sillón");
        Obj1Boton.setBounds(56, 181, 108, 44);
        getContentPane().add(Obj1Boton);  
        
        JButton Obj2Boton = new JButton("Cascabel");
        Obj2Boton.setBounds(201, 181, 108, 44);
        getContentPane().add(Obj2Boton);
        
        JButton Obj3Boton = new JButton("Arbusto");
        Obj3Boton.setBounds(347, 181, 108, 44);
        getContentPane().add(Obj3Boton);
        
        JButton Obj4Boton = new JButton("Reloj");
        Obj4Boton.setBounds(486, 181, 108, 44);
        getContentPane().add(Obj4Boton);
        
        JButton Obj5Boton = new JButton("Sombrero");
        Obj5Boton.setBounds(620, 181, 108, 44);
        getContentPane().add(Obj5Boton);
        
        JButton Obj6Boton = new JButton("Sombrilla");
        Obj6Boton.setBounds(56, 255, 108, 44);
        getContentPane().add(Obj6Boton);
        
        JButton Obj7Boton = new JButton("Silla");
        Obj7Boton.setBounds(201, 255, 108, 44);
        getContentPane().add(Obj7Boton);
        
        JButton button_6 = new JButton("Sill\u00F3n");
        button_6.setBounds(347, 255, 108, 44);
        getContentPane().add(button_6);
        
        JButton button_7 = new JButton("Sill\u00F3n");
        button_7.setBounds(486, 255, 108, 44);
        getContentPane().add(button_7);
        
        JButton button_8 = new JButton("Sill\u00F3n");
        button_8.setBounds(620, 255, 108, 44);
        getContentPane().add(button_8);
        
        /*Aceptar*/
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.setBounds(247, 443, 253, 75);
        getContentPane().add(acceptButton);
        
        /*Menú*/
        JButton menuButton = new JButton("Menú");
        menuButton.setBounds(700, 20, 80, 30);
        getContentPane().add(menuButton);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        getContentPane().add(backgroundLabel);

        
        
	}
	
	public void mostrarInfo(ControladorCuartoNivel controlador,JPanel labelPanel) {
         ArrayList<String> informacionObjetos = controlador.obtenerInfo();
         for (int i = 0; i < informacionObjetos.size(); i++) {
             JLabel label = new JLabel(informacionObjetos.get(i));
             labelPanel.add(label);
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
}

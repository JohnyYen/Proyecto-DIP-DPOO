package ComponentesVisuales.Niveles;
import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ComponentesVisuales.Componentes.BarraMenu;
import Logica.ControladorCuartoNivel;
import Personajes.GlitchMonster;
import Util.ControladorCorazones;
import Util.Objetos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;

public class CuartoNivel extends JFrame {
	private JPanel contentPane;
	private String comunicar;
    private  int ordenar;
	private GlitchMonster monstruo;
	private  ImageIcon GlitchImage;
	private  JLabel GlitchLabel;
	private  JPanel labelPanel;
	private JLabel labelBotones;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private ArrayList <Objetos> objEncontrados ;
	private ControladorCorazones controlCorazon;
	BufferedReader buffer;
	
	
	public CuartoNivel( final ArrayList<Objetos>objDisponibles,final ArrayList<Objetos>objPerdidos,int acept){
		setTitle("¡Encuentra los objetos!");
        setSize(923, 736);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.objEncontrados = new ArrayList<Objetos>(4);
        
		/*Fondo*/
        ImageIcon backgroundImage = new ImageIcon("src/Recursos/fondo cuarto nivel.jpg");
        getContentPane().setLayout(null);


        
        /*Glitch*/
        JPanel GlitchPanel = new JPanel();
        GlitchPanel.setBounds(562, 389, 201, 188);
        GlitchPanel.setBackground(Color.WHITE);
        getContentPane().add(GlitchPanel);
    
        ImageIcon GlitchImage = new ImageIcon("src/Recursos/monstruo.jpg");
        Image image = GlitchImage.getImage();
        int newWidth = 198; 
        int newHeight = 178; 
        Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
 
        ImageIcon resizedImageGlitch = new ImageIcon(newImage);
        GlitchPanel.setLayout(null);
        
        JLabel GlitchLabel = new JLabel(new ImageIcon("C:\\Users\\mirai\\OneDrive\\Desktop\\Proyecto-DIP-DPOO\\ProyectoDIP\\src\\Recursos\\monstruo.jpg"));
        GlitchLabel.setBounds(0, 0, 201, 188);
        GlitchPanel.add(GlitchLabel);
       
     
        
        /*Peticion objetos*/
        
       labelPanel = new JPanel();
        labelPanel.setBounds(107, 58, 580, 75);
        labelPanel.setBackground(Color.WHITE); 
        getContentPane().add(labelPanel);
        labelPanel.setLayout(null);
        
        
        JLabel lblNewLabel = new JLabel(this.comunicar);
        lblNewLabel.setBounds(0, 0, 568, 75);
        labelPanel.add(lblNewLabel);
        
        /*Aceptar*/
        JButton acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        	 
        });
        acceptButton.setBounds(266, 463, 253, 75);
        getContentPane().add(acceptButton);
        
        /*Menú*/
        
        BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;};
        
       
        
        JPanel panel = new JPanel();
        panel.setBounds(40, 172, 792, 175);
        getContentPane().add(panel);
        panel.setLayout(null);
        
         button = new JButton(objDisponibles.get(0).getNombre());
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		objEncontrados.add(objDisponibles.get(0));
        		
        	}
        });
        button.setBounds(61, 27, 108, 44);
        panel.add(button);
        
         button_1 = new JButton(objPerdidos.get(0).getNombre());
         button_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         	}
         });
      
        button_1.setBounds(206, 27, 108, 44);
        panel.add(button_1);
        
        button_2 = new JButton(objDisponibles.get(8).getNombre());
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		objEncontrados.add(objDisponibles.get(8));	
        	}
        });
        button_2.setBounds(352, 27, 108, 44);
        panel.add(button_2);
        
       button_3 = new JButton(objPerdidos.get(1).getNombre());
       button_3.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		objEncontrados.add(objPerdidos.get(1));
       	}
       });
        button_3.setBounds(491, 27, 108, 44);
        panel.add(button_3);
        
         button_4 = new JButton(objPerdidos.get(2).getNombre());
         button_4.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		objEncontrados.add(objPerdidos.get(2));
         	}
         });
        button_4.setBounds(625, 27, 108, 44);
        panel.add(button_4);
        
         button_5 = new JButton(objPerdidos.get(3).getNombre());
         button_5.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		objEncontrados.add(objPerdidos.get(3));
         	}
         });
        button_5.setBounds(61, 101, 108, 44);
        panel.add(button_5);
        
         button_6 = new JButton(objDisponibles.get(2).getNombre());
         button_6.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		objEncontrados.add(objDisponibles.get(2));
         	}
         });
        button_6.setBounds(206, 101, 108, 44);
        panel.add(button_6);
        
         button_7 = new JButton(objDisponibles.get(7).getNombre());
         button_7.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		objEncontrados.add(objDisponibles.get(7));
         	}
         });
        button_7.setBounds(352, 101, 108, 44);
        panel.add(button_7);
        
        button_8 = new JButton(objDisponibles.get(5).getNombre());
        button_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		objEncontrados.add(objDisponibles.get(5));
        	}
        });
        button_8.setBounds(491, 101, 108, 44);
        panel.add(button_8);
        
        button_9 = new JButton(objDisponibles.get(9).getNombre());
        button_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		objEncontrados.add(objDisponibles.get(9));
        	}
        });
        button_9.setBounds(625, 101, 108, 44);
        panel.add(button_9);
        
        labelBotones = new JLabel();
        labelBotones.setIcon(new ImageIcon("src/Recursos/fondo cuarto nivel - copia.jpg"));
        labelBotones.setBounds(0, 0, 792, 175);
        panel.add(labelBotones);
       
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 900, 700);
        getContentPane().add(backgroundLabel);
        

        
        
	}
	
        
	
	public CuartoNivel(Object object, Object object2, Object object3,
			Object object4) {
		// TODO Auto-generated constructor stub
	}



	public int informarOrden(){
		int control = 0;
		Random r =new Random();
	   control = (int)(r.nextDouble()*10-6);
		
	   switch(control){
		case 1: this.comunicar = "El orden seleccionado es: mismo orden" ;
			
			break;
			
		case 2: this.comunicar = "El orden seleccionado es: orden inverso";
			break;
			
			
		case 3: this.comunicar = "El orden seleccionado es: ascendente";
			break;
			

		
			
			default: this.comunicar = "El orden seleccionado es: descendente"
				
				 ;
				
		}
	return control;
	   
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuartoNivel frame = new CuartoNivel(null, null, null,null);
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

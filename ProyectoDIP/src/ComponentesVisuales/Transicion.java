package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Recursos.CustomFont;

public class Transicion extends JFrame {

	private JPanel contentPane;
	private JLabel cuadroDialogos;
	private JLabel BotonX;
	private JLabel BotonY;
	private ArrayList<String> dialogos;
	private KeyListener tocarTecla;
	private int cantDialogos = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transicion frame = new Transicion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transicion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 700, 576);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/Primera.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		tocarTecla = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'z'){
					cuadroDialogos.setText("Sino cojo 2");
				}
				if(e.getKeyChar() == 'x'){
					PrimerNIvel pri = new PrimerNIvel();
					dispose();
					pri.setVisible(true);
				}
				
			}
		};
		CustomFont myfont = new CustomFont();
		this.addKeyListener(tocarTecla);
		BotonX = new JLabel("X -> Saltar");
		BotonX.setForeground(Color.black);
		BotonX.setBounds(154, 464, 131, 50);
		BotonX.setFont(myfont.MyFont(1, 15));
		
		BotonY = new JLabel("Y -> Continuar");
		BotonY.setBounds(295, 464, 138, 50);
		BotonY.setFont(myfont.MyFont(1, 15));
		BotonY.setForeground(Color.black);
		contentPane.setLayout(null);
		
		contentPane.add(BotonX);
		contentPane.add(BotonY);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cuadroDialogos = new JLabel();
		diseniarLabel(cuadroDialogos);
		
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
	}
	
	
	public void getDialogos(){
		dialogos = new ArrayList<>();
		dialogos.add("Tengo que terminar el proyecto de DPOO");
		dialogos.add("Si no la profesora me da 2");
		dialogos.add("Me falta poco");
	}
	
	public void diseniarLabel(JLabel dialogos){
		ImageIcon imagenLabel = new ImageIcon("src/Recursos/CuadroDialogos.png");
		Image iconLabel = imagenLabel.getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
		
		CustomFont mf = new CustomFont();
		cuadroDialogos.setFont(mf.MyFont(1, 15));
		cuadroDialogos.setForeground(Color.WHITE);
		
		cuadroDialogos.setText("Tengo que hacer el proyecto de DPOO");
		cuadroDialogos.setBounds(100, 350, 500, 200);
		cuadroDialogos.setIcon(new ImageIcon(iconLabel)); //Cambiar de imagen en el Label
		cuadroDialogos.setVerticalTextPosition(SwingConstants.CENTER);
		cuadroDialogos.setHorizontalTextPosition(SwingConstants.CENTER);
		//cuadroDialogos.setPreferredSize (new Dimension(200,200)); 
		contentPane.add(cuadroDialogos);
	}

}

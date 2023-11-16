package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Util.Corazon;
import Personajes.Cleopatra;
import Personajes.Heroe;

public class Pruebas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pruebas frame = new Pruebas();
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
	public Pruebas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Heroe heroe = new Heroe();
		heroe.setNormal();
		heroe.setBounds(172, 67, 134, 157);
		contentPane.add(heroe);
		
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setPerdio();
		cleopatra.setSorprendida();
		cleopatra.setBounds(46, 67, 152, 157);
		contentPane.add(cleopatra);
		
		Boton boton = new Boton("Hola", 100, 100, 0, 0);
		boton.setText("Buenas Noches");
		contentPane.add(boton);
		
		
		
	}
}

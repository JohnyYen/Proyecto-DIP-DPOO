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
		
		BarraMenu barraMenu = new BarraMenu();
		setJMenuBar(barraMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CartaVisual cartaVisual = new CartaVisual();
		cartaVisual.setBounds(104, 71, 287, 146);
		contentPane.add(cartaVisual);
		cartaVisual.voltearCarta();
		
		Heroe heroe = new Heroe();
		heroe.setBounds(22, 32, 96, 78);
		contentPane.add(heroe);
		
		
		
		
	}
}

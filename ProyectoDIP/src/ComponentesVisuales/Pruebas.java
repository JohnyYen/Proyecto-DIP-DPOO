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
		setBounds(100, 100, 610, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		BotonExtendidoNivel2 btnxtndnvl2Hola = new BotonExtendidoNivel2();
		btnxtndnvl2Hola.setText("Hola");
		btnxtndnvl2Hola.setBounds(33, 97, 463, 76);
		contentPane.add(btnxtndnvl2Hola);
		
		BotonExtendido btnxtndHola = new BotonExtendido();
		btnxtndHola.setText("Hola");
		btnxtndHola.setBounds(98, 35, 284, 51);
		contentPane.add(btnxtndHola);
		
		
		
	}
}

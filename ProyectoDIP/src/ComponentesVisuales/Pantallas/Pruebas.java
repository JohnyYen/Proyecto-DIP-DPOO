package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Corazon;
import ComponentesVisuales.Componentes.TextPanel;
import Personajes.Cleopatra;
import Personajes.Heroe;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

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
		
		TextPanel txtpnlHola = new TextPanel();
		txtpnlHola.setText("Hola\nHola\nHello\nHola\nHola\nHola\nHola\n");
		txtpnlHola.setBounds(305, 237, 153, 51);
		contentPane.add(txtpnlHola);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Hola\nHola\nHola");
		contentPane.add(textArea);
		
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(50, 44, 153, 225);
		contentPane.add(cleopatra);
		
		System.out.println((int)3.254+ System.lineSeparator() + "Hola");
		
	}
}

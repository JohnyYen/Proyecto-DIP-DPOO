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
import ComponentesVisuales.Componentes.BotonExtendido;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;

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
		
		JLabel label = new JLabel("");
		label.setBounds(12, 12, 356, 401);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(372, 12, 36, 58);
		textArea.setEditable(false);
		textArea.setText("Hola\nHola\nHola");
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(412, 12, 0, 0);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(416, 12, 0, 0);
		contentPane.add(label_2);
		
		Cleopatra cleopatra = new Cleopatra();
		cleopatra.setBounds(420, 12, 10, 10);
		contentPane.add(cleopatra);
		
		BotonExtendido botonExtendido = new BotonExtendido();
		botonExtendido.setBounds(434, 12, 32, 8);
		contentPane.add(botonExtendido);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(470, 12, 0, 0);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(474, 12, 0, 0);
		contentPane.add(label_4);
		
		TextPanel txtpnlHola = new TextPanel();
		txtpnlHola.setBounds(478, 12, 104, 132);
		txtpnlHola.setText("Hola\nHola\nHello\nHola\nHola\nHola\nHola\n");
		contentPane.add(txtpnlHola);
		
		System.out.println((int)3.254+ System.lineSeparator() + "Hola");
		
	}
}

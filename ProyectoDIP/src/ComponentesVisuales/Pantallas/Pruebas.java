package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ComponentesVisuales.Componentes.CuadroDialogo;

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
		setBounds(300, 20, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CuadroDialogo cdrdlgHola = new CuadroDialogo();
		cdrdlgHola.setText("Hola");
		cdrdlgHola.setBounds(51, 11, 457, 191);
		contentPane.add(cdrdlgHola);
		
		CuadroDialogo cdrdlgHello = new CuadroDialogo();
		cdrdlgHello.setText("Hello");
		cdrdlgHello.setBounds(-18, 134, 451, 68);
		contentPane.add(cdrdlgHello);
		
		System.out.println((int)3.254+ System.lineSeparator() + "Hola");
		
	}
}

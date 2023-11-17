package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ComponentesVisuales.Componentes.CuadroDialogo;
import ComponentesVisuales.Componentes.TextPanel;
import ComponentesVisuales.Componentes.BotonExtendido;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pruebas extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private TextPanel textPanel;
	private BotonExtendido btnxtndTocame;

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
		
		textPanel = new TextPanel();
		textPanel.setText("hello\nhello");
		textPanel.setBounds(10, 121, 210, 78);
		contentPane.add(textPanel);
		
		btnxtndTocame = new BotonExtendido();
		btnxtndTocame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPanel.setText(textArea.getText());
			}
		});
		btnxtndTocame.setText("Tocame");
		btnxtndTocame.setBounds(222, 150, 210, 28);
		contentPane.add(btnxtndTocame);
		
		textArea = new JTextArea();
		textArea.setBounds(247, 26, 173, 20);
		contentPane.add(textArea);
		
		System.out.println((int)3.254+ System.lineSeparator() + "Hola");
		
	}
}

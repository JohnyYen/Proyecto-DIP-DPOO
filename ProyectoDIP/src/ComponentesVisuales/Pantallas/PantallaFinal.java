package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import ComponentesVisuales.Componentes.TextPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaFinal extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> mensajesFinales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaFinal frame = new PantallaFinal();
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
	public PantallaFinal() {
		
		mensajesFinales = new ArrayList<String>();
		mensajesFinales.add("Gracias por haber jugado nuestro juego, esperamos que lo haya disfrutado hasta el final");
		mensajesFinales.add("La realización de este juego es fruto del esfuerzo en equipo de:");
		mensajesFinales.add("Johny A. Pedraza Romero Ricardo A. Cintas Díaz Grabiela Lucía Rosado León Rafael Rodríguez Pérez Félix Michel Silva Zamora");
		mensajesFinales.add("Y a la diseñadora que se encargó de TODOS los dibujos del juego ella sola: Patricia Mieres Diaz");
		
		
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextPanel mensaje = new TextPanel();
		mensaje.setFont(new Font("Dialog", Font.BOLD, 15));
		mensaje.setForeground(Color.WHITE);
		mensaje.setBounds(275, 138, 215, 231);
		contentPane.add(mensaje);
		
		slowText(mensaje, 100);
	}
	
	private void slowText(final TextPanel text, int delay){
		Timer timer = new Timer(delay, new ActionListener() {
			int index = 0;
			int currentIndex = 0;
			String mensaje = mensajesFinales.get(currentIndex++);
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index < mensaje.length() && currentIndex <= mensajesFinales.size()){
					String currentText = text.getText();
					currentText += mensaje.charAt(index++);
					text.setText(currentText);
					
					if(index == mensaje.length() && currentIndex != mensajesFinales.size()){
						index = 0;
						mensaje = mensajesFinales.get(currentIndex++);
						text.setText("");
					}
				}
				else{
					((Timer)e.getSource()).stop();
					dispose();
				}
				
			}
		});
		timer.start();
	}
}

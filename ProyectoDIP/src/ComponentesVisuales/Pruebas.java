package ComponentesVisuales;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Corazon;
import Personajes.Cleopatra;
import Personajes.Heroe;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.DropMode;

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
		setBounds(100, 100, 967, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelPreguntasNivelDos p = new PanelPreguntasNivelDos();
		p.getOpcion3().setText("holaaaaa");
		p.getOpcion2().setText("holaaaaaaaaa");
		p.getOpcion1().setText("hola");
		p.getOpcion2().setSize(679, 64);
		p.getOpcion3().setSize(668, 64);
		p.getOpcion1().setSize(679, 64);
		p.getOpcion3().setLocation(80, 206);
		p.getOpcion2().setLocation(103, 313);
		p.getOpcion1().setLocation(80, 120);
		p.setBounds(167, 174, 931, 513);
		p.setLayout(null);
		//p.repaint();
		//p.revalidate();
		contentPane.add(p);
		
		JTextArea txtrDasdsasasadsadsadsadsadsadsad = new JTextArea();
		txtrDasdsasasadsadsadsadsadsadsad.setOpaque(false);
		txtrDasdsasasadsadsadsadsadsadsad.setFocusable(false);
		txtrDasdsasasadsadsadsadsadsadsad.setBorder(null);
		txtrDasdsasasadsadsadsadsadsadsad.setLineWrap(true);
		txtrDasdsasasadsadsadsadsadsadsad.setEditable(false);
		txtrDasdsasasadsadsadsadsadsadsad.setText("dasdsasasadsadsadsadsadsadsad");
		txtrDasdsasasadsadsadsadsadsadsad.setBounds(29, 30, 166, 67);
		contentPane.add(txtrDasdsasasadsadsadsadsadsadsad);
		
		btnprueba btnprueba_ = new btnprueba();
		btnprueba_.setText("holaa mi nombre es rafael");
		btnprueba_.setBounds(405, 45, 478, 82);
		contentPane.add(btnprueba_);
		
	}
}

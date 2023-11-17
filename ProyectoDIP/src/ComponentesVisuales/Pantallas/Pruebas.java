package ComponentesVisuales.Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesVisuales.Componentes.CuadroDialogo;
import ComponentesVisuales.Componentes.TextPanel;
import ComponentesVisuales.Componentes.BotonExtendido;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ComponentesVisuales.Componentes.BotonExtendidoNivel2;
import ComponentesVisuales.Componentes.LabelRespuestasNivelDos;
import ComponentesVisuales.Niveles.PrimerNivel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pruebas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		BotonExtendidoNivel2 btnxtndnvl2Holaaaaaaa = new BotonExtendidoNivel2();
		btnxtndnvl2Holaaaaaaa.setText("<html>Un bucle \"for\" siempre ejecuta un numero fijo de iteraciones, mientras que un bucle \"while\" depende de una condicion.");
		btnxtndnvl2Holaaaaaaa.setBounds(184, 224, 643, 113);
		contentPane.add(btnxtndnvl2Holaaaaaaa);
		
		BotonExtendidoNivel2 botonExtendidoNivel2 = new BotonExtendidoNivel2();
		botonExtendidoNivel2.setText("holaaaaaaa");
		botonExtendidoNivel2.setBounds(184, 363, 679, 102);
		contentPane.add(botonExtendidoNivel2);
		
		BotonExtendidoNivel2 botonExtendidoNivel2_1 = new BotonExtendidoNivel2();
		botonExtendidoNivel2_1.setText("holaaaaaaa");
		botonExtendidoNivel2_1.setBounds(168, 504, 679, 102);
		contentPane.add(botonExtendidoNivel2_1);
		
		
		
	}
}

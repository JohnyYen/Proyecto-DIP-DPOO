package ComponentesVisuales.Componentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

import Logica.Carta;

public class EditarNivel3 extends JPanel {

	private JPanel contentPane;
	private JTextField nombCarta;
	private JTextField descCarta;
	private JTextField textField;
	private JButton cartaUno;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_12;
	private JButton button_11;
	private JButton button_14;
	private JButton button_13;
	public EditarNivel3(ArrayList<Carta> cartas) {
		setBounds(100, 100, 700, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("src/Recursos/reversoCarta.png");
		
		JLabel lblCartas = new JLabel("Cartas:");
		lblCartas.setBounds(23, 46, 46, 14);
		add(lblCartas);
		
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(23, 46, 46, 14);
		add(iconLabel);
		
		cartaUno = new JButton("1");
		cartaUno.setBounds(10, 74, 46, 23);
		cartaUno.setOpaque(true);
		add(cartaUno);
		
		button = new JButton("2");
		button.setBounds(89, 74, 46, 23);
		add(button);
		
		button_1 = new JButton("3");
		button_1.setBounds(10, 97, 46, 23);
		add(button_1);
		
		button_2 = new JButton("4");
		button_2.setBounds(89, 97, 46, 23);
		add(button_2);
		
		button_3 = new JButton("5");
		button_3.setBounds(10, 120, 46, 23);
		add(button_3);
		
		button_4 = new JButton("6");
		button_4.setBounds(89, 120, 46, 23);
		add(button_4);
		
		button_5 = new JButton("7");
		button_5.setBounds(10, 145, 46, 23);
		add(button_5);
		
		button_6 = new JButton("8");
		button_6.setBounds(89, 145, 46, 23);
		add(button_6);
		
		button_7 = new JButton("9");
		button_7.setBounds(10, 170, 46, 23);
		add(button_7);
		
		button_8 = new JButton("10");
		button_8.setBounds(89, 170, 46, 23);
		add(button_8);
		
		button_9 = new JButton("11");
		button_9.setBounds(10, 195, 46, 23);
		add(button_9);
		
		button_10 = new JButton("12");
		button_10.setBounds(89, 195, 46, 23);
		add(button_10);
		
		JPanel modificarCarta = new JPanel();
		modificarCarta.setBackground(Color.WHITE);
		modificarCarta.setBounds(213, 46, 458, 233);
		add(modificarCarta);
		modificarCarta.setLayout(null);
		
		JLabel labelNomCarta = new JLabel("Nombre Carta: ");
		labelNomCarta.setBounds(10, 11, 112, 14);
		modificarCarta.add(labelNomCarta);
		
		nombCarta = new JTextField();
		nombCarta.setBackground(Color.LIGHT_GRAY);
		nombCarta.setBounds(10, 24, 326, 20);
		modificarCarta.add(nombCarta);
		nombCarta.setColumns(10);
		
		JLabel labelDescr = new JLabel("Descripci\u00F3n Carta:");
		labelDescr.setBounds(10, 55, 213, 14);
		modificarCarta.add(labelDescr);
		
		descCarta = new JTextField();
		descCarta.setBackground(Color.LIGHT_GRAY);
		descCarta.setBounds(10, 80, 326, 76);
		modificarCarta.add(descCarta);
		descCarta.setColumns(10);
		
		JLabel lblCdigoDeCarta = new JLabel("C\u00F3digo de Carta:");
		lblCdigoDeCarta.setBounds(10, 167, 93, 14);
		modificarCarta.add(lblCdigoDeCarta);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(10, 184, 70, 20);
		modificarCarta.add(textField);
		textField.setColumns(10);
		
		button_11 = new JButton("14");
		button_11.setBounds(89, 226, 46, 23);
		add(button_11);
		
		button_12 = new JButton("13");
		button_12.setBounds(10, 226, 46, 23);
		add(button_12);
		
		button_13 = new JButton("16");
		button_13.setBounds(89, 260, 46, 23);
		add(button_13);
		
		button_14 = new JButton("15");
		button_14.setBounds(10, 260, 46, 23);
		add(button_14);
	}
}

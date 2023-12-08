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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class EditarNivel3 extends JPanel {
	private ArrayList<Carta> nuevasCartas;
	private JPanel contentPane;
	private JTextField nombCarta;
	private JTextField descCarta;
	private JTextField codCarta;
	private JButton cartaUno;
	private JButton cartaDos;
	private JButton cartaTres;
	private JButton cartaCuatro;
	private JButton cartaCinco;
	private JButton cartaSeis;
	private JButton cartaSiete;
	private JButton cartaOcho;
	private JButton cartaNueve;
	private JButton cartaDiez;
	private JButton cartaOnce;
	private JButton cartaDoce;
	private JButton cartaTrece;
	private JButton cartaCatorce;
	private JButton cartaQuince;
	private JButton cartaDieciceis;
	private JLabel imagenCarta2;
	private JLabel imagenCarta3;
	private JLabel imagenCarta4;
	private JLabel imagenCarta5;
	private JLabel imagenCarta6;
	private JLabel imagenCarta7;
	private JLabel imagenCarta8;
	private JLabel imagenCarta9;
	private JLabel imagenCarta10;
	private JLabel imagenCarta11;
	private JLabel imagenCarta12;
	private JLabel imagenCarta13;
	private JLabel imagenCarta14;
	private JLabel imagenCarta15;
	private JLabel imagenCarta16;
	public EditarNivel3(ArrayList<Carta> cartas) {
		nuevasCartas = new ArrayList<>();
		nuevasCartas.addAll(cartas);
		setBounds(100, 100, 700, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("src/Recursos/reversoCarta.png");
		
		JLabel lblCartas = new JLabel("Cartas:");
		lblCartas.setBounds(21, 49, 46, 14);
		add(lblCartas);
		
		cartaUno = new JButton("1");
		cartaUno.setForeground(Color.WHITE);
		cartaUno.setBounds(10, 67, 50, 39);
		diseniarBoton(cartaUno);
		add(cartaUno);
		
		cartaDos = new JButton("2");
		cartaDos.setForeground(Color.WHITE);
		cartaDos.setBounds(89, 67, 46, 39);
		diseniarBoton(cartaDos);
		add(cartaDos);
		
		cartaTres = new JButton("3");
		cartaTres.setForeground(Color.WHITE);
		cartaTres.setBounds(10, 117, 46, 33);
		diseniarBoton(cartaTres);
		add(cartaTres);
		
		cartaCuatro = new JButton("4");
		cartaCuatro.setForeground(Color.WHITE);
		cartaCuatro.setBounds(89, 114, 46, 28);
		diseniarBoton(cartaCuatro);
		add(cartaCuatro);
		
		cartaCinco = new JButton("5");
		cartaCinco.setForeground(Color.WHITE);
		cartaCinco.setBounds(10, 161, 46, 39);
		diseniarBoton(cartaCinco);
		add(cartaCinco);
		
		cartaSeis = new JButton("6");
		cartaSeis.setForeground(Color.WHITE);
		cartaSeis.setBounds(89, 161, 46, 39);
		diseniarBoton(cartaSeis);
		add(cartaSeis);
		
		cartaSiete = new JButton("7");
		cartaSiete.setForeground(Color.WHITE);
		cartaSiete.setBounds(10, 211, 46, 33);
		diseniarBoton(cartaSiete);
		add(cartaSiete);
		
		cartaOcho = new JButton("8");
		cartaOcho.setForeground(Color.WHITE);
		cartaOcho.setBounds(89, 211, 46, 33);
		diseniarBoton(cartaOcho);
		add(cartaOcho);
		
		cartaNueve = new JButton("9");
		cartaNueve.setForeground(Color.WHITE);
		cartaNueve.setBounds(10, 261, 46, 43);
		diseniarBoton(cartaNueve);
		add(cartaNueve);
		
		cartaDiez = new JButton("10");
		cartaDiez.setForeground(Color.WHITE);
		cartaDiez.setBounds(78, 255, 57, 43);
		diseniarBoton(cartaDiez);
		add(cartaDiez);
		
		cartaOnce = new JButton("11");
		cartaOnce.setForeground(Color.WHITE);
		cartaOnce.setBounds(10, 315, 57, 39);
		diseniarBoton(cartaOnce);
		add(cartaOnce);
		
		cartaDoce = new JButton("12");
		cartaDoce.setForeground(Color.WHITE);
		
		cartaDoce.setBounds(78, 315, 59, 39);
		diseniarBoton(cartaDoce);
		add(cartaDoce);
		
		cartaCatorce = new JButton("14");
		cartaCatorce.setForeground(Color.WHITE);
		cartaCatorce.setBounds(76, 365, 59, 36);
		diseniarBoton(cartaCatorce);
		add(cartaCatorce);
		
		cartaTrece = new JButton("13");
		cartaTrece.setForeground(Color.WHITE);
		cartaTrece.setBounds(10, 365, 57, 36);
		diseniarBoton(cartaTrece);
		add(cartaTrece);
		
		cartaQuince = new JButton("15");
		cartaQuince.setForeground(Color.WHITE);
		
		cartaQuince.setBounds(10, 412, 57, 39);
		diseniarBoton(cartaQuince);
		add(cartaQuince);
		
		cartaDieciceis = new JButton("16");
		cartaDieciceis.setForeground(Color.WHITE);
		cartaDieciceis.setBounds(76, 412, 59, 39);
		diseniarBoton(cartaDieciceis);
		add(cartaDieciceis);
		
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
		
		codCarta = new JTextField();
		codCarta.setBackground(Color.LIGHT_GRAY);
		codCarta.setBounds(10, 184, 70, 20);
		modificarCarta.add(codCarta);
		codCarta.setColumns(10);
		
		BotonExtendido guardar = new BotonExtendido();
		guardar.setText("Guardar Carta");
		guardar.setBounds(162, 167, 235, 37);
		modificarCarta.add(guardar);
		
		imagenCarta2 = new JLabel(icon);
		imagenCarta2.setForeground(Color.RED);
		imagenCarta2.setBounds(89, 67, 46, 39);
		add(imagenCarta2);
		
		JLabel imagenCarta1 = new JLabel(icon);
		imagenCarta1.setForeground(Color.RED);
		imagenCarta1.setBounds(10, 67, 46, 39);
		add(imagenCarta1);
		
		imagenCarta3 = new JLabel(icon);
		imagenCarta3.setForeground(Color.RED);
		imagenCarta3.setBounds(10, 111, 46, 39);
		add(imagenCarta3);
		
		imagenCarta4 = new JLabel(icon);
		imagenCarta4.setForeground(Color.RED);
		imagenCarta4.setBounds(89, 112, 46, 39);
		add(imagenCarta4);
		
		imagenCarta5 = new JLabel(icon);
		imagenCarta5.setForeground(Color.RED);
		imagenCarta5.setBounds(10, 155, 46, 45);
		add(imagenCarta5);
		
		imagenCarta6 = new JLabel(icon);
		imagenCarta6.setForeground(Color.RED);
		imagenCarta6.setBounds(89, 153, 46, 47);
		add(imagenCarta6);
		
		imagenCarta7 = new JLabel(icon);
		imagenCarta7.setForeground(Color.RED);
		imagenCarta7.setBounds(10, 207, 46, 43);
		add(imagenCarta7);
		
		imagenCarta8 = new JLabel(icon);
		imagenCarta8.setForeground(Color.RED);
		imagenCarta8.setBounds(89, 207, 46, 43);
		add(imagenCarta8);
		
		imagenCarta9 = new JLabel(icon);
		imagenCarta9.setForeground(Color.RED);
		imagenCarta9.setBounds(10, 255, 50, 45);
		add(imagenCarta9);
		
		imagenCarta10 = new JLabel(icon);
		imagenCarta10.setForeground(Color.RED);
		imagenCarta10.setBounds(89, 255, 46, 49);
		add(imagenCarta10);
		
		imagenCarta11 = new JLabel(icon);
		imagenCarta11.setForeground(Color.RED);
		imagenCarta11.setBounds(10, 315, 46, 39);
		add(imagenCarta11);
		
		imagenCarta12 = new JLabel(icon);
		imagenCarta12.setForeground(Color.RED);
		imagenCarta12.setBounds(89, 309, 46, 45);
		add(imagenCarta12);
		
		imagenCarta13 = new JLabel(icon);
		imagenCarta13.setForeground(Color.RED);
		imagenCarta13.setBounds(10, 365, 46, 39);
		add(imagenCarta13);
		
		imagenCarta14 = new JLabel(icon);
		imagenCarta14.setForeground(Color.RED);
		imagenCarta14.setBounds(89, 365, 46, 39);
		add(imagenCarta14);
		
		imagenCarta15 = new JLabel(icon);
		imagenCarta15.setForeground(Color.RED);
		imagenCarta15.setBounds(10, 412, 46, 43);
		add(imagenCarta15);
		
		imagenCarta16 = new JLabel(icon);
		imagenCarta16.setForeground(Color.RED);
		imagenCarta16.setBounds(86, 412, 49, 43);
		add(imagenCarta16);
	}
	
	private void diseniarBoton(final JButton carta){
		carta.setOpaque(false);
		carta.setContentAreaFilled(false);
		carta.setBorderPainted(false);
		carta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(carta.getText());
				Carta c = nuevasCartas.get(index-1);
				nombCarta.setText(c.getNombre());
				descCarta.setText(c.getFuncionalidad());
				codCarta.setText(c.getCodigo());
			}
		});
	}
	
	public ArrayList<Carta> getNuevasCartas(){return this.nuevasCartas;}
}

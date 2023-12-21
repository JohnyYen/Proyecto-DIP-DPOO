package ComponentesVisuales.Componentes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import Logica.Juego;
import Logica.Objeto;
import Logica.Validacion;
import java.awt.Color;

public class EditarNivel4 extends JPanel {
	
	private Validacion val;
	private JPanel contentPane;
	private JSpinner spinner;
	private JTextField textNombre_1;
	private JTextField txtTamao_1;
	private JTextField textNombre_2;
	private JTextField txtTamao_2;
	private JTextField textNombre_3;
	private JTextField txtTamao_3;
	private JTextField textNombre_4;
	private JTextField txtTamao_4;
	private JTextField textNombre_5;
	private JTextField txtTamao_5;
	private JTextField textNombre_6;
	private JTextField txtTamao_6;
	private JTextField textNombre_7;
	private JTextField txtTamao_7;
	private JTextField textNombre_8;
	private JTextField txtTamao_8;
	private JTextField textNombre_9;
	private JTextField txtTamao_9;
	private JTextField textNombre_10;
	private JTextField txtTamao_10;
	private JTextField textNombre_11;
	private JTextField textNombre_12;
	private JTextField txtTamao_11;
	private JTextField txtTamao_12;
	private JLabel lblNombres;
	private JLabel lblTamaos;
	private Juego miJuego;
	private ArrayList<JTextField> componentesNom = new ArrayList<JTextField>();
	private ArrayList<JTextField> componentesTam = new ArrayList<JTextField>();
	private int valor;
	private ArrayList<Objeto> nuevosObjetos;
	
	public EditarNivel4(ArrayList<Objeto> objetos) {
		setBackground(new Color(0, 51, 102));
		
		nuevosObjetos = new ArrayList<Objeto>();
		nuevosObjetos.addAll(objetos);
		val = new Validacion();
		setBounds(100, 100, 501, 440);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		JButton btnAceptar = new BotonExtendido();
		btnAceptar.setText("Aplicar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean correct = true;
				boolean combFloat = true;
				
				for(int i = 0; i < valor; i++){
					if(componentesNom.get(i).getText().replaceAll(" ", "").equalsIgnoreCase("") || componentesTam.get(i).getText().replaceAll(" ", "").equalsIgnoreCase(""))
						correct = false;
					if(val.esNumeroflotante(componentesTam.get(i).getText()) == false)
						combFloat = false;
					
				}

				if(correct == false)
					JOptionPane.showMessageDialog(null, "Te faltan campos por llenar!");
				
				else if(combFloat == false)
					JOptionPane.showMessageDialog(null, "El tamaño debe de ser un valor numérico");
				
				else{
					JOptionPane.showMessageDialog(null, "Modificaciónn Exitosa!");
				}
			}
		});
		btnAceptar.setBounds(236, 217, 217, 30);
		this.add(btnAceptar);
		
		

		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
			    valor = Integer.parseInt(String.valueOf(spinner.getValue()));
				for(int i = 0; i < valor; i++){
					componentesNom.get(i).setEnabled(true);
					componentesTam.get(i).setEnabled(true);
				}
				
				for(int i = 11; i >= valor; i--){
					componentesNom.get(i).setEnabled(false);
					componentesTam.get(i).setEnabled(false);
					
				}

				
					
			}
		});
		spinner.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		spinner.setToolTipText("");
		spinner.setBounds(345, 83, 57, 20);
		this.add(spinner);

		JLabel lblCantidad = new JLabel("Cantidad Editable");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(324, 56, 108, 20);
		this.add(lblCantidad);

		JLabel lblEdiccintoNivel = new JLabel("Edici\u00F3n 4to Nivel");
		lblEdiccintoNivel.setForeground(Color.WHITE);
		lblEdiccintoNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdiccintoNivel.setBounds(162, 0, 217, 45);
		this.add(lblEdiccintoNivel);
		
		JLabel lblEditorObjetos = new JLabel("Editor Objetos");
		lblEditorObjetos.setForeground(Color.WHITE);
		lblEditorObjetos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEditorObjetos.setBounds(43, 43, 127, 20);
		this.add(lblEditorObjetos);
		
		JLabel label = new JLabel("#2");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 111, 46, 14);
		this.add(label);
		
		
			//Editor de nombres
		textNombre_2 = new JTextField();	
		textNombre_2.setBackground(Color.DARK_GRAY);
		textNombre_2.setForeground(Color.WHITE);
		textNombre_2.setEnabled(false);
		textNombre_2.setText("");
		textNombre_2.setColumns(10);
		textNombre_2.setBounds(33, 108, 69, 20);
		this.add(textNombre_2);
		
			//Editor de Tamaï¿½os
		txtTamao_2 = new JTextField();
		txtTamao_2.setBackground(Color.DARK_GRAY);
		txtTamao_2.setForeground(Color.WHITE);
		txtTamao_2.setEnabled(false);
		txtTamao_2.setText("");
		txtTamao_2.setColumns(10);
		txtTamao_2.setBounds(112, 108, 69, 20);
		this.add(txtTamao_2);
		
		JLabel label_1 = new JLabel("#3");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 139, 46, 14);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("#4");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 167, 46, 14);
		this.add(label_2);
		
		JLabel label_3 = new JLabel("#5");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(10, 192, 46, 14);
		this.add(label_3);
		
		JLabel label_4 = new JLabel("#6");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(10, 225, 46, 14);
		this.add(label_4);
		
		JLabel label_5 = new JLabel("#7");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(10, 256, 46, 14);
		this.add(label_5);
		
		JLabel label_7 = new JLabel("#8");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(10, 288, 46, 14);
		this.add(label_7);
		
		JLabel label_8 = new JLabel("#9");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(10, 321, 46, 14);
		this.add(label_8);
		
		JLabel label_9 = new JLabel("#10");
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(10, 349, 46, 14);
		this.add(label_9);
		
		textNombre_3 = new JTextField();
		textNombre_3.setBackground(Color.DARK_GRAY);
		textNombre_3.setForeground(Color.WHITE);
		textNombre_3.setEnabled(false);
		textNombre_3.setText("");
		textNombre_3.setColumns(10);
		textNombre_3.setBounds(33, 136, 69, 20);
		this.add(textNombre_3);
		
		textNombre_4 = new JTextField();
		textNombre_4.setBackground(Color.DARK_GRAY);
		textNombre_4.setForeground(Color.WHITE);
		textNombre_4.setEnabled(false);
		textNombre_4.setText("");
		textNombre_4.setColumns(10);
		textNombre_4.setBounds(33, 164, 69, 20);
		this.add(textNombre_4);
		
		textNombre_5 = new JTextField();
		textNombre_5.setBackground(Color.DARK_GRAY);
		textNombre_5.setForeground(Color.WHITE);
		textNombre_5.setEnabled(false);
		textNombre_5.setText("");
		textNombre_5.setColumns(10);
		textNombre_5.setBounds(33, 192, 69, 20);
		this.add(textNombre_5);
		
		textNombre_6 = new JTextField();
		textNombre_6.setBackground(Color.DARK_GRAY);
		textNombre_6.setForeground(Color.WHITE);
		textNombre_6.setEnabled(false);
		textNombre_6.setText("");
		textNombre_6.setColumns(10);
		textNombre_6.setBounds(33, 222, 69, 20);
		this.add(textNombre_6);
		
		textNombre_7 = new JTextField();
		textNombre_7.setBackground(Color.DARK_GRAY);
		textNombre_7.setForeground(Color.WHITE);
		textNombre_7.setEnabled(false);
		textNombre_7.setText("");
		textNombre_7.setColumns(10);
		textNombre_7.setBounds(33, 253, 69, 20);
		this.add(textNombre_7);
		
		textNombre_8 = new JTextField();
		textNombre_8.setBackground(Color.DARK_GRAY);
		textNombre_8.setForeground(Color.WHITE);
		textNombre_8.setEnabled(false);
		textNombre_8.setText("");
		textNombre_8.setColumns(10);
		textNombre_8.setBounds(33, 285, 69, 20);
		this.add(textNombre_8);
		
		textNombre_9 = new JTextField();
		textNombre_9.setBackground(Color.DARK_GRAY);
		textNombre_9.setForeground(Color.WHITE);
		textNombre_9.setEnabled(false);
		textNombre_9.setText("");
		textNombre_9.setColumns(10);
		textNombre_9.setBounds(33, 315, 69, 20);
		this.add(textNombre_9);
		
		textNombre_10 = new JTextField();
		textNombre_10.setBackground(Color.DARK_GRAY);
		textNombre_10.setForeground(Color.WHITE);
		textNombre_10.setEnabled(false);
		textNombre_10.setText("");
		textNombre_10.setColumns(10);
		textNombre_10.setBounds(33, 346, 69, 20);
		this.add(textNombre_10);
		
		JLabel label_6 = new JLabel("#1");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(10, 86, 46, 14);
		this.add(label_6);
		
		textNombre_1 = new JTextField();
		textNombre_1.setBackground(Color.DARK_GRAY);
		textNombre_1.setForeground(Color.WHITE);
		textNombre_1.setEnabled(false);
		textNombre_1.setText("");
		textNombre_1.setColumns(10);
		textNombre_1.setBounds(33, 83, 69, 20);
		this.add(textNombre_1);
		
		txtTamao_1 = new JTextField();
		txtTamao_1.setBackground(Color.DARK_GRAY);
		txtTamao_1.setForeground(Color.WHITE);
		txtTamao_1.setEnabled(false);
		txtTamao_1.setColumns(10);
		txtTamao_1.setBounds(112, 83, 69, 20);
		this.add(txtTamao_1);
		
		txtTamao_3 = new JTextField();
		txtTamao_3.setBackground(Color.DARK_GRAY);
		txtTamao_3.setForeground(Color.WHITE);
		txtTamao_3.setEnabled(false);
		txtTamao_3.setText("");
		txtTamao_3.setColumns(10);
		txtTamao_3.setBounds(112, 139, 69, 20);
		this.add(txtTamao_3);
		
		txtTamao_4 = new JTextField();
		txtTamao_4.setBackground(Color.DARK_GRAY);
		txtTamao_4.setForeground(Color.WHITE);
		txtTamao_4.setEnabled(false);
		txtTamao_4.setText("");
		txtTamao_4.setColumns(10);
		txtTamao_4.setBounds(112, 164, 69, 20);
		this.add(txtTamao_4);
		
		txtTamao_5 = new JTextField();
		txtTamao_5.setBackground(Color.DARK_GRAY);
		txtTamao_5.setForeground(Color.WHITE);
		txtTamao_5.setEnabled(false);
		txtTamao_5.setText("");
		txtTamao_5.setColumns(10);
		txtTamao_5.setBounds(112, 192, 69, 20);
		this.add(txtTamao_5);
		
		txtTamao_6 = new JTextField();
		txtTamao_6.setBackground(Color.DARK_GRAY);
		txtTamao_6.setForeground(Color.WHITE);
		txtTamao_6.setEnabled(false);
		txtTamao_6.setText("");
		txtTamao_6.setColumns(10);
		txtTamao_6.setBounds(112, 222, 69, 20);
		this.add(txtTamao_6);
		
		txtTamao_7 = new JTextField();
		txtTamao_7.setBackground(Color.DARK_GRAY);
		txtTamao_7.setForeground(Color.WHITE);
		txtTamao_7.setEnabled(false);
		txtTamao_7.setText("");
		txtTamao_7.setColumns(10);
		txtTamao_7.setBounds(112, 253, 69, 20);
		this.add(txtTamao_7);
		
		txtTamao_8 = new JTextField();
		txtTamao_8.setBackground(Color.DARK_GRAY);
		txtTamao_8.setForeground(Color.WHITE);
		txtTamao_8.setEnabled(false);
		txtTamao_8.setText("");
		txtTamao_8.setColumns(10);
		txtTamao_8.setBounds(112, 285, 69, 20);
		this.add(txtTamao_8);
		
		txtTamao_9 = new JTextField();
		txtTamao_9.setBackground(Color.DARK_GRAY);
		txtTamao_9.setForeground(Color.WHITE);
		txtTamao_9.setEnabled(false);
		txtTamao_9.setText("");
		txtTamao_9.setColumns(10);
		txtTamao_9.setBounds(112, 315, 69, 20);
		this.add(txtTamao_9);
		
		txtTamao_10 = new JTextField();
		txtTamao_10.setBackground(Color.DARK_GRAY);
		txtTamao_10.setForeground(Color.WHITE);
		txtTamao_10.setEnabled(false);
		txtTamao_10.setText("");
		txtTamao_10.setColumns(10);
		txtTamao_10.setBounds(112, 346, 69, 20);
		this.add(txtTamao_10);
		
		textNombre_12 = new JTextField();
		textNombre_12.setBackground(Color.DARK_GRAY);
		textNombre_12.setForeground(Color.WHITE);
		textNombre_12.setText("");
		textNombre_12.setEnabled(false);
		textNombre_12.setColumns(10);
		textNombre_12.setBounds(33, 401, 69, 20);
		add(textNombre_12);
		
		txtTamao_11 = new JTextField();
		txtTamao_11.setBackground(Color.DARK_GRAY);
		txtTamao_11.setForeground(Color.WHITE);
		txtTamao_11.setText("");
		txtTamao_11.setEnabled(false);
		txtTamao_11.setColumns(10);
		txtTamao_11.setBounds(112, 375, 69, 20);
		add(txtTamao_11);
		
		txtTamao_12 = new JTextField();
		txtTamao_12.setBackground(Color.DARK_GRAY);
		txtTamao_12.setForeground(Color.WHITE);
		txtTamao_12.setText("");
		txtTamao_12.setEnabled(false);
		txtTamao_12.setColumns(10);
		txtTamao_12.setBounds(112, 401, 69, 20);
		add(txtTamao_12);
		
		textNombre_11 = new JTextField();
		textNombre_11.setBackground(Color.DARK_GRAY);
		textNombre_11.setForeground(Color.WHITE);
		textNombre_11.setText("");
		textNombre_11.setEnabled(false);
		textNombre_11.setColumns(10);
		textNombre_11.setBounds(33, 375, 69, 20);
		add(textNombre_11);
		
		lblNombres = new JLabel("Nombre");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setBounds(43, 70, 59, 14);
		this.add(lblNombres);
		
		lblTamaos = new JLabel("Tama\u00F1o");
		lblTamaos.setForeground(Color.WHITE);
		lblTamaos.setBounds(123, 70, 58, 14);
		this.add(lblTamaos);
		
		componentesNom.add(textNombre_1);
		componentesNom.add(textNombre_2);
		componentesNom.add(textNombre_3);
		componentesNom.add(textNombre_4);
		componentesNom.add(textNombre_5);
		componentesNom.add(textNombre_6);
		componentesNom.add(textNombre_7);
		componentesNom.add(textNombre_8);
		componentesNom.add(textNombre_9);
		componentesNom.add(textNombre_10);
		componentesNom.add(textNombre_11);
		componentesNom.add(textNombre_12);
		
		componentesTam.add(txtTamao_1);
		componentesTam.add(txtTamao_2);
		componentesTam.add(txtTamao_3);
		componentesTam.add(txtTamao_4);
		componentesTam.add(txtTamao_5);
		componentesTam.add(txtTamao_6);
		componentesTam.add(txtTamao_7);
		componentesTam.add(txtTamao_8);
		componentesTam.add(txtTamao_9);
		componentesTam.add(txtTamao_10);
		componentesTam.add(txtTamao_11);
		componentesTam.add(txtTamao_12);
		
		
		rellenadoObjetos();
		
		JLabel label_10 = new JLabel("#11");
		label_10.setForeground(Color.WHITE);
		label_10.setBounds(10, 378, 46, 14);
		add(label_10);
		
		JLabel label_11 = new JLabel("#12");
		label_11.setForeground(Color.WHITE);
		label_11.setBounds(10, 404, 46, 14);
		add(label_11);
		
		
	}	
	//Rellena los campos con los objetos existentes
	public void rellenadoObjetos(){
		for(int i = 0; i < nuevosObjetos.size(); i++){
			componentesTam.get(i).setText(String.valueOf((nuevosObjetos.get(i).getTamanio())));
			componentesNom.get(i).setText((nuevosObjetos.get(i).getNombre()));
		}
	}
	
	public ArrayList<Objeto> getNuevosObjetos(){
		return nuevosObjetos;
	}

	public ArrayList<JTextField> getComponentesNom() {
		return componentesNom;
	}


	public ArrayList<JTextField> getComponentesTam() {
		return componentesTam;
	}
	
	public Validacion getVal() {
		return val;
	}


	
	
	
}

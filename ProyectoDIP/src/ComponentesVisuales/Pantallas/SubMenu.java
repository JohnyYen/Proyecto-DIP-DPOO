package ComponentesVisuales.Pantallas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;

import ComponentesVisuales.Componentes.Boton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ObjectInputStream.GetField;
import java.net.ContentHandler;

public class SubMenu extends JPanel{
	public SubMenu(final Frame parent, boolean model){
		
		//Botón para volver a la Partida
		Boton boton = new Boton("Volver", 200, 200, 100, 0);
		boton.setBackground(new Color(0, 0, 139));
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		boton.setBounds(100, 41, 200, 34);
		
		//Botón para volver al menú
		Boton botonVolverMenu = new Boton("Volver al menu", 200, 200, 100, 150);
		botonVolverMenu.setBounds(100, 186, 200, 34);
		botonVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menu = new MenuPrincipal();
				setVisible(false);
				parent.dispose();
				menu.setVisible(true);
			}
		});
		
		//Botón para las opciones
		Boton botonOpciones = new Boton("Opciones", 200, 200, 100, 50);
		botonOpciones.setBounds(100, 96, 200, 34);
		Boton botonGuardar = new Boton("Guardar Partida", 200, 200, 100, 100);
		botonGuardar.setBounds(100, 141, 200, 34);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.guardarEstado(parent);
			}
		});
		
		this.add(botonVolverMenu);
		this.add(botonGuardar);
		this.add(boton);
		this.add(botonOpciones);
		
		//Modificaciones al JPanel
		this.setBounds(120, 50, 400, 500);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("src/Recursos/SubMenuFondo.png");
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}

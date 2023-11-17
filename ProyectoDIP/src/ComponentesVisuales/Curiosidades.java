package ComponentesVisuales;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ComponentesVisuales.Componentes.Boton;
import Recursos.CustomFont;
import Util.CuriosidadesTableModel;
import Util.RenderizadorImagenes;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ScrollPaneConstants;

public class Curiosidades extends JFrame {
	private JTable table;

	public Curiosidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 20, 700, 576);
		JPanel contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			//Para dibujar el fondo
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/FondoMenuPrincipal.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Un scrollPane para introducir varios elementos
		JScrollPane scrollPane = new JScrollPane(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/FondoMenuPrincipal.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		scrollPane.setBackground(new Color(153, 0, 0));
		scrollPane.setBounds(10, 11, 664, 454);
		contentPane.add(scrollPane);
		
		//Botón para volver al menú principal
		Boton salir  = new Boton("Volver", 300, 300, 350, 350);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				dispose();
				menuPrincipal.setVisible(true);
			}
		});
		contentPane.add(salir);
		
		//Fuente modificable
		CustomFont mfont = new CustomFont();
		
		//Tabla
		//Modelo de la Tabla
		CuriosidadesTableModel tableModel = new CuriosidadesTableModel();
		table = new JTable();
		table.setFont(mfont.MyFont(1, 16));
		table.setModel(tableModel); //Setear el modelo de tabla
		table.getColumnModel().getColumn(0).setCellRenderer(new RenderizadorImagenes()); //Para que se vean las imagenes en una columna especifica
		table.setRowHeight(100);
		tableModel.adicionar(new ImageIcon("src/Recursos/CIcon.png"), "El lenguaje C es muy importante");
		tableModel.adicionar(new ImageIcon("src/Recursos/JavaIcon.png"), "Java es un lenguaje POO");
		scrollPane.setViewportView(table);
		
		//Modificaciones al Frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage());
		table.getColumnModel().getColumn(0).setResizable(true);
		
	}
}

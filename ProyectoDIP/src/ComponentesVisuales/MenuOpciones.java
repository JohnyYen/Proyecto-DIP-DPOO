package ComponentesVisuales;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import Recursos.CustomFont;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.Component;
import java.awt.Font;
public class MenuOpciones extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdAsd;
	private JLabel lblClave;
	private Boton btnEntrar;
	private JLabel lblClaveErronea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpciones frame = new MenuOpciones();
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
	public MenuOpciones() {
		CustomFont cf = new CustomFont();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 561);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Recursos/FondoMenuPrincipal.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setToolTipText("");
		contentPane.setOpaque(false);;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Boton btnModoProfesor = new Boton("Modo Profesor", 300, 300, 200, 250);
		btnModoProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pwdAsd.isVisible() && lblClave.isVisible() && btnEntrar.isVisible()){
					pwdAsd.setVisible(false);
					lblClave.setVisible(false);
					btnEntrar.setVisible(false);
				}
				else {
					pwdAsd.setVisible(true);
					lblClave.setVisible(true);
					btnEntrar.setVisible(true);
				}
				
			}
		});
		btnModoProfesor.setBounds(149, 235, 280, 61);
		getContentPane().add(btnModoProfesor);
		
		//Boton Volver
		Boton btnVolver = new Boton("Volver", 300, 300, 200, 250);
		btnVolver.setAlignmentY(Component.TOP_ALIGNMENT);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal m = new MenuPrincipal();
				m.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(149, 433, 280, 61);
		getContentPane().add(btnVolver);
		
		//Radio para activar y desactivar sonido
		JRadioButton rdbtnSonido = new JRadioButton("SONIDO");
		rdbtnSonido.setSelected(true);
		rdbtnSonido.setOpaque(false); // Hace que el fondo sea transparente
		rdbtnSonido.setForeground(Color.BLACK); // Establece el color del texto
		rdbtnSonido.setUI(new BasicRadioButtonUI() {
            @Override
            protected void paintFocus(Graphics g, AbstractButton b, java.awt.Rectangle viewRect, java.awt.Rectangle textRect, java.awt.Rectangle iconRect) {};
    
        });
		rdbtnSonido.setForeground(Color.LIGHT_GRAY);
		rdbtnSonido.setFont(cf.MyFont(1, 30));
		rdbtnSonido.setBounds(149, 46, 138, 23);
		contentPane.add(rdbtnSonido);
		
		//Label para indicar que introduzca la clave de acceso
		lblClave = new JLabel("Inserte la clave de acceso:");
		lblClave.setVisible(false);
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(159, 307, 211, 14);
		contentPane.add(lblClave);
		
		//Introducir la clave de acceso
		pwdAsd = new JPasswordField();
		pwdAsd.setToolTipText("");
		pwdAsd.setVisible(false);
		pwdAsd.setBounds(159, 332, 197, 20);
		contentPane.add(pwdAsd);
		
		//Botón para entrar al modo Profesor
		btnEntrar = new Boton("Entrar", 300, 300, 200, 250);
		btnEntrar.setVisible(false);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarClave(pwdAsd.getText())) {
					System.out.println("siiiiiiii");
				} else {
					lblClaveErronea.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(388, 308, 280, 61);
		getContentPane().add(btnEntrar);
		
		//En caso de no ser valida
		lblClaveErronea = new JLabel("Clave de acceso no valida");
		lblClaveErronea.setForeground(Color.RED);
		lblClaveErronea.setBackground(Color.RED);
		lblClaveErronea.setVisible(false);
		lblClaveErronea.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClaveErronea.setBounds(127, 374, 266, 14);
		contentPane.add(lblClaveErronea);
		
		
		//Modificaciones al Frame
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("src/Recursos/GameIcon.png").getImage());
		
	}
	
	private boolean validarClave(String clave){
		boolean result = false;
		
		if(clave.equalsIgnoreCase("admin")){
			result = true;
		}
		
		return result;
	}
}

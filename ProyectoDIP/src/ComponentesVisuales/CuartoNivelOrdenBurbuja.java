package ComponentesVisuales;
import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import Logica.ControladorCuartoNivel;


public class CuartoNivelOrdenBurbuja extends JFrame {
	private JPanel mainPanel;
    private JLabel infoLabel;
    private JButton swapButton;
    private JButton acceptButton;

    public CuartoNivelOrdenBurbuja() {
    	setFont(new Font("Dialog", Font.PLAIN, 14));
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Juego de Ordenamiento");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        mainPanel = new JPanel();
        getContentPane().add(mainPanel);
        mainPanel.setLayout(null);

        infoLabel = new JLabel("La forma en que debe ordenarse es: método burbuja");
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoLabel.setBounds(0, 0, 382, 118);
        mainPanel.add(infoLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBounds(0, 118, 382, 35);
        swapButton = new JButton("Intercambiar");
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 intercambiarElementos(); 
            }

			
        });
        buttonPanel.add(swapButton);

        acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para verificar y confirmar el orden
            }
        });
        buttonPanel.add(acceptButton);

        mainPanel.add(buttonPanel);
    }
    
    
    private void intercambiarElementos() {
		// TODO Auto-generated method stub
		
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CuartoNivelOrdenBurbuja juego = new CuartoNivelOrdenBurbuja();
                juego.setVisible(true);
            }
        });
    }
}

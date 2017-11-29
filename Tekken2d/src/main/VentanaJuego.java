package main;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Animacion.Fondo;
import Animacion.Musica;

import java.awt.Color;
public class VentanaJuego extends JFrame {
		/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	public VentanaJuego() throws InterruptedException{
	getContentPane().setLayout(null);
    //Panel con fondo de Pantalla utilizado(clase)
	Fondo panel = new Fondo();
	panel.setBackground(Color.ORANGE);
	panel.setForeground(Color.ORANGE);
	panel.setBounds(10, 11, 401, 239);
	getContentPane().add(panel);
	panel.setOpaque(false);
	panel.setBackground("ImagenFondo/tekkenfondo.jpg");
	panel.setLayout(null);
	//Musica de Fondo
	Musica m1=new Musica("/Musica/101 Player Select.mp3");
	m1.play();
	//BOTON JUGAR
	JButton btnJugar = new JButton("JUGAR");
	btnJugar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			new Vlogin();
			
			
		}
	});
	btnJugar.setBackground(Color.WHITE);
	btnJugar.setForeground(new Color(50, 205, 50));
	btnJugar.setBounds(108, 153, 89, 23);
	panel.add(btnJugar);
	//BOTON SALIR
	JButton btnSalir = new JButton("SALIR");
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	btnSalir.setForeground(Color.RED);
	btnSalir.setBackground(Color.WHITE);
	btnSalir.setBounds(220, 153, 89, 23);
	panel.add(btnSalir);
	
	//Titulo del Juego 
	//JLabel lblAirhockey = new JLabel("TEKKEN 2D");
	//lblAirhockey.setHorizontalAlignment(SwingConstants.CENTER);
	//lblAirhockey.setFont(new Font("Dancing Donuts NF", Font.BOLD, 24));
	//lblAirhockey.setBounds(100, 21, 215, 42);
	//panel.add(lblAirhockey);
	setSize(445,300);
	setTitle("TEKKEN 2D");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
}
	
public static void main(String[] args)throws InterruptedException {    
			
			new VentanaJuego();
			
			
		}
	}

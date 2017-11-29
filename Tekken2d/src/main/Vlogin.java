package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Vlogin extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    private JButton btnLogin;
    private JButton btnGuardar;
    private JButton btnSalir;  
    private JLabel labelUsuario;
    private JLabel labelContra;
    private JTextField txtUsuario;
    private JTextField txtContra;
    
    
	public Vlogin(){

	        componentes();
	                                                      // Al cerrar la ventana 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// se detiene prog 
	    setSize(500,300); // Tamaño de la Ventana Ancho y Largo
	    setLocationRelativeTo(null); // Centra la ventana en el monitor
	    setLayout(null); // elimina toda plantilla.
	    setResizable(false); // evita se pueda modificar el tamaño de ventana
	    setVisible(true); // hace visible la ventana
	    setTitle("*LOGIN*"); // Le pone un titulo a la ventana
	    
	     }
	    
	    public void componentes(){
	    	//textos
	    	    labelUsuario = new JLabel(); // etiqueta
	            labelUsuario.setBounds(20, 50, 150,20);
	            labelUsuario.setText("Usuario");
	            add(labelUsuario);
	        
	            txtUsuario = new JTextField(); // recuadro a rellenar
	            txtUsuario.setBounds(90, 50, 300, 20);
	            add(txtUsuario);
	        
	            labelContra = new JLabel();
	            labelContra.setBounds(20, 80, 150, 20);
	            labelContra.setText("Contraseña");
	            add(labelContra);
	        
	            txtContra = new  JTextField();
	            txtContra.setBounds(90, 80, 300, 20);
	            add(txtContra);
	            //Botones
	            btnLogin=new JButton();
	            btnLogin.setBounds(100, 200, 100, 20);
	            btnLogin.setText("Login");
	            add(btnLogin);
	            btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
    				//dispose();
	            	//new Game();
	            	//Clase que llama al juego
    			}
    });
	            
	            btnGuardar = new JButton();
	            btnGuardar.setBounds(200, 200, 100, 20);
	            btnGuardar.setText("Registrar");
	            add(btnGuardar);
	            btnGuardar.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				//futuro metodo guardar usurario de la BD
		    			}
		    });
	            
	            btnSalir=new JButton();
	            btnSalir.setBounds(300,200, 100, 20);
	            btnSalir.setText("Salir");
	            add(btnSalir);
	            btnSalir.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				System.exit(0);
	    			}
	    });
	            
	        
	            }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 new Vlogin();
	}

}

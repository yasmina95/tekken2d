package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Objetos.Sprite;


public class Juego extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JFrame ventana;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();
    private Sprite sprite, otroSprite;
    long tiempo=System.currentTimeMillis();

    public Juego() {
    	sprite=new Sprite();
        otroSprite=new Sprite();
        
    	try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(766,351 ));
            setTitle("TEKKEN2D");
            
            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
            //ImageIcon ii = new ImageIcon(this.getClass().getResource("ImagenFondo/background.gif"));
            
            imageLabel.setIcon(new javax.swing.ImageIcon("ImagenFondo/background2.gif"));
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            //Metemos el panel en la ventana
            
            
            ventana.setSize(750,350);
            ventana.add(this);
            ventana.setVisible(true);
            ventana.add(contentPane);
            ventana.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
            });
            sprite.setSprite("/ImagenesFondo/ken.gif");
            otroSprite.setSprite("/ImagenesFondo/personaje.png");
            while(true)
            {         
                if (System.currentTimeMillis()-tiempo>25) { // actualizamos cada 25 milisegundos
     
                    if (sprite.getX()>this.getWidth()) sprite.setX(0);
                    else sprite.setX(sprite.getX()+1);
     
                    dibuja(this.getGraphics());
                    tiempo=System.currentTimeMillis();
                }
            }
            
           
        } catch (Exception exception) {
            exception.printStackTrace();
        }
       
    }
    public void dibuja(Graphics grafico) {
        // El Begin de OpenGL o DirectX
        BufferedImage pantalla=new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB );
 
        sprite.putSprite(pantalla.getGraphics(), sprite.getX(), sprite.getY());
        otroSprite.putSprite(pantalla.getGraphics(), 110, 100);
 
        // El ENd
        grafico.drawImage(pantalla, 0, 0, this);
    }
    public static void main(String[] args) {
        new Juego();
    }
	
}

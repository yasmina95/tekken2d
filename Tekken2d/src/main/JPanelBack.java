package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JPanelBack extends javax.swing.JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JFrame jFramePadre;
    public JPanelBack() {
        this.setSize(800, 600);
    }
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        Dimension shape = getSize();        
        ImageIcon imgBack = new ImageIcon(getClass().
                getResource("ImagenFondo/background.gif"));
        g.drawImage(imgBack.getImage(), 0, 0, 
                shape.width, shape.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }
    
    public JFrame getjFramePadre() {
        return jFramePadre;
    }

    
    public void setjFramePadre(JFrame jFramePadre) {
        this.jFramePadre = jFramePadre;
    }

}

package main;


import java.awt.BorderLayout;

public class MainFrame extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanelBack pnlBack;
	public MainFrame() {
        initComponents();
        pnlBack = new JPanelBack();
        pnlBack.setjFramePadre(this);
        this.add(pnlBack, BorderLayout.CENTER);
    }
	
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final MainFrame mf = new MainFrame(); 
                mf.setVisible(true);
                (new Thread() {
					@Override
					public void run() {
						while (true) {
							mf.repaint();
							try { Thread.sleep(40); } catch (Exception e) {}
						}
					}
				}).start();
            }
        });
    }

}

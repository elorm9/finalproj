package game;
import java.awt.BorderLayout;
import java.awt.Color;

import game.StartMenu.StartMenu;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Rtype extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLayeredPane layers;
	private JPanel background;
	private JPanel game;
	
	public Rtype() {
		
		layers = new JLayeredPane();
        background = new Background();
        background.setBounds(0, 0, 800, 400);
        background.setBackground(Color.BLACK);
        
        layers.add(background, new Integer(1));
        
        game = new Board();
        game.setBounds(0, 0, 800, 600);
        
        layers.add(game, new Integer(2));
        
        getContentPane().add(layers, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        
        setVisible(true);
    }

    public static void main(String[] args) {
    	new Rtype();
    	
    }
}

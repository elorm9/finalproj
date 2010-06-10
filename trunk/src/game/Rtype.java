package game;
import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//this is the main class of this program
public class Rtype extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//the layered pane is used to present the game sprites in front of the background
	private JLayeredPane layers;
	
	//background Jpanel
	private JPanel background;
	
	//Jpanel with the main game
	private JPanel game;
	
	public Rtype() {
		
		//initialize the layers 
		layers = new JLayeredPane();
		
		//initialize the background jpanel
        background = new Background();
        background.setBounds(0, 0, 800, 400);
        background.setBackground(Color.BLACK);
        
        //add the background jpanel to the layers
        layers.add(background, new Integer(1));
        
        //initialize the main game
        game = new Board();
        game.setBounds(0, 0, 800, 600);
        
        //add the game jpanel to the layers
        layers.add(game, new Integer(2));
        
        //add the layers to the Jframe
        getContentPane().add(layers, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        
        setVisible(true);
    }

    public static void main(String[] args) {
    	
    	//start the program
    	new Rtype();
    	
    }
}

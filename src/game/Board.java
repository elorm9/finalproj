package game;

import game.Enemy.*;
import game.Items.ItemCollector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
   
	private Craft craft;
    private ItemCollector drops;
    private Enemies opponents;
    
    private Image background;

    
    public Board() {


    	
    	
    	 ImageIcon ii = new ImageIcon(this.getClass().getResource("Background1.png"));
         background = ii.getImage();
         

        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);


        //create a user plane
        craft = new Craft(40,60);
        opponents = new Enemies();
        drops = new ItemCollector();
        
        //create a timer
        timer = new Timer(3, this);
        timer.start();
       
    }

    
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        
        drawGUI();
        //drawBackground(g2d, this);
        
        craft.draw(g2d, this);
        craft.drawHP(g);
        craft.drawMissiles(g2d, this);
        
        
        opponents.drawEnemies(g2d, this);
        opponents.drawHP(g);
        opponents.drawEnemyMissiles(g2d, this);

        drops.drawItems(g2d, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        
   
        //update the airplane's position
        craft.move();
        craft.missileAction(opponents.getEnemies());
        
        opponents.removeEnemies(drops);
        opponents.move();
        opponents.missileAction(craft);
        
        drops.removeItems();
        drops.moveItems();
        drops.checkCollisions(craft);
        //update the current image
        repaint();  
    }


    private void drawBackground(final Graphics2D g2d, final ImageObserver i)
    {
    	g2d.drawImage(background, 0, 0, i);
    	
    }


    private void drawGUI(){
    	
    }

 
    
    private class TAdapter extends KeyAdapter {

    	//if any keys are pressed queue the keylistener in the craft class
        public void keyReleased(KeyEvent e) {
        	
        	int key = e.getKeyCode();
        	
        	if(key == KeyEvent.VK_ESCAPE)
        		System.exit(0);
        	else
            {
        		craft.keyReleased(e);
            }
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}


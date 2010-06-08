package game;

import game.Collectors.EnemyCollector;
import game.Collectors.ItemCollector;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Timer refresh;
	private Timer createEnemy;
	private Timer updateOthers;
	private Timer explode;
	private Timer checkEnemies;

	private boolean enemySpawn = true;
	private int currentLevel;
	
	private Craft craft;
    private ItemCollector drops;
    private EnemyCollector opponents;
    
    
    
    private Font GUI;
    
    public Board() {

        GUI = new Font("Monospaced", Font.BOLD, 15);
        
        //add the user airplane's key listener
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        //set to Opaque in order to display the game's background in the layered jpanel
        setOpaque(false);
        
        //create a user plane
        craft = new Craft(40,60);
        
        //create an Enemy Collector set to 20 enemies
        opponents = new EnemyCollector(20);
        
        //create an Item Collector which handles items that are dropped by enemies
        drops = new ItemCollector();
        
        //refresh is a swing timer that
        //determines how often the functions in this program are executed
        refresh = new Timer(5, this);
        refresh.start();
        
        //checkEnemies basically tells the Enemy Collector to delete enemies
        //that are already destroyed
        checkEnemies = new Timer(200, new ActionListener(){

			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
					opponents.removeEnemies(drops);
			}
        	
        });
        
        checkEnemies.start();
        
        //createEnemy determines how often a new enemy spawns
        createEnemy = new Timer(750, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
					opponents.addEnemy();
			}
        	
        });
        
        createEnemy.start();
        
        //the explode function basically checks the hp of each enemy and loads the explosion
        //animation if any enemy in the collector has an hp of 0
        explode = new Timer(5, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				opponents.explode();
				
			}
        	
        });
        
        explode.start();
        
        //updateOthers basically handles other calculations
        updateOthers = new Timer(1, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				
				//move each enemy inside the Enemy collector
		        opponents.move();
		        
		        //update the position of each enemy and handle collisions
		        //with the user's craft
		        opponents.missileAction(craft);
		        
		        //check the items inside the collector
		        drops.removeItems();
		        
		        //update the position of each item
		        drops.moveItems();
		        
		        //check item collisions with the user's craft
		        drops.checkCollisions(craft);
				
			}
        	
        });
        
        updateOthers.start();
       
    }

    //main draw function
    public void paintComponent(Graphics g) {
    	//clears the screen
        super.paintComponent(g);
        
        //g2D is used to draw images
        Graphics2D g2d = (Graphics2D)g;
        
        //draw the GUI that is displayed on the bottom of the screen
        drawGUI(g2d, this);
        
        //draw the user's craft, its hp, and its missiles
        craft.draw(g2d, this);
        craft.drawMissiles(g2d, this);
        
        //draw each enemy inside the Enemy collector
        opponents.draw(g2d, this);
        
        //draw each item inside the Item collector
        drops.drawItems(g2d, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void updateLevel(Graphics2D g2d){
    	
    }
    public void actionPerformed(ActionEvent e) {
        
        //update the airplane's position
        craft.move();
        craft.missileAction(opponents.getEnemies());
        
        //update the current image
        repaint();  
    }
    
	public void drawGUI(Graphics2D g2d, ImageObserver i){
		//strings that are used to compose the GUI
		String numMissiles = "Missiles: " + craft.getNumMissiles();
		String numBlueBullets = "Blue Bullets:" + craft.getNumBlueBullets();
		String numGreenBullets = "Green Lasers:" + craft.getNumBGreenBullets();
		String userHP = "HP";
		
		g2d.setFont(GUI);
		

		
		g2d.fill3DRect(0, 370, 800, 50, true);
		
		//draw the numMissiles string in Red
    	g2d.setColor(Color.RED);
		g2d.drawString(numMissiles, 150, 400);
		
		//draw the numBlueBullets string in blue
		g2d.setColor(Color.BLUE);
		g2d.drawString(numBlueBullets, 270, 400);
		
		//draw the numGreenBullets string in green
		g2d.setColor(Color.GREEN);
		g2d.drawString(numGreenBullets, 410, 400);
		
		//draw the User's hp
		craft.drawHP(g2d);
		g2d.drawString(userHP, 60, 385);

		
	}

 
    
    private class TAdapter extends KeyAdapter {

    	//if any keys are pressed queue the keylistener in the craft class
        public void keyReleased(KeyEvent e) {
        	
        	int key = e.getKeyCode();
        	
        	//if the user presses the Esc key then quit the game
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


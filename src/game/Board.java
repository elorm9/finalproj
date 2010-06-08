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

	private boolean enemySpawn;
	
	private Craft craft;
    private ItemCollector drops;
    private EnemyCollector opponents;
    
    
    
    private Font GUI;
    
    public Board() {

        GUI = new Font("Monospaced", Font.BOLD, 15);
         
        addKeyListener(new TAdapter());
        setFocusable(true);
        setOpaque(false);
        
 
        
        
        //create a user plane
        craft = new Craft(40,60);
        
        //
        opponents = new EnemyCollector(20);
        drops = new ItemCollector();
        
        //create a timer
        refresh = new Timer(5, this);
        refresh.start();
        
        checkEnemies = new Timer(200, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
					opponents.removeEnemies(drops);
			}
        	
        });
        
        checkEnemies.start();
        
        createEnemy = new Timer(750, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
					opponents.addEnemy();
					opponents.removeEnemies(drops);
			}
        	
        });
        
        createEnemy.start();
       
        explode = new Timer(5, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				opponents.explode();
				
			}
        	
        });
        
        explode.start();
        
        updateOthers = new Timer(1, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		      
		        opponents.move();
		        opponents.missileAction(craft);
		        
		        drops.removeItems();
		        drops.moveItems();
		        drops.checkCollisions(craft);
				
			}
        	
        });
        
        updateOthers.start();
       
    }

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        drawGUI(g2d, this);
        
        
        craft.draw(g2d, this);
        craft.drawHP(g);
        craft.drawMissiles(g2d, this);
        
        opponents.draw(g2d, this);

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

    /*
    
	*/
    
  /*  public void initFont() throws FontFormatException, IOException{
    
    	File file = new File("Radiof.ttf");
    	FileInputStream fis = new FileInputStream(file);
    	GUI = Font.createFont(Font.TRUETYPE_FONT, fis);
    }*/
    
	public void drawGUI(Graphics2D g2d, ImageObserver i){
		String numMissiles = "Missiles: " + craft.getNumMissiles();
		String numBlueBullets = "Blue Bullets:" + craft.getNumBlueBullets();
		String numGreenBullets = "Green Lasers:" + craft.getNumBGreenBullets();
		String userHP = "HP";
		
		g2d.setFont(GUI);
		
		Color red = new Color(255, 100,0);
		Color blue = new Color(0,100,255);
		Color green = new Color(0,255,100);
		
		g2d.fill3DRect(0, 370, 800, 50, true);
		
    	g2d.setColor(red);
		g2d.drawString(numMissiles, 150, 400);
		
		g2d.setColor(blue);
		g2d.drawString(numBlueBullets, 270, 400);
		
		g2d.setColor(green);
		g2d.drawString(numGreenBullets, 410, 400);
		
		craft.drawHP(g2d);
		g2d.drawString(userHP, 60, 385);

		
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


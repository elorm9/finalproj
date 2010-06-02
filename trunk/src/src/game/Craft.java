package game;

import game.Enemy.Enemy;
import game.Weapons.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


//this class creates the player's airplane

public class Craft extends Airplane {

	//reference to the airplane's image file
    private String ref = "Images/Planes/plane2.png";
   
    private final int CRAFT_SIZE = 20;
    
    //number of missiles and bullets that the airplane has
    private int numMissiles;
    private int numGreenBullets;
    private int numBlueBullets;
    
    public Craft()
    {
    	super();
    }
    
    public Craft(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
    	setExplosion(getExplosionRef());
    	
        setWidth(getImage().getWidth(null) -30 );
        setHeight(getImage().getHeight(null));
        setHP(100);
        setMaxHP(100);
        initSounds();
        numMissiles = 5;
    }

    //moves the airplane according to the current values of DX and DY
    public void move() {
    	getLocation().translate(getDX(), getDY());
	}
    
    //return the number of missiles that the airplane has
    public int getNumMissiles(){
    	return numMissiles;
    }
    
    //increase the stockpile of missiles that the airplane has
    public void addMissiles(int a){
    	numMissiles += a;
    }
    
    //return the number of green bullets that the airplane has
    public int getNumBGreenBullets(){
    	return numGreenBullets;
    }
    
    //increase the stockpile of green bullets that the airplane has
    public void addGreenBullets(int a){
    	numGreenBullets+= a;
    }
    
  //return the number of blue bullets that the airplane has
    public int getNumBlueBullets(){
    	return numBlueBullets;
    }
    
    //increase the stockpile of blue bullets that the airplane has
    public void addBlueBullets(int a){
    	numBlueBullets+= a;
    }
    
    //fires a red bullet
    public void fireRedBullet() {
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	getL1().loop();
    	getMissiles().add(new RedBullet(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));

    }
    
    //fires a blue bullet
    public void fireBlueBullet(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numBlueBullets > 0){
    		getMissiles().add(new BlueBullet(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));	
    		getL2().play();
    		numBlueBullets--;
    	}
    }
    
    //fires a laser (green bullet)
    public void fireLaser(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numGreenBullets > 0){
    		getMissiles().add(new GreenLaser(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));	
    		numGreenBullets--;
    	}
    }
    
    //fires a missile
    public void fireMissle(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numMissiles > 0){
    		getMissiles().add(new RedMissle(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));
    		numMissiles--;
    	}

    }
 
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        //if the user presses the left arrow key then set the x-displacement to -2
        if (key == KeyEvent.VK_LEFT) {
            setDX(-2);
        }
        
        //if the user presses the right arrow key then set the x-displacement to 2
        if (key == KeyEvent.VK_RIGHT) {
        	setDX(2);
        }
        
        //if the user presses the up arrow key then set the y-displacement to -2
        if (key == KeyEvent.VK_UP) {
            setDY(-2);
        }
        
        //if the user presses the down arrow key then set the y-displacement to 2
        if (key == KeyEvent.VK_DOWN) {
            setDY(2);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        //once any of the arrow keys have been released, set all the displacements to 0
        if (key == KeyEvent.VK_LEFT) {
            setDX(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
          setDX(0);
        }

        if (key == KeyEvent.VK_UP) {
            setDY(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            setDY(0);
        }
        
        if (key == KeyEvent.VK_A) {
            fireMissle();
        }
        
        if(key == KeyEvent.VK_S)
        	fireRedBullet();
        
        if(key == KeyEvent.VK_D)
        	fireBlueBullet();
        
        if(key == KeyEvent.VK_F)
        	fireLaser();

    }
    
    //draws the HP bar in the bottom left corner
    public void drawHP(Graphics hp)
    {
    	Color green = new Color(0,255,0);
    	hp.setColor(green);
    	
    	//draw a rectangle (HP BAR) at the coordinates (20,390)
    	hp.fillRect(20, 390, getHP(), 15);
    }
	
    
	public void missileAction(ArrayList<Enemy> enemies) 
	{
		ArrayList<Missile> missiles = getMissiles();
		
		//for each missle in the missle arraylist
	    for (int i = 0; i < missiles.size(); i++) {
	    	
	    	Missile m =  missiles.get(i);  
	    	
	        //if the missile is visible, the continue moving it
	    	
	        if (m.isVisible())
	        {
	        	m.move();
	            for( int j = 0; j < enemies.size(); j++)
	            {
	            	if(m.getBound().intersects(enemies.get(j).getBound())){
	            		enemies.get(j).takeDamage(m.getDamage()+10);
	            		m.setVisible(false);
	            	}
	            }
	            	
	        }
	        //else delete it from the arraylist
	        else missiles.remove(i);
	    }
	}



	



}

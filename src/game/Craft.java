package game;

import game.Enemy.Enemy;
import game.Weapons.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public class Craft extends Airplane implements KeyListener{

	//reference to the image file for this entity
    private String ref = "Images/Planes/plane2.png";
    
    //the craft size variable is basically used to properly draw missiles in the correct starting positions
    private final int CRAFT_SIZE = 20;
    
    //each int stores the number of each missile that the user's craft currently has
    private int numMissiles;
    private int numGreenBullets;
    private int numBlueBullets;
    
    public Craft()
    {
    	super();
    }
    
    public Craft(int x, int y) {
    	super(x,y);
    	
    	//set the images of this entity using the provided reference
    	setImage(ref);
    	setExplosion(getExplosionRef());
    	
    	//set the width and height of this entity
    	//these variables are used to create a rectangle that will be used in object collision detection
        setWidth(getImage().getWidth(null) -80);
        setHeight(getImage().getHeight(null));
        
        //set the hp and the max HP that this entity can have
        setHP(100);
        setMaxHP(100);
        
        
        //start the user off with 5 missiles
        numMissiles = 5;
    }

    //update this entity's position using its current dx and dy values
    public void move() {
    	getLocation().translate(getDX(), getDY());
	}
    
    //the functions below are used to get this craft's current number of
    //missiles and to add more missiles 
    public int getNumMissiles(){
    	return numMissiles;
    }
    
    public void addMissiles(int a){
    	numMissiles += a;
    }
    
    public int getNumBGreenBullets(){
    	return numGreenBullets;
    }
    
    public void addGreenBullets(int a){
    	numGreenBullets+= a;
    }
    
    public int getNumBlueBullets(){
    	return numBlueBullets;
    }
    
    public void addBlueBullets(int a){
    	numBlueBullets+= a;
    }
    
    //the following functions fire a missile
    //the CRAFT_SIZE variable is used to ensure that the missiles
    //are drawn in the proper position
    public void fireRedBullet() {
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	getMissiles().add(new RedBullet(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));

    }
    
    public void fireBlueBullet(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numBlueBullets > 0){
    		getMissiles().add(new BlueBullet(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));	
    		numBlueBullets--;
    	}
    }
    
    public void fireLaser(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numGreenBullets > 0){
    		getMissiles().add(new GreenLaser(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));	
    		numGreenBullets--;
    	}
    }
    
    public void fireMissle(){
    	int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	if(numMissiles > 0){
    		getMissiles().add(new RedMissle(x + CRAFT_SIZE, y + CRAFT_SIZE/2 + 20));
    		numMissiles--;
    	}

    }
 
    //this keylistener updates the current displacement of the entity
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        //this block handles commands that take place
        //when a user presses the left arrow key
        if (key == KeyEvent.VK_LEFT) {
        	
        	//if the craft's current position along the x-axis is less than
        	//zero, set the displacement in the x direction to 0
        	//otherwise, set the displacement in the x direction to -2
        	if(getLocation().getX() < 0)
        		setDX(0);
        	else
        		setDX(-2);
        }
        
        //this block handles commands that take place
        //when a user presses the right arrow key
        if (key == KeyEvent.VK_RIGHT) {
        	
        	//if the craft's current position along the x-axis is greater than
        	//740, set the displacement in the x direction to 0
        	//otherwise, set the displacement in the x direction to 2
        	if(getLocation().getX()>740)
        		setDX(0);
        	else	
        		setDX(2);
        }
        
        //this block handles commands that take place
        //when a user presses the up arrow key
        if (key == KeyEvent.VK_UP) {
        	
        	//if the craft's current position along the y-axis is less than
        	//zero, set the displacement in the y direction to 0
        	//otherwise, set the displacement in the x direction to -2
        	if(getLocation().getY() < 0)
        		setDY(0);
        	else
        		setDY(-2);
        }
        
        //this block handles commands that take place
        //when a user presses the down arrow key
        if (key == KeyEvent.VK_DOWN) {
        	
        	//if the craft's current position along the y-axis is greater than
        	//340, set the displacement in the y direction to 0
        	//otherwise, set the displacement in the y direction to 2
        	if(getLocation().getY() > 310)
        		setDY(0);
        	else
        		setDY(2);
        }
    }

    //once all of the keys have been released
    //set all displacements to 0
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

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
    
    //this function draws the green bar that is present in the
    //bottom right corner of the screen
    public void drawHP(Graphics hp)
    {
    	Color green = new Color(0,255,0);
    	hp.setColor(green);
    	
    	hp.fillRect(20, 390, getHP(), 15);
    }
	
    //this function updates the position of each missile
    //inside the craft's missile arraylist and handles missile collisions with the
    //enemies
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

	public void keyTyped(KeyEvent e) {
		//do nothing
	}



	



}

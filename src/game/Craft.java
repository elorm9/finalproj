package game;

import game.Enemy.Enemy;
import game.Weapons.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Craft extends Airplane {

    private String ref = "Images/Planes/plane2.png";
    private final int CRAFT_SIZE = 20;
    
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
        setWidth(getImage().getWidth(null) -30 );
        setHeight(getImage().getHeight(null));
        setHP(100);
        
        numMissiles = 5;
    }


    public void move() {
    	getLocation().translate(getDX(), getDY());
	}
    
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
 
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            setDX(-2);
        }

        if (key == KeyEvent.VK_RIGHT) {
        	setDX(2);
        }

        if (key == KeyEvent.VK_UP) {
            setDY(-2);
        }

        if (key == KeyEvent.VK_DOWN) {
            setDY(2);
        }
    }

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

    public void drawHP(Graphics hp)
    {
    	Color green = new Color(0,255,0);
    	hp.setColor(green);
    	
    	hp.fillRect(20, 330, getHP(), 15);
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

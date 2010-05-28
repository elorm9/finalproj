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


public class Craft extends Airplane implements Entity{

    private String ref = "Images/Planes/plane2.png";
    private final int CRAFT_SIZE = 20;
    
    private int numMissiles;
    private int numBullets;
    
    public Craft()
    {
    	super();
    }
    
    public Craft(int x, int y) {
    	super(x,y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        HP = 100;
        
        numMissiles = 5;
        numBullets = 200;
    }


    public void move() {
		x += dx;
    	y += dy;
	}
    
    public void fireRedBullet() {
    	if(numBullets > 0){
    		missiles.add(new RedBullet(getX() + CRAFT_SIZE, getY() + CRAFT_SIZE/2 + 20));
    		numBullets--;
    	}
    	System.out.println(numBullets);
    }
    
    public void fireBlueBullet(){
    	if(numBullets > 0){
    		missiles.add(new BlueBullet(getX() + CRAFT_SIZE, getY() + CRAFT_SIZE/2 + 20));	
    		numBullets--;
    	}
    }
    
    public void fireLaser(){
    	if(numBullets > 0){
    		missiles.add(new GreenLaser(getX() + CRAFT_SIZE, getY() + CRAFT_SIZE/2 + 20));	
    		numBullets--;
    	}
    }
    
    public void fireMissle(){
    	if(numMissiles > 0){
    		missiles.add(new RedMissle(getX() + CRAFT_SIZE, getY() + CRAFT_SIZE/2 + 20));
    		numMissiles--;
    	}
    	
    	System.out.println(numMissiles);
    }


    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
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

    public Rectangle getBound(){
   	 return new Rectangle(x, y, image.getWidth(null)-68, image.getHeight(null));
   }

    
    public void drawHP(Graphics hp)
    {
    	Color green = new Color(0,255,0);
    	hp.setColor(green);
    	
    	hp.fillRect(20, 330, HP, 15);
    }
	
    
	public void missileAction(ArrayList<Enemy> enemies) 
	{
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

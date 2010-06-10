package game;

import game.Weapons.Missile;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;



public abstract class Airplane extends Entity{
	
	private int CRAFT_SIZE = 20;
	
	//this stores the current HP of the craft
    private int HP;
    
    //this stores the maxHP that the craft can have
    private int maxHP;
    
    private String explosionRef = "Images/Planes/explode.gif";
    
    //this arraylist stores all missiles of each airplane
	private ArrayList <Missile> missiles = new ArrayList<Missile>();

	
	//attack commands that will be defined by
	//each sub-class
    public abstract void fireRedBullet();
    public abstract void fireBlueBullet();
    public abstract void fireMissle();
    
    public abstract void drawHP(Graphics hp);

    
    public Airplane() {

    }
    
    public Airplane(int x, int y)
    {
    	setLocation(x,y);
    }
   
    public ArrayList<Missile> getMissiles(){
    	return missiles;
    }
    
    public int getSize(){
    	return CRAFT_SIZE;
    }
    //this function draws all of the missiles in the missile arraylist
	public void drawMissiles(Graphics2D g2d, ImageObserver j)
	{
		int x = 0;
		int y = 0;
		for (int i = 0; i < missiles.size(); i++ ){
			Missile m =  missiles.get(i);
			
			x = (int)m.getLocation().getX();
			y = (int)m.getLocation().getY();
	        //draw the missile
			g2d.drawImage(m.getImage(), x, y, j);
		}
	}
	
	//reduces hp by the specified amount of damage
	public void takeDamage(int damage)
	{
		HP -= damage;
	}
	
	//set the HP
	public void setHP(int h){
		HP = h;
	}
	
	//get the HP
	public int getHP()
	{
		return HP;
	}
	
	//set the maximum HP
	public void setMaxHP(int h){
		maxHP = h;
	}
	
	//increase the HP
	public void increaseHP(int h){
		HP += h;
		
		if(HP > maxHP)
			HP = maxHP;
	}
	
	//get the reference to the explosion animation
	public String getExplosionRef(){
		return explosionRef;
	}
	


}



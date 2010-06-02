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
	
    private int HP;
    private int maxHP;
    
    //location of the animated gif containing the explosion image
    private String explosionRef = "Images/Planes/explode.gif";
    
    //stores the missiles for each airplane
	private ArrayList <Missile> missiles = new ArrayList<Missile>();
	
	private AudioClip laser1;
	private AudioClip laser2;
	private AudioClip laser3;
	private AudioClip explode;
	
	//methods for firing various missiles
    public abstract void fireRedBullet();
    public abstract void fireBlueBullet();
    public abstract void fireMissle();
    
    //method for drawing HP
    public abstract void drawHP(Graphics hp);

    //default constructor
    public Airplane() {

    }
    
    //sets the location according to the input x and y variables
    public Airplane(int x, int y)
    {
    	setLocation(x,y);
    }
   
    //returns the arraylist of missiles
    public ArrayList<Missile> getMissiles(){
    	return missiles;
    }
    
    //draws all the missiles inside the arraylist of each plane
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
	
	//reduces the health of the airplane
	public void takeDamage(int damage)
	{
		HP -= damage;
	}
	
	//sets the HP of the airplane
	public void setHP(int h){
		HP = h;
	}
	
	//gets the HP of the airplane
	public int getHP()
	{
		return HP;
	}
	
	//sets the maximum possible HP of the airplane
	public void setMaxHP(int h){
		maxHP = h;
	}
	
	//increases the HP of the airplane by the input amount
	//also ensures that the airplane's HP doesn't exceed the maximum HP it can have
	public void increaseHP(int h){
		HP += h;
		
		if(HP > maxHP)
			HP = maxHP;
	}
	
	//returns the location of the reference to the explosion image
	public String getExplosionRef(){
		return explosionRef;
	}

	
	public void initSounds(){
		
		URL url = this.getClass().getResource("Sounds/Laser1.wav");
		laser1 = Applet.newAudioClip(url);
		
		url = this.getClass().getResource("Sounds/Laser2.wav");
		laser2 = Applet.newAudioClip(url);
		
		url = this.getClass().getResource("Sounds/Laser3.wav");
		laser3 = Applet.newAudioClip(url);
		
		url = this.getClass().getResource("Sounds/Explode.aif");
		explode = Applet.newAudioClip(url);
	}
	
	public AudioClip getL1(){
		return laser1;
	}
	
	public AudioClip getL2(){
		return laser2;
	}
	
	public AudioClip getL3(){
		return laser3;
	}

}



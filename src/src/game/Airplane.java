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
    
    private String explosionRef = "Images/Planes/explode.gif";
    
	private ArrayList <Missile> missiles = new ArrayList<Missile>();
	
	private AudioClip laser1;
	private AudioClip laser2;
	private AudioClip laser3;
	private AudioClip explode;
	
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
	
	public void takeDamage(int damage)
	{
		HP -= damage;
	}
	
	public void setHP(int h){
		HP = h;
	}
	
	public int getHP()
	{
		return HP;
	}
	
	public void setMaxHP(int h){
		maxHP = h;
	}
	
	public void increaseHP(int h){
		HP += h;
		
		if(HP > maxHP)
			HP = maxHP;
	}

	public String getExplosionRef(){
		return explosionRef;
	}
	
	public void explode(){
		super.explode();
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



package game;

import game.Weapons.Missile;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.awt.*;


public abstract class Airplane extends Entity{
	
    private int HP;
    private int maxHP;
    
	private ArrayList <Missile> missiles = new ArrayList<Missile>();

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




}



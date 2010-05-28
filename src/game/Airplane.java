package game;
import game.Weapons.Missile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;


import java.awt.*;
import java.net.*;
import javax.swing.*;


public abstract class Airplane implements Entity{
	
	protected int index;
	
	    
    protected int dx;
    protected int dy;
    
    protected int x;
    protected int y;
    
    protected int width;
    protected int height;
    
    protected Image image;
    protected Image explosion;
    
    protected int HP;
    
	protected ArrayList <Missile> missiles = new ArrayList<Missile>();

	
    protected boolean visible;
    
    public Airplane() {
    	image = null;
        x = 40;
        y = 60;
    }
    
    public Airplane(int x, int y)
    {
    	this.x = x;
    	this.y = y;
    	image = null;
    	index = 0;
    	HP = 0;
    }
    

    public abstract void fireRedBullet();
    
    public abstract void fireBlueBullet();
    
    public abstract void fireMissle();
    
    public abstract ArrayList<Missile> getMissiles();
    
    public  abstract void move();

    public void destroy()
    {
    	visible = false;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Image getImage() {
        return image;
    }
    
    public boolean isVisible() {
		return visible;
	}
    
    public void setVisible(boolean a) {
		visible = a;
	}
    
    public abstract void drawHP(Graphics hp);
    
    public Rectangle getBound(){
    	 return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    public void draw(Graphics2D g2d, ImageObserver i)
	{
		g2d.drawImage(getImage(), getX(), getY(), i);
	}
	
	public void drawMissiles(Graphics2D g2d, ImageObserver j)
	{
		for (int i = 0; i < missiles.size(); i++ ){
			Missile m =  missiles.get(i);
			
	        //draw the missile
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), j);
		}
	}
	


	public void takeDamage(int damage)
	{
		HP -= damage;
	}
	
	public int getHP()
	{
		return HP;
	}




}



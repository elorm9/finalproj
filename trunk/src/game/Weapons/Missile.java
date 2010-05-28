package game.Weapons;


import game.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Missile implements Entity{

    private int x, y;
    protected boolean visible;
    protected Image image;
    
    protected int width;
    protected int height;
    
    public Missile()
    {
    	this.x = 0;
    	this.y = 0;
    	
    	image = null;
    	
    	visible = false;
    }
    
    public Missile(int x, int y) {

        ImageIcon ii = new ImageIcon(this.getClass().getResource("Bullets/missile.png"));
        image = ii.getImage();
        
        
        visible = true;
        this.x = x;
        this.y = y;
        
    }
    
    
	
    
    public Image getImage() {
        return image;
    }

    public int getX() {	
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }
    
    public void setSpeed(int missileSpeed)
    {
    	x += missileSpeed;
    }

	public void setVisible(boolean a) {
		visible = a;
		
	}
	
	public Rectangle getBound(){
		return new Rectangle(x, y, width, height);
	}
    public abstract void move();
    
    public abstract int getDamage();
    
}

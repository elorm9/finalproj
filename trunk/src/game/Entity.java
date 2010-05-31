package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;


public abstract class Entity {

	private Point location;
	
	private int dx;
   	private int dy;
   
   	private int width;
   	private int height;
   	
   	private Image image;
    private Image explosion;
    
   	private boolean visible;
	private boolean isExploded = false;
	
   	public abstract void move();
	  
	public Entity(){
		width = 0;
		height = 0;
		image = null;
		
		visible = false;
	}
	
   	public Entity(int x, int y){
   		location = new Point(x,y);
   		width = 0;
		height = 0;
		image = null;
		
		visible = false;
   	}
   	
    public Rectangle getBound(){
    	int x = (int)location.getX();
    	int y = (int)location.getY();
    	
    	if(isExploded == false)
    		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    	else
    		return new Rectangle(x,y, 1,1);
    }
    

    public void setLocation(int X, int Y){
    	location = new Point(X,Y);
    }
    
    public Point getLocation(){
    	return location;
    }
    
    public int getDX(){
    	return dx;
    }
    
    public void setDX(int DX){
    	dx = DX;
    }
    
    public int getDY(){
    	return dy;
    }
    
    public void setDY(int DY){
    	dy = DY;
    }
    
    public void setWidth(int w){
    	width = w;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public void setHeight(int l){
    	height = l;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public void draw(Graphics2D g2d, ImageObserver i)
	{
      	int x = (int)location.getX();
    	int y = (int)location.getY();
		g2d.drawImage(getImage(), x, y, i);
	}
	
    
	  
   	public boolean isVisible(){
   		return visible;
   	}
   	
	public void setVisible(boolean a){
   		visible = a;
   	}
	
	public void setImage(String ref){
	    ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
	    image = ii.getImage();
	}

	
	public void setExplosion(String ref){
	    ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
	    explosion = ii.getImage();
	}
	
	public Image getExplosion(){
		return explosion;
	}
	
	public void explode(){
		image = explosion;
		isExploded = true;
	}
	
	public boolean isExploded(){
		return isExploded;
	}
	
	public Image getImage() {
		return image;
	}

	

}

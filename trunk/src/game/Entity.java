package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;


public abstract class Entity {
	
	private Point location;
	
	//dx: displacement of the entity in the x direction
	//dy: displacement in the entity in the y direction
	private int dx;
   	private int dy;
   
   	//width and height of the object's image
   	private int width;
   	private int height;
   	
   	//main image and explosion animation for each entity
   	private Image image;
    private Image explosion;
    
    //basic booleans that are used to remove the entity 
    //and to display the explosion animation
   	private boolean visible;
	private boolean isExploded = false;
	
	//function that moves the entity around the screen
   	public abstract void move();
	
   	//default constructor
	public Entity(){
		width = 0;
		height = 0;
		image = null;
		
		visible = false;
	}
	
	//constructor that takes location coordinates
   	public Entity(int x, int y){
   		location = new Point(x,y);
   		width = 0;
		height = 0;
		image = null;
		
		visible = false;
   	}
   	
   	//returns a Rectangle that is used in object collisions
    public Rectangle getBound(){
    	int x = (int)location.getX();
    	int y = (int)location.getY();
    	
    	if(isExploded == false)
    		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    	else
    		return new Rectangle(x,y, 1,1);
    }
    
    //set the location using specified coordinates
    public void setLocation(int X, int Y){
    	location = new Point(X,Y);
    }
    
    //get the location
    public Point getLocation(){
    	return location;
    }
    
    //the the displacement in the x direction
    public int getDX(){
    	return dx;
    }
    
    //set the displacement in the x direction
    public void setDX(int DX){
    	dx = DX;
    }
    
    //get the displacement in the Y direction
    public int getDY(){
    	return dy;
    }
    
    //set the displacement in the Y direction
    public void setDY(int DY){
    	dy = DY;
    }
    
    //set the width of the entity which is used to create its Rectangle bound
    public void setWidth(int w){
    	width = w;
    }
    
    //get the width of the entity
    public int getWidth(){
    	return width;
    }
    
    //set the height of the entity
    public void setHeight(int l){
    	height = l;
    }
    
    //get the height of the entity
    public int getHeight(){
    	return height;
    }
    
    //draw the entity
    public void draw(Graphics2D g2d, ImageObserver i)
	{
      	int x = (int)location.getX();
    	int y = (int)location.getY();
		g2d.drawImage(getImage(), x, y, i);
	}
	
    //return the visibility of the entity
   	public boolean isVisible(){
   		return visible;
   	}
   	
   	//set the visibility of the entity
	public void setVisible(boolean a){
   		visible = a;
   	}
	
	//set the image using a specified string reference
	public void setImage(String ref){
	    ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
	    image = ii.getImage();
	}

	//set the explosion image using a specified string reference
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

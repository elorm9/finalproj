package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

//provides basic functionality for all the classes
public abstract class Entity {

	private Point location;
	
	//displacement in the x direction
	private int dx;
	
	//displacement in the y direction
   	private int dy;
   
   	//width of the object's image file
   	private int width;
   	
   	//height of the object's image file
   	private int height;
   	
   	//image files of the entity
   	private Image image;
   	
   	//explosion image of the entity
    private Image explosion;
    
    //determines whether or not the entity will be drawn
   	private boolean visible;
   	
   	//determines whether or not the entity has exploded
	private boolean isExploded = false;
	
	//standared move function
   	public abstract void move();
	  
   	//default constructors
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
   	
   	//returns a Rectangle that is used in collision detection by accessing the Rectangle's
   	//intersect function to determine if the the rectangle boundaries of two entitys intersect
    public Rectangle getBound(){
    	
    	//get the current x and y coordinates of the entity
    	int x = (int)location.getX();
    	int y = (int)location.getY();
    	
    	//if the entity hasn't exploded, return a rectangle using the width and height
    	//variables
    	if(isExploded == false)
    		return new Rectangle(x, y, width, height);
    	else
    		return new Rectangle(x,y, 0,0);
    }
    
    //set the location
    public void setLocation(int X, int Y){
    	location = new Point(X,Y);
    }
    
    //get the entity's current location
    public Point getLocation(){
    	return location;
    }
    
    //get the entity's x displacement
    public int getDX(){
    	return dx;
    }
    
    //set the entity's x displacement
    public void setDX(int DX){
    	dx = DX;
    }
    
    //get the entity's y-displacement
    public int getDY(){
    	return dy;
    }
    
  //set the entity's y-displacement
    public void setDY(int DY){
    	dy = DY;
    }
    
    //set the entity's width
    public void setWidth(int w){
    	width = w;
    }
    
    //get the entity's width
    public int getWidth(){
    	return width;
    }
    
    //set the entity's height
    public void setHeight(int l){
    	height = l;
    }
    
    //get the entity's height
    public int getHeight(){
    	return height;
    }
    
    //draw the entity based on its current location
    public void draw(Graphics2D g2d, ImageObserver i)
	{
      	int x = (int)location.getX();
    	int y = (int)location.getY();
		g2d.drawImage(getImage(), x, y, i);
	}
	
    //return whether or not the entity is visible
   	public boolean isVisible(){
   		return visible;
   	}
   	
   	//set the entity's visibility
	public void setVisible(boolean a){
   		visible = a;
   	}
	
	//set the image of the entity using a string reference
	public void setImage(String ref){
	    ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
	    image = ii.getImage();
	}

	//set the entity's explosion image using a string reference
	public void setExplosion(String ref){
	    ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
	    explosion = ii.getImage();
	}
	
	//get the entity's explosion image
	public Image getExplosion(){
		return explosion;
	}
	
	//set the objects image to the explosion image
	//and set the isExploded boolean variable to true
	public void explode(){
		image = explosion;
		isExploded = true;
	}
	
	//return whether or not the entity has exploded
	public boolean isExploded(){
		return isExploded;
	}
	
	//get the entity's current image file
	public Image getImage() {
		return image;
	}

	

}

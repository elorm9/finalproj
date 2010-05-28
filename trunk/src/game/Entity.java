package game;

import java.awt.Image;
import java.awt.Rectangle;


public interface Entity {

	  public int getX();

	  public int getY();
	  
	  public void move();
	  
	  public Image getImage();
	  
	  public void setVisible(boolean a);
	  
	  public Rectangle getBound();
	  
	  public boolean isVisible();

}

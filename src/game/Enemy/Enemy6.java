package game.Enemy;

import javax.swing.ImageIcon;

public class Enemy6 extends Enemy{
	private String ref = "Planes/Enemy6.png";
    
    
    
    public Enemy6()
    {
    	super();
    }
    
    public Enemy6(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setVisible(true);
        
    	setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    



}

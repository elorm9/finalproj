package game.Enemy;

import javax.swing.ImageIcon;

public class Enemy5 extends Enemy{
	private String ref = "Planes/Enemy5.png";
    
    private int dx = 1;
    private int dy = 1;
    
    
    public Enemy5()
    {
    	super();
    }
    
    public Enemy5(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        
    	setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    



}
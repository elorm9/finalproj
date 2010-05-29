package game.Enemy;

import javax.swing.ImageIcon;

public class Enemy2 extends Enemy{
	private String ref = "Planes/Enemy2.png";

    
    
    public Enemy2()
    {
    	super();
    }
    
    public Enemy2(int x, int y) {
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
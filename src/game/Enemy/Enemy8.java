package game.Enemy;

import javax.swing.ImageIcon;

public class Enemy8 extends Enemy{
	private String ref = "Planes/Enemy8.png";
   

    public Enemy8()
    {
    	super();
    }
    
    public Enemy8(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        
    	setHP(20);
    	setVisible(true);
    	
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        setExplosion(getRef());
    }
   
	



}

package game.Enemy;

import game.Weapons.EnemyMissile;
import game.Weapons.Missile;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy4 extends Enemy{
	private String ref = "Planes/Enemy4.png";
    private ArrayList <Missile> missiles = new ArrayList<Missile>();
    
    private final int CRAFT_SIZE = 20;
    
    
    
    public Enemy4()
    {
    	super();
    }
    
    public Enemy4(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    
    
}

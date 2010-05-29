package game.Enemy;
import game.Weapons.EnemyMissile;
import game.Weapons.Missile;

import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Enemy1 extends Enemy{

	private String ref = "Planes/Enemy1.png";
    
    
    
    public Enemy1()
    {
    	super();
    }
    
    public Enemy1(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    




	


}

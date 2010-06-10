package game.Enemy;

import game.Weapons.EnemyBullet1;
import game.Weapons.Missile;

import java.util.ArrayList;



public class Enemy5 extends Enemy{
	private String ref = "Planes/Enemy5.png";
    
    public Enemy5()
    {
    	super();
    }
    
    public Enemy5(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setVisible(true);
        
    	setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        setExplosion(getRef());
    }
    
    //this enemy fires 3 bullets at once
	public void fireRedBullet() {
		int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	getMissiles().add(new EnemyBullet1(x - getSize(), y + getSize()/2 + 20, 6, 1));
    	getMissiles().add(new EnemyBullet1(x - getSize(), y + getSize()/2 + 20, 4, 1));
    	getMissiles().add(new EnemyBullet1(x - getSize(), y + getSize()/2 + 20, 2, 1));
	}
	
	public void attack(){
		ArrayList<Missile> missiles = getMissiles();

		int x = (int)getLocation().getX();
		if(x >= 300)
			if(missiles.size()<1)
				fireRedBullet();

	}
    

}
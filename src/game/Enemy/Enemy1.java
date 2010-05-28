package game.Enemy;
import game.Weapons.EnemyMissile;
import game.Weapons.Missile;

import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Enemy1 extends Enemy{

	private String ref = "Planes/Enemy1.png";
    
    private int dx = 1;
    private int dy = 1;
    
    
    public Enemy1()
    {
    	super();
    }
    
    public Enemy1(int x, int y) {
    	super(x,y);
    	
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
        
        width = image.getWidth(null)-20;
        height = image.getHeight(null);
        
    }
    

	public void move() {
	
		if( !movedX){
			if( x > 300)
				x -= dx;
		}
		
		if( x <= 300 )
			setMoved();
		
		if( movedX ){
			x+= dx;
		}
		
		if(x >= 700)
			setMoved();
		
		
	}

	private void setMoved()
	{
		if(movedX == false)
			movedX = true;
		else
			movedX = false;
	}



	


}

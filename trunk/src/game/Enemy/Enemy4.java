package game.Enemy;

import game.Weapons.EnemyMissile;
import game.Weapons.Missile;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy4 extends Enemy{
	private String ref = "Planes/Enemy4.png";
    private ArrayList <Missile> missiles = new ArrayList<Missile>();
    
    private final int CRAFT_SIZE = 20;
    
    private int dx = 1;
    private int dy = 1;
    
    
    public Enemy4()
    {
    	super();
    }
    
    public Enemy4(int x, int y) {
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

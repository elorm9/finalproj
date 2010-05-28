package game.Weapons;

import javax.swing.ImageIcon;


public class RedMissle extends Missile{

	
	    private final int BOARD_WIDTH = 800;
	    private final int MISSILE_SPEED = 3;
	    
	    private int damage = 4;

	    public RedMissle()
	    {
	    	super();
	    }
	    
	    public RedMissle(int x, int y) {

	    	super(x,y);
	        ImageIcon ii = new ImageIcon(this.getClass().getResource("Bullets/missile.png"));
	        image = ii.getImage();
	  
	        width = image.getWidth(null)-66;
	        height = image.getHeight(null);
	        visible = true;
	    }

	    public void move() {
	        setSpeed(MISSILE_SPEED);
	        if (getX() > BOARD_WIDTH)
	            visible = false;
	    }

		public int getDamage() {
			return damage;
		}

	}
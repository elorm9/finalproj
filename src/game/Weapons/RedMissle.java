package game.Weapons;



public class RedMissle extends Missile{

		String ref = "Bullets/missile.png";

	    public RedMissle()
	    {
	    	super();
	    }
	    
	    public RedMissle(int x, int y) {

	    	super(x,y);
	     	setImage(ref);
	     	  
	    	setWidth(getImage().getWidth(null)-23);
	        setHeight(getImage().getHeight(null));
	        
	        setDX(3);
	        setDamage(4);
	        
	        setVisible(true);
	    }


	}
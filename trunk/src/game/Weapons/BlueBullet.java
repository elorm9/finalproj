package game.Weapons;



public class BlueBullet extends Missile{
	

	private String ref = "Bullets/12px-blue-arrow.png";
    
    
    public BlueBullet()
    {
    	super();
    }
    
    public BlueBullet(int x, int y) {

    	super(x,y);
    	setImage(ref);
    	
    	setSpeed(3);
    	setDamage(5);
    	
    	setWidth(getImage().getWidth(null)-23);
        setHeight(getImage().getHeight(null));
        
        setVisible(true);
    }
    
}


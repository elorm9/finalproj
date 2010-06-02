package game.Weapons;

public class GreenLaser extends Missile{

	private String ref = "Bullets/12px-long-green.png";

 

    public GreenLaser()
    {
    	super();
    }
    
    public GreenLaser(int x, int y) {

    	super(x,y);
    	setImage(ref);
    	  
    	setWidth(getImage().getWidth(null)-23);
        setHeight(getImage().getHeight(null));
        
        setDamage(7);
        setSpeed(4);
        
        setVisible(true);

    }




    
}

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
    	  
    	setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        
        setDamage(7);
        setDX(4);
        
        setVisible(true);

    }




    
}

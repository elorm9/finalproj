package game.Weapons;




public class RedBullet extends Missile{

	private String ref = "Bullets/12px-red-comet.png";
	
    
    public RedBullet()
    {
    	super();
    }
    
    public RedBullet(int x, int y) {

    	super(x,y);
    	setImage(ref);
    	  
    	setWidth(getImage().getWidth(null)-23);
        setHeight(getImage().getHeight(null));
        
        setDamage(3);
        setDX(3);
        setVisible(true);
    }




}

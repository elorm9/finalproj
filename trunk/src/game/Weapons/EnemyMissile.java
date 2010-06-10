package game.Weapons;


public class EnemyMissile extends Missile{

private String ref = "EnemyBullets/missileFlipped.png";
	
    private final int BOARD_WIDTH = -100;
    
    

    public EnemyMissile()
    {
    	super();
    }
    
    public EnemyMissile(int x, int y) {

    	super(x,y);
    	setImage(ref);
  
    	setWidth(getImage().getWidth(null)-23);
        setHeight(getImage().getHeight(null));
        
        setDX(2);
        setDamage(5);
        
        setVisible(true);
    }



    public void move() {
    	getLocation().translate(-getDX(), 0);
        if (getLocation().getX() <= BOARD_WIDTH)
            setVisible(false);
    }


    
    

}

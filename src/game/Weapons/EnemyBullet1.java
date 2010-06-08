package game.Weapons;

public class EnemyBullet1 extends Missile{

	final int BOARD_WIDTH = -1;
	
	private String ref = "EnemyBullets/EnemyMissile2.png";
	
    public EnemyBullet1()
    {
    	super();
    }
    
    public EnemyBullet1(int x, int y) {

    	super(x,y);
    	setImage(ref);
  
    	setWidth(getImage().getWidth(null)-23);
        setHeight(getImage().getHeight(null));
        
        setSpeed(2);
        setDamage(5);
        
        setVisible(true);
    }
    
    public EnemyBullet1(int x, int y, int DX, int DY){
    	super(x,y);
    	
    	setDX(DX);
    	setDY(DY);
    	
    	setImage(ref);
    	  
    	setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
        
        setSpeed(2);
        setDamage(5);
        
        setVisible(true);
    }



    public void move() {
    	getLocation().translate(-getDX(), getDY());
        if (getLocation().getX() <= BOARD_WIDTH)
            setVisible(false);
    }
    
}

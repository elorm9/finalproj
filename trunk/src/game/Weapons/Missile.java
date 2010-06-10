package game.Weapons;


import game.Entity;


//standard missile class
public abstract class Missile extends Entity{

	//used to determine when the missiles has passed the x-coordinate of 800
	private final int BOARD_WIDTH = 800;
	
	//amount of damage that the missile delivers
    private int damage;
    
    
    public Missile()
    {
    	super();
    }
    
    public Missile(int x, int y) {
    
    	setImage("Bullets/missile.png");
    	
        setVisible(true);
        setLocation(x,y);
        
        damage = 2;
    }
    
    //update the missile's position
    public void move() {
    	getLocation().translate(getDX(), 0);
        if (getLocation().getX() > BOARD_WIDTH)
           setVisible(false);
    }
    
    
    //get the damage of the missile
    public int getDamage(){
    	return damage;
    }
    
    //set the damage of the missile
    public void setDamage(int d){
    	damage = d;
    }
    
}

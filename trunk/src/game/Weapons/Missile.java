package game.Weapons;


import game.Entity;



public abstract class Missile extends Entity{

	private final int BOARD_WIDTH = 800;
	
    private int damage;
    private int speed;
    
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
    
    public void move() {
    	getLocation().translate(speed, 0);
        if (getLocation().getX() > BOARD_WIDTH)
           setVisible(false);
    }
    
    
    public void setSpeed(int s)
    {
    	speed = s;
    }
    
    public int getSpeed(){
    	return speed;
    }
    
    public int getDamage(){
    	return damage;
    }
    
    public void setDamage(int d){
    	damage = d;
    }
    
}

package game.Weapons;

import javax.swing.ImageIcon;

public class EnemyMissile extends Missile{

private String ref = "EnemyBullets/missileFlipped.png";
	
    private final int BOARD_WIDTH = -1;
    private final int MISSILE_SPEED = 3;
    
    private int damage = 5;
    

    public EnemyMissile()
    {
    	super();
    }
    
    public EnemyMissile(int x, int y) {

    	super(x,y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
  
        width = image.getWidth(null);
        height = image.getHeight(null);
        
        visible = true;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
    	setSpeed(-MISSILE_SPEED);
        if (getX() <= BOARD_WIDTH)
            visible = false;
    }

	public int getDamage() {
		return damage;
	}
    
    

}

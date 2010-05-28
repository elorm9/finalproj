package game.Weapons;

import javax.swing.ImageIcon;


public class RedBullet extends Missile{

	private String ref = "Bullets/12px-red-comet.png";
	
    private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 3;

    private final int damage = 3;
    
    public RedBullet()
    {
    	super();
    }
    
    public RedBullet(int x, int y) {

    	super(x,y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
  
        width = image.getWidth(null)-40;
        height = image.getHeight(null);
        
        visible = true;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
    	setSpeed(MISSILE_SPEED);
        if (getX() > BOARD_WIDTH)
            visible = false;
    }

	@Override
	public int getDamage() {
		return damage;
	}



}

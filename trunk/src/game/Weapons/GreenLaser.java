package game.Weapons;

import javax.swing.ImageIcon;

public class GreenLaser extends Missile{

	private String ref = "Bullets/12px-long-green.png";
    private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 4;
    
    private final int damage = 5;

    public GreenLaser()
    {
    	super();
    }
    
    public GreenLaser(int x, int y) {

    	super(x,y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
  
        width = image.getWidth(null)-50;
        height = image.getHeight(null);
        
        visible = true;
    }

    public void move() {
        setSpeed(MISSILE_SPEED);
        if (getX() > BOARD_WIDTH)
            visible = false;
    }

	public int getDamage() {
		return damage;
	}
    
}

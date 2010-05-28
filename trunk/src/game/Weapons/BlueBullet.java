package game.Weapons;

import javax.swing.ImageIcon;


public class BlueBullet extends Missile{
	

	private String ref = "Bullets/12px-blue-arrow.png";
    private final int BOARD_WIDTH = 800;
    private final int MISSILE_SPEED = 3;
    
    private int damage = 4;
    
    public BlueBullet()
    {
    	super();
    }
    
    public BlueBullet(int x, int y) {

    	super(x,y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
  
        width = image.getWidth(null)-23;
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


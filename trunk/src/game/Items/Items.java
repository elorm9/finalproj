package game.Items;

import game.Craft;
import game.Entity;

public abstract class Items extends Entity{

	private final int BOARD_WIDTH = -1;
	
	public Items(){
		super();
	}
	
	public Items(int x, int y){
		super(x,y);
	}
	
	public void move() {
		
		getLocation().translate(-1, 0);
        if (getLocation().getX() <= BOARD_WIDTH)
            setVisible(false);
	}
	

	public void collidesWith(Craft a){
		if( getBound().intersects(a.getBound()))
			effect(a);
	}
	
	public abstract void effect(Craft a);

}

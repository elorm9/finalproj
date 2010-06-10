package game.Items;

import game.Craft;
import game.Entity;

public abstract class Items extends Entity{

	private final int BOARD_WIDTH = -1;
	
	public Items(){
		super();
	}
	
	//set the item in the specified x and y coordinates
	public Items(int x, int y){
		super(x,y);
	}
	
	//update the item's position
	public void move() {
		
		getLocation().translate(-1, 0);
        if (getLocation().getX() <= BOARD_WIDTH)
            setVisible(false);
	}
	
	//checks for collisions with the user's craft
	public void collidesWith(Craft a){
		if( getBound().intersects(a.getBound())){
			effect(a);
			setVisible(false);
		}
	}
	
	//the effect function allows the item
	//to give bonuses (extra HP, ammo etc)
	//to the user craft
	public abstract void effect(Craft a);

}

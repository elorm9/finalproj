package game.Items;

import game.Craft;

//this item appears as a red orb
//it increases the user's number of missiles
public class Item_Missile extends Items{

	private String ref = "12px-purple-round.png";
	public Item_Missile(){
		super();
	}
	
	public Item_Missile(int x, int y){
		super(x,y);
		
		setImage(ref);
		setVisible(true);
		setWidth(getImage().getWidth(null));
		setHeight(getImage().getHeight(null));
	}
	
	public void effect(Craft a) {

		a.addMissiles(3);
		
	}

}

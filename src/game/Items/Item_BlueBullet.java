package game.Items;

import game.Craft;

//this item appears as a blue orb, it increases the user's number of blue bullets
public class Item_BlueBullet extends Items{

	private String ref = "12px-blue-round.png";
	
	public Item_BlueBullet(){
		super();
	}
	
	public Item_BlueBullet(int x, int y){
		super(x,y);
		setImage(ref);
		setVisible(true);
		setWidth(getImage().getWidth(null));
		setHeight(getImage().getHeight(null));
	}
	
	public void effect(Craft a) {
		a.addBlueBullets(20);
	}

}

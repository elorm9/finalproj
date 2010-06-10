package game.Items;

import game.Craft;

//this item appears as a green orb, it increases the user's number of green bullets
public class Item_GreenLaser extends Items{

	private String ref = "12px-green-round.png";
	
	public Item_GreenLaser(){
		super();
	}
	
	public Item_GreenLaser(int x, int y)
	{
		super(x,y);
		setImage(ref);
		setVisible(true);
		setWidth(getImage().getWidth(null));
		setHeight(getImage().getHeight(null));
		
	}
	
	public void effect(Craft a) {
		a.addGreenBullets(5);
	}

}

package game.Items;

import game.Craft;

public class Item_HP extends Items{

	String ref = "40px-electric.png";
	
	public Item_HP(){
		super();
	}
	
	public Item_HP(int x, int y)
	{
		super(x,y);
		setImage(ref);
		
		setWidth(getImage().getWidth(null));
		setHeight(getImage().getHeight(null));
		setVisible(true);
	}
	
	public void effect(Craft a) {
		a.setHP(a.getHP()+20);
	}

}

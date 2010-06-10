package game.Collectors;

import game.Craft;
import game.Enemy.Enemy;
import game.Items.Item_BlueBullet;
import game.Items.Item_GreenLaser;
import game.Items.Item_HP;
import game.Items.Item_Missile;
import game.Items.Items;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

//handles the items that are dropped by enemies
public class ItemCollector {

	//arraylist of items
	private ArrayList<Items> items;

	
	//default constructor which initailizes the
	//item arraylist
	public ItemCollector(){
		items = new ArrayList<Items>();
	}
	
	//adds an item to the arraylist of items
	public void addItem(Items a)
	{
		items.add(a);
	}
	
	//adds a random item into the arraylist of items
	public void addRandomItem(Enemy b){
		int chance = 0;
		int x = (int)b.getLocation().getX();
		int y = (int)b.getLocation().getY();
		
		chance = (int) (Math.random()*4);
		
		if(chance == 0)
			addItem(new Item_HP(x,y));
		else
			if(chance == 1)
				addItem(new Item_GreenLaser(x,y));
			else
				if(chance == 2)
					addItem(new Item_BlueBullet(x,y));
				else
					if(chance == 3)
						addItem(new Item_Missile(x,y));
	}
	
	//returns the arraylits of items
	public ArrayList<Items> getItems(){
		return items;
	}
	
	//moves each item on the board
	public void moveItems(){
		for(Items a: items){
			a.move();
		}
	}
	
	//checks item collisions with the user's craft
	public void checkCollisions(Craft a){
		for(Items b: items){
			b.collidesWith(a);
		}
	}
	
	//draws each item of the item arraylist
	public void drawItems(Graphics2D g2d, ImageObserver j){
		int x = 0;
		int y = 0;
		
		for(Items a: items){
			x = (int)a.getLocation().getX();
    		y = (int)a.getLocation().getY();
			g2d.drawImage(a.getImage(),x, y, j);
		}
	}
	
	//checks each item's visibility and them accordingly
	public void removeItems(){
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).isVisible() == false)
				items.remove(i);
		}
	}
	
}

package game.Items;

import game.Craft;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class ItemCollector {

	private ArrayList<Items> items;
	
	public ItemCollector(){
		items = new ArrayList<Items>();
	}
	
	public void addItem(Items a)
	{
		items.add(a);
	}
	
	public ArrayList<Items> getItems(){
		return items;
	}
	
	public void moveItems(){
		for(Items a: items){
			a.move();
		}
	}
	
	public void checkCollisions(Craft a){
		for(Items b: items){
			b.collidesWith(a);
		}
	}
	
	public void drawItems(Graphics2D g2d, ImageObserver j){
		int x;
		int y;
		
		for(Items a: items){
			x = (int)a.getLocation().getX();
    		y = (int)a.getLocation().getY();
			g2d.drawImage(a.getImage(),x, y, j);
		}
	}
	public void removeItems(){
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).isVisible() == false)
				items.remove(i);
		}
	}
	
}

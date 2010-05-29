package game.Items;

import game.Airplane;
import game.Craft;
import game.Enemy.Enemy;

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
			/*if(b.getBound().intersects(a.getBound()))
				b.effect(a);
				b.setVisible(false);
				*/
		}
	}
	
	public void drawItems(Graphics2D g2d, ImageObserver j){
		int x = 0;
		int y = 0;
		
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

package game;


import game.Enemy.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import game.Weapons.*;
public class Enemies {

	//holds all the enemies
	
	private Enemy a;
	private ArrayList<Enemy> enemies;
	
	public Enemies()
	{
		enemies = new ArrayList<Enemy>();
		createEnemies();
	}
	
	//create enemies
	public void createEnemies()
	{
		int x;
		int y;
		
		for(int j = 0; j <= 1; j ++)
		{
			x = (int) (Math.random()*400)+300;
			y =  (int) (Math.random()*300);
			if( j == 0)
				a = new Enemy1(x,y);
			
			if( j == 1)
				a = new Enemy2(x,y);
			
			if( j == 2)
				a = new Enemy3(x,y);
			
			if( j == 3)
				a = new Enemy4(x,y);
			
			if( j == 4)
				a = new Enemy5(x,y);
			
			if( j == 5)
				a = new Enemy6(x, y);
			
			if( j == 6)
				a = new Enemy7(x,y);
			
			if( j == 7)
				a = new Enemy8(x,y);
			
			
			enemies.add(a);
		}
	}
	
	
	public void drawEnemies(Graphics2D g2d, ImageObserver j)
	{
		int x;
		int y;
		 if( enemies.size() > 0 ){
	        	for(Enemy a: enemies)
	        	{
	        		x = (int)a.getLocation().getX();
	        		y = (int)a.getLocation().getY();
	        		
	        		g2d.drawImage(a.getImage(), x, y, j);
	        		
	        	}
	        }
	        else
	        {
	        	createEnemies(); 
	        }
	}
	
	
	private int countMissiles()
	{
		int i = 0;
		for(Enemy a: enemies)
			i += a.getMissiles().size();
		
		return i;
	}
	
	public void drawEnemyMissiles(Graphics2D g2d, ImageObserver j)
	{
		if( countMissiles() > 0)
		{
			for(Enemy a: enemies)
			{
				a.drawMissiles(g2d, j);
			}
		}
	}
	
	public void missileAction(Craft a)
	{
		for(Enemy b: enemies)
			b.missileAction(a);
	}
	
	public void move()
	{
		for(Enemy a: enemies)
			a.move();
	}
	
	public void attack()
	{
		for(Enemy a: enemies)
			a.attack();
	}
	
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	public void drawHP(Graphics g)
	{
		for(Enemy a : enemies)
			a.drawHP(g);
	}
	
	public void removeEnemies(){
		for(int i = 0; i < enemies.size(); i++)
		{
			if(enemies.get(i).getHP() <= 0)
				enemies.remove(i);
		}
	}

	
	
}

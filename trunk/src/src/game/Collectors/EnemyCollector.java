package game.Collectors;

import game.Craft;
import game.Enemy.Enemy;
import game.Enemy.Enemy1;
import game.Enemy.Enemy2;
import game.Enemy.Enemy3;
import game.Enemy.Enemy4;
import game.Enemy.Enemy5;
import game.Enemy.Enemy6;
import game.Enemy.Enemy7;
import game.Enemy.Enemy8;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class EnemyCollector {

	//holds all the enemies
	
	//arraylist of all the enemies
	private ArrayList<Enemy> enemies;
	
	//number of enemies to create
	private int numEnemies;
	
	//default constructor
	public EnemyCollector()
	{
		enemies = new ArrayList<Enemy>();
		addEnemy();
	}
	
	//construct a new object with a set number of enemies to create
	public EnemyCollector(int numEnemies)
	{
		enemies = new ArrayList<Enemy>();
		this.numEnemies = numEnemies;
		addEnemy();
	}
	
	//add a random enemy into the arraylist
	public void addEnemy(){
		
		int x = 800;
		int y =  (int) (Math.random()*300);
		
		Enemy a = null;
		int j = (int) (Math.random()*6);
		
		
		if(numEnemies > 0){
		//x = (int) (Math.random()*400)+300;
			if( j == 0)
				a = new Enemy1(x,y);
			
			if( j == 1)
				a = new Enemy2(x,y);
			
			if( j == 2)
				a = new Enemy3(x,y);
			
			if( j == 3)
				a = new Enemy4(x,y);
			
			if( j == 4)
				a = new Enemy5(x,1);
			
			if( j == 5)
				a = new Enemy6(x, 100);
			
			if( j == 6)
				a = new Enemy7(x,100);
			
			if( j == 7)
				a = new Enemy8(x,100);
			
			numEnemies--;
			enemies.add(a);
		}
		
		
		
	}
	
	/*
	//create enemies
	public void createEnemies()
	{
		Enemy a = null;
		int x = 800;
		int y;
		
		for(int j = 0; j <= 4; j ++)
		{
			//x = (int) (Math.random()*400)+300;
			
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
				a = new Enemy5(x,1);
			
			if( j == 5)
				a = new Enemy6(x, 100);
			
			if( j == 6)
				a = new Enemy7(x,100);
			
			if( j == 7)
				a = new Enemy8(x,100);
			
			
			enemies.add(a);
		}
	}
	*/
	
	//basic draw function
	public void draw(Graphics2D g2d, ImageObserver j){
		drawEnemies(g2d,j);
		drawHP(g2d);
		drawEnemyMissiles(g2d, j);
	}
	
	//draw all enemies
	private void drawEnemies(Graphics2D g2d, ImageObserver j)
	{
		//if enemies are present then draw them all
		 if( enemies.size() > 0 ){
	        	for(Enemy a: enemies)
	        	{
	        		a.draw(g2d, j);
	        	}
	        }
	        else
	        {
	        	//otherwise, create a new enemy if possible
	        	if(numEnemies >0)
	        		addEnemy(); 
	        }
	}
	
	//draw the HP of all the enemies
	private void drawHP(Graphics g)
	{
		for(Enemy a : enemies)
			a.drawHP(g);
	}
	
	//draw all the missiles of the enemies
	private void drawEnemyMissiles(Graphics2D g2d, ImageObserver j)
	{
		if( countMissiles() > 0)
		{
			for(Enemy a: enemies)
			{
				a.drawMissiles(g2d, j);
			}
		}
	}
	
	//sum the number of missiles of each enemy
	private int countMissiles()
	{
		int i = 0;
		for(Enemy a: enemies)
			i += a.getMissiles().size();
		
		return i;
	}
	

	//move the enemy missiles and handle their collisions with the user's airplane
	public void missileAction(Craft a)
	{
		for(Enemy b: enemies)
			b.missileAction(a);
	}
	
	//move all the enemies
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
	
	//get the arraylist of enemies
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	//if any enemies have no more HP left then invoke the explode function
	public void explode(){
		for(Enemy a: enemies){
			if(a.getHP() <= 0)
				a.explode();
		}
	}
	
	
	public void removeEnemies(ItemCollector a){
	
		for(int i = 0; i < enemies.size(); i++)
		{
			if(enemies.get(i).getHP() <= 0){
				enemies.get(i).dropItem(a);
				enemies.remove(i);
			}
			else
				if(enemies.get(i).isVisible() == false){
					enemies.get(i).dropItem(a);
					enemies.remove(i);
				}
		}
	}

	public void setNumEnemies(int numEnemies) {
		this.numEnemies = numEnemies;
	}

	public int getNumEnemies() {
		return numEnemies;
	}

	
	
}
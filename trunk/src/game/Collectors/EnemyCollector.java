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

//an enemy collector holds an arraylist of enemies 
//and handles them accordingly

public class EnemyCollector {

	//arraylist of enemies
	private ArrayList<Enemy> enemies;
	
	//determines how many enemies to create
	private int numEnemies;
	
	//default constructor
	public EnemyCollector()
	{
		//initialize the arraylist
		enemies = new ArrayList<Enemy>();
	}
	
	public EnemyCollector(int numEnemies)
	{
		enemies = new ArrayList<Enemy>();
		this.numEnemies = numEnemies;
		addEnemy();
	}
	
	//add a random enemy into the list
	public void addEnemy(){
		
		//x and y coordinate for where enemies start
		int x = 800;
		
		//y coordinate is generated randomly
		int y =  (int) (Math.random()*300);
		
		Enemy a = null;
		
		//j is used to determine which enemy to create
		int j = (int) (Math.random()*6);
		
		//creates an enemy based on the value of j
		if(numEnemies > 0){
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
	
	//main draw function
	public void draw(Graphics2D g2d, ImageObserver j){
		drawEnemies(g2d,j);
		drawHP(g2d);
		drawEnemyMissiles(g2d, j);
	}
	
	//draw all  enemies on the screen
	private void drawEnemies(Graphics2D g2d, ImageObserver j)
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
	        	addEnemy(); 
	        }
	}
	
	//draw the HP bar of each enemy
	private void drawHP(Graphics g)
	{
		for(Enemy a : enemies)
			a.drawHP(g);
	}
	
	//draw all enemy missiles
	private void drawEnemyMissiles(Graphics2D g2d, ImageObserver j)
	{
		//if there are enemy missiles then draw them
		if( countMissiles() > 0)
		{
			for(Enemy a: enemies)
			{
				a.drawMissiles(g2d, j);
			}
		}
	}
	
	
	//count the number total number of enemy missiles
	private int countMissiles()
	{
		int i = 0;
		for(Enemy a: enemies)
			i += a.getMissiles().size();
		
		return i;
	}
	

	//handles enemy missile collisions with the user's craft
	public void missileAction(Craft a)
	{
		for(Enemy b: enemies)
			b.missileAction(a);
	}
	
	//updates the position of each enemy
	public void move()
	{
		for(Enemy a: enemies)
			a.move();
	}
	
	//causes each enemy to attack
	public void attack()
	{
		for(Enemy a: enemies)
			a.attack();
	}
	
	//return the arraylist of enemies
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	
	//initiates the explode function
	public void explode(){
		for(Enemy a: enemies){
			//if an enemy's hp is less than 1 then invoke the explode function
			if(a.getHP() <= 0)
				a.explode();
		}
	}
	
	//checks enemies to see if they are still visible
	//and removes them accordingly
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
	
	//sets the number of enemies
	public void setNumEnemies(int numEnemies) {
		this.numEnemies = numEnemies;
	}
	
	//gets the number of enemies
	public int getNumEnemies() {
		return numEnemies;
	}

	
	
}
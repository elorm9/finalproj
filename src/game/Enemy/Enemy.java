package game.Enemy;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import game.Airplane;
import game.Craft;
import game.Weapons.EnemyMissile;
import game.Weapons.Missile;


public abstract class Enemy extends Airplane{

	protected boolean movedX = false;
	protected boolean visible;
	
	protected final int CRAFT_SIZE = 20;
	protected boolean hasAttacked = true;
	
	protected final int ATTACK_DELAY = 200;
	public Enemy()
	{
		super();
		HP = 20;
	}
	
	public Enemy(int x, int y)
	{
		super(x,y);
		HP = 50;
	}
	
	@Override
	public void fireBlueBullet() {
		// TODO Auto-generated method stub
		
	}

	public void fireMissle() {
		missiles.add(new EnemyMissile(getX() - CRAFT_SIZE, getY() + CRAFT_SIZE/2 + 20));
		hasAttacked = false;
	}

	@Override
	public void fireRedBullet() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Missile> getMissiles() {
		return missiles;
	}

	public void move() {
		
		if( !movedX){
			if( x > 300)
				x -= dx;
		}
		
		if( x <= 300 )
			setMoved();
		
		if( movedX ){
			x+= dx;
		}
		
		if(x >= 700)
			setMoved();
	}
	
	private void setMoved()
	{
		if(movedX == false)
			movedX = true;
		else
			movedX = false;
	}
	
	public void missileAction(Craft a)
	{
		attack();
		//for each missle in the missle arraylist
	    for (int i = 0; i < missiles.size(); i++) {
	    	
	    	Missile m =  missiles.get(i);  
	    	
	        //if the missile is visible, the continue moving it
	    	
	        if (m.isVisible() == true)
	        {
	        	Rectangle craftBound = a.getBound();
	        	
	        	if(m.getBound().intersects(craftBound)){
        			a.takeDamage(m.getDamage());
            		m.setVisible(false);
            		missiles.remove(i);
            		
	        	}
	        	m.move();
	        
	            	
	        }
	        //else delete it from the arraylist
	        else missiles.remove(i);
	    }
	}

	public void drawHP(Graphics hp)
	{
	    Color green = new Color(0,255,0);
	    hp.setColor(green);
	    	
	    hp.fillRect(x+30, y-3, HP, 5);
	}	
	
	public void attack(){
		
		if(missiles.size()<1)
			fireMissle();
		/*
		Thread t;
		
		t = new Thread(new Runnable(){
			
			public void run() {
				try{
					while(getMissiles().size() <1)
						fireMissle();
				}catch (Exception e){}
			}
		});
		
		t.start();
		*/
	}
	

}

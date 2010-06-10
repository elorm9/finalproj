package game.Enemy;

public class Enemy3 extends Enemy{
	private String ref = "Planes/Enemy3.png";
    
	//used in the move function
	//helps to determine when to move up or down
	private boolean moveUp = true;
	private boolean movedX;
    public Enemy3()
    {
    	super();
    }
    
    public Enemy3(int x, int y) {
  	super(x,y);
    	
    	setImage(ref);
        
    	setHP(20);
    	setVisible(true);
    	
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        
        setDX(1);
        setDY(1);
        setExplosion(getRef());
    }
    
    //this enemy moves in a zigzag motion
	public void move() {
		
		int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	
    	if(isExploded() == false){
    		//getLocation().translate(-1, 1);
    		if(moveUp == true){
    			getLocation().translate(-1, -1);
    		
    			if(y <= 50)
    				moveUp = false;
    		}
    	
    		else
    		{
    			getLocation().translate(-1, 1);
    			if(y >= 300)
    				moveUp = true;
    		}

	    	
			if(!movedX)
	    		if( x <= -40)
	    			setVisible(false);
    		}
    	else
    		super.move();
	}
		


}

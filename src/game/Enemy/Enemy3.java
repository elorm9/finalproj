package game.Enemy;

public class Enemy3 extends Enemy{
	private String ref = "Planes/Enemy3.png";
    
	private boolean moveUp = true;
	
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
    }
    
	public void move() {
		
		int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	
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
		


}

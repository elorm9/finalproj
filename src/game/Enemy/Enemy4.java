package game.Enemy;



public class Enemy4 extends Enemy{
	private String ref = "Planes/Enemy4.png";
    

    private boolean moveDown = true;
    private boolean movedX = true;
    
    public Enemy4()
    {
    	super();
    }
    
    public Enemy4(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setVisible(true);
        
        setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        setExplosion(getRef());
    }
    
public void move() {
		
		int x = (int)getLocation().getX();
    	int y = (int)getLocation().getY();
    	
    	
    	//getLocation().translate(-1, 1);
    	if(isExploded() == false){
    		if(moveDown == true){
    			getLocation().translate(-1, 1);
    		
    			if(y >= 300)
    				moveDown = false;
    		}	
    	
    		else
    		{
    			getLocation().translate(-1, -1);
    			if(y <= 50)
    				moveDown = true;
    		}

    	
    		if(!movedX)
    		
    			if( x <= -40)
    				setVisible(false);
    	}
    	else
    		super.move();
	}
    
    
}

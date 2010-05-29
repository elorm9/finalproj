package game.Enemy;

public class Enemy3 extends Enemy{
	private String ref = "Planes/Enemy3.png";
    
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
    


}

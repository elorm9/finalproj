package game.Enemy;



public class Enemy5 extends Enemy{
	private String ref = "Planes/Enemy5.png";
    
    public Enemy5()
    {
    	super();
    }
    
    public Enemy5(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setVisible(true);
        
    	setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    



}
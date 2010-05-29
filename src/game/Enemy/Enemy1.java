package game.Enemy;

public class Enemy1 extends Enemy{

	private String ref = "Planes/Enemy1.png";
    
    
    public Enemy1()
    {
    	super();
    }
    
    public Enemy1(int x, int y) {
    	super(x,y);
    	
    	setVisible(true);
    	setImage(ref);
        setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    




	


}

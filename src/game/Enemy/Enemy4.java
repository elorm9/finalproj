package game.Enemy;



public class Enemy4 extends Enemy{
	private String ref = "Planes/Enemy4.png";
    

    

    public Enemy4()
    {
    	super();
    }
    
    public Enemy4(int x, int y) {
    	super(x,y);
    	
    	setImage(ref);
        setVisible(true);
        
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        setDX(1);
        setDY(1);
        
    }
    
    
}

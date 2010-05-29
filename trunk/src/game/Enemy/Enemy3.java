package game.Enemy;



import javax.swing.ImageIcon;

public class Enemy3 extends Enemy{
	private String ref = "Planes/Enemy3.png";
    
    private final int CRAFT_SIZE = 20;
    

    
    
    public Enemy3()
    {
    	super();
    }
    
    public Enemy3(int x, int y) {
  	super(x,y);
    	
    	setImage(ref);
        
    	setHP(20);
        setWidth(getImage().getWidth(null)-20);
        setHeight(getImage().getHeight(null));
        
        setDX(1);
        setDY(1);
    }
    


}

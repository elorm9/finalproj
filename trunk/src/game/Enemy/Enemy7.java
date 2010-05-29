package game.Enemy;




import javax.swing.ImageIcon;

public class Enemy7 extends Enemy{

	private String ref = "Planes/Enemy7.png";
    
    
    
    public Enemy7()
    {
    	super();
    }
    
    public Enemy7(int x, int y) {
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

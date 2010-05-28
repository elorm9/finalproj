package game.Enemy;



import javax.swing.ImageIcon;

public class Enemy3 extends Enemy{
	private String ref = "Planes/Enemy3.png";
    
    private final int CRAFT_SIZE = 20;
    
    private int dx = 1;
    private int dy = 1;
    
    
    public Enemy3()
    {
    	super();
    }
    
    public Enemy3(int x, int y) {
    	super(x,y);
    	
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(ref));
        image = ii.getImage();
        
        width = image.getWidth(null)-20;
        height = image.getHeight(null);
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

}

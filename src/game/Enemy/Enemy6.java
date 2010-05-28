package game.Enemy;

import javax.swing.ImageIcon;

public class Enemy6 extends Enemy{
	private String ref = "Planes/Enemy6.png";
    
    private int dx = 1;
    private int dy = 1;
    
    
    public Enemy6()
    {
    	super();
    }
    
    public Enemy6(int x, int y) {
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

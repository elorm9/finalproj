package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//this class is used to draw the background image
//it helps to have another jpanel draw the background since
//the background image only needs to be drawn once
//throughout the whole program
public class Background extends JPanel{
	private Image background;
	
	//this sets the background image 
	//by obtaining it from the specified url
	public Background(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Background1.png"));
        background = ii.getImage();
	}
	
	//the paint function of this class draws the background image on the screen
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		drawBackground(g2d, this);
	}
	
	//draw the background
	private void drawBackground(final Graphics2D g2d, final ImageObserver i)
    {
    	g2d.drawImage(background, 0, 0, i);
    }
}



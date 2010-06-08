package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel{
	private Image background;
	
	public Background(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("Background1.png"));
        background = ii.getImage();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		drawBackground(g2d, this);
	}
	
	private void drawBackground(final Graphics2D g2d, final ImageObserver i)
    {
    	g2d.drawImage(background, 0, 0, i);
    }
}



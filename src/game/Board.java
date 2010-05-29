package game;

import game.Collectors.EnemyCollector;
import game.Collectors.ItemCollector;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Timer timer2;
	
	private Craft craft;
    private ItemCollector drops;
    private EnemyCollector opponents;
    
    private Image background;

    
    public Board() {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource("Background1.png"));
        background = ii.getImage();
         
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);


        //create a user plane
        craft = new Craft(40,60);
        opponents = new EnemyCollector(20);
        drops = new ItemCollector();
        
        //create a timer
        timer = new Timer(5, this);
        timer.start();
        
        timer2 = new Timer(1000, new ActionListener(){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				opponents.addEnemy();
				
			}
        	
        });
        
        timer2.start();
       
    }

    
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        
        drawGUI();
        //drawBackground(g2d, this);
        
        craft.draw(g2d, this);
        craft.drawHP(g);
        craft.drawMissiles(g2d, this);
        
        opponents.draw(g2d, this);

        drops.drawItems(g2d, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        
   
        //update the airplane's position
        craft.move();
        craft.missileAction(opponents.getEnemies());

        opponents.removeEnemies(drops);
        opponents.move();
        opponents.missileAction(craft);
        
        drops.removeItems();
        drops.moveItems();
        drops.checkCollisions(craft);
        //update the current image
        repaint();  
    }

    /*
    private void drawBackground(final Graphics2D g2d, final ImageObserver i)
    {
    	g2d.drawImage(background, 0, 0, i);
    	
    }
	*/
    
    private void drawGUI(){
    	
    }

 
    
    private class TAdapter extends KeyAdapter {

    	//if any keys are pressed queue the keylistener in the craft class
        public void keyReleased(KeyEvent e) {
        	
        	int key = e.getKeyCode();
        	
        	if(key == KeyEvent.VK_ESCAPE)
        		System.exit(0);
        	else
            {
        		craft.keyReleased(e);
            }
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}


package game;
import javax.swing.JFrame;

public class Rtype extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rtype() {


        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Rtype();
    }
}

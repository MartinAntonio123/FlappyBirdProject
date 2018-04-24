import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ImageLoader extends Applet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		super.paint(g);
	    Graphics2D draw= (Graphics2D)g;
	    draw.fillOval(1,1,1,1);
	}

}

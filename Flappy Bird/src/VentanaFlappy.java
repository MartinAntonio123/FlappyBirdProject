import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.sound.sampled.*;
import java.net.URL;
import java.io.*;

public class VentanaFlappy extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanvasFlappy Micanvas;
	
	VentanaFlappy(){
		this.addKeyListener(this);
		setLayout(new BorderLayout());
		Micanvas=new CanvasFlappy();
		add(Micanvas, BorderLayout.CENTER);
		try{
		URL url = this.getClass().getClassLoader().getResource("music.wav");
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(url); //esta no se cambia

		Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		clip.open(audioIn);     
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	 } catch (UnsupportedAudioFileException e) { e.printStackTrace(); 
	} catch (IOException e) { e.printStackTrace();
	} catch (LineUnavailableException e) { e.printStackTrace();
	}
		

}

	@Override
	public void keyPressed(KeyEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getKeyCode()==KeyEvent.VK_SPACE){
		    Micanvas.setCond(30);
	   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

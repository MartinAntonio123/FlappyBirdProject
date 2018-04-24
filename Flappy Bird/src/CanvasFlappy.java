import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class CanvasFlappy extends JPanel implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer reloj;
	private BloquesFlappy obstaculos;
	private NubeFlappy nube;
	private Pajaro miPajaro;
	private int cont=0, iniciar=0, reinicio=0;
	private int cond=0, gameover=1;
	private Graphics bufferGraphics;
	private Image bufferImage;
	private Enemigos balas;
	private Record best;
	private int b=0;
	//private Record recordGeneral;
	
	
	public CanvasFlappy(){
		super();
		this.addMouseListener(this);
		this.addKeyListener(this);
		reloj=new Timer(5, this);
		obstaculos=new BloquesFlappy();
		this.setBackground(new Color(178,233,255));
		nube=new NubeFlappy();
		miPajaro=new Pajaro();
		balas=new Enemigos();
		try {
			best=(Record) leerRecord("record.obj");
		} catch(Exception x){
			best=new Record();
		} 
		//recordGeneral=new Record();
	}
	public void paint(Graphics g)
	{
		bufferImage=createImage(this.getWidth(),this.getHeight());
		bufferGraphics=bufferImage.getGraphics();
		paintComponent(bufferGraphics);
		g.drawImage(bufferImage, 0, 0, this);
	}
	public void paintComponent(Graphics g){
		//++g.clearRect(0, 0, 2000, 1600);
		//super.paint(g);
		Graphics2D draw= (Graphics2D) g;
		nube.paint(g);
		obstaculos.paint(g);
		miPajaro.paint(g);
		balas.paint(g);
		if(true)
		{
			draw.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			if(obstaculos.getRecord()<0)
			{
				draw.setColor(Color.orange);
			    draw.drawString("Score  0.0 ", 300, 900);
			}
			else
			{
			    draw.setColor(Color.orange);
			    draw.drawString("Score "+obstaculos.getRecord(), 300, 900);
		
			}
		    draw.setColor(Color.cyan);
		    draw.drawString("Best "+ best.checkRecord(obstaculos.getRecord()), 900, 900);

		}
		if(gameover==0)
		{
			draw.setColor(Color.black);
			draw.setFont(new Font("TimesRoman", Font.PLAIN, 200)); 
			draw.drawString("Game Over", 160, 160);
		}
		if(iniciar==0)
		{
			draw.setColor(Color.green);
			draw.setFont(new Font("TimesRoman", Font.PLAIN, 120)); 
			draw.drawString("Pulsa en la pantalla para empezar", 160, 160);
		}
	}
    public void iniciar(){
    	this.iniciar=0;
		obstaculos=new BloquesFlappy();
		this.setBackground(new Color(178,233,255));
		nube=new NubeFlappy();   
		miPajaro=new Pajaro();
		balas=new Enemigos();
		try {
			best=(Record) leerRecord("record.obj");
		} catch(Exception x){
			best=new Record();
		} 
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b=b+1;
		obstaculos.avanza();
		nube.avanza();
	    cont=cont+1;  // dificil cont++;
	    balas.avanzar(obstaculos.getRecord());
	    /*if(b<=2000){//
		if(cont==150){
			obstaculos.anadir();
			cont=0;
		}}
	    if(b>2000){
	    	if(cont==110){
				obstaculos.anadir();
				cont=0;
			}
	    }/*/
		if(cond>=0){
			miPajaro.caer();
			miPajaro.caer();//dificil
			miPajaro.caer();
		}
		if(cond>0){
			miPajaro.volar();
			cond--;
			miPajaro.volar();
			cond--;
			miPajaro.volar();
			cond--;
		}
		if(obstaculos.choque(miPajaro)){
			this.gameover=0;
			this.reloj.stop();
		}
		if(balas.chocar(miPajaro))
		{
			this.gameover=0;
			this.reloj.stop();
		}
		this.update(getGraphics());
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(iniciar==0){
			reloj.start();
			iniciar=1;
		
		}
		else if(gameover==0){
			this.gameover=1;
			this.cont=0;
			this.cond=0;
			reinicio=1;
			this.repaint();
			try {
				salvarRecord(best);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(reinicio==1){
			this.iniciar();
			reinicio=0;
		}
		cond=30;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent ev) {
		// TODO Auto-generated method stub
		System.out.println("qie pedo");
		if(ev.getKeyCode()==KeyEvent.VK_SPACE){
		    cond=20;
	   }
	}
	public int getCond() {
		return cond;
	}
	public void setCond(int cond) {
		this.cond = cond;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
        if(arg0.getKeyChar()=='w'){
		    
		    cond=20;
	   }
	}
	public void salvarRecord(Object Record) throws IOException{
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("record.obj"));
        salida.writeObject(Record);
        salida.flush();
        salida.close();
    }
    
    public static Object leerRecord(String archivo) throws IOException, ClassNotFoundException{
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("record.obj"));
        Object Record = entrada.readObject();
        entrada.close();
        return Record;
    }

}


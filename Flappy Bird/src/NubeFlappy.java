import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class NubeFlappy{
	private int x, y;
	private int a,b,c, contador=0;
	private BufferedImage  imagen, imagen2, imagen3; 

	public NubeFlappy(){
		x=300;
		y=40;
		a=0;
		b=a+2000;
		c=b+2000;
	    String nomImagen = "mario.png";
	    File archImagen = new File(nomImagen);
        try {
            imagen = ImageIO.read(archImagen);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        try {
            imagen2 = ImageIO.read(archImagen);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        try {
            imagen3 = ImageIO.read(archImagen);
        } catch (IOException e) {
            
            e.printStackTrace();
        }

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}/*
	public void paint(Graphics g){
		//super.paint(g);
		Graphics2D draw= (Graphics2D) g;
		draw.setColor(new Color(178,233,255));
		draw.fillRect(0, 0, 2000, 1600);
		draw.drawImage(imagen,0,0,2000,1000,null);
		draw.setColor(Color.red);
		draw.fillRect(0,800, 6500, 600);
		draw.setColor(Color.black);
		draw.fillOval(x+80, y-5, 120, 55);
		draw.fillOval(x+50, y-10, 80, 60);
		draw.fillOval(x-20, y, 160, 50);
		draw.setColor(Color.WHITE);
		draw.fillOval(x+160, y-5, 120, 55);
		draw.fillOval(x+100, y-10, 80, 60);
		draw.fillOval(x+40, y, 160, 50);
		draw.setColor(Color.YELLOW);
		draw.fillOval(1700, -50, 200, 200);
	}*/
	public void paint(Graphics g)
	{
	
		Graphics2D draw= (Graphics2D) g;
		draw.drawImage(imagen,a,0,2000,1000,null);
		draw.drawImage(imagen2,b,0,2000,1000,null);
		draw.drawImage(imagen3,c,0,2000,1000,null);
		draw.setColor(new Color(0,100,0));
		draw.fillRect(0,800, 6500, 600);
		draw.setColor(Color.YELLOW);
		draw.fillOval(1700, -50, 200, 200);
	}
	public void avanza()
	{
		a--;
		b--;
		c--;
		contador++;
		if(contador==2000)
		{
			a=c+2000;
		}
		if(contador==4000)
		{
			b=a+2000;
		}
		if(contador==6000)
		{
			c=b+2000;
			contador=0;
		}
	}

}

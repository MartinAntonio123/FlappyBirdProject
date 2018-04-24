import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemigo {
	private int x,y;
	private int ancho, alto;
	private int vida;
	private Random rand;
	private double record;
	private BufferedImage imagen;
	
	public Enemigo()
	{
		rand=new Random();
		x=2500;
		y=rand.nextInt(750)+10;
		ancho=60;
		alto=40;
		vida=3;
		record=0;
		String nomImagen = "BillBanzai.png";
	    File archImagen = new File(nomImagen);
        try {
            imagen = ImageIO.read(archImagen);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
	}
	public void dar()
	{
		vida--;
		if(vida==0)
		{
			x=rand.nextInt(3000)+2000;
			y=rand.nextInt(750)+10;
			vida=3;
		}
	}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}
	public void avanza()
	{
		if(record<10){
			x=x-7;
		}
		else if(record<20)
		{
			x=x-9;
		}
		else if(record<30)
		{
			x=x-11;
		}
		else if(record<40)
		{
			x=x-14;
		}
		else
		{
			x=x-17;
		}
		if(x<0)
		{
			x=2500;
			y=rand.nextInt(750)+10;
			vida=3;
		}
	}
	public boolean chocar(Pajaro miPajaro){
		   if((miPajaro.getX()+60)>(this.x)&&((miPajaro.getX())<(this.x+this.ancho))){
			   if(((miPajaro.getY()+45)>(this.y))&&((miPajaro.getY())<(this.y+this.alto))){
				   return true;
			   }
			   else{
				   return false;
			   }
		   }
		   else{
			   return false; 
		   }
	   }
	public void paint(Graphics g)
	{
		g.drawImage(imagen, x, y, ancho, alto, null);
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
	}
	

}

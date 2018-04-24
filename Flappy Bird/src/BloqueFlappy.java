import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class BloqueFlappy extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x,y;
	private int alto, ancho;
	private Random rand;
	private double record;
	
	public BloqueFlappy() {
		super();
		rand=new Random();
		this.x = 1900;
		this.alto = rand.nextInt(350)+150;
		this.ancho = 80;
		this.y =800-this.alto;
	}
	public BloqueFlappy(int x, int y, int alto, int ancho){
		super();
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
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
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D draw= (Graphics2D) g;
		draw.setColor(Color.pink);
		draw.fillRect(x,y,ancho,alto);
		draw.setColor(Color.black);
		draw.fillOval(x+15, y+35, 15, 15);
		draw.fillOval(x+45, y+35, 15, 15);
		draw.fillRect(x+20, y+70, 35, 4);
		draw.fillRect(x+15, y+25, 15, 5);
		draw.fillRect(x+45, y+25, 15, 5);
		/*draw.setColor(Color.BLACK);
		draw.fillRect(x, y+120, ancho, alto-120);
		draw.setColor(Color.WHITE);
		draw.triangle(x,y-120,x+ancho,y+120,x+ancho/2,y+300);*/
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
   public double getRecord() {
	   
	     return record;
    }
   public void setRecord(double record) {
	   this.record = record;
}
   public void avanza(){
	   if(this.record<10){
		   x=x-4;
	   }
	   else if(this.record<20)
	   {
		   x=x-5;
	   }
	   else if(this.record<30){
		   x=x-6;
	   }
	   else{
		   x=x-7;
	   }
   }
   

}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pajaro {
	int x, y;
	private BufferedImage  imagen;
	
	public Pajaro(){
		x=300;
		y=300;
		String nomImagen = "pajaro4.png";
	    File archImagen = new File(nomImagen);
        try {
            imagen = ImageIO.read(archImagen);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
	}
	public void volar(){
		y=y-2;
	}
	public void caer(){
		y=y+1;
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
	public void paint(Graphics g){
		Graphics2D draw= (Graphics2D) g;
		draw.setColor(Color.red);
		draw.fillOval(x, y, 60, 45);
		draw.setColor(Color.white);
		draw.fillOval(x+40, y+8, 20, 20);
		draw.setColor(Color.black);
		draw.fillOval(x+45, y+10, 10, 10);
		draw.setColor(Color.orange);
		draw.fillRect(x+55, y+24, 16, 8);
		draw.fillRect(x+7, y+15, 30, 15);
		//draw.drawImage(imagen, x-15, y-2, 85, 60, null);
		
	}

}

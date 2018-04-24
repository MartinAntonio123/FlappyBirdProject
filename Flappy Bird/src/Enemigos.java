 import java.awt.Graphics;

public class Enemigos {
	private Enemigo bala1, bala2, bala3;
	private double record;
	
	public Enemigos()
	{
		bala1=new Enemigo();
		bala2=new Enemigo();
		bala3=new Enemigo();
		bala2.setX(bala2.getX()+700);
		bala3.setX(bala3.getX()+1400);
	}
	public void avanzar(double i)
	{
		record=i;
		bala1.setRecord(record);
		bala2.setRecord(record);
		bala3.setRecord(record);
		bala1.avanza();
		bala2.avanza();
		bala3.avanza();

	}
	public void paint(Graphics g)
	{
		bala1.paint(g);
		bala2.paint(g);
		bala3.paint(g);
	}
	public boolean chocar(Pajaro miPajaro)
	{
		if(bala1.chocar(miPajaro))
			return true;
		if(bala2.chocar(miPajaro))
			return true;
		if(bala3.chocar(miPajaro))
			return true;
		else
			return false;
	}

}

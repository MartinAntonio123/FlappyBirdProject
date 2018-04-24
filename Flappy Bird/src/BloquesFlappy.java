import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

public class BloquesFlappy extends Canvas{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ArrayList <ParBloques> bloq;
    private double record;
    private int cont, bcont;
	
	public BloquesFlappy(){
		super();
		bloq=new ArrayList <ParBloques> (10);
		bloq.add(new ParBloques());
		cont=0;
		bcont=0;
		record=-2;
	 
	}

	public void paint(Graphics g){
		super.paint(g);
		ListIterator <ParBloques> plt=bloq.listIterator();
		while(plt.hasNext()){
			ParBloques aux=plt.next();
			aux.paint(g);
		}
	}
	public void avanza(){
		cont++;
		bcont++;
		ListIterator <ParBloques> plt=bloq.listIterator();
		while(plt.hasNext()){
			ParBloques aux=plt.next();
			if(aux.Avanza()+30<100)
			{
				aux=null;
			}
			else{
				aux.setRecord(this.record);
			}
		}

		if(bcont<=2000){//
			if(cont==150){
				this.anadir();
				cont=0;
			}
			}
		else if(bcont>2000){
		    	if(cont==110){
					this.anadir();
					cont=0;
				}
		    }
		else if(bcont>5000){
	    	if(cont==80){
				this.anadir();
				cont=0;
			}
	    }
		
	}
	
	
	public void anadir(){
		this.bloq.add(new ParBloques());
		this.record++;
	}
	public boolean choque(Pajaro miPajaro){
		ListIterator <ParBloques> plt=bloq.listIterator();
		while(plt.hasNext()){
			ParBloques aux=plt.next();
			if(aux.chocar(miPajaro)){
				return true;
			}
		}
		if(miPajaro.getY()==750)
		{
			return true;
		}
		return false;
	}

	public double getRecord() {
		return record;
	}

	public void setRecord(double record) {
		this.record = record;
	}
	

}

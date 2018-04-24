import java.awt.Canvas;
import java.awt.Graphics;

public class ParBloques extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BloqueFlappy superior;
	private BloqueFlappy inferior;
	private double record;
	
	public ParBloques(){
		super();
		superior=new BloqueFlappy();
		int alto=800-superior.getAlto()-200;
		inferior=new BloqueFlappy(superior.getX(), 0, alto, 80);
	}
	public BloqueFlappy getSuperior() {
		return superior;
	}
	public void setSuperior(BloqueFlappy superior) {
		this.superior = superior;
	}
	public BloqueFlappy getInferior() {
		return inferior;
	}
	public void setInferior(BloqueFlappy inferior) {
		this.inferior = inferior;
	}
	public int Avanza(){
		superior.avanza();
		inferior.setX(superior.getX());
        superior.setRecord(record);
        inferior.setRecord(record);
		return(superior.getX());
	}
	public void paint(Graphics g){
		super.paint(g);
		superior.paint(g);
		inferior.paint(g);
	}
	public boolean chocar(Pajaro miPajaro){
		if(this.superior.chocar(miPajaro)||(this.inferior.chocar(miPajaro))){
			return true;
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
	

}

import java.io.Serializable;

public class Record implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double record;
	
	public Record() 
	{
		record=0;
	}
	public void score()
	{
		/*try
		{
		FileWriter fw=new FileWriter("out.txt",true);
		PrintWriter bw=new PrintWriter(fw);
		bw.print(record);
		bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error"+e.getMessage());
		}


	}
	public void best()
	{
		try
		{
		FileReader fw=new FileReader("out.txt");
		PrintWriter bw=new PrintWriter(fw);
		bw.print(record);
		bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error"+e.getMessage());
		}
	}
*/
}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}
	public double checkRecord(double actual){
		if (actual >record){
			record = actual;
			
		} else{
		
		}
		return record;
		
	}
}
	

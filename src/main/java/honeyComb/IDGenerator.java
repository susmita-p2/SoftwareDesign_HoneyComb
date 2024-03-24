package honeyComb;


public class IDGenerator
{
	private int id;
	private  static IDGenerator uniqueInstance; 
	
	private IDGenerator() 
	{
		this.id = -1;
	}
	
	public  static IDGenerator getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new IDGenerator();
		}
		return uniqueInstance;	
	}
	public String getNextID()
	{
		id++;
		return Integer.toString(id);
	}
	

}

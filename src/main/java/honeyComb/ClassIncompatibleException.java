package honeyComb;

public class ClassIncompatibleException extends Exception
{

	private static final long serialVersionUID = 6386435678652671072L;

	/**
	 * 
	 */
	public ClassIncompatibleException()
	{
		super("Page incompatabile for this role!");
		
	}

	/**
	 * @param message
	 */
	public ClassIncompatibleException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}

package ifpr.console;

public class Singleton 
{		
	public static Console console;
	
	private Singleton(){}
	
	public static synchronized Console getInstance()
	{
		if (console == null)
		{
			console = new Console();
		}
		
		return console;
	}
}
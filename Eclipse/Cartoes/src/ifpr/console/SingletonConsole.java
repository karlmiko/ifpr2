package ifpr.console;

public class SingletonConsole {

	private static Console console;
	
	private SingletonConsole(){}
	
	public static synchronized Console getInstance()
	{
		if(console == null)
		{
			console = new Console();
		}
		
		return console;
	}
}

package ifpr.main;

public class Singleton {
	
	int flagProcessamentoOn = 0;

	//Observe que o construtor é private
	
	private Singleton() 
	{
		//Construtor com acesso private
		flagProcessamentoOn = -5;
	}

	private static Singleton IndiceSingleton;

	public static Singleton getIndiceSingleton() 
	{
		if (IndiceSingleton == null) 
		{
			IndiceSingleton = new Singleton();
		}
		return IndiceSingleton;
	}

	public static synchronized Singleton getSingletonObject() 
	{
		if (IndiceSingleton == null) 
		{
			IndiceSingleton = new Singleton();
		}
		return IndiceSingleton;
	}

	public Object clone() throws CloneNotSupportedException 
	{
		throw new CloneNotSupportedException();
	}

	public void setFlagProcessamentoOn(int flagProcessamentoOn) 
	{
		this.flagProcessamentoOn = flagProcessamentoOn;
	}

	public int getFlagProcessamentoOn() 
	{
		return flagProcessamentoOn;
	}
}
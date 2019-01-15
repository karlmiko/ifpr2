package exercicio7;

public class Exercicio7_2
{
	public static void main(String[] args)
	{
		int total = 1;
		int f1 = 1;
		int f2 = 0;
		int loops = 0;
		
		while (loops < 10)
		{
			System.out.println("Valor " + (loops+1) + ": " + f2);
			f2 = f1;
			f1 = total;
			total = f1 + f2;
			loops++;
		}	
	}
}
package exercicio7;

public class Exercicio7_1
{
	public static void main(String[] args) 
	{
		int total = 1;
		int f1 = 1;
		int f2 = 0;
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Valor " + (i+1) + ": " + f2);
			f2 = f1;
			f1 = total;
			total = f1 + f2;
		}
	}
}

package exercicio10;

public class Exercicio10
{
	public static void main(String[] args)
	{
		int total = 0;
		int nextLine = 0;
		
		for (int i = 1; i < 1000; i++)
		{
			if (nextLine < 5)
			{
				System.out.print(i + " + ");
				nextLine++;
			}
			else
			{
				System.out.println(i + " + ");
				nextLine = 0;
			}
			
			total = total + i;
		}
		
		System.out.print("1000 = " + total);
	}
}
package exercicio9;

public class Exercicio9
{
	public static void main(String[] args)
	{
		int nextLine = 0;
		
		for (int i = 150; i < 350; i++)
		{
			if (nextLine < 5)
			{
				System.out.print(i + ", ");
				nextLine++;
			}
			else
			{
				System.out.println(i + ", ");
				nextLine = 0;
			}
		}
		System.out.print("350.");
	}
}

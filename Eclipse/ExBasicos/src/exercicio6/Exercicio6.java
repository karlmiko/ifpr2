package exercicio6;

import java.util.Scanner;

public class Exercicio6 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Número: ");
		int number = reader.nextInt();
		int total = 1;
		
		if (number > 0)
		{
			for (int i = 1; i <= number; i++)
			{
				total = total * i;
			}
		}
		
		System.out.println("Fatorial: " + total);
	
		reader.close();
	}
}
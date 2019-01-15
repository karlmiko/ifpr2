package exercicio8;

import java.util.Scanner;

public class Exercicio8
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Número: ");
		int number = reader.nextInt();
		
		for (int i = 1; i < 11; i++)
		{
			int answer = number*i;
			System.out.println(number + " x " + i + " = " + answer);
		}
				
		reader.close();
	}
}
package exercicio3;

import java.util.Scanner;

public class Exercicio3 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Número: ");
		int number = reader.nextInt();
		System.out.print("Modo simples(0) ou completo(1): ");
		int mode = reader.nextInt();
		
		if (mode == 0)
		{
			boolean answer = false;
			
			if (number >= 1 && number <= 10)
			{
				answer = true;
			}
			
			System.out.println("Entre 1 e 10: " + answer);
		}
		else if (mode == 1)
		{
			boolean answer1 = true, answer2 = true;
			
			if (number < 10)
			{
				answer2 = false;
			}
			if (number > 1)
			{
				answer1 = false;
			}
			
			System.out.println("Menor ou igual a 1: " + answer1);
			System.out.println("Maior ou igual a 10: " + answer2);
		}
		
		reader.close();
	}
}
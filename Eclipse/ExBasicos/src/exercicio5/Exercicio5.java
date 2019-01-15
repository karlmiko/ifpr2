package exercicio5;

import java.util.Scanner;

public class Exercicio5 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner (System.in);
		int threeNumbers[] = {0, 0, 0};
		
		for (int i = 0; i < 3; i++)
		{
			System.out.print("Número " + (i+1) + ": ");
			threeNumbers[i] = reader.nextInt();
		}
		
		if (threeNumbers[0] < threeNumbers[1] && threeNumbers[1] < threeNumbers[2])
		{
			System.out.print("Ordem crescente: ");
		}
		else if (threeNumbers[0] > threeNumbers[1] && threeNumbers[1] > threeNumbers[2])
		{
			System.out.print("Ordem decrescente: ");
		}
		else
		{
			System.out.print("Não estão em ordem: ");
		}
		
		for (int i = 0; i < 2; i++)
		{
			System.out.print(threeNumbers[i] + ", ");
		}
		
		System.out.print(threeNumbers[2] + ".");
		
		reader.close();
	}
}
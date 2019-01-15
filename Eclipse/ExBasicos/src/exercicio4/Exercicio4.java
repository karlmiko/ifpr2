package exercicio4;

import java.util.Scanner;

public class Exercicio4
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Número de toques do telefone: ");
		int rings = reader.nextInt();
		
		if (rings >= 3 && rings <= 5)
		{
			System.out.println("Atender Ligacão");
		}
		else if (rings >= 6 && rings <= 10)
		{
			System.out.println("Secretária eletrônica deve atender a ligacão");
		}
		else if (rings > 10)
		{
			System.out.println("Deixar tocar");
		}
		
		reader.close();
	}
}
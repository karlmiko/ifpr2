package exercicio1;

import java.util.Scanner;

public class Exercicio1
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Dia de semana(0), fim de semana(1): ");
		int option = reader.nextInt();
		System.out.print("Quantidade de Cigarros: ");
		int cigarette = reader.nextInt();
		
		boolean success = false;
		
		if (cigarette >= 40)
		{
			success = true;
		}
		if (cigarette > 60 && option == 0)
		{
			success = false;
		}
		
		System.out.print("Sucesso: " + success);
		reader.close();
	}
}
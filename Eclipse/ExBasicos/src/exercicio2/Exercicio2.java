package exercicio2;

import java.util.Scanner;

public class Exercicio2 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner (System.in);
		System.out.print("Velocidade do motorista(km/h): ");
		int speed = reader.nextInt();
		int ticket = 0;
		
		for (int limit = 60; limit <= 90; limit+=10)
		{
			if (speed <= limit)
			{
				break;
			}
			
			ticket+=50;
		}
		
		System.out.println("Multa: R$" + ticket);
		reader.close();
	}
}
package capitulo1;

import java.util.Scanner;

public class Exercicio19
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.println("1 - Em toda história, qual o menor jogador da NBA a ganhar um Slam Dunk?");
		System.out.println("2 - Qual a altura oficial do aro no basketball?");
		System.out.print("Opcao: ");
		
		int pergunta = leitor.nextInt();
		int resposta = 0;
		
		if (pergunta != 1 && pergunta != 2)
		{
			System.out.println("ERRO: Opcão inválida");
		}
		else
		{
			if (pergunta == 1)
			{
				resposta = 4;
			
				System.out.println("Em toda história, qual o menor jogador da NBA a ganhar um Slam Dunk?");
				System.out.println("1 - LeBron James");
				System.out.println("2 - Marceliho Huertas");
				System.out.println("3 - Shaquille O'Neil");
				System.out.println("4 - Nate Robinson");
				System.out.println("5 - Michael Jordan");	
			}
			
			if (pergunta == 2)
			{	
				resposta = 3;
			
				System.out.println("Qual a altura oficial do aro no basketball?");
				System.out.println("1 - 2,95m");
				System.out.println("2 - 3,00m");
				System.out.println("3 - 3,05m");
				System.out.println("4 - 3,10m");
				System.out.println("5 - 3,15m");
			}
		
			System.out.print("Resposta: ");
			
			int escolhaUsuario = leitor.nextInt();
				
			if (escolhaUsuario == resposta)
			{
				System.out.println("Parabéns, você é bom mesmo!");
			}
			else
			{
				System.out.println("Parabéns, você errou feio!");
			}
		}
			
		leitor.close();
	}
}
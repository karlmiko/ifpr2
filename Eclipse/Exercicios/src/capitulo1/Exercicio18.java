package capitulo1;

import java.util.Scanner;

public class Exercicio18
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		int resposta = 4;
		
		System.out.println("Em toda história, qual o menor jogador da NBA a ganhar um Slam Dunk?");
		System.out.println("1 - LeBron James");
		System.out.println("2 - Marceliho Huertas");
		System.out.println("3 - Shaquille O'Neil");
		System.out.println("4 - Nate Robinson");
		System.out.println("5 - Michael Jordan");
		
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
		
		leitor.close();
	}
}

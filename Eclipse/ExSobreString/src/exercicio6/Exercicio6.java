package exercicio6;

import java.util.Scanner;

public class Exercicio6
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Frase ou palavra: ");
		String fraseOuPalavra = leitor.nextLine();
		
		char ponto = '.';
		boolean possui = false;
		
		for (int i = 0; i < fraseOuPalavra.length(); i++)
		{
			char caracter = fraseOuPalavra.charAt(i);
			if (caracter == ponto)
			{
				possui = true;
				break;
			}
		}
		
		if(!possui)
		{
			System.out.println("A frase/palavra não apresenta \".\"");
		}
		else
		{
			System.out.println("A frase/palavra apresenta \".\"");
		}
					
		leitor.close();
	}
}
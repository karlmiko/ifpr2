package exercicio1;

import java.util.Scanner;

public class Exercicio1
{
	public static void main (String []args)
	{
		Scanner leitura = new Scanner (System.in);
		
		System.out.print("Entre com uma palavra: ");
		String palavra = leitura.next();
		
		int tamanhoPalavra = palavra.length();
		String novaString = "";
		
		for (int i = 0; i < tamanhoPalavra; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				char pegaLetra = palavra.charAt(i);
				novaString = novaString + pegaLetra;
			}
		}
		
		System.out.println(novaString);
		
		leitura.close();
	}
}
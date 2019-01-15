package exercicio7;

import java.util.Scanner;

public class Exercicio7 
{
	public static void main (String []args)
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Frase ou palavra: ");
		String fraseOuPalavra = leitor.nextLine();
		String novaFraseOuPalavra = "";
		
		int penultimaPosicao = fraseOuPalavra.length() -2;
		
		for (int i = penultimaPosicao; i < (penultimaPosicao+2); i++)
		{
			char letra = fraseOuPalavra.charAt(i);
			novaFraseOuPalavra = novaFraseOuPalavra + letra;
		}
		
		fraseOuPalavra = fraseOuPalavra.concat(novaFraseOuPalavra);
		System.out.println(fraseOuPalavra);
		
		leitor.close();
	}
}
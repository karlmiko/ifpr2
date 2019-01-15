package exercicio5;

import java.util.Scanner;

public class Exercicio5
{
	public static void main (String []args)
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Frase ou palavra: ");
		String fraseOuPalavra = leitor.nextLine();
		
		fraseOuPalavra = fraseOuPalavra.toUpperCase();
		
		System.out.println(fraseOuPalavra);
		
		leitor.close();
	}
}

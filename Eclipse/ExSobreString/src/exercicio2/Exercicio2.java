package exercicio2;

import java.util.Scanner;

public class Exercicio2
{
	public static void main(String[] args)
	{
		Scanner leitura = new Scanner (System.in);
		
		System.out.print("Cadeia de palavra(s): ");
		String frase = leitura.nextLine();
	
		int tamanhoFrase = frase.length();
		int aparicoes = 0;
		
		char letraL = 'l';
		char letraA = 'a';
		
		for (int i = 0; i < (tamanhoFrase-1); i++)
		{
			char letra = frase.charAt(i);
			
			if (letra == letraL && frase.charAt(i+1) == letraA)
			{
				aparicoes++;
			}
		}
		
		System.out.println("\"la\" aparece " + aparicoes + " vezes!");
		
		leitura.close();
	}
}
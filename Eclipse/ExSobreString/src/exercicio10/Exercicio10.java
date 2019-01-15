package exercicio10;

import java.util.Scanner;

public class Exercicio10 
{
	public static void main(String[] args) 
	{
		Scanner leitor = new Scanner (System.in);
		System.out.print("Frase: ");
		String frase = leitor.nextLine() + " ";
		String novaString = "";
		
		int tamanhoFrase = frase.length();
		int ultimoEspaco = 0;
		
		for (int i = 0; i < tamanhoFrase; i++)
		{
			char caracter = frase.charAt(i);
			
			if (caracter == ' ')
			{				
				for (int j = (i-1); j >= ultimoEspaco; j--)
				{
					char letra = frase.charAt(j);
					novaString = novaString + letra;
				}
				
				novaString = novaString + " ";
				ultimoEspaco = i+1;
			}
		}
		
		System.out.print("Nova frase: " + novaString);
		
		leitor.close();
	}
}
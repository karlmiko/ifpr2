package exercicio9;

import java.util.Scanner;

public class Exercicio9
{
	public static void main(String[] args) 
	{
		Scanner leitor = new Scanner (System.in);
		
		System.out.print("Frase: ");
		String frase = leitor.nextLine() + " ";
		String novaFrase = "";
		
		int tamanhoFrase = frase.length();
		int ultimoEspaco = 0;
		
		for (int i = 0; i < tamanhoFrase; i++)
		{
			char charPosicao = frase.charAt(i);
			
			if (charPosicao == ' ')
			{
				String pegaParteFrase = frase.substring(ultimoEspaco, i);
				novaFrase = novaFrase.concat(pegaParteFrase);
				ultimoEspaco = i+1;
			}
		}
		
		System.out.println ("Nova frase: " + novaFrase);
		
		leitor.close();
	}
}
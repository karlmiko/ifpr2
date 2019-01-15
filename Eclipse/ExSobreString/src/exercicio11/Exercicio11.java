package exercicio11;

import java.util.Scanner;

public class Exercicio11
{
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner (System.in);
		System.out.print ("Sequência: ");
		String sequencia = leitor.nextLine();
		
		int tamanhoSequencia = sequencia.length();
		int maiorSequencia = 0;
		char letraSequencia = ' ';
		int qtdSequencia = 1;
		
		for (int i = 0; i < (tamanhoSequencia-1); i++) //-1 para não dar erro no if abaixo
		{
			char letra = sequencia.charAt(i);
			
			if (letra == sequencia.charAt(i+1))
			{
				qtdSequencia++;
				if (qtdSequencia > maiorSequencia)
				{
					maiorSequencia = qtdSequencia;
					letraSequencia = letra;
				}
			}
			else
			{
				qtdSequencia = 1;
			}
		}
		
		System.out.print("Qtd: " + maiorSequencia + " Letra: " + letraSequencia);
		
		leitor.close();
	}
}
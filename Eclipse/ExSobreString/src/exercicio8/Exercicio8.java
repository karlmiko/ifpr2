package exercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio8
{
	public static void main(String []args)
	{
		Scanner leitor = new Scanner (System.in);
		System.out.print("Frase: ");
		String frase = leitor.nextLine() + " "; //" " para ler a última palavra!
		List<String> listaPalavras = new ArrayList<String>();
		
		int tamanhoFrase = frase.length();
		int ultimoEspaco = 0;
		int qtdPalavras = 0;
		char espaco = ' ';
			
		for (int i = 0; i < tamanhoFrase; i++)
		{
			char posicaoFrase = frase.charAt(i);
			
			if (posicaoFrase == espaco)
			{
				String palavra = frase.substring(ultimoEspaco, i); 
				ultimoEspaco = i+1; //+1 para pular a posicao do espaco!
				listaPalavras.add(palavra);			
				qtdPalavras++;
				i++;
			}
		}
		
		System.out.println("Quantidade de palavras: " + qtdPalavras);
		
		for (int j = 0; j < qtdPalavras; j++)
		{
			String palavra = listaPalavras.get(j);
			System.out.println("Palavra " + (j+1) + ": " + palavra);
		}

		leitor.close();
	}
}